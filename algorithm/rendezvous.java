/*
���� Ʈ���� �ݴ�� ���� �� ���� �κ��� �� �������� �ݴ� �������� �ٸ� �ӵ��� �� �� ���� �������� �ٽ� ���� ������ �� ������ �ٽ� ���� �� �ִ� ���� �˾Ƴ��� ���� �����̴�.

���� ��� �ʼ� 2m/s ,3m/s �� ���� Ʈ���� ���̰� 10 m ���

1 �� �κ� �̵� �Ÿ�	2 �� �κ� �̵� �Ÿ�
1 ��° ������ ��ġ	4	6
2 ��° ������ ��ġ	8	12
3 ��° ������ ��ġ	12	18
4 ��° ������ ��ġ	16	24
5 ��° ������ ��ġ	20	30

�Է�

�� �κ��� �ӵ�(m/sec) a,b �� �Է����� �־�����. a,b �� 100 000 000 ������ �ڿ����̴�.
Ʈ���� ���̴� �Է����� �־����� �ʴ´�. Ʈ���� ���̿� ������� ���� �����ϴ�.

���

�� ��ġ���� �ٽ� ���� �������� ������ Ƚ���� ����Ѵ�.
����� ��

�Է�

2 3

���

5
 */

package algorithm;

import java.util.Scanner;

public class rendezvous {
	
	public void meetnumber(int robot1, int robot2) {
		
		int mn, x, y, r;
		
		x = robot1;
		y = robot2;
		
		while(y != 0) {
			r = x%y;
			x = y;
			y = r;
		}
		
		mn = (robot1/x)+(robot2/x);
		
		System.out.println(mn);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int a, b;
		
		a = in.nextInt();
		b = in.nextInt();
		
		rendezvous rdv = new rendezvous();
		
		rdv.meetnumber(a, b);
	}

}
