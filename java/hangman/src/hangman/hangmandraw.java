package hangman;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class hangmandraw extends JPanel { //행맨을 그리는 패널 클래스
	int count=0; // 몇 번 틀렸는지 카운하는 변수
	
	public hangmandraw(){ // 생성자로 형태를 잡아준다
		setBorder(new LineBorder(Color.blue));
		setPreferredSize(new Dimension(300,500));
	}
	
	public void paintComponent(Graphics g){ // 행맨을 그리는 함수
		super.paintComponent(g);
		g.drawLine(50, 450, 250, 450); // 기본적으로 그려지는 부분
		g.drawLine(200, 450, 200, 100);
		g.drawLine(120, 100, 200, 100);
		g.drawLine(120, 100, 120, 150);
		if(count>0) // 틀릴때 마다 그려지는 부분
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
	
	public void reset(){ // 행맨 그림을 리셋하는 함수
		count=0;
		repaint();
	}
	
	public boolean increase(){ // 틀렸을 경우 카운트를 증가 시키고 그림을 다시 그리고 카운트가 다 찼을 경우 true를 리턴 아니면 false를 리턴하는 함수
		count++;
		repaint();
		if(count>6){
			return true;
		}
		return false;
	}
}
