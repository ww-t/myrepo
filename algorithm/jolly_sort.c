/*
jolly sort �� ����,������ �ݺ��Ǵ� ���¸� ���Ѵ�.

���� ��� , { 1 , 5, 6 , 8 , 9 , 2 , 3 , 4 , 7 } ���� {1 , 5 , 2 , 4 ,3 , 9 , 6 , 8 ,7 } �� jolly sort �� �� ���̴�. ó�� �� ���� ���� ������������ �Ǿ�� �Ѵ�.

�Է�

�Է��� ù ���� ���� ���� n �̴�. n �� 20 ������ ���� �����̰� ���� ���� �Էµ��� �ʴ´�.
�ԷµǴ� ���� 100 ������ ���� �����̴�.

���

jolly sort �� ������ ����Ѵ�. �������� ���� �����ϴ� ��� �� �� �ϳ����� ����Ѵ�.

����� ��

�Է�

9
1 5 6 8 9 2 3 4 7

���

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
