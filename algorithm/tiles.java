/*
�ٴڿ� Ÿ���� ��� ���� �ʿ��� Ÿ�ϼ��� ���ϴ� ���̴�.
Ÿ���� ũ��� 8*8 �̴�. Ÿ���� �״�� �̿��� ���� �ְ� �߶� �κ��� �̿��� ���� �ִ�.
�׷��� �߶� ����� Ÿ���� �������� �ݵ�� ������ �Ѵ�.

������ ���Ǿ��� ������ Ÿ�ϼ��� �߶� ����� Ÿ�ϼ��� ���ϴ� ���̴�. ��� ������ inch �̰� �����Ѵ�.

�Է�

���� ���� , ���� ũ�Ⱑ �־�����. �� ���� 1000 �����̴�.

���

��� ���� �������� ����Ѵ�.

����� ��

�Է�

160 240

���

The number of whole tiles is 600 part tiles is 0

�Է�

100 120

���

The number of whole tiles is 180 part tiles is 15
 */

package algorithm;

import java.util.Scanner;

public class tiles {
	
	public void counttiles(int horizental, int vertical) {
		
		int hquotient, vquotient, hremainder, vremainder, whole, part;
		
		hquotient = horizental/8;
		vquotient = vertical/8;
		hremainder = horizental%8;
		vremainder = vertical%8;
		
		whole = hquotient*vquotient;
		part = 0;
		
		if((hremainder != 0) && (vremainder != 0))
			part = part+hquotient+vquotient+1;
		else if(hremainder != 0)
			part = part+vquotient;
		else if(vremainder != 0)
			part = part+hquotient;
		
		System.out.println("The number of whole tiles is "+whole+" part tiles is "+part);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int x, y;
		tiles t = new tiles();
		
		x = scan.nextInt();
		y = scan.nextInt();
		
		t.counttiles(x, y);
	}

}
