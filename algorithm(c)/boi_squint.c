/*
정수 n 의 제곱 근을 구하는 문제이다.

입력

정수 n ( 0 <= n <2^63) 이 입력으로 주어진다.
출력

q^2 >= n 을 만족하는 음이 아닌 정수 값중 최소 q 를 출력한다.
입출력 예

입력

122333444455555

출력

11060446
*/

#include <stdio.h>
#include <stdlib.h>
 
int main(int argc, char *argv[])
{
    long long n;
     
    scanf("%lld",&n);
     
    n=(long long)ceil(sqrt((double)n));
     
    printf("%lld\n",n);
 
    return 0;
}
