//1 2 ... N 에서 합이 같은 두 집합으로 나누는게 문제이다.
//
//N 이 3 인 경우 다음과 같은 한 가지 방법이 존재하고
//
//1 2, 3
//N 이 7 이면 , 4 가지 방법이 있다.
//1,6,7 과 2,3,4,5
//2,5,7 과 1,3,4,6
//3,4,7 과 1,2,5,6
//1,2,4,7 과 3,5,6
//N 이 주어질 때 합이 같은 두 집합으로 만들 수 있는 방법의 수를 구하는게 문제이다.
//제한 시간은 1 초이다.
//
//입력형식
//
//정수 N( 1 <= N <= 39)이 입력된다.
//
//출력형식
//
//만들 수 있는 방법의 수를 출력한다. 방법이 없으면 0 을 출력한다.
//
//입출력 예
//
//입력 
//
//7
//
//출력
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
