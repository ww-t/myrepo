/*
ī�޷� �������� ȸ�ǰ� ������ �ִ�. �㸶�� ���� ��Ÿ���� �鼺���� �������� ���� �̴�.

��Ź�� ��� ��ΰ� ��� �ο�� �;� ������ ���� ���븦 �̲��� �� �� ���� �̸� �˾�ä�� ������ ��� �� ���� �� �� �ִ�. 
�ƴ����� ���� ������ ������ �ϴ� �� ��ο� ������.

�׷��� �� ������Ʈ�� ������ �����Ͽ���.

��Ź�� �ѷ��ɾ� �ִ� ��� n ���� �ð�������� ���ʴ�� 1 ������ n ���� ��ȣ�� �ο��Ѵ�.
�� �� ������ ���� m �� �����Ͽ� �� ��ȣ�� ��縦 ���� ��Ų��
���� �� ���κ��� �ð� �������� k ��° �ִ� ��縦 �����Ͽ� ���ܽ�Ų��.
�̷��� ���ܵ� ���κ��� k ��° �ִ� ��縦 ���ܽ�Ű�� �۾��� �� �� ���� ���� ������ ����� �� �� ��� ���������� ���� ��簡 ��� �ο췯 ���� ���̴�.


���� ��� n=8, m=2, k=3 �� ��� 2 �� ���� ���ܵ� �� �̾� 5 �� 8 �� ��簡 ���ʴ�� ���ܵȴ�.

��Ź�� ����� ��, ó�� ������ ����� ��ȣ , �������� �� ��° ��縦 ���ܽ�ų ���ΰ� �ϴ� �� �־��� �� ���ܵǴ� ������ ��ȣ�� ������� ��� �Ѵ�.

�Է� ����

n,m,k �� ���ʴ�� �Էµȴ�. n , m , k �� 2 �̻� 1000 ������ �����̴�.

��� ����

���ܵǴ� ������ ��ȣ�� ���ܵǴ� ������� ����Ѵ�. �������� ��µ� ��簡 ���õǴ� ���̴�.

����� ��

�Է�

8 2 3

���

2 5 8 4 1 7 3 6
���� ����

linked list �� ����
*/

#include <stdio.h>
#include <stdlib.h> 

struct linkedlist{
	int num;
	struct linkedlist *next;
};

typedef struct linkedlist ll;

ll *head=NULL,*tail=NULL;

void creat(int n){
	int i;
	
	ll *newlist=(ll*)malloc(sizeof(ll));    
		
	newlist->num=n;
	newlist->next=NULL;
	if(head==NULL){
		head=newlist;
		tail=newlist;
	}
	else{
		tail->next=newlist;
		tail=newlist;
	}
}

void choice(int n,int m,int k){
	ll *choicelist,*pchoicelist;
	int i,j;
	
	pchoicelist=head;
	
	for(i=2;i<m;i++)
		pchoicelist=pchoicelist->next;
	for(i=1;i<n;i++){
		choicelist=pchoicelist->next;
		printf("%d ",choicelist->num);
		pchoicelist->next=choicelist->next;
		free(choicelist);
		for(j=1;j<k;j++)
			pchoicelist=pchoicelist->next;
	}
	choicelist=pchoicelist->next;
	printf("%d\n",choicelist->num);
	free(choicelist);
}

int main(){
	int n,m,k,i;
	
	scanf("%d %d %d",&n,&m,&k);
	
	for(i=1;i<=n;i++)
		creat(i);
	tail->next=head;
	choice(n,m,k);
	
	return 0;
}
