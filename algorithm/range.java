//1 로 채워진 2*2 이상의 정사각형 수를 찾는 것이 문제이다. 
//
//중복이 가능한다. 
//
//예를 들어 , 크기가 3 인 행열에서 
//010
//111
//111
//
//2*2 이상인 인 행열의 개수는 2*2 행열 2 개뿐이다. 
//
//입력 
//입력의 첫째 줄은 주어진 정방행렬의 크기 N (2 <= N <= 250)이 주어진다. 다음 N 줄에는 각 N 개의 0 혹은 1 이 주어진다. 
//
//출력
//가장 작은 정사각형 부터 정렬해서 출력한다. 각 줄당 첫번째 수는 정사각형의 크기이고 다음 줄은 개수이다. 
//만약 존재하는 정사각형이 없으면 0 을 출력한다. 
//
//입출력 예
//
//입력
//
//6
//101111
//001111
//111111
//001111
//101101
//111001
//
//출력
//
//2 10
//3 4
//4 1

package algorithm;

import java.util.Scanner;

public class range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n, i, j, count, size, arr[][], check[];
		boolean flag;
		
		n = scan.nextInt();
		arr = new int[n][n];
		check = new int[n];
		
		for(i=0 ; i<n ; i++) {
			String tmp = scan.next();
			for(j=0 ; j<n ; j++) {
				arr[i][j] = Character.digit(tmp.charAt(j), 10);
			}
		}
		
		size = 2;
		count = 0;
		
		while(size<=n) {
			for(i=0 ; i<n-size+1 ; i++) {
				for(j=0 ; j<n-size+1 ; j++) {
					if(arr[i][j]==size-1
							&&arr[i][j+1]==size-1
							&&arr[i+1][j]==size-1
							&&arr[i+1][j+1]==size-1) {
						arr[i][j]++;
						count++;
					}
				}
			}
			
			check[size-1] = count;
			count = 0;
			size++;
		}
		
		flag = true;
		
		for(i=1 ; i<n ; i++) {
			if(check[i]!=0) {
				System.out.println(i+1+" "+check[i]);
				flag = flag&&false;
			}
		}
		
		if(flag)
			System.out.println(0);
	}

}
