/*
�� N �� �Է����� �޾� 0 ���� N ������ ���� ����Ͽ� 0 �� 1 ����(0,1 ����)�� �ִ� ���м��� ���ϴ°� �����̴�.

���� ��� , N �� 5 �̸� 0 , 1 , 2 , 3 , 4 , 5 �� ����Ͽ� 0 �� 1 ���̼��� ũ�� ������ ���ϸ�

0/1 1/5 1/4 1/3 2/5 1/2 3/5 2/3 3/4 4/5 1/1
�� �ȴ�. �ð��� 2 �ʸ� �ʰ��� �� ����.

�Է� ����

���� ���� N (1 <= N <= 100) �� �Էµȴ�.

��� ����

�� �ٿ� �ϳ��� ũ�� ������ ����Ѵ�.

����� ��

�Է�

5

��� 

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
