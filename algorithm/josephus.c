/*
카메롯 성에서는 회의가 열리고 있다. 밤마다 용이 나타나서 백성들을 괴롭히기 때문 이다.

원탁의 기사 모두가 용과 싸우고 싶어 하지만 많은 군대를 이끌고 가 면 용이 미리 알아채기 때문에 기사 한 명만이 갈 수 있다. 
아더왕은 과연 누구를 보내야 하는 가 고민에 빠졌다.

그러던 중 란슬러트가 묘안을 제시하였다.

원탁에 둘러앉아 있는 기사 n 명에게 시계방향으로 차례대로 1 번부터 n 번의 번호를 부여한다.
그 중 임의의 숫자 m 을 선택하여 그 번호의 기사를 제외 시킨다
다음 그 기사로부터 시계 방향으로 k 번째 있는 기사를 선택하여 제외시킨다.
이렇게 제외된 기사로부터 k 번째 있는 기사를 제외시키는 작업을 단 한 명이 남을 때까지 계속한 뒤 그 결과 마지막으로 남은 기사가 용과 싸우러 가는 것이다.


예를 들어 n=8, m=2, k=3 인 경우 2 가 먼저 제외된 후 이어 5 번 8 번 기사가 차례대로 제외된다.

원탁의 기사의 수, 처음 선택한 기사의 번호 , 다음으로 몇 번째 기사를 제외시킬 것인가 하는 가 주어질 때 제외되는 기사들의 번호를 순서대로 출력 한다.

입력 형식

n,m,k 가 차례대로 입력된다. n , m , k 은 2 이상 1000 이하인 정수이다.

출력 형식

제외되는 기사들의 번호를 제외되는 순서대로 출력한다. 마지막에 출력된 기사가 선택되는 것이다.

입출력 예

입력

8 2 3

출력

2 5 8 4 1 7 3 6
권장 사항

linked list 로 구현
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
