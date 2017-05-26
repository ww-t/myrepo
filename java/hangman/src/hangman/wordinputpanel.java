package hangman;
import java.awt.*;
import javax.swing.*;

public class wordinputpanel extends JPanel { // 문자를 입력 받는 패널 클래스
	JTextField iptf=new JTextField(1); // 문자를 입력 받을 텍스트필드
	public wordinputpanel(){ // 생성자로 형태를 잡아준다.
		setLayout(new FlowLayout());
		JLabel lb1=new JLabel("Guess :");
		add(lb1);
		add(iptf);
	}
}
