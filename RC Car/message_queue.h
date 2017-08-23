#ifndef MESSAGE_QUEUE
#define MESSAGE_QUEUE

#define MAX_MESSAGES 100
#define MAX_MESSAGE_LENGTH 50

void init_message_queue();
void send_data(char msg);
char* retrieve_data();
void destroy_message_queue();

#endif
