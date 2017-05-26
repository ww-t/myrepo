package hangman;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class wordpanel extends JPanel { // ���� ���ڵ��� ó���ϴ� Ŭ����
	JLabel mtx=new JLabel("",JLabel.CENTER); // ���� ���ڸ� �����ִ� ��
	JLabel lenlb=new JLabel(""); // ������ϴ� �ܾ��� ���̸� �����ִ� ��
	String[] rightword=new String[8]; // ���� ���ڵ��� �����ϴ� �迭
	
	public wordpanel(){ // �����ڷ� ���۽� ����� ����ش�
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
	
	public void rightwordupdate(String cstr,String istr){ // ���� ���ڰ� ���´ٸ� ȭ�鿡 ����ִ� �Լ� �Է����ڴ� ���� ����� �ϴ� �ܾ�� ���� �����̴� 
		String rw=new String("");
		char[] cstrar=cstr.toCharArray();
		for(int i=0;i<cstr.length();i++){ // ���� ���ڸ� ��ġ�� ���缭 ����
			if(cstrar[i]==istr.charAt(0))
				rightword[i]=istr;
		}
		for(int i=0;i<cstr.length();i++){
			rw+=rightword[i];
		}
		mtx.setText(rw); // ���� ���ڵ��� ���
	}
	
	public void wordlenupdate(int len){ // ������ϴ� �ܾ��� ���̸� ����ִ� �Լ� �Է����ڴ� �ܾ��� �����̴�
		lenlb.setText("Length : "+len+" characters");
	}
	
	public void reset(int len,String cstr){ // ���� ���� �г��� �ʱ�ȭ�ϴ� �Լ� �Է����ڴ� ���� ������� �ܾ��� ���̿� �ܾ�
		int i;
		for(i=0;i<8;i++)
			rightword[i]="_";
		rightwordupdate(cstr," ");
		wordlenupdate(len);
	}
}
