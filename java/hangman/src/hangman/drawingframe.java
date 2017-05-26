package hangman;
import java.awt.*;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.event.*;

import javax.swing.*;

public class drawingframe extends JFrame implements KeyListener { // �гε��� ���̴� ������ Ŭ����
	
	hangmandraw hmd=new hangmandraw(); // ����� �׸��� Ŭ���� ��ü
	JPanel tp=new JPanel(); // 3���� �г��� ��ĥ �г� ��ü
	wordpanel wp=new wordpanel(); // ���� ���ڿ� �ܾ��� ���̸� �����ִ� Ŭ���� ��ü
	wordinputpanel wip=new wordinputpanel(); // ���ڸ� �Է� �޴� Ŭ���� ��ü
	wrongwordpanel wwp=new wrongwordpanel(); // Ʋ�� ���ڸ� ó���ϴ� Ŭ���� ��ü
	word w=new word(); // ������� �ܾ ó���ϴ� Ŭ���� ��ü
	JFrame infof=new JFrame(); // ������ ������ ��� ������ ��ü
	JDialog info=new JDialog(infof,"Hangman Info",false); // ������ ������ ��� ���̾˷α� ��ü
	JLabel lb1=new JLabel("",JLabel.CENTER); // ������ ������ �ߴ� ���̾˷α׿� ��� ��
	JLabel lb2=new JLabel("",JLabel.CENTER); // ������ ������ �ߴ� ���̾˷α׿� ��� ��
	
	public drawingframe(String str){ // �����ڷ� ���۽� ���¸� ����ش�
		super(str);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		w.choice();
		wp.rightwordupdate(w.w[w.x]," ");
		wp.wordlenupdate(w.slens());
		wwp.wrongwordupdate();
		tp.setLayout(new GridLayout(3,1));
		tp.setPreferredSize(new Dimension(400,150));
		tp.add(wp);
		tp.add(wip);
		tp.add(wwp);
		wip.iptf.addKeyListener(this);
		add(hmd);
		add(tp);
		setBounds(0,0,1000,560);
		setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) { // ���ڸ� �Է� ������ ó���ϴ� �Լ�
		if(e.getKeyChar()==e.VK_ENTER){ // ���͸� �Է� ���� ���
			String inputstr=wip.iptf.getText(); // �Է¹޴� �ؽ�Ʈ�ʵ忡 �Էµ� ���ڿ��� �����´�
			int index=w.w[w.x].indexOf(inputstr); // �Է¹��� ���ڰ� �ܾ ����ִ��� Ȯ�� ������ -1�� ���ϵȴ�
			if(inputstr.length()==1&&inputstr.charAt(0)>='a'&&inputstr.charAt(0)<='z'&&wwp.mwlb.getText().indexOf(inputstr)==-1){ // �Է¹��� ���ڰ� ���ڸ��� �ҹ��� ���ĺ��̰� Ʋ�ȴ� ���ڰ� �ƴҶ� ������ ����
				if(index>=0){ // �Է¹��� ���ڰ� ���� ���
					wp.rightwordupdate(w.w[w.x],inputstr); // ���� ���ڸ� �߰���
					if(wp.mtx.getText().compareTo(w.w[w.x])==0){ // �� ���缭 ������ ���� ���
						infodialog("you win"); // ���̾˷α� â�� �ٿ�
						w.choice(); // �ܾ ���� �����ϰ� ����
						hmd.reset();
						wp.reset(w.slens(),w.w[w.x]);
						wwp.reset();
					}
				}
				else{ // �Է� ���� ���ڰ� Ʋ�� ���
					wwp.wrongwordinput(inputstr); // Ʋ�� ���� �߰�
					wwp.wrongwordupdate();
					if(hmd.increase()){ // ��� ��ȸ�� �� Ʋ���� ������ ���� ���
						infodialog("you lose"); // ���̾˷α� â�� �ٿ�
						w.choice(); // �ܾ ���� �����ϰ� ����
						hmd.reset();
						wp.reset(w.slens(),w.w[w.x]);
						wwp.reset();
					}
				}
			}
			wip.iptf.setText("");
		}
	}

	public void infodialog(String str){ // ������ �������� ���̾˷α׸� ���
		info.setLayout(new GridLayout(2,1));
		info.add(lb1);
		info.add(lb2);
		lb1.setText(str); // �Է����ڷ� ���� ���ڿ��� ���
		lb2.setText("correct answer : "+w.w[w.x]); // ������ ���
		infof.setDefaultCloseOperation(EXIT_ON_CLOSE);
		info.setBounds(400, 180, 200, 200);
		info.setVisible(true);
	}
}
