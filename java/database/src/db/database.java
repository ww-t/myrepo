package db;
import java.sql.*;
import java.util.Enumeration;
import java.util.Vector;

public class database { //�����ͺ��̽� ���� Ŭ����
	String driver;
	String url;
	String user;
	String pwd;
	Connection con;
	Statement stmt;
	ResultSet rs;
	String sql;
	
	public database(){ //�⺻���� ������ ����
		driver="oracle.jdbc.driver.OracleDriver";
		url="jdbc:oracle:thin:@localhost:1521:orcl";
		user="c##suk";
		pwd="suk";
		con=null;
		stmt=null;
		rs=null;
		sql="";
	}
	
	public void con(){ //�����ͺ��̽� ���� �޼ҵ�
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, pwd);
			stmt=con.createStatement();
		}
		catch(Exception e){
			System.out.println("connect fail : "+e.getMessage());
		}
	}
	
	public void discon(){ //�����ͺ��̽� �������� �޼ҵ�
		try{
			if(con!=null) con.close();
			if(stmt!=null) stmt.close();
		}
		catch(Exception e){
			System.out.println("disconnect fail : "+e.getMessage());
		}
	}
	
	public Vector<Vector<Object>> select(String ctname,String pname){ //�����ͺ��̽� select�� ���� �޼ҵ�
		rs=null;
		Vector<Vector<Object>> data=new Vector<Vector<Object>>();
		Vector<Object> row=new Vector<Object>();
		
		try{
			con();
			sql="select pp.ctno, c.ctname, pp.pno, p.pname, pp.preference"
					+ " from preferproduct pp, customer c, product p"
					+ " where pp.ctno=c.ctno and pp.pno=p.pno"; //����, ��ǰ�� �� �� �Է��� ���� ��� ��ü ��ȸ
			
			if(ctname.isEmpty()==false && pname.isEmpty()==false) //����, ��ǰ������ ��ȸ�ϴ� ���
				sql=sql+" and ctname='"+ctname+"' and pname='"+pname+"'";
			else if(pname.isEmpty()==false) //��ǰ������ ��ȸ�ϴ� ���
				sql=sql+" and pname='"+pname+"'";
			else if(ctname.isEmpty()==false) //�������� ��ȸ�ϴ� ���
				sql=sql+" and ctname='"+ctname+"'";
			sql+=" order by pp.ctno";
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				row.addElement(rs.getInt(1));
				row.addElement(rs.getString(2));
				row.addElement(rs.getInt(3));
				row.addElement(rs.getString(4));
				row.addElement(rs.getString(5));
				data.addElement((Vector<Object>)row.clone());
				row.clear();
			}
			discon();
		}
		catch(Exception e){
			new sdialog("��ȸ ����");
			System.out.println("select fail : "+e.getMessage());
		}
		
		return data; //select�� ����� Vector<Vector<Object>>�� ����
	}
	
	public void delete(Vector<Object> vctno, Vector<Object> vpno){ //�����ͺ��̽� delete�� ���� �޼ҵ�
		Enumeration<Object> ctno=vctno.elements();
		Enumeration<Object> pno=vpno.elements();
		try{
			con();
			while(ctno.hasMoreElements()){ //���� ���� �����͸� ������ �� ����
				sql="delete from preferproduct"
						+ " where ctno="+(int)ctno.nextElement()
						+ " and pno="+(int)pno.nextElement();
				stmt.executeUpdate(sql);
			}
			new sdialog("���� �Ϸ�");
			discon();
		}
		catch(Exception e){
			new sdialog("���� ����");
			System.out.println("delete fail : "+e.getMessage());
		}
	}
	
	public void update(String upctname,String uppname,String preference, int ctno, int pno){ //�����ͺ��̽� update�� ���� �޼ҵ�
		try{
			con();
			sql="update preferproduct"
					+ " set ctno=(select ctno from customer where ctname='"+upctname+"'),"
					+ " pno=(select pno from product where pname='"+uppname+"'),"
					+ " preference='"+preference+"'"
					+ " where ctno="+ctno+" and pno="+pno; //�Է��� �����͸� �����ϰ� ���� �����ʹ� ���� ����
			stmt.executeUpdate(sql);
			new sdialog("���� �Ϸ�");
			discon();
		}
		catch(Exception e){
			new sdialog("���� ����");
			System.out.println("update fail : "+e.getMessage());
		}
	}
	
	public void insert(String ctname, String pname, String preference){ //�����ͺ��̽� insert�� ���� �޼ҵ�
		try{
			con();
			sql="insert into preferproduct"
					+ " values ((select ctno from customer where ctname='"+ctname+"'),"
					+ " (select pno from product where pname='"+pname+"'),"
					+ " '"+preference+"')";
			stmt.executeUpdate(sql);
			new sdialog("���� �Ϸ�");
			discon();
		}
		catch(Exception e){
			new sdialog("���� ����");
			System.out.println("insert fail : "+e.getMessage());
		}
	}
}