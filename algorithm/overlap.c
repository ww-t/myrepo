/*
두 사각형 좌표가 주어질 때 두 사각형이 오버랩(overlap) 되는지 아닌지를 판단하는 프로그램을 작성하시오.
변을 공유하거나 꼭지점을 공유하는 경우에도 overlap 되는 것으로 간주한다.

입력

한 줄에 4 개 씩 음이 아닌 정수 x1 y1 x2 y2 가 두 줄로 주어진다.
(x1,y1) 은 왼쪽 아래 좌표이고, (x2,y2) 은 오른쪽 위 좌표이다. 입력되는 수는 200 보다 작다.

출력

overlap 되는 경우에는 "Overlap" 아니면 "No overlap" 을 출력한다.
입출력 예

입력

1 1 2 2
2 2 5 3

출력

Overlap
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x1,y1,x2,y2,x3,y3,x4,y4;
    
    scanf("%d %d %d %d",&x1,&y1,&x2,&y2);
    scanf("%d %d %d %d",&x3,&y3,&x4,&y4);
    
    if(x2<x3||x4<x1||y2<y3||y4<y1)
        printf("No overlap\n");
    else
        printf("Overlap\n");
        
    system("pause");
    return 0;
}
