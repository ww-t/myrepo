/*
농부 존은 축사에 새로운 보안 시스템을 설치 후 소들에게 가능한 모든 유효한 번호를 알려 주어야 한다.

유효한 비밀번호란 L 개의 서로다른 소문자로 이루어지고 (관습적으로 'a' ... 'z') 을 사용하고 , 적어도 모음 한자와 자음 2 자를 가져야 하고 ,
문자들은 오름차순으로 이루어져야 한다. ( 즉 abc 는 유효한 비밀번호이지만 , cba 는 아님)

사용할 수 있는 문자와 패스워드의 자리수가 주어질 때 유효한 비밀번호를 모두 출력하는게 문제이다.

입력

첫 줄은 L , C 가 입력으로 주어진다. L 은 만들고자 하는 패스워드의 크기이고 C 는 사용할 수 있는 소문자의 개수이다. 다음 줄에는 C 개의 소문자가 입력으로 주어진다.

출력

스페이스 없이 가능한 패스워드를 사전식 오름차순 순으로 출력한다.

입출력 예

입력

4 6
a t c i s w

출력

acis
acit
aciw
acst
acsw
actw
aist
aisw
aitw
astw
cist
cisw
citw
istw
*/

#include <stdio.h>
#include <stdlib.h>

int main(){
	int l,c,i;
	char ch[26],pwd[26];
	
	scanf("%d %d",&l,&c);
	
	for(i=0;i<c;i++)
		scanf(" %c",&ch[i]);
	
	int compare(void *a,void *b){
		if(*(char*)a>*(char*)b)
			return 1;
		else
			return -1;
	}
	
	qsort(ch,c,sizeof(ch[0]),compare);
	
	int ck(){
		int j,m=0,n=0;
		
		for(j=0;j<l;j++){
			if(pwd[j]=='a'||pwd[j]=='e'||pwd[j]=='i'||pwd[j]=='o'||pwd[j]=='u')
				m++;
			else
				n++;
		}
		if(m>=1&&n>=2)
			return 1;
		else
			return 0;
	}
		
	void sc(int p,int q){
		int j;
		
		if(p==l){
			if(ck()){
				for(j=0;j<l;j++)
					printf("%c",pwd[j]);
				printf("\n");
			}
			return;
		}
		else if(q>=c)
			return;
		else{
			pwd[p]=ch[q];
			sc(p+1,q+1);
			sc(p,q+1);
		}
	}
	
	sc(0,0);
	
	system("pause");
	return 0;
}
