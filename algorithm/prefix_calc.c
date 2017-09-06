/*
전위표현식이 입력으로 주어질 때 이 를 계산하는 프로그램을 작성하는 것이 문제이다.

문제를 간단히 하기위해 연산자는 +,-,*,/ 로 한정하고 데이터는 한 자리수로 한정한다. 잘못된 수식은 입력되지 않는다.

계산 중간에 0 으로 나누어지는 수가 있으면 "Divide by zero" 를 출력한다.

입력

공백 없이 한 줄에 하나의 데이터가 입력으로 주어진다.

출력

연산한 결과를 출력한다.

입출력 예

입력

+42

출력

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
