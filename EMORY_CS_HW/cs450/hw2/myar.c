


/*
Qingyuan Zhang
1977923
THIS CODE IS MY OWN WORK. IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR MATERIALS OTHER THAN THIS SEMESTER'S COURSE MATERIALS. Qingyuan Zhang

I also did the v and d commnad
*/



#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <ar.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <time.h>
#include <utime.h>
#include <sys/types.h>
#include <dirent.h>
#include <sys/stat.h>
#include <dirent.h>
#include <errno.h>

#define HeaderLength  sizeof(struct ar_hdr)
#define Length(member) sizeof(((struct ar_hdr *)0)->member)
#define MAXPATHLENGTH 260
#define ARMAGLength 8
#define ARMAG   "!<arch>\n"
#define FMAG    "`\n"
#define openMode 0666
#define copyFile "replica.c"
#define verboseFileSizeLength 6
#define verboseDateLength 17
#define ctimeLengthWWW 4
#define ctimePosSSS 16
#define ctimeLengthSSS 3


char* deletespace(char *string);
int concisetable(int fd1, int argc, char *argv[]);
int verbosetable(int fd1, int argc, char *argv[]);
const char * HeaderConstruct(char* input, int length);
int Append(int fd1, int fd2, struct stat buf, char* argvName, int existed);
int extract(int fd1, int i, char* argv[]);
int delete(int fd1, int fd2, int argc, char* argv[]);

int main(int argc, char *argv[]) {
    int fd1,fd2;        /* file descriptors */
    struct stat buf;
    if (argc < 2)
    {
        printf( "usage:\tmyar q append named files\n");
        printf( "      \tmyar x extract named files\n");
        printf( "      \tmyar t print a concise table \n");
        printf( "      \tmyar v print a verbose table \n");
        printf( "      \tmyar d delete named files \n");
        printf( "      \tmyar A append all \"ordinary\" files in the current directory\n");
    }
    else if (strcmp(argv[1], "-t") == 0 || strcmp(argv[1], "t") ==0){
        if((fd1=open(argv[2],O_RDONLY)) < -1) return 1; //open arc
        if (lseek(fd1,8,0) < 0) return 1;    //skip armsg
        if (concisetable(fd1, argc, argv) < 1) return 1;   //print table
    }
    else if (strcmp(argv[1], "-v") == 0 || strcmp(argv[1], "v") ==0 ){
        if ((fd1=open(argv[2],O_RDONLY)) < -1) return 1; //open arc
        if (lseek(fd1,8,0) < 0) return 1;    //skip armsg
        if (verbosetable(fd1, argc, argv) < 1) return 1; //print verbose table
    }
    else if (strcmp(argv[1], "-q") == 0 || strcmp(argv[1], "q") == 0){
        //archive file
        int existed = 1;    //true
        if ((fd1=open(argv[2],O_RDWR)) == -1){
            existed = 0;
            if ((fd1=open(argv[2], O_WRONLY| O_CREAT |O_TRUNC,openMode)) == -1){
                perror("open archive");
                exit(1);
            }
        }
        //appending

    int i = 3;
    
    while(i < argc){
        if ((fd2=open(argv[i],0)) == -1) {
            perror("open file");
            exit(1);
        }
        // get stat info
        if (stat(argv[i],&buf) == -1) {
            perror("Bad Stat");
            exit(1);
        }
        Append(fd1, fd2, buf, argv[i], existed);    //not append all
        existed = 1;
        close(fd2);
        i++;
    }
        close(fd1);
}
    
    else if (strcmp(argv[1], "-x") == 0 || strcmp(argv[1], "x") ==0 ){
        //extract file
        if ((fd1=open(argv[2],0)) == -1) {
            perror("open archive");
            exit(1);
        }
        int i;
        for (i= 3; i < argc; i++)
            if(extract(fd1, i, argv) == -1)
                printf("%s: %s: not found in archive\n", argv[0], argv[i]);
    }
    else if (strcmp(argv[1], "-A") == 0 || strcmp(argv[1], "A") == 0 ){
        DIR *dirp;
        struct dirent *dp;
        struct stat buf;
        if (!(dirp = opendir("."))) { /* open the directory */
            perror("opendir:");
            exit(1);
        }
        //archive file
        int existed = 1;    //true
        
        if ((fd1=open(argv[2],O_RDWR)) == -1){
            existed = 0;
            
            if ((fd1=open(argv[2], O_WRONLY| O_CREAT |O_TRUNC,openMode)) == -1){
                perror("open archive");
                exit(1);
            }
        }
        while ((dp = readdir(dirp)) != NULL) {
            // check the directory is what we want to append
            if (strcmp(dp->d_name, ".") == 0 || strcmp(dp->d_name, "..") == 0 || strcmp(dp->d_name, argv[2]) == 0)
                continue;
            
            if ((fd2=open(dp->d_name,0)) == -1) {
                perror("open file");
                exit(1);
            }
            // stat
            if (stat(dp->d_name,&buf) == -1) {
                perror("Bad Stat");
                exit(1);
            }
            // appending
            Append(fd1, fd2, buf, dp->d_name, existed++);  
            close(fd2);
        }
        closedir(dirp);
    }
    else if (strcmp(argv[1], "-d") == 0 || strcmp(argv[1], "d") == 0 ){
        //extract file
        if ((fd1=open(argv[2],0)) == -1) {
            perror("open archive");
            exit(1);
        }
        if (delete(fd1, fd2, argc, argv) == 2)
            printf("%s: %s: Inappropriate file type or format\n", argv[0], argv[2]);
        
    }
    else{
        printf( "usage:\tmyar q append named files\n");
        printf( "      \tmyar x extract named files\n");
        printf( "      \tmyar t print a concise table \n");
        printf( "      \tmyar v print a verbose table \n");
        printf( "      \tmyar d delete named files \n");
        printf( "      \tmyar A append all \"ordinary\" files in the current directory\n");
    }
}




int concisetable(int fd1, int argc, char *argv[]){
    int count = 0;
    while(1){
        char header[HeaderLength];
	    //check if it is archive file
        if(read(fd1,header,HeaderLength) != HeaderLength)  return -1;
        //print file name
        char name[Length(ar_name)+1];
        memcpy(name, &header[0], Length(ar_name));
        name[Length(ar_name)] = '\0';
        deletespace(name);
        printf("%s\n",name);
	
        char fileSize[Length(ar_size)+1];
        memcpy(fileSize, &header[Length(ar_name)+Length(ar_date)+Length(ar_uid)+Length(ar_gid)+Length(ar_mode)], Length(ar_size));
        fileSize[Length(ar_size)] = '\0';
        int skipLength = atoi(fileSize);
	       // check whether it start with even
	if(skipLength%2 == 1) skipLength = skipLength+1;
        //skip file content
        if(lseek(fd1,skipLength, SEEK_CUR) < 0) return 1;
    }
    return -1;
}


char* deletespace(char *string){ 
//delete the trailing space   
    char* endOfString = string + strlen(string) - 1;
     while(string < endOfString  && isspace(*endOfString)){
          endOfString-- ;
     }
     *(endOfString+1) = '\0';
     return string;
}



int Append(int fd1, int fd2, struct stat buf, char* argvName, int existed){
    int bufSize = (int)buf.st_blksize; /* real buffer size */
    char buff[bufSize];    /* overkill on buffer size*/
    long iosize;            /* actual amount read */
    //build the header in buffer
    if (!existed)
    {   
        strcpy(buff, ARMAG);
        strcat(buff, HeaderConstruct(argvName, Length(ar_name)));
    }
    else strcpy(buff, HeaderConstruct(argvName, Length(ar_name)));
    char time[Length(ar_date)];
    sprintf(time, "%ld", buf.st_mtime);
    strcat(buff, HeaderConstruct(time, Length(ar_date)));
    char uid[Length(ar_uid)];
    sprintf(uid, "%d", buf.st_uid);
    strcat(buff, HeaderConstruct(uid, Length(ar_uid)));
    char gid[Length(ar_uid)];
    sprintf(gid, "%d", buf.st_gid);
    strcat(buff, HeaderConstruct(gid, Length(ar_gid)));
    char mode[Length(ar_mode)];
    sprintf(mode, "%o", buf.st_mode);
    strcat(buff, HeaderConstruct(mode, Length(ar_mode)));
    char size[Length(ar_size)];
    sprintf(size, "%lld", buf.st_size);
    strcat(buff, HeaderConstruct(size, Length(ar_size)));
    strcat(buff, FMAG);
    //lseek to the end of the archive
    
        if (lseek(fd1,ARMAGLength,SEEK_SET) < 0) return 1;
        while(1){
            char header[HeaderLength];
            if(read(fd1,header,HeaderLength) != HeaderLength)  break;
            char fileSize[Length(ar_size)+1];
            memcpy(fileSize, &header[HeaderLength-Length(ar_fmag)-Length(ar_size)], Length(ar_size));
            fileSize[Length(ar_size)] = '\0';
            int skipLength = atoi(fileSize);
            if(lseek(fd1,(skipLength%2 == 1) ? skipLength+1:skipLength,SEEK_CUR) < 0) break;
        }
    
    //write header
    write(fd1, buff, (!existed) ? (HeaderLength+ARMAGLength) : HeaderLength);

    while ((iosize=read(fd2,buff,bufSize)) >0 )
    {
        write(fd1,buff,iosize);
        if (iosize % 2 != 0)
            write(fd1, "\n", 1);
    }
    
    if (iosize == -1) {
        perror("read");
        exit(1);
    }
    return -1;
}


const char * HeaderConstruct(char* input, int length){
    char* member = malloc(length);
    sprintf(member,"%-*.*s", (int)length, (int)length, input);
    
    return member;
}

int extract(int fd1, int i, char* argv[]){
    int fd2;
    struct stat arFile;
    struct utimbuf buf;
    // stat for archive
    if (stat(argv[2],&arFile) == -1) {
        perror("Bad Stat");
        exit(1);
    }
    int bufSize = (int)arFile.st_blksize; /* real buffer size */
    char buff[bufSize];    /* overkill on buffer size*/
    char header[HeaderLength];
    long iosize;			/* actual amount read */
    mode_t mode_to_assign;
    time_t date_to_assign;
    off_t skipLength = 0;
    int found = 0;

    if (lseek(fd1,ARMAGLength,SEEK_SET) < 0) return -1;
    //search for file
    while(1){
        if(read(fd1,header,HeaderLength) != HeaderLength)  return -1;
        //get file name and size in archive
        char name[Length(ar_name)+1];
        memcpy(name, &header[0], Length(ar_name));
        name[Length(ar_name)] = '\0';
        char fileSize[Length(ar_size)+1];
        memcpy(fileSize, &header[HeaderLength-Length(ar_fmag)-Length(ar_size)], Length(ar_size));
        fileSize[Length(ar_size)] = '\0';
        skipLength = atoi(fileSize);
        // compare with argv[]
        if (!strncmp(argv[i], deletespace(name), Length(ar_name)))
        {
            found = 1;
            char mode[Length(ar_mode)+1];
            memcpy(mode, &header[HeaderLength-Length(ar_fmag)-Length(ar_size)-Length(ar_mode)], Length(ar_mode));
            mode[Length(ar_mode)] = '\0';
            int temp_mode;
            sscanf(mode, "%o", &temp_mode);
            mode_to_assign = temp_mode;
            char date[Length(ar_date)+1];
            memcpy(date, &header[Length(ar_name)], Length(ar_date));
            date[Length(ar_date)] = '\0';
            date_to_assign = atol(date);
            break;
        }
        //skip file content
        if(skipLength%2 == 1) skipLength = skipLength+1;
        if (lseek(fd1, skipLength, SEEK_CUR) < 0) return -1;
    }
    if (!found){
        printf("%s: %s: not found in archive\n", argv[0], argv[i]);
    }
    else if ((fd2=open(argv[i], O_WRONLY |O_CREAT |O_TRUNC, mode_to_assign)) == -1) {
        perror("open file");
        exit(1);
    }
    else {
        while ((iosize=read(fd1,buff,bufSize)) >0 )
        {
            if (bufSize > skipLength){
                write(fd2,buff,skipLength);
                break;
            }
            else {
                skipLength -= iosize;
                write(fd2,buff,iosize);
            }
        }
        buf.modtime = date_to_assign;
        buf.actime = date_to_assign;
        utime(argv[i], &buf);
        chmod(argv[i], mode_to_assign);
    }
    return -1;
}


int verbosetable(int fd1, int argc, char *argv[]){
    int count = 0;
    while(1){
        char header[HeaderLength];
        if(read(fd1,header,HeaderLength) != HeaderLength)  return -1;
 
        //print mode
        char modeString[Length(ar_mode)+1];          /* octal file permissions */
        memcpy(modeString, &header[Length(ar_name)+Length(ar_date)+Length(ar_uid)+Length(ar_gid)], Length(ar_mode));
        modeString[Length(ar_mode)] = '\0';
        int mode = atoi(modeString);
        sscanf(modeString, "%o", &mode);
        char *rwx[] = {"---", "--x", "-w-", "-wx",
            "r--", "r-x", "rw-", "rwx"};
        char bits[10];
        bits[0] = '\0';
        strcpy(bits, rwx[(mode >> 6)& 7]);
        strcat(bits, rwx[(mode >> 3)& 7]);
        strcat(bits, rwx[(mode >> 0)& 7]);
        printf("%s ",bits);
        
        //print UID and GID
        char strUid[Length(ar_uid)+1];           /* user id */
        memcpy(strUid, &header[Length(ar_name)+Length(ar_date)], Length(ar_uid));
        strUid[Length(ar_uid)] = '\0';
        char strGid[Length(ar_gid)+1];           /* group id */
        memcpy(strGid, &header[Length(ar_name)+Length(ar_date)+Length(ar_uid)], Length(ar_gid));
        strGid[Length(ar_gid)] = '\0';
        printf("%s/%s ", deletespace(strUid), deletespace(strGid));
        
        //print size
        char fileSize[Length(ar_size)+1];
        memcpy(fileSize, &header[Length(ar_name)+Length(ar_date)+Length(ar_uid)+Length(ar_gid)+Length(ar_mode)], Length(ar_size));
        fileSize[Length(ar_size)] = '\0';
        deletespace(fileSize);
        if (strlen(fileSize) > verboseFileSizeLength)
            printf("%s ", fileSize);
        else printf("%*s ", (int)verboseFileSizeLength, fileSize);

        //print date
        char strDate[Length(ar_date)];           /* modification time */
        memcpy(strDate, &header[Length(ar_name)], Length(ar_date));
        time_t date = (time_t)atoi(strDate);
        char* dateHelp = ctime(&date);
        char dateOut[verboseDateLength+1];
        memcpy(dateOut, &dateHelp[ctimeLengthWWW], ctimePosSSS-ctimeLengthWWW);
        dateOut[ctimePosSSS] = '\0';
        memcpy(&dateOut[ctimePosSSS-ctimeLengthWWW], &dateHelp[ctimePosSSS+ctimeLengthSSS], strlen(dateHelp)-ctimeLengthSSS-ctimePosSSS-1);
        dateOut[verboseDateLength] = '\0';
        printf("%s ",dateOut);
        
        //print name
        char name[Length(ar_name)+1];
        memcpy(name, &header[0], Length(ar_name));
        name[Length(ar_name)] = '\0';
        printf("%s\n",deletespace(name));
        
        
        int skipLength = atoi(fileSize);
        if (skipLength%2 == 1)  skipLength++;
        if(lseek(fd1,skipLength,SEEK_CUR) < 0) return 1;
    }
    return -1;
}


int delete(int fd1, int fd2, int argc, char* argv[]){
    long iosize;			/* actual amount read */
    struct stat arFile;
    int found[argc];
    int i;
    for (i = 0; i < argc; i++) found[i] = 0;
    if (stat(argv[2],&arFile) == -1) {
        perror("Bad Stat");
        exit(1);
    }
    unlink(argv[2]);
    int bufSize = (int)arFile.st_blksize; /* real buffer size */
    char buff[bufSize];    /* overkill on buffer size*/
    char header[HeaderLength];
    mode_t mode_to_assign;
    off_t skipLength = 0;
    mode_to_assign = arFile.st_mode;
    if ((fd2=open(argv[2], O_WRONLY |O_CREAT |O_TRUNC, mode_to_assign)) == -1) {
        perror("open file");
        exit(1);
    }
    if (read(fd1,buff,ARMAGLength) != ARMAGLength) return 1;
    write(fd2, buff, ARMAGLength);

    while(1){
        if(read(fd1,header,HeaderLength) != HeaderLength)  break;
        //print file name
        char name[Length(ar_name)+1];
        memcpy(name, &header[0], Length(ar_name));
        name[Length(ar_name)] = '\0';
        char fileSize[Length(ar_size)+1];
        memcpy(fileSize, &header[HeaderLength-Length(ar_fmag)-Length(ar_size)], Length(ar_size));
        fileSize[Length(ar_size)] = '\0';
        skipLength = atoi(fileSize);
        if (skipLength%2 == 1) skipLength++;
        //        size_to_assign = skipLength;
        int i;
        int skip = 0;
        for (i = 3; i < argc && !skip; i++){
            if (!found[i] && !strncmp(argv[i], deletespace(name), Length(ar_name)))
            {
                //skip file content
                if (lseek(fd1, skipLength, SEEK_CUR) < 0) return 1;
                found[i] = 1;
                skip = 1;
            }
        }
        if (skip) continue;
        else write(fd2, header, HeaderLength);
        while (1){
            if (bufSize > skipLength){
                if ((iosize=read(fd1,buff,skipLength)) > 0)
                {
                    write(fd2,buff,skipLength);
                    break;
                }
            }
            if ((iosize=read(fd1,buff,bufSize)) > 0 ){
                skipLength -= iosize;
                write(fd2,buff,iosize);
            }
        }
    }

    for (i = 3; i < argc; i++)
    {
        if (!found[i])
            printf("%s: %s: not found in archive\n", argv[0], argv[i]);
    }
    return -1;
}


