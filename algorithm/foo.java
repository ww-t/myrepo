//깨끗한 언어만들기 위원회는 FOO 란 단어가 산뜻한 단어가 아니라고 선언했다. 그래서 그들은 이 것을 OOF 로 바꾸기로 하였다. 
//
//당신은 스트링을 입력으로 받아 더 이상의 FOO 가 없을때 까지 FOO 를 OOF 로 변경 하는 프로그램을 작성하라. 
//
//입력
//여러개의 테스트 데이터가 입력으로 주어진다. 각 테스트 데이터는 한 줄에 공백없이 최대 256 개의 대문자가 주어진다. 
//입력의 끝은 EOF 이다. 
//
//출력
//FOO 를 OOF 로 바꾸어 출력한다. 즉 문자열에서 FOO 가 나타나면 안된다. 
//
//입출력 예
//
//입력
//
//FOOK
//FOOOOOPLE
//
//출력
//
//OOFK
//OOOOFOPLE

package algorithm;

import java.util.Scanner;

public class foo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String s;
		
		while(sc.hasNextLine()) {
			s = sc.nextLine();
			
			while(s.indexOf("FOO")!=-1) {
				s = s.replace("FOO", "OOF");
			}
			
			System.out.println(s);
		}
	}

}
