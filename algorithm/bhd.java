//소들은 자기 앞 쪽의 소들만을 볼수 있는 경우 각 소가 다른 소들의 머리 정수리를 볼 수 있는 소(cow) 수의 총합을 구하는 문제이다. 
//
//키가 같거나 큰 소가 나올 때까지의 모든 소들의 정수리를 볼 수 있다. 더 앞쪽의 소들은 그 소에 막혀서 볼 수가 없다. 
//
//예를 들어 6 마리의 소가 있고 차례대로 키가 5 , 2 , 4 , 2 , 6 , 1 이면 
//
// 
//• 1 번소는 2 , 3, 4 를 볼 수 있고 ... 3 마리 
//• 2 번소는 볼 수 있는 소가 없고 
//• 3 번소는 4 번 소 ... 1 마리 
//• 4 번소는 볼 수 있는 소가 없고 
//• 5 번소는 6 번소 ... 1 마리 
//• 6 번소는 볼 수 있는 소가 없다 
//이 경우 답은 3 + 1 + 1 = 5 
//
//입력
//소의 수 N(1 ≤ N ≤ 80,000 ) 이 주어지고 , N 개의 키 hi (1 ≤ hi ≤ 1,000,000,000 ) 가 주어진다.
//
//출력
//가능한 소들의 총 합을 출력한다.
//
//입출력 예
//
//입력
//
//6
//10
//3
//7
//4
//12
//2
//
//출력
//
//5

package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class bhd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n, i;
		long sum = 0;
		Stack<Integer> s = new Stack<>();
		
		n = sc.nextInt();
		
		for(i=0 ; i<n ; i++) {
			int ipi = sc.nextInt();
			
			while(true) {
				if(s.isEmpty()) {
					s.push(ipi);
					break;
				}
				else if(s.peek()>ipi) {
					s.push(ipi);
					break;
				}
				else {
					s.pop();
					sum = sum+s.size();
				}
			}
		}
		
		while(s.isEmpty()==false) {
			s.pop();
			sum = sum+s.size();
		}
		
		System.out.println(sum);
	}

}
