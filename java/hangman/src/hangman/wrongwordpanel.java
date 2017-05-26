package hangman;
import java.awt.*;

import javax.swing.*;

public class wrongwordpanel extends JPanel { // 틀린 문자를 처리하는 클래스
	JLabel mwlb=new JLabel(""); // 틀린 문자를 보여줄 라벨
	String[] wrongword=new String[7]; // 틀린 문자를 저장하는 배열
	int id=6; // 틀린 문자를 저장할때 쓸 인덱스
	
	public wrongwordpanel(){ // 생성자로 시작시 모습을 잡아준다
		setLayout(new FlowLayout());
		JLabel lb1=new JLabel("Misses :");
		for(int i=0;i<7;i++)
			wrongword[i]="";
		mwlb.setPreferredSize(new Dimension(70,30));
		add(lb1);
		add(mwlb);
	}
	
	public void wrongwordupdate(){ // 틀린 문자가 나온다면 화면에 띄어주는 함수
		int i,j;
		String ww=new String("");
		for(i=0;i<6;i++){ // 틀린 문자들을 정렬하는 부분
			for(j=0;j<6;j++){
				if(wrongword[i].compareTo(wrongword[i+1])>0){
					String temp=wrongword[i];
					wrongword[i]=wrongword[i+1];
					wrongword[i+1]=temp;
				}
			}
		}
		
		for(i=0;i<7;i++){
			if(wrongword[i].isEmpty())
				continue;
			else
				ww+=wrongword[i]+" ";
		}
		
		mwlb.setText(ww); // 틀린 문자들을 띄움
	}
	
	public void wrongwordinput(String input){ // 틀린 문자를 배열에 저장하는 함수 입력인자는 저장할 틀린 문자
		wrongword[id]=input;
		id--;
	}
	
	public void reset(){ // 틀린 문자 패널을 리셋 하는 함수
		int i;
		for(i=0;i<7;i++)
			wrongword[i]="";
		id=6;
		mwlb.setText("");
	}
}
