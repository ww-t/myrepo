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

public class sdupanel extends JPanel implements ActionListener { //��ȸ, ����, ���� ȭ�� Ŭ����
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
	
	public sdupanel(database mdb){ //��ȸ, ����, ���� gui ����, mdb�� database ��ü
		db=mdb;		
		header.addElement("����ȣ");
		header.addElement("����");
		header.addElement("��ǰ��ȣ");
		header.addElement("��ǰ��");
		header.addElement("��ȣ��");
		up=new updatepanel(mdb);
		selb=new JButton("��ȸ");
		upb=new JButton("����");
		delb=new JButton("����");
		cb=new JButton("���");
		cl=new JLabel("����");
		pl=new JLabel("��ǰ��");
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
		ud.setTitle("����");
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
	public void actionPerformed(ActionEvent arg0) { //��ȸ, ����, ���� ȭ�� �׼Ǹ�����
		// TODO Auto-generated method stub
		String ctname,pname,preference;
		int ctno,pno,i;
		int[] delrow;
		Vector<Object> delctno=new Vector<Object>(),delpno=new Vector<Object>();
		Object obj=arg0.getSource();
		Vector<Vector<Object>> data;
		
		if((JButton)obj==selb){ //��ȸ ��ư Ŭ���� �Է��� �����ͷ� database ��ü�� ���� select�� ���� �� �����͸� �޾Ƽ� ���̺� ��Ÿ��
			ctname=ctf.getText();
			pname=ptf.getText();
			data=db.select(ctname, pname); //database ��ü�� select �޼ҵ� ȣ��
			tm.setDataVector(data, header);
			if(tm.getRowCount()==0) //��ȸ ����� ���� ���
				new sdialog("��ȸ ����� �����ϴ�.");
		}
		else if((JButton)obj==upb){ //���� ��ư Ŭ���� ���̺��� ������ �����͸� ���� ȭ�� ��ü�� �����ϰ� ���� ȭ���� ��Ÿ��
			if(rt.getSelectedRowCount()==0) //�����͸� �������� ���� ���
				new sdialog("�����͸� �������ּ���.");
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
		else if((JButton)obj==delb){ //���� ��ư Ŭ���� ���̺��� ������ �����ͷ�  database ��ü�� ���� delete���� ����
			if(rt.getSelectedRowCount()==0) //�����͸� �������� ���� ���
				new sdialog("�����͸� �������ּ���.");
			else{
				delrow=rt.getSelectedRows(); //�����͸� ������ �޾Ƽ� ó���� �� ����
				for(i=0;i<delrow.length;i++){
					delctno.addElement((int) tm.getValueAt(delrow[i],0));
					delpno.addElement((int) tm.getValueAt(delrow[i],2));
				}
				db.delete(delctno, delpno); //database ��ü�� delete �޼ҵ� ȣ��
			}
		}
		else if((JButton)obj==cb){ //��� ��ư Ŭ���� �ؽ�Ʈ�ʵ带 ���
			ctf.setText("");
			ptf.setText("");
		}
	}
}
