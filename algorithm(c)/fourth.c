/*
주희는 축에 평행 한 직사각형을 만들기 위해 3 점을 선택 후 네 번째 점을 구하는데 고생을 하고 있다.
주희를 도와 네 번째 점을 구하라.

입력

1 에서 1000 이하의 정수 3 쌍이 입력으로 주어진다.
출력

네 번째 점을 구하라.
입출력 예

입력

5 5
5 7
7 5

출력

7 7

입력

30 20
10 10
10 20

출력

30 10
*/

#include <stdio.h>
#include <stdlib.h>
 
int main()
{
    int x1,y1,x2,y2,x3,y3,x4,y4;
     
    scanf("%d %d",&x1,&y1);
    scanf("%d %d",&x2,&y2);
    scanf("%d %d",&x3,&y3);
     
    if(x1==x2)
              x4=x3;  
    else if(x1==x3)
              x4=x2;
    else
              x4=x1;
    if(y1==y2)
              y4=y3;
    else if(y1==y3)
              y4=y2;
    else
              y4=y1;
     
    printf("%d %d\n",x4,y4);
     
    return 0;
}
