/*
A + B = C
A �� ������, B �� ������ ���� C �� ������ �հ� ���� �� True �� �ƴϸ� False �� ����Ѵ�.
001000 �� ������ ���� 100.(�� ��ȿ�� ���� �Է����� �־��� �� �ְ� , �� ��ȿ�� ���� ������ ��� ��ȿ�� ������ �ٲ�� ��쿡 �����Ѵ�.

�Է�

�� ���ڴ� �ִ� 7 �ڸ������̰� , �Է»��̿� ������ ����.

���

True Ȥ�� False �� ����Ѵ�.

����� ��

�Է�

73+42=16

���

True

�Է�

5+8=13

���

False

�Է�

10+20=30

���

True

�Է�

0001000+000200=00030

���

True

�Է�

1234+5=1239

���

False

�Է�

1+0=0

���

False

�Է�

7000+8000=51

���

True
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
	char s[23],r[23];
	int a,b,c,l,i;
	
	gets(s);
	l=strlen(s);
	
	for(i=0;i<l;i++)
		r[i]=s[l-i-1];
		
	sscanf(r,"%d=%d+%d",&c,&b,&a);
	
	if(a+b==c)
		printf("True\n");
	else
		printf("False\n");
		
	system("pause");
	return 0;
}
