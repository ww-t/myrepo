//1 2 ... N ���� ���� ���� �� �������� �����°� �����̴�.
//
//N �� 3 �� ��� ������ ���� �� ���� ����� �����ϰ�
//
//1 2, 3
//N �� 7 �̸� , 4 ���� ����� �ִ�.
//1,6,7 �� 2,3,4,5
//2,5,7 �� 1,3,4,6
//3,4,7 �� 1,2,5,6
//1,2,4,7 �� 3,5,6
//N �� �־��� �� ���� ���� �� �������� ���� �� �ִ� ����� ���� ���ϴ°� �����̴�.
//���� �ð��� 1 ���̴�.
//
//�Է�����
//
//���� N( 1 <= N <= 39)�� �Էµȴ�.
//
//�������
//
//���� �� �ִ� ����� ���� ����Ѵ�. ����� ������ 0 �� ����Ѵ�.
//
//����� ��
//
//�Է� 
//
//7
//
//���
//
//4

package algorithm;

import java.util.Scanner;

public class subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n, sum;
		long arr[];
		
		n = scan.nextInt();
		sum = n*(n+1)/2;
		arr = new long[sum+1];
		arr[0]++;
		
		for(int i=1 ; i<=n ; i++) {
			for(int j=(i-1)*i/2 ; j>=0 ; j--) {
				if(arr[j]>0)
					arr[i+j] = arr[i+j]+arr[j];
			}
		}
		
		if(sum%2==0)
			System.out.println(arr[sum/2]/2);
		else
			System.out.println(0);
	}

}
