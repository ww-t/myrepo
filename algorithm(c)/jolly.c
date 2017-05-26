/*
n 개의 수로 이루어진 수열이 주어질 때 인접한 수의 차이가 1 부터 n-1 까지의 수를 만들수 있을 때 이를 jolly jumper 라 한다.
단 차례대로 1 부터 만들어 질 필요는 없다.

예를 들어 아래와 같이 4 개의 수로 이루어지는 수열이 주어질 때

1 4 3 1
이 수열은 인접한 수의 차가 3 1 2 이므로 jolly jumper 이다.

1 4 2 3
도 인접한 수의 차가 3 2 1 이므로 jolly jumper 이다.

수가 하나만 있는 경우는 jolly jumper로 간주한다.

수열이 jolly jumper 인지 아닌지를 구하는 프로그램을 작성하시오.

입력

입력의 첫줄은 3000 이하인 0 보다 큰 정수 n 이 입력되고 다음부터 n 개의 수가 입력된다.

출력

jolly jumper 이면 Jolly를 아니면 Not jolly를 출력 한다.

입출력 예

입력 

4
1 4 2 3

출력 

Jolly

입력 

5 
1 4 2 -1 6

출력

Not jolly
*/

#include <stdio.h>
#include <stdlib.h>

int main(){
    
    int n,i,x,bet;
    int a[3000]={};
    int b[3000];
    
    scanf("%d",&n);
    
    for(i=0;i<n;i++){
         scanf("%d",&x);
         b[i]=x;
         if(i>0){
              bet=abs(b[i-1]-b[i]);
              a[bet-1]=1;
         }
    }
    
    for(i=0;i<n-1;i++){
         if(a[i]==0){
              printf("Not jolly\n");
              
              system("pause");
              return 0;
         }
    }
    
    printf("Jolly\n");
    
    system("pause");
    return 0;
}
