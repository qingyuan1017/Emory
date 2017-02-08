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
int n; /* global variable indicating current test point */
int sid;	/* global segment id of shared memory segment */
int qid_MGReceive;	/* message queue id for manager receive */
int qid_MGSend; /* message queue id for manager send */
struct myshare * shMem;	/* global pointer to shared mem, no storage yet*/

/* handler */
void quit(){
    int i;
    for (i = 0; i < processLim; i++){
        if (shMem->statList[i].pid != 0 && kill(shMem->statList[i].pid,SIGINT) != 0)
            perror("kill");
    }
    sleep(5);
    if (shmdt((void  *) shMem) == -1) {
        perror("shmdt");
        exit(4);
    }
    if (shmctl(sid,IPC_RMID,0) == -1) {
        perror("shmctl");
        exit(5);
    }
    if (msgctl(qid_MGReceive,IPC_RMID,0) == -1) {
        perror("msgctl_Receive");
        exit(6);
    }
    if (msgctl(qid_MGSend,IPC_RMID,0) == -1) {
        perror("msgctl_Send");
        exit(7);
    }
    exit(0);
}

int main(int argc, char * argv[]){
    int perfNum = 0;    /* number of perfect number found */
    int i;      /* generic counter  */
    
    
    /* create shared segment if necessary */
    if ((sid=shmget(KEY_SM,sizeof (struct myshare),IPC_CREAT |0660))== -1) {
        perror("shmget");
        exit(1);
    }
    
    /* map it into our address space*/
    if ((shMem = ((struct myshare *) shmat(sid,0,0))) == NULL) {
        perror("shmat");
        exit(2);
    }

    /* create queue if necessary */
    if ((qid_MGReceive=msgget(KEY_MQ_MGReceive,IPC_CREAT |0660))== -1) {
        perror("msgget");
        exit(3);
    }
    if ((qid_MGSend=msgget(KEY_MQ_MGSend,IPC_CREAT |0660))== -1) {
        perror("msgget");
        exit(3);
    }
    
    /* initialization */
    for (i = 0; i < processLim; i++){
        shMem->statList[i].pid = 0;
    }
    for (i = 0; i < perfNum; i++){
        shMem->perf[i] = 0;
    }
    shMem->managePid = getpid();
    shMem->totalTestedByKilledProcess = 0;
    
    /* Status Routine will handle timer and INTR */
    sigset_t mask;
    struct sigaction action;
    
    sigemptyset(&mask);
    sigaddset(&mask, SIGINT);
    sigaddset(&mask, SIGHUP);
    sigaddset(&mask, SIGQUIT);
    action.sa_flags=0;
    action.sa_mask=mask;
    
    action.sa_handler=quit;
    sigaction(SIGINT,&action,NULL);
    sigaction(SIGHUP,&action,NULL);
    sigaction(SIGQUIT,&action,NULL);
    
    /* Now read the messages */
    while (1) {
        msgrcv(qid_MGReceive,&my_msg,sizeof(my_msg.data),0,0);
        
        if (my_msg.type == 1){
            /*  perfect number found    */

            int exist = 0;
            for (i = 0; i < perfLim; i++){
                if (shMem->perf[i] == my_msg.data)
                    exist = 1;
            }
            if (!exist){
                shMem->perf[perfNum++] = my_msg.data;
                perfNum %= 20;
            }
        } else{
            i = 0;
            while(i < processLim && shMem->statList[i].pid != 0) i++;
            shMem->statList[i].pid = my_msg.data;

            my_msg.data = i;
            msgsnd(qid_MGSend,&my_msg,sizeof(my_msg.data),0);
        }
    }
}
