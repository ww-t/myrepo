package db;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class sdialog extends JDialog implements ActionListener { //�˸� ȭ�� Ŭ����
	JLabel jl;
	JButton jb;
	JPanel jp,bp,lp;
	
	public sdialog(String ms){
		jl=new JLabel(ms);
		jb=new JButton("Ȯ��");
		jp=new JPanel(new BorderLayout());
		bp=new JPanel();
		lp=new JPanel(new FlowLayout());
		
		setTitle("�˸�");
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		bp.add(jb);
		lp.add(jl);
		jp.add(BorderLayout.NORTH,lp);
		jp.add(BorderLayout.SOUTH,bp);
		
		getContentPane().add(jp);
		
		jb.addActionListener(this);
		
		setSize(200, 100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if((JButton)obj==jb)
			dispose();
	}
}
