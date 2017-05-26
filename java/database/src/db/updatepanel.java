package db;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class updatepanel extends JPanel implements ActionListener { //���� ȭ�� Ŭ����
	database db;
	JButton ub,cb;
	JLabel cl,pl,pfl;
	JTextField ctf,ptf;
	JComboBox<String> pcb;
	JPanel p1,p2,p1_1,p1_2,p1_3;
	int ctno,pno;
	String ctname,pname,preference;
	
	public updatepanel(database mdb){ //���� ȭ�� gui ����
		db=mdb;
		ub=new JButton("����");
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
		p2.add(ub);
		p2.add(cb);
		
		ub.addActionListener(this);
		cb.addActionListener(this);
		
		add(BorderLayout.CENTER,p1);
		add(BorderLayout.SOUTH,p2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //���� ȭ�� �׼Ǹ�����
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		
		if((JButton)obj==ub){ //���� ��ư Ŭ���� �Է��� �����ͷ� database ��ü�� ���� update�� ���� 
			if(ctf.getText().isEmpty()==false)
				ctname=ctf.getText();
			if(ptf.getText().isEmpty()==false)
				pname=ptf.getText();
			preference=(String)pcb.getSelectedItem();
			db.update(ctname, pname, preference, ctno, pno); //database ��ü�� update �޼ҵ� ȣ��
		}
		ctf.setText("");
		ptf.setText("");
	}
	
	public void setselvalues(String sctname, String spname, String spreference, int sctno, int spno){ //���̺��� ������ �����͸� �޴� �޼ҵ�
		ctname=sctname;
		pname=spname;
		preference=spreference;
		ctno=sctno;
		pno=spno;
		pcb.setSelectedItem(spreference);
	}
}
