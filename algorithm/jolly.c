/*
n ���� ���� �̷���� ������ �־��� �� ������ ���� ���̰� 1 ���� n-1 ������ ���� ����� ���� �� �̸� jolly jumper �� �Ѵ�.
�� ���ʴ�� 1 ���� ����� �� �ʿ�� ����.

���� ��� �Ʒ��� ���� 4 ���� ���� �̷������ ������ �־��� ��

1 4 3 1
�� ������ ������ ���� ���� 3 1 2 �̹Ƿ� jolly jumper �̴�.

1 4 2 3
�� ������ ���� ���� 3 2 1 �̹Ƿ� jolly jumper �̴�.

���� �ϳ��� �ִ� ���� jolly jumper�� �����Ѵ�.

������ jolly jumper ���� �ƴ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�

�Է��� ù���� 3000 ������ 0 ���� ū ���� n �� �Էµǰ� �������� n ���� ���� �Էµȴ�.

���

jolly jumper �̸� Jolly�� �ƴϸ� Not jolly�� ��� �Ѵ�.

����� ��

�Է� 

4
1 4 2 3

��� 

Jolly

�Է� 

5 
1 4 2 -1 6

���

Not jolly
*/

#include <stdio.h>
#include <stdlib.h>

int main(){
    
    int n,i,x,bet;
    int a[3000]={};
    int b[3000];
    
    scanf("%d",&n);
    
    for(i=0;i<n;i++){
         scanf("%d",&x);
         b[i]=x;
         if(i>0){
              bet=abs(b[i-1]-b[i]);
              a[bet-1]=1;
         }
    }
    
    for(i=0;i<n-1;i++){
         if(a[i]==0){
              printf("Not jolly\n");
              
              system("pause");
              return 0;
         }
    }
    
    printf("Jolly\n");
    
    system("pause");
    return 0;
}
