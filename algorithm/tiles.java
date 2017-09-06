/*
바닥에 타일을 깔기 위해 필요한 타일수를 구하는 것이다.
타일의 크기는 8*8 이다. 타일은 그대로 이용할 수도 있고 잘라서 부분을 이용할 수도 있다.
그런데 잘라서 사용한 타일의 나머지는 반드시 버려야 한다.

문제는 사용되어진 온전한 타일수와 잘라서 사용한 타일수를 구하는 것이다. 모든 단위는 inch 이고 생략한다.

입력

방의 가로 , 세로 크기가 주어진다. 각 수는 1000 이하이다.

출력

출력 예의 형식으로 출력한다.

입출력 예

입력

160 240

출력

The number of whole tiles is 600 part tiles is 0

입력

100 120

출력

The number of whole tiles is 180 part tiles is 15
 */

package algorithm;

import java.util.Scanner;

public class tiles {
	
	public void counttiles(int horizental, int vertical) {
		
		int hquotient, vquotient, hremainder, vremainder, whole, part;
		
		hquotient = horizental/8;
		vquotient = vertical/8;
		hremainder = horizental%8;
		vremainder = vertical%8;
		
		whole = hquotient*vquotient;
		part = 0;
		
		if((hremainder != 0) && (vremainder != 0))
			part = part+hquotient+vquotient+1;
		else if(hremainder != 0)
			part = part+vquotient;
		else if(vremainder != 0)
			part = part+hquotient;
		
		System.out.println("The number of whole tiles is "+whole+" part tiles is "+part);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int x, y;
		tiles t = new tiles();
		
		x = scan.nextInt();
		y = scan.nextInt();
		
		t.counttiles(x, y);
	}

}
