/*
Nikky �� Byron ü���ð��� ������ �ϰ� �ִ�.

�������� Nikky ���Դ� a �� ���� �Ŀ� b �� �����ϰ� , Byron ���Դ� c �� ���� �� d �� �����ϴ� �۾��� �ݺ������� �ϰ� �ߴ�.

���� ���� ������ ������ �� ������ �ɸ��� �ð��� ����.

s ���� ���� �������� �ֽ��� �� ��� �� �� ���� ó�� ��ġ���� �ָ� �� �ִ°��� �˾Ƴ��� ���α׷��� �϶�.

�Է�

5 ���� ���� a,b,c,d,s �� �־�����.
��, a,b,c,d �� 100 ������ �����̰� a > b , c > d �̰� s �� 10000 ������ �����̴�.

���

�� ���� �� �ϳ��� ����Ѵ�.
Nikky
Byron
Tied

����� ��

�Է�

4
2
5
3
12

���

Byron

����� ����

Nikky �� 12 ���� ���� ���´� 4 - 2 + 4 - 2 �� ù ��ġ���� 4 ���� ��ŭ �������� Byron �� 5 - 3 + 4 �� 6 ���� �������� Byron �� �� �ָ� ������ �ִ�.
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,b,c,d,s;
    int N,B;
    
    scanf("%d %d %d %d %d",&a,&b,&c,&d,&s);
    
    int step(int x, int y, int s)
    {
             int cy,re;
             
             cy=s/(x+y);
             re=s%(x+y);
             
             if(x>=re)
                      return (x-y)*cy+re;
             else
                      return (x-y)*cy+2*x-re;
    }
    
    N=step(a,b,s);
    B=step(c,d,s);
    
    if(N>B)
           printf("Nikky\n");
    else if(B>N)
           printf("Byron\n");
    else
           printf("Tied\n");
           
    system("pause");
    return 0;
}
