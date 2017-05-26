#include <stdio.h>
#include <stdlib.h>
 
int main(){
     
    int n,i,c,j=0;
    int a[13];
     
    scanf("%d",&n);
     
    for(i=0;i<n;i++)
         a[i]=0;
     
    for(i=1;i<=n;i++){
         c=0;
         while(1){
              if(a[j]==0)
                   c++;
              else{
                   j=(j+1)%n;
                   continue;
              }
              if(c==i+1){
                   a[j]=i;
                   j=(j+1)%n;
                   break;
              }
              j=(j+1)%n;
         }
    }
     
    for(i=0;i<n;i++)
         printf("%d ",a[i]);
    printf("\n");
          
    system("pause");
    return 0;
}
