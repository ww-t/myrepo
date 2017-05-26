/*
����ǥ������ �Է����� �־��� �� �� �� ����ϴ� ���α׷��� �ۼ��ϴ� ���� �����̴�.

������ ������ �ϱ����� �����ڴ� +,-,*,/ �� �����ϰ� �����ʹ� �� �ڸ����� �����Ѵ�. �߸��� ������ �Էµ��� �ʴ´�.

��� �߰��� 0 ���� ���������� ���� ������ "Divide by zero" �� ����Ѵ�.

�Է�

���� ���� �� �ٿ� �ϳ��� �����Ͱ� �Է����� �־�����.

���

������ ����� ����Ѵ�.

����� ��

�Է�

+42

���

6
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int stack[50],top=0;

void push(int a){
	stack[top++]=a;
	return;
}

int pop(){
	int r=stack[--top];
	return r;
}

int calc(char ot,int op1,int op2){
	if(op2==0&&ot=='/'){
		printf("Divide by zero");
		system("pause");
		exit(1);
	}
	switch(ot){
		case '+': return op1+op2;
		case '-': return op1-op2;
		case '*': return op1*op2;
		case '/': return op1/op2;
	}
}

int main(){
	int o1,o2,i,sl;
	char s[50];
	
	scanf("%s",s);
	sl=strlen(s);
	
	for(i=sl-1;i>=0;i--){
		if(isdigit(s[i]))
			push(s[i]-'0');
		else{
			o1=pop();
			o2=pop();
			push(calc(s[i],o1,o2));
		}
	}
	printf("%d\n",stack[top-1]);
	
	system("pause");
	return 0;
}
