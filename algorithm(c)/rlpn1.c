#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x1,y1,x2,y2,x3,y3,x4,y4;
    
    scanf("%d %d %d %d %d %d %d %d",&x1,&y1,&x2,&y2,&x3,&y3,&x4,&y4);
    
    if(x2<x3||x4<x1||y2<y3||y4<y1)
        printf("none\n");
    else if(x2==x3||x4==x1||y2==y3||y4==y1)
        if((x2==x3&&y2==y3)||(x2==x3&&y1==y4)||(x4==x1&&y3==y2)||(x4==x1&&y4==y1))
            printf("point\n");
        else
            printf("line\n");
    else
        printf("rectangle\n");
        
    system("pause");
    return 0;
}
