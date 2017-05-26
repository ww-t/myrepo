/*
���ڿ� dovelet �� �־��� ��

0	1	2	3	4	5	6
d	o	v	e	l	e	t

�� ���ڿ��� ���� �� �ִ� ���̻�� 7 �� �̴�.

dovelet(0)
ovelet(1)
velet(2)
elet(3)
let(4)
et(5)
t(6)

�� ���̻� �迭(suffix array)�� �����ϸ�

dovelet(0)
elet(3)
et(5)
let(4)
ovelet(1)
t(6)
velet(2)

�Է�

�Է��� 2000 ������ ���ڿ��� �־�����.

���

������ ���̻� �迭�� ����Ѵ�. ���ڿ��� �� ���̿��� �� ĭ�� ������ �д�.

����� ��

�Է�

dovelet

���

dovelet 0
elet 3
et 5
let 4
ovelet 1
t 6
velet 2
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
	char s[2001];
	char *sa[2000];
	int i,sal,sl;
	
	gets(s);
	
	for(i=0;s[i]!='\0';i++)
		sa[i]=&s[i];
		
	sal=i;
	sl=strlen(s);
		
	int compare(const void* a,const void* b){
		return strcmp(*(char**)a,*(char**)b);
	}
	
	qsort(sa,sal,sizeof(sa[0]),compare);
	
	for(i=0;i<sal;i++)
		printf("%s %d\n",sa[i],sl-strlen(sa[i]));
		
	system("pause");
	return 0;
}
