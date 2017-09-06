/*
1742 년 독일 수학자 골드바하는 오일러에게 다음과 같은 추측을 했다.

골드바하의 추측

4 보다 큰 모든 짝수는 두 개의 홀수 소수의 합으로 나타낼수가 있다
예를 들어 ,
8 = 3 + 5. Both 3 and 5 are odd prime numbers. 
20 = 3 + 17 = 7 + 13. 
42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23. 
이 추측이 맞는지 아닌지는 아직 증명되지 않았지만 반례도 찾지 못했다.
당신이 해야 할 일은 백만 미만의 짝수가 주어질 때 두 개의 홀수 소수의 합으로 표시할 수 있는지를 알아보는 것이다.

입력

6 이상 1000000 미만의 짝수 n 이 입력으로 주어진다.

출력

두 소수 a , b 의 합으로 표시될 수 있으면 n = a + b 형식으로 출력한다. 그런 쌍이 없으면 "Goldbach's conjecture is wrong." 으로 표시한다.
답이 여러가지 인 경우 b - a 가 최대인 값을 출력한다.

입출력 예

입력

8

출력

8 = 3 + 5

입력

20

출력

20 = 3 + 17

입력

42

출력

42 = 5 + 37
*/

#include <stdio.h>
#include <stdlib.h>

int main(){
	int i,n;
	
	int pn(int a){
		int j;
		for(j=(int)sqrt((double)a);j>1;j--){
			if(a%j==0)
				break;
		}
		if(j==1)
			return 1;
		else
			return 0;
	}
	
	scanf("%d",&n);
	
	for(i=2;i<=n/2;i++){
		if(pn(i)&&pn(n-i)){
			printf("%d = %d + %d\n",n,i,n-i);
			break;
		}
	}
	
	if(i>n/2)
		printf("Goldbach's conjecture is wrong.");
	
	system("pause");
	return 0;
}
