/*
�� �簢�� ��ǥ�� �־��� �� �� �簢���� ������(overlap) �Ǵ��� �ƴ����� �Ǵ��ϴ� ���α׷��� �ۼ��Ͻÿ�.
���� �����ϰų� �������� �����ϴ� ��쿡�� overlap �Ǵ� ������ �����Ѵ�.

�Է�

�� �ٿ� 4 �� �� ���� �ƴ� ���� x1 y1 x2 y2 �� �� �ٷ� �־�����.
(x1,y1) �� ���� �Ʒ� ��ǥ�̰�, (x2,y2) �� ������ �� ��ǥ�̴�. �ԷµǴ� ���� 200 ���� �۴�.

���

overlap �Ǵ� ��쿡�� "Overlap" �ƴϸ� "No overlap" �� ����Ѵ�.
����� ��

�Է�

1 1 2 2
2 2 5 3

���

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
