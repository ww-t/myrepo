/*
������ �־��� �� ���� ¦�� ��ȣ�� ��ġ�� ã�� �����̴�.

(a*(b+c)+d)

�� ��쿡�� 3 �� 7 , 0 �� 10 �� �� ���� ��ȣ�̴�.

�Է�

�Է��� ������� �Էµȴ�. �ԷµǴ� ���ڴ� �ҹ���,�Ұ�ȣ,(+,-,*,/)�̴�.
���ڿ��� ���̴� �ִ� 50 �����̴�.

���

���ʿ��� �������� ���鼭 ���� ¦�� �´� (���� ��ȣ ��ġ, �ݴ� ��ȣ ��ġ) ������ ����ϰ�, ¦�� ���� �ʴ� ������ not match �� ����Ѵ�.

�� ��� ��

�Է�

(a*(b+c)+d)

���

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
