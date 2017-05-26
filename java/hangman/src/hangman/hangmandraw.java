package hangman;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class hangmandraw extends JPanel { //����� �׸��� �г� Ŭ����
	int count=0; // �� �� Ʋ�ȴ��� ī���ϴ� ����
	
	public hangmandraw(){ // �����ڷ� ���¸� ����ش�
		setBorder(new LineBorder(Color.blue));
		setPreferredSize(new Dimension(300,500));
	}
	
	public void paintComponent(Graphics g){ // ����� �׸��� �Լ�
		super.paintComponent(g);
		g.drawLine(50, 450, 250, 450); // �⺻������ �׷����� �κ�
		g.drawLine(200, 450, 200, 100);
		g.drawLine(120, 100, 200, 100);
		g.drawLine(120, 100, 120, 150);
		if(count>0) // Ʋ���� ���� �׷����� �κ�
			g.drawOval(100, 150, 40, 40);
		if(count>1)
			g.drawLine(120, 190, 120, 240);
		if(count>2)
			g.drawLine(120, 195, 105, 215);
		if(count>3)
			g.drawLine(120, 195, 135, 215);
		if(count>4)
			g.drawLine(120, 240, 105, 270);
		if(count>5)
			g.drawLine(120, 240, 135, 270);
	}
	
	public void reset(){ // ��� �׸��� �����ϴ� �Լ�
		count=0;
		repaint();
	}
	
	public boolean increase(){ // Ʋ���� ��� ī��Ʈ�� ���� ��Ű�� �׸��� �ٽ� �׸��� ī��Ʈ�� �� á�� ��� true�� ���� �ƴϸ� false�� �����ϴ� �Լ�
		count++;
		repaint();
		if(count>6){
			return true;
		}
		return false;
	}
}
