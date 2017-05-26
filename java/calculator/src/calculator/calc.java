package calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class calc extends JFrame implements ActionListener {
	
	JButton btn[]=new JButton[16];
	String btnn[]={"7","8","9","+",
				   "4","5","6","-",
				   "1","2","3","*",
				   "0","c","=","/"};
	JLabel lbl;
	int result;
	double dresult;
	char op;
	int i;
	
	public calc(String str){
		super(str);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		init();
		for(i=0;i<16;i++){
			btn[i].addActionListener(this);
		}
		setSize(300,350);
		setVisible(true);
	}
	
	public void init(){
		lbl=new JLabel("");
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout(4,4));
		for(i=0;i<16;i++){
			btn[i]=new JButton(btnn[i]);
			p2.add(btn[i]);
		}
		p1.add(lbl);
		p1.setPreferredSize(new Dimension(300,50));
		getContentPane().add("North",p1);
		getContentPane().add("Center",p2);
	}
	
	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource();
		for(i=0;i<16;i++){
			
		}
		for(i=0;i<16;i++){
			if((JButton)obj==btn[i]){
				switch(i){
				case 3:
					op='+';
					result=Integer.parseInt(lbl.getText());
					lbl.setText("");
					break;
				case 7:
					op='-';
					result=Integer.parseInt(lbl.getText());
					lbl.setText("");
					break;
				case 11:
					op='*';
					result=Integer.parseInt(lbl.getText());
					lbl.setText("");
					break;
				case 15:
					op='/';
					dresult=(double)Integer.parseInt(lbl.getText());
					lbl.setText("");
					break;
				case 14:
					switch(op){
					case '+':
						result+=Integer.parseInt(lbl.getText());
						lbl.setText(String.valueOf(result));
						break;
					case '-':
						result-=Integer.parseInt(lbl.getText());
						lbl.setText(String.valueOf(result));
						break;
					case '*':
						result*=Integer.parseInt(lbl.getText());
						lbl.setText(String.valueOf(result));
						break;
					case '/':
						dresult/=(double)Integer.parseInt(lbl.getText());
						lbl.setText(String.valueOf(dresult));
						break;
					}
					break;
				case 13:
					lbl.setText("");
					result=0;
					break;
				default:
					lbl.setText(lbl.getText()+btnn[i]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new calc("calculator");
	}

}