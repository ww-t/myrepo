/*
농부 존은 N (2 <= N <= 100,000)개의 우리(stall)를 가진 긴 축사(barn)를 지으려고 한다. 우리(stall)는 직선 형태로 각각은 x1 ,x2 , .. , xn 에 위치하고 있다.
(0 <= xi <= 1,000,000,000).

그가 가진 C 마리의 소들은 한 우리에 넣는 경우 매우 공격적이 된다. 
소들이 서로 싸워 다치지 않게 우리에 넣은 인접한 소들의 떨어진 거리의 최소 값이 가능한 크게 소들을 배치하기를 원한다.

최대 최소 거리는 얼마인가?

입력

첫 줄에는 두 정수 N , C 가 주어진다.
다음 N 줄에는 xi 가 주어진다.

출력

가장 큰 최소 거리를 출력한다.

입출력 예

입력

5 3
1
2
8
4
9

출력

3

출력 보충

3 마리의 소를 1 , 4 , 8 위치에 둘 경우 최소 거리가 3 으로 가장 크다.
1	2	3	4	5	6	7	8	9
	 	 		 	 	 		 
* 큰 데이터가 주어지니 scanf 권장
*/

#include <stdio.h>
#include <stdlib.h>

int n,c,x[100001];

int dt(int d){
	int i,cc=1,cr=x[1];
	
	for(i=2;i<=n;i++){
		if(x[i]-cr>=d){
			cr=x[i];
			cc++;
		}
	}
	if(cc>=c)
		return 1;
	else
		return 0;
}

int main(){
	int l,h,m,i;
	
	scanf("%d %d",&n,&c);
	
	for(i=1;i<=n;i++)
		scanf("%d",&x[i]);
		
	int compare(const void *a,const void *b){
		if(*(int*)a>*(int*)b)
			return 1;
		else
			return 0;
	}
	
	qsort(x,n,sizeof(x[0]),compare);
	
	l=1; h=(x[n]-x[1])/(c-1);
	
	while(l<=h){
		m=(l+h)/2;
		
		if(dt(m))
			l=m+1;
		else
			h=m-1;
	}
	
	printf("%d\n",h);
	
	system("pause");
	return 0;
}
