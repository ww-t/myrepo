#include <stdio.h>
#include <stdlib.h>

int main(){
	int n,i,j,id=0;
	int a[5150][2];
	
	scanf("%d",&n);
	
	int ft(int x,int y){
		int r;
		while(y!=0){
			r=x%y;
			x=y;
			y=r;
		}
		if(x==1)
			return 1;
		else
			return 0;
	}
	
	int compare(int *f,int *s){
		if((double)f[0]/f[1]>(double)s[0]/s[1])
			return 1;
		else
			return -1;
	}
	
	for(i=2;i<=n;i++){
		for(j=1;j<i;j++){
			if(ft(i,j)){
				a[id][0]=j;
				a[id][1]=i;
				id++;
			}
		}
	}
	
	qsort(a,id,sizeof(a[0]),compare);
	
	printf("0/1\n");
	for(i=0;i<id;i++)
		printf("%d/%d\n",a[i][0],a[i][1]);
	printf("1/1\n");
	
	system("pause");
	return 0;
}
