/*
��ź�� �ø��� ���ڸ� �����ϴ� ������ �ϰ� �ִ�.

��ź�� 1 �� 10 ���� ���� �� �� ���ڸ� �����ϰ� , �ø��� ��ź�� ���� ���� ������ ���� ���ߴ� �����̴�.
�ø��� ���ڸ� �θ� �� ���� ��ź�� �ø��� ���� ������ ������ �ƴϸ� �´����� ������ �ش�.

���� ���� �� ���� �� �� , �ø��� ��ź�� Ȥ�� �������� �ϴ����� �ǽɽ����� ����. �� �ø��� ���ڸ� �θ� �� Ȥ ���ڸ� �ٲٴ°� �ƴѰ� �ϰ�.

��ź�� �������� �ϴ��� �ƴ����� �˾ƺ����� �ø��� ���� ���¸� ��� �ߴ�. �� ���� ���¸� ���� ��ź�� ������ �ϰ� �ִ��� �ƴ����� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.

�Է�

�ø��� �θ� ����(1 �� 10 ����)�� ���� �ٿ��� �� ���ڿ� ���� ��ź�� ������ ��ϵȴ�. right on �� �ԷµǸ� ������ ������ ���̴�.
��ź�� ������ �Ʒ� �� ���� �� �ϳ��̴�. too high , too low , right on

���

��ź�� ������ �Դٸ� ���ٸ� �ϴ� ��� Stan is dishonest �� ����ϰ� �ƴϸ� Stan may be honest �� ����Ѵ�.

����� ��

�Է�

10
too high
3
too low
4
too high
2
right on

���

Stan is dishonest

�Է�

5
too low
7
too high
6
right on

���

Stan may be honest
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
	int ii,k,f,l=1,h=10;
	char is[10];
	
	while(1){
		scanf("%d",&ii);
		fflush(stdin);
		gets(is);
		
		if(strcmp(is,"too high")==0){
			if(h>=ii)
				h=ii-1;
		}
		else if(strcmp(is,"too low")==0){
			if(l<=ii)
				l=ii+1;
		}
		else if(strcmp(is,"right on")==0){
			if(l<=ii&&ii<=h)
				printf("Stan may be honest\n");
			else
				printf("Stan is dishonest\n");
			break;
		}
	}
	
	system("pause");
	return 0;
}
