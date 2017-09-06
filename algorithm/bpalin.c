/*
10 진수 n 의 이진수가 회귀수이면 이 수 n 을 이진 회귀수라 하자.
21 은 10 진수로 회귀수가 아니지만 , 2 진수로는 회귀수이다.(10101)

1 에서 100 000 사이에 있는 이진 회귀수를 모두 출력하는 것이 문제이다.

입력

입력은 없다.

출력

이진 회귀수를 크기 순으로 한 줄에 하나씩 출력한다.

입출력 예

입력

출력

1
3
...
*/

#include <stdio.h>
#include <stdlib.h>

int main(){
	int i,j,a[17],k;
	
	void b(int x){
		if(x==1)
			a[k++]=1;
		else{
			b(x/2);
			a[k++]=x%2;
		}
	}
	
	for(i=1;i<=100000;i++){
		k=0;
		b(i);
		for(j=0;j<k-1-j;j++){
			if(a[j]!=a[k-1-j])
				break;
		}
		if(j>=k-1-j)
			printf("%d\n",i);
	}
	 
	system("pause");
	return 0;
}
