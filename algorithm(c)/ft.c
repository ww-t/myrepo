/*
자연수가 입력으로 주어진다. 이 수의 약수를 출력하고 , 다음 줄에는 약수의 개수 , 다음 줄에는 약수의 총합 , 다음 줄에는 약수의 곱의 일의 자리수를 출력한다.

입력

주어지는 수는 1000 이하의 자연수이다.
출력

입출력 예

입력

6

출력

1 2 3 6
4
12
6
*/

#include <stdio.h> 
#include <stdlib.h> 
   
int main(void) 
{ 
    int i, x, c=0, s=0, m=1; 
   
    scanf("%d", &x); 
    for(i=1;i<=x;i++){ 
           if(x%i==0){ 
                      c++; 
                      s+=i; 
                      m=m*i%10; 
                      printf("%d ", i); 
           } 
    } 
    printf("\n%d\n%d\n%d\n", c, s, m); 
    
    return 0; 
}
