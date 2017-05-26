package db;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class insertpanel extends JPanel implements ActionListener { //삽입 화면 클래스
	database db;
	JButton ib,cb;
	JLabel cl,pl,pfl;
	JTextField ctf,ptf;
	JPanel p1,p2,p1_1,p1_2,p1_3;
	JComboBox<String> pcb;
	
	public insertpanel(database mdb){ //삽입 화면 gui 구성, mdb는 database 객체
		db=mdb;
		ib=new JButton("삽입");
		cb=new JButton("취소");
		cl=new JLabel("고객명");
		pl=new JLabel("제품명");
		pfl=new JLabel("선호도");
		ctf=new JTextField(20);
		ptf=new JTextField(20);
		pcb=new JComboBox<String>();
		p1=new JPanel(new BorderLayout());
		p2=new JPanel();
		p1_1=new JPanel();
		p1_2=new JPanel();
		p1_3=new JPanel();
		
		setLayout(new BorderLayout());
		
		pcb.addItem("상");
		pcb.addItem("중");
		pcb.addItem("하");
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
	public void actionPerformed(ActionEvent arg0) { //삽입 화면 액션리스너
		// TODO Auto-generated method stub
		Object obj=arg0.getSource();
		String ctname, pname, preference;
		
		if((JButton)obj==ib){ //삽입 버튼 클릭시 입력한 데이터로 database 객체를 통해 insert문 실행
			ctname=ctf.getText();
			pname=ptf.getText();
			preference=(String)pcb.getSelectedItem();
			db.insert(ctname, pname, preference);
		}
		ctf.setText("");
		ptf.setText("");
	}

}
