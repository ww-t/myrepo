/*
���� ���� ������ ������ ���̶� �Ѵ�.

������ 1 ���� 100 ���� ������ �������� ���� �ο��Ǿ� �ִ�.

�� ���� ���� �־��� �� �� ���� �����ϴ��� �ƴ����� �Ǵ��ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է� ����

ù �ٿ��� �� ���� ������ ���� �ٿ��� �ٸ� �� ���� ������ �Էµȴ�. ���ڴ� 1 �̻� 100 ������ ���� �ٸ� �ڿ����̴�.

��� ����

�� ���� �����ϸ� cross ,�ƴϸ� not cross �� ����Ѵ�.

����� ��


�Է� 

20 80
85 40

��� 

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
