/*
자연수 n 이 입력으로 주어진다. 이 수를 소인수 분해하는 프로그램을 작성하시오.

입력

n 은 2 이상 1 000 000 000 이하의 자연수이다.

출력

소인수를 크기 순으로 공백을 사이에 두고 한 줄에 출력한다.

입출력 예

입력

20

출력

2 2 5

입력

7

출력

7
 */

package algorithm;

import java.util.Scanner;

public class decomp {

	public void factorization(int n) {
		
		int i = 2;
		
		while(i<=Math.sqrt(n)) {
			if(n%i==0) {
				System.out.print(i+" ");
				n = n/i;
				i = 2;
			}
			
			else
				i++;
		}
		
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n;
		
		n = scan.nextInt();
		
		decomp d = new decomp();
		
		d.factorization(n);
	}

}
