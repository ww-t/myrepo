//1 �� ä���� 2*2 �̻��� ���簢�� ���� ã�� ���� �����̴�. 
//
//�ߺ��� �����Ѵ�. 
//
//���� ��� , ũ�Ⱑ 3 �� �࿭���� 
//010
//111
//111
//
//2*2 �̻��� �� �࿭�� ������ 2*2 �࿭ 2 �����̴�. 
//
//�Է� 
//�Է��� ù° ���� �־��� ��������� ũ�� N (2 <= N <= 250)�� �־�����. ���� N �ٿ��� �� N ���� 0 Ȥ�� 1 �� �־�����. 
//
//���
//���� ���� ���簢�� ���� �����ؼ� ����Ѵ�. �� �ٴ� ù��° ���� ���簢���� ũ���̰� ���� ���� �����̴�. 
//���� �����ϴ� ���簢���� ������ 0 �� ����Ѵ�. 
//
//����� ��
//
//�Է�
//
//6
//101111
//001111
//111111
//001111
//101101
//111001
//
//���
//
//2 10
//3 4
//4 1

package algorithm;

import java.util.Scanner;

public class range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n, i, j, count, size, arr[][], check[];
		boolean flag;
		
		n = scan.nextInt();
		arr = new int[n][n];
		check = new int[n];
		
		for(i=0 ; i<n ; i++) {
			String tmp = scan.next();
			for(j=0 ; j<n ; j++) {
				arr[i][j] = Character.digit(tmp.charAt(j), 10);
			}
		}
		
		size = 2;
		count = 0;
		
		while(size<=n) {
			for(i=0 ; i<n-size+1 ; i++) {
				for(j=0 ; j<n-size+1 ; j++) {
					if(arr[i][j]==size-1
							&&arr[i][j+1]==size-1
							&&arr[i+1][j]==size-1
							&&arr[i+1][j+1]==size-1) {
						arr[i][j]++;
						count++;
					}
				}
			}
			
			check[size-1] = count;
			count = 0;
			size++;
		}
		
		flag = true;
		
		for(i=1 ; i<n ; i++) {
			if(check[i]!=0) {
				System.out.println(i+1+" "+check[i]);
				flag = flag&&false;
			}
		}
		
		if(flag)
			System.out.println(0);
	}

}
