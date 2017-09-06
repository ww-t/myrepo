/*
Nikky 와 Byron 체육시간에 게임을 하고 있다.

선생님이 Nikky 에게는 a 보 전진 후에 b 보 후퇴하게 , Byron 에게는 c 보 전진 후 d 보 후퇴하는 작업을 반복적으로 하게 했다.

둘은 같은 보폭을 가지고 한 보폭당 걸리는 시간이 같다.

s 스텝 이후 선생님이 휘슬을 분 경우 둘 중 누가 처음 위치보다 멀리 가 있는가를 알아내는 프로그램을 하라.

입력

5 개의 정수 a,b,c,d,s 가 주어진다.
단, a,b,c,d 는 100 이하의 정수이고 a > b , c > d 이고 s 는 10000 이하의 정수이다.

출력

세 가지 중 하나를 출력한다.
Nikky
Byron
Tied

입출력 예

입력

4
2
5
3
12

출력

Byron

입출력 보충

Nikky 는 12 스텝 후의 상태는 4 - 2 + 4 - 2 즉 첫 위치에서 4 스텝 만큼 떨어지고 Byron 는 5 - 3 + 4 즉 6 스텝 떨어져서 Byron 이 더 멀리 떨어져 있다.
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,b,c,d,s;
    int N,B;
    
    scanf("%d %d %d %d %d",&a,&b,&c,&d,&s);
    
    int step(int x, int y, int s)
    {
             int cy,re;
             
             cy=s/(x+y);
             re=s%(x+y);
             
             if(x>=re)
                      return (x-y)*cy+re;
             else
                      return (x-y)*cy+2*x-re;
    }
    
    N=step(a,b,s);
    B=step(c,d,s);
    
    if(N>B)
           printf("Nikky\n");
    else if(B>N)
           printf("Byron\n");
    else
           printf("Tied\n");
           
    system("pause");
    return 0;
}
