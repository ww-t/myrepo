/*
�� ���� A, B (1 <= A <= B <= 2,000,000,000) �� �־����� A �� B ���� (A, B ����) �� ����� ������ ¦���� ���� ������ ����Ͻÿ�.

�Է�

�� ���� A, B �� �־�����.
���

����� ������ ¦���� ���� ������ ����Ͻÿ�.
����� ��

�Է�

3 17

��� 

12
*/

#include <stdio.h>
#include <stdlib.h>
 
int main(int argc, char *argv[])
{
    int a,b,na,nb;
     
    scanf("%d %d",&a,&b);
     
    na=(int)ceil(sqrt((double)a));
    nb=(int)floor(sqrt((double)b));
     
    printf("%d\n",((b-a)+1)-(nb-na+1));
     
    return 0;
}
