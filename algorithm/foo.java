//������ ����� ����ȸ�� FOO �� �ܾ ����� �ܾ �ƴ϶�� �����ߴ�. �׷��� �׵��� �� ���� OOF �� �ٲٱ�� �Ͽ���. 
//
//����� ��Ʈ���� �Է����� �޾� �� �̻��� FOO �� ������ ���� FOO �� OOF �� ���� �ϴ� ���α׷��� �ۼ��϶�. 
//
//�Է�
//�������� �׽�Ʈ �����Ͱ� �Է����� �־�����. �� �׽�Ʈ �����ʹ� �� �ٿ� ������� �ִ� 256 ���� �빮�ڰ� �־�����. 
//�Է��� ���� EOF �̴�. 
//
//���
//FOO �� OOF �� �ٲپ� ����Ѵ�. �� ���ڿ����� FOO �� ��Ÿ���� �ȵȴ�. 
//
//����� ��
//
//�Է�
//
//FOOK
//FOOOOOPLE
//
//���
//
//OOFK
//OOOOFOPLE

package algorithm;

import java.util.Scanner;

public class foo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String s;
		
		while(sc.hasNextLine()) {
			s = sc.nextLine();
			
			while(s.indexOf("FOO")!=-1) {
				s = s.replace("FOO", "OOF");
			}
			
			System.out.println(s);
		}
	}

}
