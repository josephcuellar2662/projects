#include <vxWorks.h>
#include <stdio.h>
#include <msgQLib.h>
#include "message_queue.h"

MSG_Q_ID mqId;

void init_message_queue(){	
  /* create message queue */
	if ((mqId = msgQCreate(MAX_MESSAGES,MAX_MESSAGE_LENGTH,MSG_Q_FIFO)) == NULL)
		printf("msgQCreate in failed\n");
}

void send_data(char msg){
	char message[MAX_MESSAGE_LENGTH];
	sprintf(message,"%c", msg);
	
	if((msgQSend(mqId,message,MAX_MESSAGE_LENGTH, WAIT_FOREVER, MSG_PRI_NORMAL)) == ERROR)
		printf("msgQSend in Sender failed\n");
	
}

char* retrieve_data(){
	char msgBuf[MAX_MESSAGE_LENGTH];
	if(msgQReceive(mqId,msgBuf,MAX_MESSAGE_LENGTH, WAIT_FOREVER ) == ERROR)
		printf("msgQReceive in Receiver failed\n");
	
	return msgBuf;
}

void destroy_message_queue(){
	msgQDelete(mqId);
}
