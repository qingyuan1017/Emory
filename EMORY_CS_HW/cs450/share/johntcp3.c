/* Demonstration of Client side of TCP with hostnames
	John has 3 args: Mary's hostname
					 Mary's port number
					 How many numbers to send      */

#include <stdio.h>
#include <sys/types.h>
#include <netdb.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <ctype.h>
#include <stdlib.h>

main (argc,argv) 
	int argc;
	char *argv[];
{
	
	struct sockaddr_in sin; /* socket address for destination */
	int s;
	int len;
	long address;
	int i,j;

			/* Fill in Mary's Address */
	address = *(long *) gethostbyname(argv[1])->h_addr;
	sin.sin_addr.s_addr= address;
	sin.sin_family= AF_INET;
	sin.sin_port = htons(atoi(argv[2]));

	while(1) { /*loop waiting for Mary if Necessary */		
			/* create the socket */
	if ((s = socket(AF_INET,SOCK_STREAM,0)) < 0) {
		perror("Socket");
		exit(1);
		}

		/* try to connect to Mary */
	if (connect (s, (struct sockaddr *) &sin, sizeof (sin)) <0) {
		printf("Where is that Mary!\n");
		close(s);
		sleep(10);
		continue;
		}
	break; /* connection successful */
	}
		/* Now send Mary the Numbers */


	for (i=1; i<= atoi(argv[3]); i++ ) {
		j=htonl(i);
		write(s,&j,sizeof (i));
	}

}
