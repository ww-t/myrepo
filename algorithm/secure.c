/*
��� ���� ��翡 ���ο� ���� �ý����� ��ġ �� �ҵ鿡�� ������ ��� ��ȿ�� ��ȣ�� �˷� �־�� �Ѵ�.

��ȿ�� ��й�ȣ�� L ���� ���δٸ� �ҹ��ڷ� �̷������ (���������� 'a' ... 'z') �� ����ϰ� , ��� ���� ���ڿ� ���� 2 �ڸ� ������ �ϰ� ,
���ڵ��� ������������ �̷������ �Ѵ�. ( �� abc �� ��ȿ�� ��й�ȣ������ , cba �� �ƴ�)

����� �� �ִ� ���ڿ� �н������� �ڸ����� �־��� �� ��ȿ�� ��й�ȣ�� ��� ����ϴ°� �����̴�.

�Է�

ù ���� L , C �� �Է����� �־�����. L �� ������� �ϴ� �н������� ũ���̰� C �� ����� �� �ִ� �ҹ����� �����̴�. ���� �ٿ��� C ���� �ҹ��ڰ� �Է����� �־�����.

���

�����̽� ���� ������ �н����带 ������ �������� ������ ����Ѵ�.

����� ��

�Է�

4 6
a t c i s w

���

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
