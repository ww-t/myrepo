package db;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class updatepanel extends JPanel implements ActionListener { //수정 화면 클래스
	database db;
	JButton ub,cb;
	JLabel cl,pl,pfl;
	JTextField ctf,ptf;
	JComboBox<String> pcb;
	JPanel p1,p2,p1_1,p1_2,p1_3;
	int ctno,pno;
	String ctname,pname,preference;
	
	public updatepanel(database mdb){ //수정 화면 gui 구성
		db=mdb;
		ub=new JButton("수정");
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
		p2.add(ub);
		p2.add(cb);
		
		ub.addActionListener(this);
		cb.addActionListener(this);
		
		add(BorderLayout.CENTER,p1);
		add(BorderLayout.SOUTH,p2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //수정 화면 액션리스너
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		
		if((JButton)obj==ub){ //수정 버튼 클리시 입력한 데이터로 database 객체를 통해 update문 실행 
			if(ctf.getText().isEmpty()==false)
				ctname=ctf.getText();
			if(ptf.getText().isEmpty()==false)
				pname=ptf.getText();
			preference=(String)pcb.getSelectedItem();
			db.update(ctname, pname, preference, ctno, pno); //database 객체의 update 메소드 호출
		}
		ctf.setText("");
		ptf.setText("");
	}
	
	public void setselvalues(String sctname, String spname, String spreference, int sctno, int spno){ //테이블에서 선택한 데이터를 받는 메소드
		ctname=sctname;
		pname=spname;
		preference=spreference;
		ctno=sctno;
		pno=spno;
		pcb.setSelectedItem(spreference);
	}
}
