/*
���� n �� ���� ���� ���ϴ� �����̴�.

�Է�

���� n ( 0 <= n <2^63) �� �Է����� �־�����.
���

q^2 >= n �� �����ϴ� ���� �ƴ� ���� ���� �ּ� q �� ����Ѵ�.
����� ��

�Է�

122333444455555

���

11060446
*/

#include <stdio.h>
#include <stdlib.h>
 
int main(int argc, char *argv[])
{
    long long n;
     
    scanf("%lld",&n);
     
    n=(long long)ceil(sqrt((double)n));
     
    printf("%lld\n",n);
 
    return 0;
}
