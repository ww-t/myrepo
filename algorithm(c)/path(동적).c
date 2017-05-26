/*
�ѹ� ���� �б��� �� ������ ����� �ı� (��С)�� �ִ�. 
�ıʹ� �б� (0,0)���� �ͽ��� (n-1,m-1) ���� ���� ������ ������ �ִ�. 
�������� ���� �濡 ���� �� �ִ� ������ �絵 ǥ�õǾ� �ִ�. 
�ı� (��С)�� ���� Ʈ�� ������ �ͽ����� �����ؾ� �ϹǷ� �ð��� �˹��Ͽ� �ݵ�� �ִ� ��ηθ� �̵��ؾ� �Ѵ�. 
�ıͰ� ������ ���� ���� ���� �� �ִ� ���� ã�� �˰����� �����϶�. 
�Է� ù �ٿ��� n�� m�� ������ ���� �ٺ��ʹ� ������ ���� ���� �ִ� ������ ��� �´�. 

�Է� 

3  4
2 2 4 1
1 3 4 1
1 1 3 3

5  5 
1 2 2 1 5
1 4 4 3 1
2 1 1 1 2
1 3 5 1 1
1 5 1 2 2 

���
 
The maximum amount of food is 18. 
The route is (0 0) (0 1) (0 2) (1 2) (2 2) (2 3).  
The maximum amount of food is 22
The route is (0,0) (0 1) (1 1) (1 2) (2 2) (3 2) (4 2) (4 3) (4 4) 
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#define left false
#define up true

int **map,**rt,**nmap;
bool **rmap;

int fr(int r,int c){
	int i,j,k;
	
	nmap[0][0]=map[0][0];
	for(i=1;i<r;i++){
		nmap[i][0]=map[i][0]+nmap[i-1][0];
		rmap[i][0]=up;
	}
	for(j=1;j<c;j++){
		nmap[0][j]=map[0][j]+nmap[0][j-1];
		rmap[0][j]=left;
	}
	for(i=1;i<r;i++){
		for(j=1;j<c;j++){
			if(nmap[i-1][j]>nmap[i][j-1]){
				nmap[i][j]=map[i][j]+nmap[i-1][j];
				rmap[i][j]=up;
			}
			else{
				nmap[i][j]=map[i][j]+nmap[i][j-1];
				rmap[i][j]=left;
			}
		}
	}
	
	i=r-1; j=c-1;
	for(k=0;k<r+c-1;k++){
		rt[k][0]=i;
		rt[k][1]=j;
		if(rmap[i][j])
			i--;
		else
			j--;
	}
	
	return nmap[r-1][c-1];
}

int main(){
	int i,j,n,m,r;
	FILE* stream;
//	FILE* stream1;
	clock_t s_t,e_t,r_t;
	
	stream=fopen("data(1000,1000,1000).txt","r");
//	stream1=fopen("result.txt","w");
	
	fscanf(stream,"%d %d",&n,&m);
	
	map=(int**)malloc(sizeof(int*)*n);
	map[0]=(int*)malloc(sizeof(int)*n*m);
	for(i=1;i<n;i++)
		map[i]=map[i-1]+m;
	
	rt=(int**)malloc(sizeof(int*)*(n+m-1));
	rt[0]=(int*)malloc(sizeof(int)*2*(n+m-1));
	for(i=1;i<n+m-1;i++)
		rt[i]=rt[i-1]+2;
		
	nmap=(int**)malloc(sizeof(int*)*n);
	nmap[0]=(int*)malloc(sizeof(int)*n*m);
	for(i=1;i<n;i++)
		nmap[i]=nmap[i-1]+m;
		
	rmap=(bool**)malloc(sizeof(bool*)*n);
	rmap[0]=(bool*)malloc(sizeof(bool)*n*m);
	for(i=1;i<n;i++)
		rmap[i]=rmap[i-1]+m;
	
	for(i=0;i<n;i++){
		for(j=0;j<m;j++)
			fscanf(stream,"%d",&map[i][j]);
	}
	
	s_t=clock();
	
	r=fr(n,m);
	
	e_t=clock();
	
	r_t=e_t-s_t;
	
	printf("The maximum amount of food is %d\n",r);
	printf("The route is ");
	for(i=n+m-2;i>=0;i--)
		printf("(%d %d) ",rt[i][0],rt[i][1]);
	printf("\n");
	printf("%lf\n",(double)r_t/1000);
	
/*	fprintf(stream1,"The maximum amount of food is %d\n",r);
	fprintf(stream1,"The route is ");
	for(i=n+m-2;i>=0;i--)
		fprintf(stream1,"(%d %d) ",rt[i][0],rt[i][1]);
	fprintf(stream1,"\n");
	fprintf(stream1,"%lf\n",(double)r_t/1000); */
	
	free(map[0]);
	free(map);
	free(rt[0]);
	free(rt);
	free(nmap[0]);
	free(nmap);
	free(rmap[0]);
	free(rmap);
	fclose(stream);
//	fclose(stream1);
	
	system("pause");
	return 0;
}
