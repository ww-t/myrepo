//�ϳ��� ȸ�ǽ��� �ְ�, ���� ȸ�ǵ��� ����Ǿ� �ִ�.
//
//ȸ�ǽǿ����� ���� �ð��� �ϳ��� ȸ�Ǹ� �����ϴ�. ����� ȸ�ǵ��� ���� �ð��� ��ġ�� ��찡 ���� ������ ���� ��ġ�� �����鼭 ������ ���� ȸ�ǵ��� �����ϰ� �ʹ�.
//
//�� ȸ�ǵ��� ���۽ð��� ���� �ð��� �־��� �� , ���� ���� ȸ�Ǹ� �����ϴ� ���α׷��� �ۼ��϶�. ȸ�ǽǿ� ������ ȸ���� ����ð��� �ٸ� ȸ�� �ð��� ���Ƶ� ��ġ�� �ʴ� ������ �Ѵ�.
//
//��, �ð��� 0 �̻� 24 �����̴�. �����ʹ� ����ð��� �������� �������� ���ĵǾ� �Էµȴ�.
//
//�Է� ���
//
//����� ȸ���� �� N(1000 ������ ����)�� ù �ٿ� �־�����.
//��° �ٺ��ʹ� N ���� ȸ�ǵ鿡 ���� ���� �ð��� ���� �ð��� �־�����.
//
//��� ���
//
//ȸ�ǽǿ� ������ ȸ���� �ִ� ���� ����Ѵ�.
//
//����� ��
//
//�Է�
//
//11
//1 4
//3 5
//0 6
//5 7
//3 8
//5 9
//6 10
//8 11
//8 12
//2 13
//12 14
//
//���
//
//4

package algorithm;

import java.util.Scanner;

public class meeting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n, i, tmp, time[][], count[];
		
		n = scan.nextInt();
		time = new int[n][2];
		
		for(i=0 ; i<n ; i++) {
			time[i][0] = scan.nextInt();
			time[i][1] = scan.nextInt();
		}
		
		count = new int[time[n-1][1]+1];
		count[time[0][1]] = 1;
		
		for(i=1 ; i<n ; i++) {
			for(int j=time[i-1][1]+1 ; j<time[i][1] ; j++)
				count[j] = count[time[i-1][1]];
			
			if(count[time[i][0]]+1<count[time[i][1]-1])
				tmp = count[time[i][1]-1];
			else
				tmp = count[time[i][0]]+1;
			
			if(tmp>count[time[i][1]])
				count[time[i][1]] = tmp;
		}
		
		System.out.println(count[count.length-1]);
	}

}
