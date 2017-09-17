//일련의 수가 주어질 때 이 수들을 앞에서 부터 차례대로 선택하는 문제이다.
//
//제한 조건
//
//앞에서 어떤 수를 선택했을 때 뒤에서 선택 가능한 수는 앞에서 선택한 수 보다 큰 수 만을 선택할 수 있다.
//예를 들어 아래와 같은 수가 주어졌을 때
//
//6 2 8 4 7 9 5 1
//
//첫 수 6 을 선택 했다면 다음 수는 6 보다 작거나 같은 수는 선택할 수 없고 6 보다 큰 8,7,9 중 하나를 선택할 수 있다.
//
//이렇게 선택하는 경우 가장 많은 수(길게)를 선택하는 경우는 2 4 7 9 를 선택하는 경우이다.
//
//
//
//입력 방법
//
//첫 줄에는 데이터 수 N 이 주어지고 ( N <= 10000 )
//다음 줄 부터는 수 들이 입력 된다. 입력되는 수는 50000 이하의 양의 정수이다.
//
//출력 방법
//
//첫 줄에는 최대 길이를 출력하고 ,
//다음 줄에는 수열을 출력한다. 여러가지 경우가 존재하는 경우 이 중 하나만을 출력한다.
//
//입출력 예
//
//입력
//
//8
//6 2 8 4 7 9 5 1
//
//출력
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
