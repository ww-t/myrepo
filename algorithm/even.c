/*
두 정수 A, B (1 <= A <= B <= 2,000,000,000) 가 주어질때 A 와 B 사이 (A, B 포함) 에 약수의 개수가 짝수인 수의 개수를 출력하시오.

입력

두 정수 A, B 가 주어진다.
출력

약수의 개수가 짝수인 수의 개수를 출력하시오.
입출력 예

입력

3 17

출력 

12
*/

#include <stdio.h>
#include <stdlib.h>
 
int main(int argc, char *argv[])
{
    int a,b,na,nb;
     
    scanf("%d %d",&a,&b);
     
    na=(int)ceil(sqrt((double)a));
    nb=(int)floor(sqrt((double)b));
     
    printf("%d\n",((b-a)+1)-(nb-na+1));
     
    return 0;
}
