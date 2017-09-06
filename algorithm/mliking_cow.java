/*
세 농부가 새벽 5시에 일어나서 젖을 짜러 소우리로 간다.

한 농부는 새벽 5 시에서 300 초가 지난시점부터 1000 초까지 젖을 짜고 , 두 번째 농부는 700 초에서 1200 초 사이에, 세 번째 농부는 1500 에서 2100 초 사이에 젖을 짠다.

                   |+++++++++++++++++++++++++| 
           |+++++++|++++++++++++++++++|      |        |+++++++|
           |       |                  |      |        |       |                             
----------------------------------------------------------------
          300     700               1000    1200     1500    2100
이 경우
적어도 한 농부라도 젖은 짜는 시간 중 가장 긴 시간은 900(1200-300) 과 600(2100-1500) 중 900 이고
젖을 짜지 않는 가장 긴 시간은 300(1500-1200) 이다.(이 경우는 한 구간 밖에 없다)
젖을 짜는 가장 긴 시간과 아무것도 하지 않는 가장 긴 시간을 구하는 것이 문제이다.

입력

입력의
첫째 줄에는 농부의 수 N(1 <= N <= 5000)이 입력된다.
다음 줄에는 한 줄에 두 개의 수 즉 시작시간과 종료시간이 입력된다. 이 수는 1000000 를 넘지않는 양의 정수이다.

출력

두 개의 정수가 출력된다. 첫 수는 적어도 한사람 이라도 젖을 짜는 가장 긴 시간이고 다른 한 수는 아무일도 하지 않은 가장 긴 시간이다.

입출력 예

입력

3
300 1000
700 1200
1500 2100

출력

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
