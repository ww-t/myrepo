/*
Folding 은 해싱(hashing) 기법에서 키 값을 가지고 주소를 결정하는 방법중의 한가지 이다.

Folding 은 키(key)값을 다음과 같은 방법으로 처리하여 주소를 결정한다.

주소는

34567 + 21 + 98 = 34686

입력 형식

입력데이터의
'$' 표시는 접힐 부분을 표시한다.
'$' 표시는 제일 첫 부분과 제일 끝 부분에 나오지 않으며, 연속되어 나오지 않는다.
'$' 표시와 '$' 표시 사이의 자릿수가 제일 긴 것으로 가정한다.
문자열에서 $ 는 두개가 존재한다.
전체문자열의 길이는 12 자리이다.($ 포함)

출력 형식

주소 값을 출력한다.

입출력 예

입력

12$34567$890

출력

34686

입력

513$27658$13

출력

28004
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
	char s[13],rs[13];
	int r,m,l,i,len;
	
	gets(s);
	
	sscanf(s,"%*d$%d$%*d",&m);
	
	len=strlen(s);
	
	for(i=0;i<len;i++)
		rs[i]=s[len-i-1];
	
	sscanf(rs,"%d$%*d$%d",&r,&l);
	
	printf("%d\n",r+m+l);
	
	system("pause");
	return 0;
}
