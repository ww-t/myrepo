package hangman;
import java.util.Random;

public class word { // ������� �ܾ ó���ϴ� Ŭ����
	String[] w=new String[7]; // ������� �ܾ���� �����ϴ� �迭
	Random r=new Random(); // �������� �ܾ��� �����ϱ� ���� ���� ��ü
	int x;
	public word(){ // �����ڷ� �ܾ���� �迭�� ������
		w[0]="java";
		w[1]="hankyung";
		w[2]="eclipse";
		w[3]="cookie";
		w[4]="class";
		w[5]="python";
		w[6]="hangman";
	}
	
	public void choice(){ // ������ ������ �Լ�
		r.setSeed(r.nextLong());
		x=Math.abs(r.nextInt()%7);
	}
	
	public int slens(){ // ���õ� �ܾ��� ���̸� ���� ���ִ� �Լ�
		return w[x].length();
	}
}
