/*
존의 소들은 해 질때를 좋아한다. 그들은 저 멀리 보이는 도시의 지평선을 볼수 있다.

베시(소)에게 스카이 라인 정보가 주어질 때 얼마나 많은 빌딩이 있는가를 알고자 한다. 빌딩수는 최소로 하여야 한다.

빌딩은 사각형 모양이고 스카이라인은 길이는 1 에서 W ( 1 <= W <= 1,000,000) 폭 만큼이고 , 점의 개수는 N ( 1 <= N <= 50,000 ) 개이고 x 와 y 의 좌표가 주어진다

예를 들어 지평선 모양이 다음과 같다면

.......................... 
.....XX.........XXX....... 
.XXX.XX.......XXXXXXX..... 
XXXXXXXXXX....XXXXXXXXXXXX 

지평선의 정보는 (1,1), (2,2), (5,1), (6,3), (8,1), (11,0), (15,2), (17,3), (20,2), (22,1) 이다.
위의 스카이라인으로 만들 수 있는 최소 빌딩수는 6 개이다.

.......................... .......................... 
.....22.........333....... .....XX.........XXX....... 
.111.22.......XX333XX..... .XXX.XX.......5555555..... 
X111X22XXX....XX333XXXXXXX 4444444444....5555555XXXXX 

.......................... 
.....XX.........XXX....... 
.XXX.XX.......XXXXXXX..... 
XXXXXXXXXX....666666666666

입력

첫 라인에는 N , W 가 주어진다.
다음 N 라인에는 x 와 y 점의 좌표가 지평선이 변하는 지점마다 주어진다. x 좌표는 증가하는 순으로 주어지고 입력의 첫 데이터의 x 좌표는 항상 1 이 될 것이다.

출력

주어진 지평선을 만들수 있는 최소 빌딩수를 출력한다.

입출력 예

입력

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

출력

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
