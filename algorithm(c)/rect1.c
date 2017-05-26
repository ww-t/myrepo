#include <stdio.h>
#include <stdlib.h>

int main(){
	int i,j,k,tx,ty,x[8],y[8],sx[8],sy[8],r=0;
	
	for(i=0;i<=6;i+=2) {
        scanf("%d %d %d %d",&x[i],&y[i],&x[i+1],&y[i+1]);
        sx[i]=x[i]; sy[i]=y[i]; sx[i+1]=x[i+1]; sy[i+1]=y[i+1];
    }
	
	int compare(void *a,void *b){
		if(*(int*)a>*(int*)b)
			return 1;
		else if(*(int*)a==*(int*)b)
			return 0;
		else
			return -1;
	}
	
	qsort(sx,8,sizeof(sx[0]),compare);
	qsort(sy,8,sizeof(sy[0]),compare);
	
	for(i=0;i<=6;i++){
		for(j=0;j<=6;j++){
			for(k=0;k<=6;k+=2){               
                if((x[k]<=sx[i])&&(sx[i]<x[k+1])&&(y[k]<=sy[j])&&(sy[j]<y[k+1])){
                    r=r+((sy[j+1]-sy[j])*(sx[i+1]-sx[i]));
                    break;
                }           
            }
		}
	}
	
	printf("%d\n",r);
	
	system("pause");
	return 0;
}
