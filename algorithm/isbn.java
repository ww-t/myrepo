//��� ���� �ҵ��� ������ �����Ѵ�. �ҵ��� ������ ������ å�� ���� �� �� ���� ������ �����Ѵٴ� ���� �˾Ҵ�. 
//
//�״� �갣�� �������� �ִ� �α��� ���� �Ҽ��� �˰���� ���а��� å���� �ٲٱ�� �����Ͽ���. �׷��� �����ϰԵ� ���ο� å���� �ű�� ���뿡 ����� ISBN ���� �бⰡ ����� ����. 
//
//ISBN(International Standard Book Number)�� å�� �����ϴ� 10 ���� ���� �̷������. ó�� 9 ���� ���� å�� �ĺ��ڵ��̰� , ������ �� �ڸ��� ISBN �� �´����� ��Ÿ���� check digit �� ���ȴ�. 
//
//ISBN �ڵ尡 ��Ȯ������ üũ�ϴ� ����� �� �ڸ��� 10 , 9 , .. , 1 �� ���� �� ���� 11 �� ���� �������� 0 �̸� ���� �ڵ�� �ν��Ѵ�. 
//
//���� ��� , �ڵ尡 0201103311 �� ���� �ڵ��̴�. 
//
//10*0 + 9*2 + 8*0 + 7*1 + 6*1 + 5*0 + 4*3 + 3*3 + 2*1 + 1*1 = 55. 
//55 �� 11 �� ���� �������� 0 �̹Ƿ� ���� �ڵ��̴�. 
//������ ���� ó�� 9 �ڸ� ���� 0 ���� 9 ���� �� �� �ϳ��� �̷���� �ְ� , check digit �� ����ϴ� ������ �ڸ��� 0 ���� 10 ������ ���� �� �� �ִ�. �� �� 10 �� X �� ǥ���Ѵ�. 
//
//156881111X�� ���� �ڵ��̴�. 
//�Է¿� ? ǥ�� �ִ� �ڸ��� ���� ã�� �� �����̴�. ? ǥ�� �� ���ڰ� ���ٸ� -1 �� ����Ѵ�. 
//
//����� ��
//
//�Է�
//
//15688?111X
//
//���
//
//1

package algorithm;

import java.util.Scanner;

public class isbn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String n;
		int arr[], i, q = 0, r = 0, sum = 0;
		
		n = scan.nextLine();
		arr = new int[10];
		
		for(i=0 ; i<n.length() ; i++) {
			char tmp = n.charAt(n.length()-1-i);
			
			if(tmp=='X')
				arr[i] = 10;
			else if(tmp=='?') {
				arr[i] = 0;
				q = i;
			}
			else
				arr[i] = Character.digit(tmp, 10);
		}
		
		for(i=0 ; i<10 ; i++) {
			sum = sum+arr[i]*(i+1);
		}
		
		if(q==0) {
			if(sum%11==0)
				r = 0;
			else
				r = 11-sum%11;
		}
		else {
			for(i=0 ; i<10 ; i++) {
				if((i*(q+1)+sum)%11==0) {
					r = i;
					break;
				}
				else
					r = -1;
			}
		}
		
		if(r==10)
			System.out.println('X');
		else
			System.out.println(r);
	}

}
