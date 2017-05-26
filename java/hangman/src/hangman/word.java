package hangman;
import java.util.Random;

public class word { // 맟춰야할 단어를 처리하는 클래스
	String[] w=new String[7]; // 맞춰야할 단어들을 저장하는 배열
	Random r=new Random(); // 랜덤으로 단어을 선택하기 위한 랜덤 객체
	int x;
	public word(){ // 생성자로 단어들을 배열에 저장함
		w[0]="java";
		w[1]="hankyung";
		w[2]="eclipse";
		w[3]="cookie";
		w[4]="class";
		w[5]="python";
		w[6]="hangman";
	}
	
	public void choice(){ // 난수를 만들어내는 함수
		r.setSeed(r.nextLong());
		x=Math.abs(r.nextInt()%7);
	}
	
	public int slens(){ // 선택된 단어의 길이를 리턴 해주는 함수
		return w[x].length();
	}
}
