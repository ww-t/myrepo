//�Ϸ��� ���� �־��� �� �� ������ �տ��� ���� ���ʴ�� �����ϴ� �����̴�.
//
//���� ����
//
//�տ��� � ���� �������� �� �ڿ��� ���� ������ ���� �տ��� ������ �� ���� ū �� ���� ������ �� �ִ�.
//���� ��� �Ʒ��� ���� ���� �־����� ��
//
//6 2 8 4 7 9 5 1
//
//ù �� 6 �� ���� �ߴٸ� ���� ���� 6 ���� �۰ų� ���� ���� ������ �� ���� 6 ���� ū 8,7,9 �� �ϳ��� ������ �� �ִ�.
//
//�̷��� �����ϴ� ��� ���� ���� ��(���)�� �����ϴ� ���� 2 4 7 9 �� �����ϴ� ����̴�.
//
//
//
//�Է� ���
//
//ù �ٿ��� ������ �� N �� �־����� ( N <= 10000 )
//���� �� ���ʹ� �� ���� �Է� �ȴ�. �ԷµǴ� ���� 50000 ������ ���� �����̴�.
//
//��� ���
//
//ù �ٿ��� �ִ� ���̸� ����ϰ� ,
//���� �ٿ��� ������ ����Ѵ�. �������� ��찡 �����ϴ� ��� �� �� �ϳ����� ����Ѵ�.
//
//����� ��
//
//�Է�
//
//8
//6 2 8 4 7 9 5 1
//
//���
//
//4
//2 4 7 9

package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class us {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n, max = 0 , maxindex;
		ArrayList<Integer> arr, count, route;
		
		n = scan.nextInt();
		arr = new ArrayList<>();
		count = new ArrayList<>();
		route = new ArrayList<>();
		
		for(int i=0 ; i<n ; i++) {
			arr.add(scan.nextInt());
			for(int j=i-1 ; j>=0 ; j--) {
				if(arr.get(i)>arr.get(j)&&count.get(j)>max)
					max = count.get(j);
			}
			count.add(max+1);
			max = 0;
		}
		
		max = Collections.max(count);
		maxindex = count.indexOf(max);
		route.add(arr.get(maxindex));
		
		System.out.println(max);
		
		for(int i=maxindex-1; i>=0 ; i--) {
			if(arr.get(maxindex)>arr.get(i)&&count.get(i)==max-1) {
				route.add(arr.get(i));
				max--;
			}
			
			if(max==0)
				break;
		}
		
		for(int i=route.size()-1 ; i>=0 ; i--) {
			System.out.print(route.get(i)+" ");
		}
	}

}
