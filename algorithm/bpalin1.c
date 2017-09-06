#include <stdio.h>
#include <stdlib.h>

int main(){
	int i,j,a[17],k;
	
	void b(int x){
		if(x==1)
			a[k++]=1;
		else{
			b(x/2);
			a[k++]=x%2;
		}
	}
	
	int c(int f,int l){
		if(f>=l)
			return 1;
		else if(a[f]!=a[l])
			return 0;
		else
			return c(f+1,l-1);
	}
	
	for(i=1;i<=100000;i++){
		k=0;
		b(i);
		if(c(0,k-1))
			printf("%d\n",i);
	}
	 
	system("pause");
	return 0;
}
