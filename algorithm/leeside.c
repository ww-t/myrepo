/*
두 수가 입력으로 주어진다. R 은 행의 수이고 , S 는 종자(seed) 수 이다.

종자 수는 삼각형의 왼쪽 위의 수를 결정한다. 이 삼각형의 규칙은 아래 보기에 제시되어 있다.

S 를 1 씩 증가하면서 대각 성분을 결정한다. S 가 10 을 이상이면 다시 1 부터 시작.

다음 수들은 왼쪽 , 아래 쪽 수의 합을 10 으로 나눈 나머지로 결정된다.

5 *
  6
5 6 를 더한 11 을 10 으로 나눈 나머지 즉 * 자리에 1 이 채워진다.
두 수를 입력으로 받아 이 삼각형을 출력하는 프로그램을 작성하시오.

입력

두 수 R , S 가 주어진다. ( 1 <= R <= 30 , 1 <= S <= 9)

출력

출력 예의 형식으로 출력한다.불 필요한 공백을 출력해서는 안된다.

입출력 예

입력

5 3

출력

3 7 6 6 0
  4 9 0 4
    5 1 4
      6 3
        7
        
출력 보충

공백을 . 으로 출력한다면 아래와 같은 형식
3.7.6.6.0
..4.9.0.4
....5.1.4
......6.3
........7
*/

#include <stdio.h>
#include <stdlib.h>

int main(){
	int r,s,i,j;
	int a[30][30];
	
	scanf("%d %d",&r,&s);
	
	for(i=0;i<r;i++){
		if(s==10)
			s=1;
		a[i][0]=s++;
	}
	
	for(i=0;i<r-1;i++){
		for(j=0;j<r-1-i;j++)
			a[j][i+1]=(a[j][i]+a[j+1][i])%10;
	}
	
	for(i=0;i<r;i++){
		for(j=0;j<i;j++)
			printf("  ");
		for(j=0;j<r-i;j++){
			if(j==r-i-1)
				printf("%d",a[i][j]);
			else
				printf("%d ",a[i][j]);
		}
		printf("\n");
	}
	
	system("pause");
	return 0;
}
