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
#define KEY_MQ_MGReceive (key_t)46411	/*key for manager receive message queue */
#define KEY_MQ_MGSend (key_t)46412	/*key for manager send message queue */

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

/* global decalre   */
struct myshare * shMem;	/* global pointer to shared mem, no storage yet*/
int pcID;   /*  corresponding process ID number in status list, before manage assign is pid */
int n;  /* this is the current number that the process is computing */
int finished;   /* this will give insight about whether the process finish computing the current number or not */

/* handler */
void computeQuit(){

    shMem->totalTestedByKilledProcess += shMem->statList[pcID].tested;
    shMem->statList[pcID].pid = 0;
    shMem->statList[pcID].tested = 0;
    shMem->statList[pcID].skipped = 0;
    shMem->statList[pcID].found = 0;
    if (!finished) shMem->bits[n/32] &= ~(1<<n%32);
    if (shmdt((void  *) shMem) == -1) {
        perror("shmdt");
        exit(4);
    }
    exit(0);
}

int main(int argc, char * argv[]) {
    if (argc < 2){
        printf("Need one integer argument");
        exit(0);
    }
    n = atoi(argv[1]);  /* start number */
    int initialN = n;
    int sid;	/* segment id of shared memory segment */
    int qid_MGReceive;	/* message queue id for manager receive */
    int qid_MGSend; /* message queue id for manager send */
    pcID = getpid();
    
    /* create shared segment if necessary */
    if ((sid=shmget(KEY_SM,sizeof (struct myshare), 0660))== -1) {
        perror("shmget");
        exit(1);
    }
    
    /* map it into our address space*/
    if ((shMem = ((struct myshare *) shmat(sid,0,0))) == NULL) {
        perror("shmat");
        exit(2);
    }
    
    /* create queue if necessary */
    if ((qid_MGReceive=msgget(KEY_MQ_MGReceive, 0660))== -1) {
        perror("msgget");
        exit(3);
    }
    if ((qid_MGSend=msgget(KEY_MQ_MGSend, 0660))== -1) {
        perror("msgget");
        exit(3);
    }

    /* Now request for processID in status list */
    my_msg.type = pcID;
    my_msg.data = pcID;
    msgsnd(qid_MGReceive,&my_msg,sizeof(my_msg.data),0);
    msgrcv(qid_MGSend,&my_msg,sizeof(my_msg.data),pcID,0);
    pcID = my_msg.data;
    
    /*  initialize process status  */
    shMem->statList[pcID].pid = getpid();
    shMem->statList[pcID].tested = 0;
    shMem->statList[pcID].skipped = 0;
    shMem->statList[pcID].found = 0;

    finished = 1;
    
    /* Status Routine will handle timer and INTR */
    sigset_t mask;
    struct sigaction action;
    
    sigemptyset(&mask);
    sigaddset(&mask, SIGINT);
    sigaddset(&mask, SIGHUP);
    sigaddset(&mask, SIGQUIT);
    action.sa_flags=0;
    action.sa_mask=mask;
    
    action.sa_handler=computeQuit;
    sigaction(SIGINT,&action,NULL);
    sigaction(SIGHUP,&action,NULL);
    sigaction(SIGQUIT,&action,NULL);
    
    /*  finding perfect num */
    int i,sum;
    do {
        n %= maxInt;

        if (shMem->bits[n/32] & 1<<n%32){
            shMem->statList[pcID].skipped++;
            
            continue;
        }
        shMem->bits[n/32] |= 1<<n%32; finished = 0;
        sum=1;
        for (i=2;i<n;i++)
            if (!(n%i)) sum+=i;
        finished = 1;
        if (n > 1 && sum==n) {
            shMem->statList[pcID].found++;
            my_msg.type = 1;
            my_msg.data = n;
            msgsnd(qid_MGReceive,&my_msg,sizeof(my_msg.data),0);
        }
        shMem->statList[pcID].tested++;
    } while (n++ != initialN-1);
    kill(getpid(), SIGINT);
}
