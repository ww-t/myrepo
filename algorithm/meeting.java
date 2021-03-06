//하나의 회의실이 있고, 여러 회의들이 예약되어 있다.
//
//회의실에서는 같은 시간에 하나의 회의만 가능하다. 예약된 회의들이 서로 시간이 겹치는 경우가 많기 때문에 서로 겹치지 않으면서 가능한 많은 회의들을 배정하고 싶다.
//
//각 회의들의 시작시간과 종료 시간이 주어질 때 , 가장 많은 회의를 배정하는 프로그램을 작성하라. 회의실에 배정된 회의의 종료시간과 다른 회의 시간이 같아도 겹치지 않는 것으로 한다.
//
//단, 시간은 0 이상 24 이하이다. 데이터는 종료시간을 기준으로 오름차순 정렬되어 입력된다.
//
//입력 방법
//
//예약된 회의의 수 N(1000 이하의 정수)이 첫 줄에 주어진다.
//둘째 줄부터는 N 개의 회의들에 대한 시작 시간과 종료 시간이 주어진다.
//
//출력 방법
//
//회의실에 배정한 회의의 최대 수를 출력한다.
//
//입출력 예
//
//입력
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
//출력
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
