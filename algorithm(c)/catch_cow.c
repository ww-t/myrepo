/*
농부 존의 소 중에서 한 마리가 집이 싫어 도망갔다. 그는 이 소를 즉시 잡아들이고 싶어한다.

그는 1 에서 N ( 0 <= N <= 100,000 ) 지점중에서 시작하고 소는 K ( 0 <= K <= 100,000) 번째 지점에 위치한다.

존은 두가지의 능력을 가지고 있고 이를 하는데 1 분이 걸린다.

걷거나 ... 현재 지점-1 혹은 현재지점+ 1
순간이동 ... 현재지점 * 2 배 위치로 이동
소는 존이 잡으러 오는 것을 눈치채지 못해서 다른 장소로 이동하지 않는다고 가정한다.

입력

N , K 가 입력으로 주어진다.

출력

소들을 잡는데 걸리는 최소 시간(분)을 출력한다.

입출력 예

입력

5 17

출력

4

보충 설명

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
