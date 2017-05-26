/*
네 개의 직사각형이 평면에 있는데, 밑변이 모두 가로축에 평행하다. 이 직사각형들이 차지하는 면적을 구하는 프로그램을 작성하시오.

이 네 개의 직사각형들은 서로 떨어져 있을 수도 있고, 겹쳐 있을 수도 있고, 하나가 다른하나를 포함 할 수도 있으며 변이나 꼭지점이 겹쳐질수도 있다.

입력형식

하나의 직사각형은 왼쪽 아래의 꼭지점과 오른 쪽 위의 꼭지점 좌표로 주어진다. 입력은 네 줄이며, 각 줄은 네 개의 정수로 하나의 직사각형을 나타낸다.
첫번째와 두 번째의 정수는 사각형의 왼쪽아래 꼭지점의 x 좌표,y 좌표이고, 세번 째와 네번 째의 정수는 사각형의 오른 쪽 위 꼭지점의 x 좌표,y 좌표이다.
단, x 좌표와 y 좌표는 1 이상이고 1000 이하인 정수이다.

출력형식

네 개의 직사각형이 차지하는 면적을 출력한다.

입출력 예

입력

1 2 4 4 
2 3 5 7 
3 1 6 5 
7 3 8 6 

출력

26
*/

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
	for(i=0;i<8;i++){
		printf("%d ",sx[i]);
	}
	
	for(i=0;i<=6;i++){
		tx=sx[i]+sx[i+1];
		for(j=0;j<=6;j++){
			ty=sy[j]+sy[j+1];
			for(k=0;k<=6;k+=2){               
                if((x[k]*2<=tx)&&(tx<=x[k+1]*2)&&(y[k]*2<=ty)&&(ty<=y[k+1]*2)){
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
