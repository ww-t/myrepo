#include<stdio.h>
#include <stdlib.h>
int main() {
    int x[8], y[8], cx[8], cy[8], i, j, k, temp,xtemp, ytemp, result=0;
    for(i=0; i<=6; i+=2) {
        scanf("%d %d %d %d", &x[i], &y[i], &x[i+1], &y[i+1]);
        cx[i] = x[i]; cy[i] = y[i]; cx[i+1] = x[i+1]; cy[i+1] = y[i+1];
    }
    for(i=0; i<=6; i++) {
        for(j=i+1; j<=7; j++) {
            if(cx[i] > cx[j]){
                temp = cx[i];
                cx[i] = cx[j];
                cx[j] = temp;
            }
            if(cy[i] > cy[j]){
                temp = cy[i];
                cy[i] = cy[j];
                cy[j] = temp;
            }
        }
    }
    
    for(i=0;i<8;i++){
		printf("%d ",cx[i]);
	}
    for(i=0; i<=6; i++) {
        xtemp = cx[i];
        for(j=0; j<=6; j++) {
            ytemp = cy[j];
            for(k=0; k<=6; k+=2) {               
                if((x[k] <= xtemp) && (xtemp < x[k+1]) && (y[k] <= ytemp) && (ytemp < y[k+1])) {
                    result = result + ((cy[j+1]-cy[j]) * (cx[i+1]-cx[i]));
                    break;
                }           
            }
        }
    }
    printf("%d", result);
    
    system("pause");
    return 0;
}
