/*
jolly sort 란 오름,내림이 반복되는 상태를 말한다.

예를 들어 , { 1 , 5, 6 , 8 , 9 , 2 , 3 , 4 , 7 } 에서 {1 , 5 , 2 , 4 ,3 , 9 , 6 , 8 ,7 } 는 jolly sort 의 한 예이다. 처음 두 개의 수는 오름차순으로 되어야 한다.

입력

입력의 첫 수는 수의 개수 n 이다. n 은 20 이하의 양의 정수이고 같은 수는 입력되지 않는다.
입력되는 수는 100 이하의 양의 정수이다.

출력

jolly sort 한 수열을 출력한다. 여러개의 답이 존재하는 경우 그 중 하나만을 출력한다.

입출력 예

입력

9
1 5 6 8 9 2 3 4 7

출력

1 5 2 4 3 9 6 8 7
*/

#include <stdio.h>
#include <stdlib.h>

int main(){
	int n,i,a[20],j[20];
	
	scanf("%d",&n);
	
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
		
	int compare(int *a,int *b){
		if(*a>*b)
			return 1;
		else
			return -1;
	}
	
	qsort(a,n,sizeof(int),compare);
	
	for(i=0;i<=n-1-i;i++){
		if(i==n-1-i)
			j[2*i]=a[i];
		else{
			j[2*i]=a[i];
			j[2*i+1]=a[n-1-i];
		}
	}
	
	for(i=0;i<n;i++)
		printf("%d ",j[i]);
		
	printf("\n");
	system("pause");
	return 0;
}
