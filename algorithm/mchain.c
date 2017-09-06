/*
두 양의 정수가 주어질 때 두 수의 길이는 다음과 같이 약속

앞수에서 뒤수를 빼가는 과정을 반복.
뺀 값이 음수이면 종료 아니면 반복
예를 들어 , 두 수가 5 3 이면

5 3 2 1 1 0 1
5 3 의 길이는 이어지는 수의 개수 7 .
n 이 입력으로 주어질 때 두 번째수를 1 , 2 , .. n 으로 줄 때 최대 길이를 구하는게 문제이다.

n 이 5 이면

5 1 4
5 2 3
5 3 2 1 1 0 1
5 4 1 3
5 5 0 5
최대 길이는 5 3 일 때 7 이다.

입력

n 은 1000 이하의 자연수이다.

출력

최대 길이를 출력한다.

입출력 예

입력

5

출력

7
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n,f,b,result,i,c,g;
    
    scanf("%d",&n);
    
    g=0;
    
    for(i=n;i>=n/2;i--)
    {
         f=n;
         b=i;
         result=0;
         for(c=2;;c++)
         {
              result=f-b;
              f=b;
              b=result;
              if(result<0)
                   break;
         }
         if(c>g)
              g=c;
    }
    
    printf("%d\n",g);
    
    system("pause");
    return 0;
}
