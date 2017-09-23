//농부 존의 소들은 독서를 좋아한다. 소들이 지적인 내용의 책을 읽을 때 더 많은 우유를 생산한다는 것을 알았다. 
//
//그는 헛간의 도서관에 있는 싸구려 연애 소설을 알고리즘과 수학관련 책으로 바꾸기로 결정하였다. 그러나 불행하게도 새로운 책들을 옮기다 진흙에 빠드려 ISBN 수를 읽기가 힘들어 졌다. 
//
//ISBN(International Standard Book Number)은 책을 구분하는 10 개의 수로 이루어진다. 처음 9 개의 수는 책의 식별코드이고 , 마지막 한 자리는 ISBN 이 맞는지를 나타내는 check digit 로 사용된다. 
//
//ISBN 코드가 정확한지를 체크하는 방법은 각 자리에 10 , 9 , .. , 1 을 곱한 후 합을 11 로 나눈 나머지가 0 이면 옳은 코드로 인식한다. 
//
//예를 들어 , 코드가 0201103311 는 옳은 코드이다. 
//
//10*0 + 9*2 + 8*0 + 7*1 + 6*1 + 5*0 + 4*3 + 3*3 + 2*1 + 1*1 = 55. 
//55 를 11 로 나눈 나머지가 0 이므로 옮은 코드이다. 
//주의할 것은 처음 9 자리 수는 0 에서 9 사이 수 중 하나로 이루어져 있고 , check digit 를 사용하는 마지막 자리는 0 에서 10 까지의 수가 들어갈 수 있다. 이 때 10 은 X 로 표현한다. 
//
//156881111X는 옳은 코드이다. 
//입력에 ? 표가 있는 자리의 수를 찾는 게 문제이다. ? 표에 들어갈 숫자가 없다면 -1 을 출력한다. 
//
//입출력 예
//
//입력
//
//15688?111X
//
//출력
//
//1

package algorithm;

import java.util.Scanner;

public class isbn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String n;
		int arr[], i, q = 0, r = 0, sum = 0;
		
		n = scan.nextLine();
		arr = new int[10];
		
		for(i=0 ; i<n.length() ; i++) {
			char tmp = n.charAt(n.length()-1-i);
			
			if(tmp=='X')
				arr[i] = 10;
			else if(tmp=='?') {
				arr[i] = 0;
				q = i;
			}
			else
				arr[i] = Character.digit(tmp, 10);
		}
		
		for(i=0 ; i<10 ; i++) {
			sum = sum+arr[i]*(i+1);
		}
		
		if(q==0) {
			if(sum%11==0)
				r = 0;
			else
				r = 11-sum%11;
		}
		else {
			for(i=0 ; i<10 ; i++) {
				if((i*(q+1)+sum)%11==0) {
					r = i;
					break;
				}
				else
					r = -1;
			}
		}
		
		if(r==10)
			System.out.println('X');
		else
			System.out.println(r);
	}

}
