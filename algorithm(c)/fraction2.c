#include <stdio.h>
#include <stdlib.h>

struct sf{
	int s;
	int p;
	double v;
};

int main(){
	int n,i,j,id=0;
	struct sf a[5150];
	
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
	
	int compare(struct sf* f,struct sf* s){
		if(f[0].v>s[0].v)
			return 1;
		else
			return -1;
	}
	
	for(i=2;i<=n;i++){
		for(j=1;j<i;j++){
			if(ft(i,j)){
				a[id].s=j;
				a[id].p=i;
				a[id].v=(double)j/i;
				id++;
			}
		}
	}
	
	qsort(a,id,sizeof(a[0]),compare);
	
	printf("0/1\n");
	for(i=0;i<id;i++)
		printf("%d/%d\n",a[i].s,a[i].p);
	printf("1/1\n");
	
	system("pause");
	return 0;
}
