/*
��� ���� N (2 <= N <= 100,000)���� �츮(stall)�� ���� �� ���(barn)�� �������� �Ѵ�. �츮(stall)�� ���� ���·� ������ x1 ,x2 , .. , xn �� ��ġ�ϰ� �ִ�.
(0 <= xi <= 1,000,000,000).

�װ� ���� C ������ �ҵ��� �� �츮�� �ִ� ��� �ſ� �������� �ȴ�. 
�ҵ��� ���� �ο� ��ġ�� �ʰ� �츮�� ���� ������ �ҵ��� ������ �Ÿ��� �ּ� ���� ������ ũ�� �ҵ��� ��ġ�ϱ⸦ ���Ѵ�.

�ִ� �ּ� �Ÿ��� ���ΰ�?

�Է�

ù �ٿ��� �� ���� N , C �� �־�����.
���� N �ٿ��� xi �� �־�����.

���

���� ū �ּ� �Ÿ��� ����Ѵ�.

����� ��

�Է�

5 3
1
2
8
4
9

���

3

��� ����

3 ������ �Ҹ� 1 , 4 , 8 ��ġ�� �� ��� �ּ� �Ÿ��� 3 ���� ���� ũ��.
1	2	3	4	5	6	7	8	9
	 	 		 	 	 		 
* ū �����Ͱ� �־����� scanf ����
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
