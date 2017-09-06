#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#define left false
#define up true

int n,m;
int **map,**rt;
bool **rmap;

int fr(int r,int c){
	int uv,lv;	
	if(r==0&&c==0)
		return map[r][c];
	else if(c==0){
		rmap[r][c]=up;
		return map[r][c]+fr(r-1,c);
	}
	else if(r==0){
		rmap[r][c]=left;
		return map[r][c]+fr(r,c-1);
	}
	else{
		lv=fr(r,c-1);
		uv=fr(r-1,c);
		if(uv>lv){
			rmap[r][c]=up;
			return map[r][c]+uv;
		}
		else{
			rmap[r][c]=left;
			return map[r][c]+lv;
		}
	}
}

void route(int r,int c){
	int k;
	for(k=0;k<n+m-1;k++){
		rt[k][0]=r;
		rt[k][1]=c;
		if(rmap[r][c]==up)
			r--;
		else
			c--;
	}
}

int main(){
	int i,j,mf;
	FILE* stream;
	clock_t s_t,e_t,r_t;
	
	stream=fopen("data(15,13,10).txt","r");
	
	fscanf(stream,"%d %d",&n,&m);
	
	map=(int**)malloc(sizeof(int*)*n);
	map[0]=(int*)malloc(sizeof(int)*n*m);
	
	for(i=1;i<n;i++)
		map[i]=map[i-1]+m;
		
	rt=(int**)malloc(sizeof(int*)*(n+m-1));
	rt[0]=(int*)malloc(sizeof(int)*2*(n+m-1));
	
	for(i=1;i<n+m-1;i++)
		rt[i]=rt[i-1]+2;
		
	rmap=(bool**)malloc(sizeof(bool*)*n);
	rmap[0]=(bool*)malloc(sizeof(bool)*n*m);
	
	for(i=1;i<n;i++)
		rmap[i]=rmap[i-1]+m;
		
	for(i=0;i<n;i++){
		for(j=0;j<m;j++)
			fscanf(stream,"%d",&map[i][j]);
	}
	
	s_t=clock();
	
	mf=fr(n-1,m-1);
	route(n-1,m-1);
	
	e_t=clock();
	
	r_t=e_t-s_t;
	
	printf("The maximum amount of food is %d\n",mf);
	printf("The route is ");
	for(i=n+m-2;i>=0;i--)
		printf("(%d %d) ",rt[i][0],rt[i][1]);
	printf("\n");
	printf("%lf\n",(double)r_t/1000);
	
	free(map[0]);
	free(map);
	free(rt[0]);
	free(rt);
	free(rmap[0]);
	free(rmap);
	fclose(stream);
	
	system("pause");
	return 0;
}
