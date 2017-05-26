package db;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class insertpanel extends JPanel implements ActionListener { //���� ȭ�� Ŭ����
	database db;
	JButton ib,cb;
	JLabel cl,pl,pfl;
	JTextField ctf,ptf;
	JPanel p1,p2,p1_1,p1_2,p1_3;
	JComboBox<String> pcb;
	
	public insertpanel(database mdb){ //���� ȭ�� gui ����, mdb�� database ��ü
		db=mdb;
		ib=new JButton("����");
		cb=new JButton("���");
		cl=new JLabel("����");
		pl=new JLabel("��ǰ��");
		pfl=new JLabel("��ȣ��");
		ctf=new JTextField(20);
		ptf=new JTextField(20);
		pcb=new JComboBox<String>();
		p1=new JPanel(new BorderLayout());
		p2=new JPanel();
		p1_1=new JPanel();
		p1_2=new JPanel();
		p1_3=new JPanel();
		
		setLayout(new BorderLayout());
		
		pcb.addItem("��");
		pcb.addItem("��");
		pcb.addItem("��");
		p1_1.add(cl);
		p1_1.add(ctf);
		p1_2.add(pl);
		p1_2.add(ptf);
		p1_3.add(pfl);
		p1_3.add(pcb);
		p1.add(BorderLayout.NORTH,p1_1);
		p1.add(BorderLayout.CENTER,p1_2);
		p1.add(BorderLayout.SOUTH,p1_3);
		p2.add(ib);
		p2.add(cb);
		
		ib.addActionListener(this);
		cb.addActionListener(this);
		
		add(BorderLayout.CENTER,p1);
		add(BorderLayout.SOUTH,p2);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) { //���� ȭ�� �׼Ǹ�����
		// TODO Auto-generated method stub
		Object obj=arg0.getSource();
		String ctname, pname, preference;
		
		if((JButton)obj==ib){ //���� ��ư Ŭ���� �Է��� �����ͷ� database ��ü�� ���� insert�� ����
			ctname=ctf.getText();
			pname=ptf.getText();
			preference=(String)pcb.getSelectedItem();
			db.insert(ctname, pname, preference);
		}
		ctf.setText("");
		ptf.setText("");
	}

}
