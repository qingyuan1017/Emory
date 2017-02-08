/*
Qingyuan Zhang
1977923
THIS CODE IS MY OWN WORK. IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR MATERIALS OTHER THAN THIS SEMESTER'S COURSE MATERIALS. Qingyuan Zhang
*/ 

#include <errno.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/msg.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>


#define maxInt 1024000
#define perfLim 20
#define processLim 20
#define KEY_SM (key_t)46410	/*key for shared memory segment */

int n; /* global variable indicating current test point */

/*  struct define   */
struct  {
    long type;
    int data;
} my_msg;

struct stats{
    pid_t pid;
    int tested;
    int skipped;
    int found;
};

struct myshare{
    int bits[(maxInt+31)/32];
    int perf[perfLim];
    struct stats statList[processLim];
    pid_t managePid;
    int totalTestedByKilledProcess;
};


int main(int argc, char * argv[]) {
    
    int sid;	/* segment id of shared memory segment */
    struct myshare * shMem;	/* global pointer to shared mem, no storage yet */
    int totalTested = 0;
    
    /* create shared segment if necessary */
    if ((sid=shmget(KEY_SM,sizeof (struct myshare),0660))== -1) {
        perror("shmget");
        exit(1);
    }
    
    /* map it into our address space*/
    if ((shMem = ((struct myshare *) shmat(sid,0,0))) == NULL) {
        perror("shmat");
        exit(2);
    }
    
    /* print perfNum */
    printf("Perfect Number found:\n");
    int i = 0;
    while(shMem->perf[i] != 0){
        printf("%d ", shMem->perf[i++]);
    }
    printf("\n\n");
    
    /* print statuses */
    printf("Statuses:\n");
    i = 0;
    for (i = 0; i < processLim; i++){
        if (shMem->statList[i].pid != 0){
            int temp = shMem->statList[i].tested;
            printf("ProcessPID: %d\tNumTested: %d\tNumSkipped: %d\t NumFound: %d\n", shMem->statList[i].pid, temp, shMem->statList[i].skipped, shMem->statList[i].found);
            totalTested += temp;
        }
    }
    printf("\n");

    /* print total tested */
    totalTested += shMem->totalTestedByKilledProcess;
    printf("Total tested: %d\n", totalTested);

    /*  cleaning */
    if (argc > 1 && argv[1][1] == 'k'){
        kill(shMem->managePid, SIGINT);
    }
    
    if (shmdt((void  *) shMem) == -1) {
        perror("shmdt");
        exit(4);
    }
}
