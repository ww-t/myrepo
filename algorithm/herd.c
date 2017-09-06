/*
수 N 이 입력으로 들어올 때 , 수들의 순차적인 합으로 N 을 만들수 있는 가지수를 출력하는게 문제이다.

15 인 경우

15
7 + 8
4 + 5 + 6
1 + 2 + 3 + 4 + 5
4 가지.

10 인 경우

10
1 + 2 + 3 + 4
2 가지.

입력

수 N ( 1 <= N <= 10,000,000 ) 이 입력으로 주어진다.

출력

가짓 수를 출력한다.

입출력 예

입력

15

출력

4 
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n,i,j,c,s;
    
    scanf("%d",&n);
    
    c=0;
    
    for(i=1;i<=n;i++)
    {
         s=0;
         for(j=i;s<=n;j++)
         {
              s+=j;
              
              if(s==n)
                   c++;
         }
    }
    
    printf("%d\n",c);
    
    system("pause");
    return 0;
}
