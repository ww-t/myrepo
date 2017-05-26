package db;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class sdupanel extends JPanel implements ActionListener { //조회, 수정, 삭제 화면 클래스
	database db;
	JButton selb,upb,delb,cb;
	JLabel cl,pl;
	JTable rt;
	JScrollPane sp;
	JTextField ctf,ptf;
	JPanel p1,p2,p3,p1_1,p1_2,p1_3;
	DefaultTableModel tm;
	Vector<String> header=new Vector<String>();
	JDialog ud;
	updatepanel up;
	
	public sdupanel(database mdb){ //조회, 수정, 삭제 gui 구성, mdb는 database 객체
		db=mdb;		
		header.addElement("고객번호");
		header.addElement("고객명");
		header.addElement("제품번호");
		header.addElement("제품명");
		header.addElement("선호도");
		up=new updatepanel(mdb);
		selb=new JButton("조회");
		upb=new JButton("수정");
		delb=new JButton("삭제");
		cb=new JButton("취소");
		cl=new JLabel("고객명");
		pl=new JLabel("제품명");
		ctf=new JTextField(20);
		ptf=new JTextField(20);
		tm=new DefaultTableModel(header,0);
		rt=new JTable(tm);
		sp=new JScrollPane(rt);
		p1=new JPanel(new BorderLayout());
		p2=new JPanel();
		p3=new JPanel();
		p1_1=new JPanel();
		p1_2=new JPanel();
		p1_3=new JPanel(new FlowLayout());
		ud=new JDialog();
		
		setLayout(new BorderLayout());
		
		p1_1.add(cl);
		p1_1.add(ctf);
		p1_2.add(pl);
		p1_2.add(ptf);
		p1_3.add(selb);
		p1_3.add(cb);
		p1.add(BorderLayout.NORTH,p1_1);
		p1.add(BorderLayout.CENTER,p1_2);
		p1.add(BorderLayout.SOUTH,p1_3);
		p2.add(sp);
		p3.add(upb);
		p3.add(delb);
		ud.setTitle("수정");
		ud.getContentPane().add(up);
		ud.pack();
		
		selb.addActionListener(this);
		upb.addActionListener(this);
		delb.addActionListener(this);
		cb.addActionListener(this);
		
		add(BorderLayout.NORTH,p1);
		add(BorderLayout.CENTER,p2);
		add(BorderLayout.SOUTH,p3);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) { //조회, 수정, 삭제 화면 액션리스너
		// TODO Auto-generated method stub
		String ctname,pname,preference;
		int ctno,pno,i;
		int[] delrow;
		Vector<Object> delctno=new Vector<Object>(),delpno=new Vector<Object>();
		Object obj=arg0.getSource();
		Vector<Vector<Object>> data;
		
		if((JButton)obj==selb){ //조회 버튼 클릭시 입력한 데이터로 database 객체를 통해 select문 실행 후 데이터를 받아서 테이블에 나타냄
			ctname=ctf.getText();
			pname=ptf.getText();
			data=db.select(ctname, pname); //database 객체의 select 메소드 호출
			tm.setDataVector(data, header);
			if(tm.getRowCount()==0) //조회 결과가 없는 경우
				new sdialog("조회 결과가 없습니다.");
		}
		else if((JButton)obj==upb){ //수정 버튼 클릭시 테이블에서 선택한 데이터를 수정 화면 객체에 전달하고 수정 화면이 나타남
			if(rt.getSelectedRowCount()==0) //데이터를 선택하지 않은 경우
				new sdialog("데이터를 선택해주세요.");
			else{
				ctname=(String) tm.getValueAt(rt.getSelectedRow(), 1);
				pname=(String) tm.getValueAt(rt.getSelectedRow(), 3);
				preference=(String) tm.getValueAt(rt.getSelectedRow(), 4);
				ctno=(int) tm.getValueAt(rt.getSelectedRow(),0);
				pno=(int) tm.getValueAt(rt.getSelectedRow(),2);
				up.setselvalues(ctname,pname,preference,ctno,pno);
				ud.setVisible(true);
			}
		}
		else if((JButton)obj==delb){ //삭제 버튼 클릭시 테이블에서 선택한 데이터로  database 객체를 통해 delete문을 실행
			if(rt.getSelectedRowCount()==0) //데이터를 선택하지 않은 경우
				new sdialog("데이터를 선택해주세요.");
			else{
				delrow=rt.getSelectedRows(); //데이터를 여러개 받아서 처리할 수 잇음
				for(i=0;i<delrow.length;i++){
					delctno.addElement((int) tm.getValueAt(delrow[i],0));
					delpno.addElement((int) tm.getValueAt(delrow[i],2));
				}
				db.delete(delctno, delpno); //database 객체의 delete 메소드 호출
			}
		}
		else if((JButton)obj==cb){ //취소 버튼 클릭시 텍스트필드를 비움
			ctf.setText("");
			ptf.setText("");
		}
	}
}
