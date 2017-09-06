/*
등차수열이란 인접한 항과의 차이가 동일한 수열을 말한다.

문제는 초항 a 와 공차 d 수 an 이 주어질 때 이 수 an 이 몇 번째 항 인가 찾는 것이다.
입력

세 정수 a , d , an 이 주어진다. -1000 < a,d < 1000 , -100000 < an < 100000
단 , d 는 0 이 아니다.

출력

an 이 몇 번째 항 인 가를 출력한다. 만약 이 수열의 수가 아니면 X 를 출력한다.
입출력 예

입력

1 2 9

출력

5

입력

2 2 9

출력

X
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,d,an;
    
    scanf("%d %d %d",&a,&d,&an);
    
    if((an-a+d)%d==0)
                     printf("%d\n",(an-a+d)/d);
    else
                     printf("X\n");
                     
    system("pause");
    return 0;
}
