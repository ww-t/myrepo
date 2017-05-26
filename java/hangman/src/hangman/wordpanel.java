package hangman;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class wordpanel extends JPanel { // 맞은 문자들을 처리하는 클래스
	JLabel mtx=new JLabel("",JLabel.CENTER); // 맞은 문자를 보여주는 라벨
	JLabel lenlb=new JLabel(""); // 맞춰야하는 단어의 길이를 보여주는 라벨
	String[] rightword=new String[8]; // 맞은 문자들을 저장하는 배열
	
	public wordpanel(){ // 생성자로 시작시 모습을 잡아준다
		setLayout(new FlowLayout());
		JLabel lb1=new JLabel("Word :");
		for(int i=0;i<8;i++)
			rightword[i]="_";
		mtx.setBorder(new LineBorder(Color.blue));
		mtx.setPreferredSize(new Dimension(100,30));
		add(lb1);
		add(mtx);
		add(lenlb);
	}
	
	public void rightwordupdate(String cstr,String istr){ // 맞은 문자가 나온다면 화면에 띄어주는 함수 입력인자는 현재 맞춰야 하는 단어와 맞은 문자이다 
		String rw=new String("");
		char[] cstrar=cstr.toCharArray();
		for(int i=0;i<cstr.length();i++){ // 맞은 문자를 위치에 맞춰서 저장
			if(cstrar[i]==istr.charAt(0))
				rightword[i]=istr;
		}
		for(int i=0;i<cstr.length();i++){
			rw+=rightword[i];
		}
		mtx.setText(rw); // 맞은 문자들을 띄움
	}
	
	public void wordlenupdate(int len){ // 맞춰야하는 단어의 길이를 띄어주는 함수 입력인자는 단어의 길이이다
		lenlb.setText("Length : "+len+" characters");
	}
	
	public void reset(int len,String cstr){ // 맞은 문자 패널을 초기화하는 함수 입력인자는 새로 맞춰야할 단어의 길이와 단어
		int i;
		for(i=0;i<8;i++)
			rightword[i]="_";
		rightwordupdate(cstr," ");
		wordlenupdate(len);
	}
}
