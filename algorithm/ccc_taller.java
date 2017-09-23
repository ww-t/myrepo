//몇 분 뒤 수업이 시작합니다. 그런데 갑자기 반 친구들의 키를 비교하기로 했습니다. 교실에 정확히 키를 잴 수 있는 방법은 없는 관계로 두 명을 나란히 등을 맞대고 서 누가 더 큰지를 재는 고전적인 방법으로 키를 재기로 했습니다. 
//다행이도 반 친구들 중 키가 같은 사람은 한 명도 없고 키를 잴 때 실수를 한 적이 없습니다. 
//
//모든 비교를 끝낸 후 누가 이 반에서 제일 큰지를 결정하려고 합니다. 
//
//입력
//• 첫 줄에 N과 M이 공백으로 구분되어 입력됩니다. N은 이 반 친구들의 수 (1 ≤ N ≤ 1000000), M은 비교 횟수 (1 ≤ M ≤ 1000000)입니다. 
//• 이후 M 줄에 x, y (1 ≤ x,y ≤ N) 가 공백으로 구분되어 입력됩니다. x번 학생이 y번 학생보다 더 키가 크다는 뜻입니다. 
//• 마지막 줄에 p, q (1 ≤ p,q ≤ N) 가 공백으로 구분되어 입력됩니다. p번 학생이 q번학생보다 더 큰지 작은지를 비교해야합니다. 
//
//출력
//첫 줄에 다음 중 하나를 출력하세요. • yes (p가 q보다 더 큰 경우) 
//• no (p가 q보다 더 작은 경우) 
//• unknown (알 수 없는 경우) 
//
//입출력 예
//
//입력
//
//10 3
//8 4
//3 8
//4 2
//3 2
//
//출력
//
//yes
//
//입력
//
//10 3
//3 8
//2 8
//3 4
//3 2
//
//출력
//
//unknown

package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ccc_taller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n, m, p, q, i;
		Hashtable<Integer, ArrayList<Integer>> ht = new Hashtable<>();
		Queue<Integer> que = new LinkedList<>();
		String answer = "unknown";
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(i=0 ; i<m ; i++) {
			int x, y;
			
			x = sc.nextInt();
			y = sc.nextInt();
			
			if(ht.get(x)==null)
				ht.put(x, new ArrayList<>());
			
			ht.get(x).add(y);
		}
		
		p = sc.nextInt();
		q = sc.nextInt();
		
		que.add(p);
		que.add(q);
		
		while(que.isEmpty()==false) {
			int key = que.poll();
			
			if(ht.get(key)==null)
				continue;
			else if(ht.get(key).contains(q)) {
				answer = "yes";
				break;
			}
			else if(ht.get(key).contains(p)) {
				answer = "no";
				break;
			}
			else {
				for(int tmp : ht.get(key))
					que.add(tmp);
			}
			
			ht.remove(key);
		}
		
		System.out.println(answer);
	}

}
