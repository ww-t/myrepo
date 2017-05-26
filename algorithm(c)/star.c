#include <stdio.h>
#include <stdlib.h>

int main(){
	int i,j;
	
	for(i=5;i>=1;i--){
		for(j=1;j<=i;j++)
			printf("*");
		printf("\n");
	}
	
	for(i=1;i<=5;i++){
		for(j=1;j<=i;j++)
			printf("*");
		printf("\n");
	}
	
	for(i=5;i>=1;i--){
		for(j=1;j<=5;j++){
			if(j>5-i)
				printf("*");
			else
				printf(" ");
		}
		printf("\n");
	}
	
	for(i=1;i<=5;i++){
		for(j=1;j<=5;j++){
			if(j>5-i)
				printf("*");
			else
				printf(" ");
		}
		printf("\n");
	}
	
	system("pause");
	return 0;
}
