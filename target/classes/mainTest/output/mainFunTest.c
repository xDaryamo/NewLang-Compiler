#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define BUFFER_SIZE  (1024*4)

char* string_concat(char* s1, char* s2)
{
    char* ns = malloc(strlen(s1) + strlen(s2) + 1);
    strcpy(ns, s1);
    strcat(ns, s2);
    return ns;
}

char* int2str(int n)
{
    char buffer[BUFFER_SIZE];
    int len = sprintf(buffer,"%d",n);
    char *ns = malloc(len + 1);
    sprintf(ns,"%d",n);
    return ns;
}

char* char2str(char c)
{
    char *ns = malloc(2);
    sprintf(ns, "%c", c);
    return ns;
}

    char* float2str(float f)
    {
        char buffer[BUFFER_SIZE];
        int len = sprintf(buffer,"%f", f);
        char *ns = malloc(len + 1);
        sprintf(ns, "%f", f);
        return ns;
    }

char* bool2str(int b)
{
    char* ns = NULL;
    if(b)
    {
        ns = malloc(5);
        strcpy(ns, "true");
    }
    else
    {
        ns = malloc(6);
        strcpy(ns, "false");
    }
    return ns;
}

float calculate(float x,float y,int* c);
void fibonacci();
void main97();
void calculatorNL();

float calculate( float x,float y,int* c){
float result;

if(*c == 1){

result = x + y;

}

if(*c == 2){

result = x - y;

}

if(*c == 3){

result = x * y;

}

if(*c == 4){

result = x / y;

}

if(*c == 5){

result = pow(x, y);

}

return result;

}

void fibonacci(){
int next_term;
int t1 = 0;
int t2 = 1;

next_term = t1 + t2;
printf("%s","Fibonacci sequence: ");
printf("%s",string_concat(int2str(t1), ", "));
printf("%s",string_concat(int2str(t2), ", "));
for(int i=3;i<=30;i++){

printf("%s",string_concat(int2str(next_term), ", "));
t1 = t2;
t2 = next_term;
next_term = t1 + t2;


}


}

void main97(){

printf("%s\n","Not main function");

}

void main(int argc, char *argv[])
{

if(argc<1)
{
    printf("missing argument\n");
    exit(-1);
}

calculatorNL();
}

void calculatorNL(){
float result;
int flag = 1;
int go_on;
int choice;
float a;
float b;

while(flag == 1){

printf("%s\n","Menu:");
printf("%s\n","1.Sum:");
printf("%s\n","2.Subtraction:");
printf("%s\n","3.Multiplication:");
printf("%s\n","4.Division:");
printf("%s\n","5.Pow:");
printf("%s\n","6.Fibonacci sequence:");
printf("Choose an operation between 1 and 6: ");
scanf("%d", &choice);
if(choice == 6){

fibonacci();

}
else{
printf("Insert first argument value: ");
scanf("%f", &a);
printf("Insert second argument value: ");
scanf("%f", &b);
result = calculate(a,b,&choice);
printf("%s","Computation result: ");
printf("%f\n",result);

}

printf("%s","Continue? 0/1: ");
scanf("%d", &go_on);
if(go_on == 0){

flag = 0;

}



}


}

