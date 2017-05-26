#include <stdio.h>

int n,r,p,q,c=0;
char s[12];

void pm(int n1,int r1){
	int i,ch=0;
	
	if(r1==r){
		c++;
		if(c==p)
			printf("%s\n",s);
		return;
	}
	else if(n1==n)
		return;
	else{
		for(i=0;i<12;i++){
			if(s[i]=='A'+n1){
				ch=1;
				break;
			}
		}
		
		if(ch==0){
			s[r1]='A'+n1;
			pm(0,r1+1);
			s[r1]=0;
		}
		pm(n1+1,r1);
	}
}

void cb(int n1,int r1){
  	if(r1==r){
  		c++;
  		if(c==q)
   			printf("%s\n",s);
  		return;
	}
	else if(n1==n)
  		return;
 	else{
  		s[r1]='A'+n1;
  		cb(n1+1,r1+1);
		cb(n1+1,r1);
	}
}

int main(){
	int i;
	
	scanf("%d %d %d %d",&n,&r,&p,&q);

	pm(0,0);
	c=0;
	cb(0,0);
	
	return 0;
}
