/*
�ڿ��� n �� �Է����� �־�����. �� ���� ���μ� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�

n �� 2 �̻� 1 000 000 000 ������ �ڿ����̴�.

���

���μ��� ũ�� ������ ������ ���̿� �ΰ� �� �ٿ� ����Ѵ�.

����� ��

�Է�

20

���

2 2 5

�Է�

7

���

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
