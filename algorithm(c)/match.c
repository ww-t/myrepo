/*
수식이 주어질 때 같은 짝의 괄호의 위치를 찾는 문제이다.

(a*(b+c)+d)

이 경우에는 3 과 7 , 0 과 10 이 한 쌍의 괄호이다.

입력

입력은 공백없이 입력된다. 입력되는 문자는 소문자,소괄호,(+,-,*,/)이다.
문자열의 길이는 최대 50 까지이다.

출력

왼쪽에서 오른쪽을 가면서 먼저 짝이 맞는 (여는 괄호 위치, 닫는 괄호 위치) 순으로 출력하고, 짝이 맞지 않는 수식은 not match 를 출력한다.

입 출력 예

입력

(a*(b+c)+d)

출력

3 7
0 10
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
  
int top=0,stack[50];
  
void push(int a){
     stack[top++]=a;
     return;
}
  
int pop(){
    int r=stack[--top];
    return r;
}
  
int main(){
    int i,sl,j=0,id[25][2];
    char s[50];
      
    gets(s);
    sl=strlen(s);
      
    for(i=0;i<sl;i++){
        if(top==0&&s[i]==')'){
            printf("not match");
            return 0;
        }
        else if(s[i]=='(')
            push(i);
        else if(s[i]==')'){
            id[j][0]=pop();
            id[j++][1]=i;
        }
    }
      
    if(top==0){
        for(i=0;i<j;i++)
            printf("%d %d\n",id[i][0],id[i][1]);
    }
    else
        printf("not match");
          
    system("pause");
	return 0;
}
