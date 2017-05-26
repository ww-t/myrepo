/*
스탄과 올리는 숫자를 추측하는 게임을 하고 있다.

스탄은 1 과 10 사이 숫자 중 한 숫자를 생각하고 , 올리는 스탄이 무슨 수를 생각한 지를 맞추는 게임이다.
올리가 숫자를 부를 때 마다 스탄은 올리의 수가 높은지 낮은지 아니면 맞는지를 가려켜 준다.

판이 여러 번 돌고 난 후 , 올리는 스탄이 혹시 거짓말을 하는지가 의심스러워 졌다. 즉 올리가 숫자를 부를 때 혹 숫자를 바꾸는게 아닌가 하고.

스탄이 거짓말을 하는지 아닌지를 알아보려고 올리는 판의 상태를 기록 했다. 이 판의 상태를 보고 스탄이 거짓을 하고 있는지 아닌지를 알아내는 프로그램을 작성하시오.

입력

올리가 부른 숫자(1 과 10 사이)와 다음 줄에는 이 숫자에 대한 스탄의 판정이 기록된다. right on 이 입력되면 게임이 끝나는 것이다.
스탄의 판정은 아래 세 가지 중 하나이다. too high , too low , right on

출력

스탄의 판정이 왔다리 갔다리 하는 경우 Stan is dishonest 를 출력하고 아니면 Stan may be honest 를 출력한다.

입출력 예

입력

10
too high
3
too low
4
too high
2
right on

출력

Stan is dishonest

입력

5
too low
7
too high
6
right on

출력

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
