/*
��� ���� �� �߿��� �� ������ ���� �Ⱦ� ��������. �״� �� �Ҹ� ��� ��Ƶ��̰� �;��Ѵ�.

�״� 1 ���� N ( 0 <= N <= 100,000 ) �����߿��� �����ϰ� �Ҵ� K ( 0 <= K <= 100,000) ��° ������ ��ġ�Ѵ�.

���� �ΰ����� �ɷ��� ������ �ְ� �̸� �ϴµ� 1 ���� �ɸ���.

�Ȱų� ... ���� ����-1 Ȥ�� ��������+ 1
�����̵� ... �������� * 2 �� ��ġ�� �̵�
�Ҵ� ���� ������ ���� ���� ��ġä�� ���ؼ� �ٸ� ��ҷ� �̵����� �ʴ´ٰ� �����Ѵ�.

�Է�

N , K �� �Է����� �־�����.

���

�ҵ��� ��µ� �ɸ��� �ּ� �ð�(��)�� ����Ѵ�.

����� ��

�Է�

5 17

���

4

���� ����

10 9 18 17, which takes 4 minutes...
*/

#include <stdio.h>
#include <stdlib.h>

int r[2],front=0,rear=0,queue[100001],check[200001]={0};

void push(int a){
	queue[++rear]=a;
	return;
}

int pop(){
	int r=queue[++front];
	return r;
}

int catch(int jr,int cr){
	int t;
	
	check[jr]=1;
	
	while(1){
		t=pop();
		
		if(t==cr)
			return check[t]-1;
		if(check[t-1]==0&&t>0){
			push(t-1);
			check[t-1]=check[t]+1;
		}
		if(check[t+1]==0&&t<cr){
			push(t+1);
			check[t+1]=check[t]+1;
		}
		if(check[t*2]==0&&t<cr){
			push(t*2);
			check[t*2]=check[t]+1;
		}
	}
}

int main(){
	int n,k;
	
	scanf("%d %d",&n,&k);
	
	if(n>=k)
		printf("%d\n",n-k);
	else{
		push(n);
		printf("%d\n",catch(n,k));
	}
	
	system("pause");
	return 0;
}
