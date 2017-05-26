/*
수 N 을 입력으로 받아 0 부터 N 까지의 수를 사용하여 0 과 1 사이(0,1 포함)에 있는 기약분수를 구하는게 문제이다.

예를 들어 , N 이 5 이면 0 , 1 , 2 , 3 , 4 , 5 를 사용하여 0 과 1 사이수를 크기 순으로 구하면

0/1 1/5 1/4 1/3 2/5 1/2 3/5 2/3 3/4 4/5 1/1
이 된다. 시간은 2 초를 초과할 수 없다.

입력 형식

양의 정수 N (1 <= N <= 100) 이 입력된다.

출력 형식

한 줄에 하나씩 크기 순으로 출력한다.

입출력 예

입력

5

출력 

0/1
1/5
1/4
1/3
2/5
1/2
3/5
2/3
3/4
4/5
1/1
*/

#include <stdio.h>
#include <stdlib.h>

struct sf{
	int s;
	int p;
	double v;
};

int main(){
	int n,i,j,id=0;
	struct sf a[5150];
	
	scanf("%d",&n);
	
	int ft(int x,int y){
		int r;
		while(y!=0){
			r=x%y;
			x=y;
			y=r;
		}
		if(x==1)
			return 1;
		else
			return 0;
	}
	
	void sort(){
		struct sf tmp;
		for(i=id;i>=2;i--){
			for(j=0;j<i-1;j++){
				if(a[j].v>a[j+1].v){
					tmp=a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
				}
			}
		}
	}
	
	for(i=2;i<=n;i++){
		for(j=1;j<i;j++){
			if(ft(i,j)){
				a[id].s=j;
				a[id].p=i;
				a[id].v=(double)j/i;
				id++;
			}
		}
	}
	
	sort();
	
	printf("0/1\n");
	for(i=0;i<id;i++)
		printf("%d/%d\n",a[i].s,a[i].p);
	printf("1/1\n");
	
	system("pause");
	return 0;
}
