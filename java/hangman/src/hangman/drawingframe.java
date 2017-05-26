package hangman;
import java.awt.*;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.event.*;

import javax.swing.*;

public class drawingframe extends JFrame implements KeyListener { // 패널들을 붙이는 프레임 클래스
	
	hangmandraw hmd=new hangmandraw(); // 행맨을 그리는 클래스 객체
	JPanel tp=new JPanel(); // 3개의 패널을 합칠 패널 객체
	wordpanel wp=new wordpanel(); // 맞은 문자와 단어의 길이를 보여주는 클래스 객체
	wordinputpanel wip=new wordinputpanel(); // 문자를 입력 받는 클래스 객체
	wrongwordpanel wwp=new wrongwordpanel(); // 틀린 문자를 처리하는 클래스 객체
	word w=new word(); // 맞춰야할 단어를 처리하는 클래스 객체
	JFrame infof=new JFrame(); // 게임이 끝날때 띄울 프레임 객체
	JDialog info=new JDialog(infof,"Hangman Info",false); // 게임이 끝날때 띄울 다이알로그 객체
	JLabel lb1=new JLabel("",JLabel.CENTER); // 게임이 끝날때 뜨는 다이알로그에 띄울 라벨
	JLabel lb2=new JLabel("",JLabel.CENTER); // 게임이 끝날때 뜨는 다이알로그에 띄울 라벨
	
	public drawingframe(String str){ // 생성자로 시작시 형태를 잡아준다
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
	public void keyTyped(KeyEvent e) { // 문자를 입력 했을때 처리하는 함수
		if(e.getKeyChar()==e.VK_ENTER){ // 엔터를 입력 했을 경우
			String inputstr=wip.iptf.getText(); // 입력받는 텍스트필드에 입력된 문자열을 가져온다
			int index=w.w[w.x].indexOf(inputstr); // 입력받은 문자가 단어에 들어있는지 확인 없으면 -1이 리턴된다
			if(inputstr.length()==1&&inputstr.charAt(0)>='a'&&inputstr.charAt(0)<='z'&&wwp.mwlb.getText().indexOf(inputstr)==-1){ // 입력받은 문자가 한자리고 소문자 알파벳이고 틀렸던 문자가 아닐때 이프문 수행
				if(index>=0){ // 입력받은 문자가 맞은 경우
					wp.rightwordupdate(w.w[w.x],inputstr); // 맞은 문자를 추가함
					if(wp.mtx.getText().compareTo(w.w[w.x])==0){ // 다 맞춰서 게임이 끝난 경우
						infodialog("you win"); // 다이알로그 창을 뛰움
						w.choice(); // 단어를 새로 선택하고 리셋
						hmd.reset();
						wp.reset(w.slens(),w.w[w.x]);
						wwp.reset();
					}
				}
				else{ // 입력 받은 문자가 틀린 경우
					wwp.wrongwordinput(inputstr); // 틀린 문자 추가
					wwp.wrongwordupdate();
					if(hmd.increase()){ // 모든 기회를 다 틀려서 게임이 끝난 경우
						infodialog("you lose"); // 다이알로그 창을 뛰움
						w.choice(); // 단어를 새로 선택하고 리셋
						hmd.reset();
						wp.reset(w.slens(),w.w[w.x]);
						wwp.reset();
					}
				}
			}
			wip.iptf.setText("");
		}
	}

	public void infodialog(String str){ // 게임이 끝났을때 다이알로그를 띄움
		info.setLayout(new GridLayout(2,1));
		info.add(lb1);
		info.add(lb2);
		lb1.setText(str); // 입력인자로 받은 문자열을 띄움
		lb2.setText("correct answer : "+w.w[w.x]); // 정답을 띄움
		infof.setDefaultCloseOperation(EXIT_ON_CLOSE);
		info.setBounds(400, 180, 200, 200);
		info.setVisible(true);
	}
}
