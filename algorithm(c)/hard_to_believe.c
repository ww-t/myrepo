/*
A + B = C
A 를 뒤집고, B 를 뒤집은 합이 C 의 뒤집은 합과 같을 때 True 를 아니면 False 를 출력한다.
001000 의 뒤집은 수는 100.(즉 무효의 영이 입력으로 주어질 수 있고 , 이 무효의 영을 뒤집은 경우 유효의 영으로 바뀌는 경우에 주의한다.

입력

각 숫자는 최대 7 자리까지이고 , 입력사이에 공백은 없다.

출력

True 혹은 False 를 출력한다.

입출력 예

입력

73+42=16

출력

True

입력

5+8=13

출력

False

입력

10+20=30

출력

True

입력

0001000+000200=00030

출력

True

입력

1234+5=1239

출력

False

입력

1+0=0

출력

False

입력

7000+8000=51

출력

True
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
	char s[23],r[23];
	int a,b,c,l,i;
	
	gets(s);
	l=strlen(s);
	
	for(i=0;i<l;i++)
		r[i]=s[l-i-1];
		
	sscanf(r,"%d=%d+%d",&c,&b,&a);
	
	if(a+b==c)
		printf("True\n");
	else
		printf("False\n");
		
	system("pause");
	return 0;
}
