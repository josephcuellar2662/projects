#ifndef SHARED_MEMORY
#define SHARED_MEMORY
#include <vxWorks.h>

void init_shared_memory();

void destroy_shared_memory();

char getDriveMode();

void setDriveMode(char mode);

char getSteerMode();

void setSteerMode(char mode);

SEM_ID getSyncSem();

SEM_ID getShutdownSem();

#endif
