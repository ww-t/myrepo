package db;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class mainframe extends JFrame implements ActionListener { //메인 화면 클래스
	JRadioButton rb1, rb2;
	JPanel p1, p2, ip, sdup;
	database mdb;
	
	public mainframe(){ //메인 화면 gui 구성
		mdb=new database();
		rb1=new JRadioButton("조회, 수정, 삭제",true);
		rb2=new JRadioButton("삽입");
		p1=new JPanel();
		p2=new JPanel();
		ip=new insertpanel(mdb);
		sdup=new sdupanel(mdb);
		ButtonGroup bg=new ButtonGroup();
		
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("취향 테이블 관리");
		setVisible(true);
		
		bg.add(rb1);
		bg.add(rb2);
		p1.add(rb1);
		p1.add(rb2);
		p2.add(ip);
		p2.add(sdup);
		ip.setVisible(false);
		sdup.setVisible(true);
		
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		
		getContentPane().add(BorderLayout.NORTH,p1);
		getContentPane().add(BorderLayout.CENTER,p2);
		
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) { //메인화면 액션리스너
		// TODO Auto-generated method stub
		Object obj=arg0.getSource();
		
		if((JRadioButton)obj==rb1){ //조회, 수정, 삭제 선택시 조회, 수정, 삭제 화면 뛰움
			sdup.setVisible(true);
			ip.setVisible(false);
		}
		else if((JRadioButton)obj==rb2){ //삽입 선택시 삽입 화면 뛰움
			sdup.setVisible(false);
			ip.setVisible(true);
		}
	}
	
	
}
