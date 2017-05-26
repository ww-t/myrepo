/*
문자열 dovelet 이 주어질 때

0	1	2	3	4	5	6
d	o	v	e	l	e	t

이 문자열로 만들 수 있는 접미사는 7 개 이다.

dovelet(0)
ovelet(1)
velet(2)
elet(3)
let(4)
et(5)
t(6)

이 접미사 배열(suffix array)을 정렬하면

dovelet(0)
elet(3)
et(5)
let(4)
ovelet(1)
t(6)
velet(2)

입력

입력은 2000 이하의 문자열이 주어진다.

출력

정렬한 접미사 배열을 출력한다. 문자열과 수 사이에는 한 칸의 공백을 둔다.

입출력 예

입력

dovelet

출력

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
