package hangman;
import java.awt.*;

import javax.swing.*;

public class wrongwordpanel extends JPanel { // Ʋ�� ���ڸ� ó���ϴ� Ŭ����
	JLabel mwlb=new JLabel(""); // Ʋ�� ���ڸ� ������ ��
	String[] wrongword=new String[7]; // Ʋ�� ���ڸ� �����ϴ� �迭
	int id=6; // Ʋ�� ���ڸ� �����Ҷ� �� �ε���
	
	public wrongwordpanel(){ // �����ڷ� ���۽� ����� ����ش�
		setLayout(new FlowLayout());
		JLabel lb1=new JLabel("Misses :");
		for(int i=0;i<7;i++)
			wrongword[i]="";
		mwlb.setPreferredSize(new Dimension(70,30));
		add(lb1);
		add(mwlb);
	}
	
	public void wrongwordupdate(){ // Ʋ�� ���ڰ� ���´ٸ� ȭ�鿡 ����ִ� �Լ�
		int i,j;
		String ww=new String("");
		for(i=0;i<6;i++){ // Ʋ�� ���ڵ��� �����ϴ� �κ�
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
		
		mwlb.setText(ww); // Ʋ�� ���ڵ��� ���
	}
	
	public void wrongwordinput(String input){ // Ʋ�� ���ڸ� �迭�� �����ϴ� �Լ� �Է����ڴ� ������ Ʋ�� ����
		wrongword[id]=input;
		id--;
	}
	
	public void reset(){ // Ʋ�� ���� �г��� ���� �ϴ� �Լ�
		int i;
		for(i=0;i<7;i++)
			wrongword[i]="";
		id=6;
		mwlb.setText("");
	}
}
