#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h> 

char* string_concat(int n, char* s){
char buffer [sizeof(int)*4+1];
sprintf(buffer,"%d",n);
return strcat(buffer, s);
}

float calculate( float x,float y,int* c);
void fibonacci();
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
int t1= 0;
int t2= 1;

next_term = t1 + t2;
printf("%s","Fibonacci sequence: ");
printf("%s",string_concat(t1, ", "));
printf("%s",string_concat(t2, ", "));
for(int i=3;i<=30;i++){

printf("%s",string_concat(next_term, ", "));
t1 = t2;
t2 = next_term;
next_term = t1 + t2;


}


}

void main(int argc, char *argv[]) {
calculatorNL();
}

void calculatorNL(){
float result;
int flag= 1;
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
printf("Choose an operation between 1 and 6");
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

printf("%s","Continue?: 0/1");
scanf("%d", &go_on);
if(go_on == 0){

flag = 0;

}



}


}

