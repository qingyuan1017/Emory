/*
THIS CODE IS MY OWN WORK. IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR MATERIALS OTHER THAN THIS SEMESTER'S COURSE MATERIALS. Qingyuan Zhang
*/

#include <sys/types.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <errno.h>
#include <sys/wait.h>
#include <ctype.h>
#include <string.h>


#define maxWordLength (80+1)
#define sorter "/bin/sort"
#define numSorter 2


int main(int argc, char * argv[]){
    static int i = 0, j = 0, k = 0; 	//parser input 
    FILE *stream[numSorter][2]; 	// [0][0] for S1 input, [0][1] for S2 input, [1][0] for S1 output, [1][1] for S2 output 
    int pid[1+numSorter];		//pids of children
    int whom;				// pid dead child
    int status;				// status
    int pipefd[numSorter][2][2];	// fds for ends of two pipes
    
    
    
     //pipefd[0] is parser to sorter, pipefd[1] is sorter to suppressor
     //pipefd[i][0] is read end,  pipefd[i][1] is write end
     
    for (j=0; j<numSorter; j++){
        for (i=0; i<2; i++) {
            if (pipe(pipefd[j][i]) == -1) {
                perror("pipe");
                exit(i+j*numSorter+0*2*numSorter+1);
            }
        }
    }
    
    // fork
    for (i=0; i< (1+ numSorter); i++) {
        if ((pid[i]=fork()) ==  -1) {
            perror("fork");
            exit (i+1*4+1);
        }
        if (pid[i] == 0) {
            //child
            
            /* sorter will sort all input and output it to suppressor to eliminate duplicates*/
            if (i < numSorter) { 
                
                for (j=0; j<numSorter; j++)
                {
                    if (j == i){
                        close (pipefd[j][0][1]); close (pipefd[j][1][0]);
                    }
                    else  {
                        for (k=0; k<2;k++){
                            close (pipefd[j][k][1]); close (pipefd[j][k][0]);
                        }
                    }
                }
                // Redirect stdin & stdout 
                dup2 (pipefd[i][0][0], STDIN_FILENO);
                dup2 (pipefd[i][1][1], STDOUT_FILENO);
                // Exec 
                execl(sorter, sorter, NULL);
                perror("execl"); 
                exit(i+2*2*numSorter+1);
            }
            
            if (i==numSorter) { // suppressor 
                for (j=0; j<numSorter; j++)
                {
                    
                    close (pipefd[j][0][0]); close (pipefd[j][0][1]); close (pipefd[j][1][1]);
                   
                    stream[j][1] = fdopen (pipefd[j][1][0], "r");
                    if (stream[j][1] == NULL) {
                        perror("redirect fd2 stdin");
                        exit (i+j*2+3*2*numSorter+1);
                    }
                }
                
                char prevBuf[maxWordLength] = "\n";
                char currentBuf[maxWordLength];
                int pipeEnd[2];
                int minBuf = 0;
                char buffer[numSorter][maxWordLength];
                while (!pipeEnd[0] || !pipeEnd[1])
                {
                    for (j=0; j<numSorter;j++)
                    {
                        while (!pipeEnd[j] && strcmp (buffer[j], prevBuf) == 0){
                            if (fgets(buffer[j], maxWordLength, stream[j][1]) == NULL)
                                pipeEnd[j] = 1;
                        }
                    }
                    if (!pipeEnd[0] && !pipeEnd[1]){
                        minBuf = (strcmp (buffer[0], buffer[1]) <= 0) ? 0:1;
                        strcpy(currentBuf, buffer[minBuf]);
                    }
                    else if (pipeEnd[0] && !pipeEnd[1])
                    {
                        strcpy(currentBuf, buffer[1]);
                        minBuf = 1;
                    }
                    else if (!pipeEnd[0] && pipeEnd[1])
                    {
                        strcpy(currentBuf, buffer[0]);
                        minBuf = 0;
                    }
                    else break;

         if (!pipeEnd[minBuf] && fgets(buffer[minBuf], maxWordLength, stream[minBuf][1]) == NULL)
                    {
                        pipeEnd[minBuf] = 1;
                    }
                    printf("%s",currentBuf);
                    strcpy(prevBuf, currentBuf);
                }
                for (j=0; j<numSorter;j++){
                    fclose (stream[j][1]);
                    close (pipefd[j][1][0]);
                }
            }
            exit (0); 
        }
    }
    
    
    //parent
    for (j=0; j<numSorter;j++){
       
        close(pipefd[j][0][0]); close(pipefd[j][1][0]); close(pipefd[j][1][1]);
        
        if ((stream[j][0] = fdopen(pipefd[j][0][1], "w")) == 0) {
            perror("redirect fd1 stdout");
            exit (i+4*2*numSorter+1);
        }
    }

    int parsePrevC = 0, parseC;
    k = 0;
    while ((parseC = fgetc(stdin)) != EOF)
    {
        k %= numSorter;
        if (isalpha(parseC))
        {

            printf("abc");
        }

        else if (!isalpha (parseC) && isalpha(parsePrevC))
        {
            
        }
        parsePrevC = parseC;
    }
    for (j=0; j<numSorter;j++){
        fclose(stream[j][0]);
        close(pipefd[j][0][1]);
    }
    
    //wait
    for (i=0; i<1+numSorter; i++ ) {
        if ((whom=wait(&status)) == -1) {
            perror("wait");
            exit(i+5*2*numSorter+1);
        }
    }
    return 0;
}
