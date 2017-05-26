/*
1 부터 나선 형 모양으로 배열에 값을 넣은 후 출력하는 프로그램을 작성하시오.

입력

입력은 배열의 크기 n 이 주어진다. n * n 행 배열이다.
n 의 크기는 20 이하의 자연수이다.

출력

각 숫자는 5 자리 확보 후 출력한다.

입출력 예

입력

3 

출력

    1    2    3
    8    9    4
    7    6    5
    
출력 보충

공백이 . 이라면
....1....2....3
....8....9....4
....7....6....5
*/

#include <stdio.h> 

int main() 
{ 
    int A[21][21];
    int n, i, j;     
    int N;
    int K = 0;
    int SW=1;
    int I=1, J=0;
    
    scanf("%d", &n); 
    N = n; 
    
    while(1) { 
        for ( i = 1 ; i <= N ; i++) { 
            K++; 
            J=J+SW;
            A[I][J] = K;                             
        }        
        N--;
        if( N > 0 ) { 
            for( i = 1 ; i <= N ; i++) {        
                K++; 
                I=I+SW;
                A[I][J] = K;                  
            }                
            SW = SW * (-1);
        } 
        else {               
            break; 
        } 
    } 
    for ( i = 1; i <= n ; i++) { 
        for ( j = 1 ; j <= n ; j++){ 
            printf("%5d", A[i][j]); 
        } 
        printf("\n"); 
    }        
} 
