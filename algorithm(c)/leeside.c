/*
�� ���� �Է����� �־�����. R �� ���� ���̰� , S �� ����(seed) �� �̴�.

���� ���� �ﰢ���� ���� ���� ���� �����Ѵ�. �� �ﰢ���� ��Ģ�� �Ʒ� ���⿡ ���õǾ� �ִ�.

S �� 1 �� �����ϸ鼭 �밢 ������ �����Ѵ�. S �� 10 �� �̻��̸� �ٽ� 1 ���� ����.

���� ������ ���� , �Ʒ� �� ���� ���� 10 ���� ���� �������� �����ȴ�.

5 *
  6
5 6 �� ���� 11 �� 10 ���� ���� ������ �� * �ڸ��� 1 �� ä������.
�� ���� �Է����� �޾� �� �ﰢ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�

�� �� R , S �� �־�����. ( 1 <= R <= 30 , 1 <= S <= 9)

���

��� ���� �������� ����Ѵ�.�� �ʿ��� ������ ����ؼ��� �ȵȴ�.

����� ��

�Է�

5 3

���

3 7 6 6 0
  4 9 0 4
    5 1 4
      6 3
        7
        
��� ����

������ . ���� ����Ѵٸ� �Ʒ��� ���� ����
3.7.6.6.0
..4.9.0.4
....5.1.4
......6.3
........7
*/

#include <stdio.h>
#include <stdlib.h>

int main(){
	int r,s,i,j;
	int a[30][30];
	
	scanf("%d %d",&r,&s);
	
	for(i=0;i<r;i++){
		if(s==10)
			s=1;
		a[i][0]=s++;
	}
	
	for(i=0;i<r-1;i++){
		for(j=0;j<r-1-i;j++)
			a[j][i+1]=(a[j][i]+a[j+1][i])%10;
	}
	
	for(i=0;i<r;i++){
		for(j=0;j<i;j++)
			printf("  ");
		for(j=0;j<r-i;j++){
			if(j==r-i-1)
				printf("%d",a[i][j]);
			else
				printf("%d ",a[i][j]);
		}
		printf("\n");
	}
	
	system("pause");
	return 0;
}