/*
n,r, 그리고 p ,q 를 입력받아 n 개의 문자 중 r 개를 택하는 순열을 사전 순서로 배열했을 때 p 번째 위치한 순열과 n 개의 문자 중 r 개를 택하는 조합을 사전 순서로 
배열했을 때 q 번째 위치한 조합을 출력하는 프로그램을 작성하시오. n 개의 문자는 A부터 시작하는 알파벳 대문자이다.

예를 들어 n=4,r=2 ,p=5 ,q=5 인 경우 A, B, C, D 네 개의 문자 중 두 개를 택하여 만든 순열을 사전 순서대로 배열한 아래와 같은 모양에서 다섯 번째 위치한 BC와,

AB, AC, AD, BA, BC, BD, CA, CB, CD, DA, DB, DC

A, B, C, D 네 개의 문자 중 두 개를 택하여 만든 조합을 사전 순서대로 배열한 아래와 같은 모양에서 다섯 번째 위치한 BD가 답이 된다.

AB, AC, AD, BC, BD, CD

입력 형식

첫째 줄에 n과 r이 사이에 하나의 공백을 두고 주어 지고
두 번째 줄에 p 와 q 가 사이에 하나의 공백을 두고 주어진다. n 은 12이하의 자연수이며 r 은 n 이하의 자연수이다.
p 는 n 개 중 r 개를 택하는 순열의 수보다, q 는 n 개 중 r 개를 택하는 조합의 수보다 같거나 작다.

출력 형식

첫째 줄에는 n 개의 문자 중 r 개를 택하는 순열을 사전 순서로 배열했을 때 p 번째 위치한 순열을
둘째 줄에는 n 개의 문자 중 r 개를 택하는 조합 을 사전 순서로 배열했을 때 q 번째 위치한 조합을 출력한다.

입출력 예

입력

4 2
5 5

출력

BC
BD
*/

#include <stdio.h>

int n,r,p,q,c=0,ch[12]={0};
char s[12];

void pm(int n1,int r1){
	if(r1==r){
		c++;
		if(c==p)
			printf("%s\n",s);
		return;
	}
	else if(n1==n)
		return;
	else{
		if(ch[n1]==0){
			ch[n1]=1;
			s[r1]='A'+n1;
			pm(0,r1+1);
			ch[n1]=0;
		}
		pm(n1+1,r1);
	}
}

void cb(int n1,int r1){
  	if(r1==r){
  		c++;
  		if(c==q)
   			printf("%s\n",s);
  		return;
	}
	else if(n1==n)
  		return;
 	else{
  		s[r1]='A'+n1;
  		cb(n1+1,r1+1);
		cb(n1+1,r1);
	}
}

int main(){
	int i;
	
	scanf("%d %d %d %d",&n,&r,&p,&q);
	
	pm(0,0);
	c=0;
	cb(0,0);
	
	return 0;
}
