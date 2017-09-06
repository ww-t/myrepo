/*
���� �ҵ��� �� ������ �����Ѵ�. �׵��� �� �ָ� ���̴� ������ ������ ���� �ִ�.

����(��)���� ��ī�� ���� ������ �־��� �� �󸶳� ���� ������ �ִ°��� �˰��� �Ѵ�. �������� �ּҷ� �Ͽ��� �Ѵ�.

������ �簢�� ����̰� ��ī�̶����� ���̴� 1 ���� W ( 1 <= W <= 1,000,000) �� ��ŭ�̰� , ���� ������ N ( 1 <= N <= 50,000 ) ���̰� x �� y �� ��ǥ�� �־�����

���� ��� ���� ����� ������ ���ٸ�

.......................... 
.....XX.........XXX....... 
.XXX.XX.......XXXXXXX..... 
XXXXXXXXXX....XXXXXXXXXXXX 

������ ������ (1,1), (2,2), (5,1), (6,3), (8,1), (11,0), (15,2), (17,3), (20,2), (22,1) �̴�.
���� ��ī�̶������� ���� �� �ִ� �ּ� �������� 6 ���̴�.

.......................... .......................... 
.....22.........333....... .....XX.........XXX....... 
.111.22.......XX333XX..... .XXX.XX.......5555555..... 
X111X22XXX....XX333XXXXXXX 4444444444....5555555XXXXX 

.......................... 
.....XX.........XXX....... 
.XXX.XX.......XXXXXXX..... 
XXXXXXXXXX....666666666666

�Է�

ù ���ο��� N , W �� �־�����.
���� N ���ο��� x �� y ���� ��ǥ�� ������ ���ϴ� �������� �־�����. x ��ǥ�� �����ϴ� ������ �־����� �Է��� ù �������� x ��ǥ�� �׻� 1 �� �� ���̴�.

���

�־��� ������ ����� �ִ� �ּ� �������� ����Ѵ�.

����� ��

�Է�

10 26
1 1
2 2
5 1
6 3
8 1
11 0
15 2
17 3
20 2
22 1

���

6
 */

package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class cskyline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n, y, i, count = 0;
		Stack<Integer> s = new Stack<>();
		
		n = scan.nextInt();
		scan.nextInt();
		
		for(i=0 ; i<n ; i++) {
			scan.nextInt();
			y = scan.nextInt();
			if(y==0)
				s.clear();
			else if(s.isEmpty()||s.peek()<y) {
				s.push(y);
				count++;
			}
			else {
				while(true) {
					if(s.isEmpty()||s.peek()<y) {
						s.push(y);
						count++;
						break;
					}
					else if(s.peek()==y)
						break;
					else
						s.pop();
				}
			}
		}
		
		System.out.println(count);
	}

}
