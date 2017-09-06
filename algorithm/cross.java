/*
원을 가로 지르는 선분을 현이라 한다.

원에는 1 부터 100 까지 일정한 간격으로 점이 부여되어 있다.

두 개의 현이 주어질 때 이 현이 교차하는지 아닌지를 판단하는 프로그램을 작성하시오.

입력 형식

첫 줄에는 한 현의 정보가 다음 줄에는 다른 한 현의 정보가 입력된다. 숫자는 1 이상 100 이하인 서로 다른 자연수이다.

출력 형식

두 현이 교차하면 cross ,아니면 not cross 를 출력한다.

입출력 예


입력 

20 80
85 40

출력 

cross
 */

package algorithm;

import java.util.Scanner;

public class cross {

	public void crosscheck(int la1, int la2, int lb1, int lb2) {
		
		boolean check1 = false, check2 = false;
		int tmp;
		
		if(la1>la2) {
			tmp = la1;
			la1 = la2;
			la2 = tmp;
		}	
		
		if(la1<lb1&&lb1<la2)
			check1 = true;
		if(la1<lb2&&lb2<la2)
			check2 = true;
		
		if(check1^check2)
			System.out.println("cross");
		else
			System.out.println("not cross");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int la1, la2, lb1, lb2;
		
		la1 = scan.nextInt();
		la2 = scan.nextInt();
		lb1 = scan.nextInt();
		lb2 = scan.nextInt();
		
		cross c = new cross();
		
		c.crosscheck(la1, la2, lb1, lb2);
	}

}
