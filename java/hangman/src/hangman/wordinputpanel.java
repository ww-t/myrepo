package hangman;
import java.awt.*;
import javax.swing.*;

public class wordinputpanel extends JPanel { // ���ڸ� �Է� �޴� �г� Ŭ����
	JTextField iptf=new JTextField(1); // ���ڸ� �Է� ���� �ؽ�Ʈ�ʵ�
	public wordinputpanel(){ // �����ڷ� ���¸� ����ش�.
		setLayout(new FlowLayout());
		JLabel lb1=new JLabel("Guess :");
		add(lb1);
		add(iptf);
	}
}
