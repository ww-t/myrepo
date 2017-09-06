/*
�� ��ΰ� ���� 5�ÿ� �Ͼ�� ���� ¥�� �ҿ츮�� ����.

�� ��δ� ���� 5 �ÿ��� 300 �ʰ� ������������ 1000 �ʱ��� ���� ¥�� , �� ��° ��δ� 700 �ʿ��� 1200 �� ���̿�, �� ��° ��δ� 1500 ���� 2100 �� ���̿� ���� §��.

                   |+++++++++++++++++++++++++| 
           |+++++++|++++++++++++++++++|      |        |+++++++|
           |       |                  |      |        |       |                             
----------------------------------------------------------------
          300     700               1000    1200     1500    2100
�� ���
��� �� ��ζ� ���� ¥�� �ð� �� ���� �� �ð��� 900(1200-300) �� 600(2100-1500) �� 900 �̰�
���� ¥�� �ʴ� ���� �� �ð��� 300(1500-1200) �̴�.(�� ���� �� ���� �ۿ� ����)
���� ¥�� ���� �� �ð��� �ƹ��͵� ���� �ʴ� ���� �� �ð��� ���ϴ� ���� �����̴�.

�Է�

�Է���
ù° �ٿ��� ����� �� N(1 <= N <= 5000)�� �Էµȴ�.
���� �ٿ��� �� �ٿ� �� ���� �� �� ���۽ð��� ����ð��� �Էµȴ�. �� ���� 1000000 �� �����ʴ� ���� �����̴�.

���

�� ���� ������ ��µȴ�. ù ���� ��� �ѻ�� �̶� ���� ¥�� ���� �� �ð��̰� �ٸ� �� ���� �ƹ��ϵ� ���� ���� ���� �� �ð��̴�.

����� ��

�Է�

3
300 1000
700 1200
1500 2100

���

900 300
 */

package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class mliking_cow {

	public void checktime(ArrayList<int[]> a) {
		
		int i, start, maxwork, maxrest, tmp[] = new int[2];
		
		a.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				
				if(o1[0]>o2[0])
					return 1;
				else if(o1[0]<o2[0])
					return -1;
				else
					return 0;
			}
		});
		
		i = 0;
		start = a.get(0)[0];
		maxwork = 0;
		maxrest = 0;
		
		while(true) {
			if(i+1<a.size()&&a.get(i+1)[0]<=a.get(i)[1]) {
				if(a.get(i+1)[1]<a.get(i)[1]) {
					tmp = a.get(i);
					a.set(i, a.get(i+1));
					a.set(i+1, tmp);
				}
				i++;
			}
			else {
				if(maxwork<a.get(i)[1]-start)
					maxwork = a.get(i)[1]-start;
				if(i+1==a.size())
					break;
				if(maxrest<a.get(i+1)[0]-a.get(i)[1])
					maxrest = a.get(i+1)[0]-a.get(i)[1];
				start = a.get(i+1)[0];
				i++;
			}
		}
		
		System.out.println(maxwork+" "+maxrest);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n, i, tmp[];
		ArrayList<int[]> a = new ArrayList<>();
		
		n = scan.nextInt();
		
		for(i=0 ; i<n ; i++) {
			tmp = new int[2];
			tmp[0] = scan.nextInt();
			tmp[1] = scan.nextInt();
			a.add(tmp);
		}
		
		mliking_cow mc = new mliking_cow();
		
		mc.checktime(a);
	}

}
