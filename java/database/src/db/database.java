package db;
import java.sql.*;
import java.util.Enumeration;
import java.util.Vector;

public class database { //데이터베이스 연동 클래스
	String driver;
	String url;
	String user;
	String pwd;
	Connection con;
	Statement stmt;
	ResultSet rs;
	String sql;
	
	public database(){ //기본적인 데이터 설정
		driver="oracle.jdbc.driver.OracleDriver";
		url="jdbc:oracle:thin:@localhost:1521:orcl";
		user="c##suk";
		pwd="suk";
		con=null;
		stmt=null;
		rs=null;
		sql="";
	}
	
	public void con(){ //데이터베이스 연결 메소드
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, pwd);
			stmt=con.createStatement();
		}
		catch(Exception e){
			System.out.println("connect fail : "+e.getMessage());
		}
	}
	
	public void discon(){ //데이터베이스 연결해제 메소드
		try{
			if(con!=null) con.close();
			if(stmt!=null) stmt.close();
		}
		catch(Exception e){
			System.out.println("disconnect fail : "+e.getMessage());
		}
	}
	
	public Vector<Vector<Object>> select(String ctname,String pname){ //데이터베이스 select문 실행 메소드
		rs=null;
		Vector<Vector<Object>> data=new Vector<Vector<Object>>();
		Vector<Object> row=new Vector<Object>();
		
		try{
			con();
			sql="select pp.ctno, c.ctname, pp.pno, p.pname, pp.preference"
					+ " from preferproduct pp, customer c, product p"
					+ " where pp.ctno=c.ctno and pp.pno=p.pno"; //고객명, 제품명 둘 다 입력을 안한 경우 전체 조회
			
			if(ctname.isEmpty()==false && pname.isEmpty()==false) //고객명, 제품명으로 조회하는 경우
				sql=sql+" and ctname='"+ctname+"' and pname='"+pname+"'";
			else if(pname.isEmpty()==false) //제품명으로 조회하는 경우
				sql=sql+" and pname='"+pname+"'";
			else if(ctname.isEmpty()==false) //고객명으로 조회하는 경우
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
			new sdialog("조회 실패");
			System.out.println("select fail : "+e.getMessage());
		}
		
		return data; //select문 결과를 Vector<Vector<Object>>로 리턴
	}
	
	public void delete(Vector<Object> vctno, Vector<Object> vpno){ //데이터베이스 delete문 실행 메소드
		Enumeration<Object> ctno=vctno.elements();
		Enumeration<Object> pno=vpno.elements();
		try{
			con();
			while(ctno.hasMoreElements()){ //여러 개의 데이터를 삭제할 수 있음
				sql="delete from preferproduct"
						+ " where ctno="+(int)ctno.nextElement()
						+ " and pno="+(int)pno.nextElement();
				stmt.executeUpdate(sql);
			}
			new sdialog("삭제 완료");
			discon();
		}
		catch(Exception e){
			new sdialog("삭제 실패");
			System.out.println("delete fail : "+e.getMessage());
		}
	}
	
	public void update(String upctname,String uppname,String preference, int ctno, int pno){ //데이터베이스 update문 실행 메소드
		try{
			con();
			sql="update preferproduct"
					+ " set ctno=(select ctno from customer where ctname='"+upctname+"'),"
					+ " pno=(select pno from product where pname='"+uppname+"'),"
					+ " preference='"+preference+"'"
					+ " where ctno="+ctno+" and pno="+pno; //입력한 데이터만 수정하고 안한 데이터는 수정 안함
			stmt.executeUpdate(sql);
			new sdialog("수정 완료");
			discon();
		}
		catch(Exception e){
			new sdialog("수정 실패");
			System.out.println("update fail : "+e.getMessage());
		}
	}
	
	public void insert(String ctname, String pname, String preference){ //데이터베이스 insert문 실행 메소드
		try{
			con();
			sql="insert into preferproduct"
					+ " values ((select ctno from customer where ctname='"+ctname+"'),"
					+ " (select pno from product where pname='"+pname+"'),"
					+ " '"+preference+"')";
			stmt.executeUpdate(sql);
			new sdialog("삽입 완료");
			discon();
		}
		catch(Exception e){
			new sdialog("삽입 실패");
			System.out.println("insert fail : "+e.getMessage());
		}
	}
}