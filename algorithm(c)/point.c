/*
두 선분의 양 끝점이 주어질 때 이 선분상에 있는 정수 점의 개수를 구하는 문제이다.
두 점이 (-1,-2) 이고 (3,4) 이면 답은 3

입력

두 쌍의 서로 다른 점의 좌표가 입력으로 주어진다. 주어지는 수는 -100 000 000 ~ 100 000 000 사이의 정수이다.

출력

정수 점의 개수를 출력한다.

입출력 예

입력

-1 -2
3 4

출력

3
*/

#include <stdio.h>

int gcd(int x,int y){
	int r;
	
	while(y!=0){
		r=x;
		x=y;
		y=r%y;
	}
	
	return x;
}

int main(){
	int a,b,c,d,g;
	
	scanf("%d %d %d %d",&a,&b,&c,&d);
	
	g=abs(c-a)/gcd(c-a,d-b);
	
	if(a!=c)
		printf("%d\n",abs(c-a)/abs(g)+1);
	else
		printf("%d\n",abs(d-b)+1);
		
	return 0;
}
