#include <sys/types.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <errno.h>
#include <sys/wait.h>
#include <ctype.h>
#include <string.h>


#define maxWordLength 80
#define sorter "/bin/sort"


int main(int argc, char * argv[]){
    static int i = 0; /* generic counter, and parser input */
    FILE *stream[2];
    int pid[2];				/*pids of children */
    int whom;				/* pid of dead child*/
    int status;				/* childs return status*/
    int pipefd[2][2];			/* fds for ends of two pipes */
    
    
    /* before forking set up the two pipes
    ** pipefd[0] is parser to sorter, pipefd[1] is sorter to suppressor 
    ** pipefd[i][0] is read end,  pipefd[i][1] is write end
     */
    for (i=0; i<2; i++) {
        if (pipe(pipefd[i]) == -1) {
        perror("pipe");
        exit(i+0*2+1);
        }
    }
    
    /* forking, pid[0] is the sorter child, pid[1] the suppressor child */
    for (i=0; i<2; i++) {
        if ((pid[i]=fork()) ==  -1) {
            perror("fork");
            exit (i+1*2+1);
        }
        if (pid[i] == 0) {
            /* this is the child*/

            /* sorter will sort all input and output it to suppressor to eliminate duplicates*/
            if (i==0) { /* sorter does this */
                /* Close pipe ends*/
                close (pipefd[0][1]); close (pipefd[1][0]);
                
                /* Redirect stdin & stdout */
                dup2 (pipefd[0][0], STDIN_FILENO);
                dup2 (pipefd[1][1], STDOUT_FILENO);

                /* Exec the sort program */
                execlp("sort", "sort", NULL);
                perror("execl"); /* shoudn't get here */
                exit(i+2*2+1);
            }
            
            if (i==1) { /* suppressor does this */
                /* Close pipe ends*/
                close (pipefd[0][0]); close (pipefd[0][1]); close (pipefd[1][1]);
                /* Associate pipe */
                stream[1] = fdopen (pipefd[1][0], "r");
                if (stream[1] == NULL) {
                    perror("redirect fd2 stdin");
                    exit (i+3*2+1);
                }
                char prevBuf[maxWordLength] = "";
                char buffer[maxWordLength];
                while (fgets(buffer, maxWordLength, stream[1]) != NULL)
                {
                    if (strcmp (buffer, prevBuf) != 0){
                        printf("%s",buffer);
                        memcpy(&prevBuf, &buffer, maxWordLength);
                    }
                }
                fclose (stream[1]);
                close (pipefd[1][0]);
            }
            exit (0); /* either way exit */
        }
    }
    
    
    /* this is the parent*/
    
    /* Close pipe ends*/
    close(pipefd[0][0]); close(pipefd[1][0]); close(pipefd[1][1]);
    /* Associate pipe */
    if ((stream[0] = fdopen(pipefd[0][1], "w")) == 0) {
        perror("redirect fd1 stdout");
        exit (i+4*2+1);
    }
    int parsePrevC = 0, parseC;
    while ((parseC = fgetc(stdin)) != EOF)
    {
        if (isalpha(parseC))
            fputc(tolower(parseC), stream[0]);
        else if (!isalpha (parseC) && isalpha(parsePrevC))
            fputc('\n', stream[0]);
        parsePrevC = parseC;
    }
    fclose(stream[0]);
    close(pipefd[0][1]);
    
    /* now parent waits */
    for (i=0; i<=1; i++ ) {
        if ((whom=wait(&status)) == -1) {
            perror("wait");
            exit(i+5*2+1);
        }
    }
    return 0;
}
