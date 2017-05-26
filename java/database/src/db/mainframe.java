package db;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class mainframe extends JFrame implements ActionListener { //���� ȭ�� Ŭ����
	JRadioButton rb1, rb2;
	JPanel p1, p2, ip, sdup;
	database mdb;
	
	public mainframe(){ //���� ȭ�� gui ����
		mdb=new database();
		rb1=new JRadioButton("��ȸ, ����, ����",true);
		rb2=new JRadioButton("����");
		p1=new JPanel();
		p2=new JPanel();
		ip=new insertpanel(mdb);
		sdup=new sdupanel(mdb);
		ButtonGroup bg=new ButtonGroup();
		
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("���� ���̺� ����");
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
	public void actionPerformed(ActionEvent arg0) { //����ȭ�� �׼Ǹ�����
		// TODO Auto-generated method stub
		Object obj=arg0.getSource();
		
		if((JRadioButton)obj==rb1){ //��ȸ, ����, ���� ���ý� ��ȸ, ����, ���� ȭ�� �ٿ�
			sdup.setVisible(true);
			ip.setVisible(false);
		}
		else if((JRadioButton)obj==rb2){ //���� ���ý� ���� ȭ�� �ٿ�
			sdup.setVisible(false);
			ip.setVisible(true);
		}
	}
	
	
}
