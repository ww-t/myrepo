/*
입력으로 n ( 10 이하의 자연수) 이 주어지고 , n * n 의 맵 정보가 주어진다.

처음 n*n 에는 지도의 정보가 주어지고 , . 은 지뢰없음을 , * 는 지뢰 지역을 나타낸다.
다음 n*n 에는 클릭한 정보가 주어진다. x 는 클릭한 지역 . 은 클릭하지 않은 지역
출력은 x 의 인접한 8 방향에 있는 있는 지뢰 수를 출력하는 게 문제이고 , . 으로 표시된 지역은 . 으로 표시한다.
단, x 위치에 지뢰가 존재하는 경우( 지뢰가 있는 지역을 클릭한 경우) 지뢰가 존재하는 모든 지역을 * 로 표시하고 , 지뢰가 존재하지 않는 x 위치는 숫자로 표시한다.

입력

n 이 주어지고 , 다음 n*n 의 지도 정보 , 다음 n*n 의 클릭 정보가 주어진다.

출력

숫자는 x 위치와 인접한 지뢰의 개수이다.

입출력 예

입력

3
..*
*..
.*.
xx.
.x.
x..

출력

12.
.3.
2..

입력

3
..*
*..
.*.
xxx
.x.
x..

출력

12*
*3.
2*.
*/

#include <stdio.h>
#include <stdlib.h>

int main(){
	char map[12][12]={0},click[12][12]={0};
	int i,j,mc,c,r,n;
	char m='.';
	
	scanf("%d",&n);
	getchar();
	for(i=1;i<=n;i++){
		for(j=1;j<=n;j++)
			scanf("%c",&map[i][j]);
		getchar();
	}
	for(i=1;i<=n;i++){
		for(j=1;j<=n;j++){
			scanf("%c",&click[i][j]);
			if(map[i][j]=='*'&&click[i][j]=='x')
				m='*';
		}
		getchar();
	}
	for(i=1;i<=n;i++){
		for(j=1;j<=n;j++){
			if(map[i][j]=='*')
				printf("%c",m);
			else if(click[i][j]=='x'){
				mc=0;
				for(r=i-1;r<=i+1;r++){
					for(c=j-1;c<=j+1;c++){
						if(map[r][c]=='*')
							mc++;
					}
				}
				printf("%d",mc);
			}
			else
				printf(".");
		}
		printf("\n");
	}
	
	system("pause");
	return 0;
} 
