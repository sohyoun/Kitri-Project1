package com.kitri.jdbctest;

import java.sql.*;

public class JdbcEx {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");//JDBC ����̹� �ε� : ojdbc.jar���Ͽ� �ִ� OracleDriver
			
			String url ="jdbc:oracle:thin:@localhost:1521:orcl";//localhost : ���� �� ��ǻ��
			String id = "haksa";
			String pw = "haksa";
			
			Connection con = DriverManager.getConnection(url, id, pw); //Connection ����
			
			Statement st = con.createStatement(); // Statement ��ü ����
			System.out.println("���Ἲ��");
			
			String sql ="select * from job"; //sql ����
			
			ResultSet rs = st.executeQuery(sql);
			//����������
			while(rs.next()) {
				
				System.out.println(rs.getString(2));//1��° column
			}
			
			if(con!=null)
				con.close();
			if(st!=null)
				st.close();
			if(rs!=null)
				rs.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
}
