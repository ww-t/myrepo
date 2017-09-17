package algorithm;

import java.util.Scanner;

public class range1 {

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
		
		for(i=1 ; i<n ; i++) {
			for(j=1 ; j<n ; j++) {
				if(arr[i][j]==1)
					arr[i][j] = 1+Math.min(arr[i][j-1], Math.min(arr[i-1][j], arr[i-1][j-1]));
			}
		}
		
		for(size=2 ; size<=n ; size++) {
			count = 0;
			
			for(i=1 ; i<n ; i++) {
				for(j=1 ; j<n ; j++) {
					if(arr[i][j]>=size)
						count++;
				}
			}
			
			check[size-1] = count;
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
