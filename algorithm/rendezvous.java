/*
같은 트랙를 반대로 도는 두 개의 로봇이 한 지점에서 반대 방향으로 다른 속도로 돌 때 시작 지점에서 다시 만날 때까지 몇 번만에 다시 만날 수 있는 가를 알아내는 것이 문제이다.

예를 들어 초속 2m/s ,3m/s 로 가고 트랙의 길이가 10 m 라면

1 번 로봇 이동 거리	2 번 로봇 이동 거리
1 번째 만나는 위치	4	6
2 번째 만나는 위치	8	12
3 번째 만나는 위치	12	18
4 번째 만나는 위치	16	24
5 번째 만나는 위치	20	30

입력

두 로봇의 속도(m/sec) a,b 가 입력으로 주어진다. a,b 는 100 000 000 이하의 자연수이다.
트랙의 길이는 입력으로 주어지지 않는다. 트랙의 길이에 관계없이 답은 일정하다.

출력

원 위치에서 다시 만날 때까지의 만나는 횟수를 출력한다.
입출력 예

입력

2 3

출력

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
