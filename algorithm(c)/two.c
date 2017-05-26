/*
2 의 N 거듭 제곱을 구하는 문제이다.

N 이 3 이면 8 , 10 이면 1024

입력

N 이 주어진다. ( 0 <= N <= 265)

출력

2^N 을 출력한다.

입출력 예

입력

100

출력

1267650600228229401496703205376
*/

#include <stdio.h>
#include <stdlib.h>

int main(){
	int n,q,l,i,j,a[80];
	
	scanf("%d",&n);
	
	q=0; l=1; a[0]=1;
	
	for(i=0;i<n;i++){
		for(j=0;j<l;j++){
			a[j]=a[j]*2+q;
			q=a[j]/10;
			a[j]=a[j]%10;
		}
		for(;q!=0;l++){
			a[l]=q%10;
			q=q/10;
		}
	}
	
	for(i=l-1;i>=0;i--)
		printf("%d",a[i]);
	printf("\n");
	
	system("pause");
	return 0;
}
