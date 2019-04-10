package com.kitri.jdbctest;

import java.sql.*;

public class JdbcEx {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");//JDBC 드라이버 로딩 : ojdbc.jar파일에 있는 OracleDriver
			
			String url ="jdbc:oracle:thin:@localhost:1521:orcl";//localhost : 지금 이 컴퓨터
			String id = "haksa";
			String pw = "haksa";
			
			Connection con = DriverManager.getConnection(url, id, pw); //Connection 생성
			
			Statement st = con.createStatement(); // Statement 객체 생성
			System.out.println("연결성공");
			
			String sql ="select * from job"; //sql 쿼리
			
			ResultSet rs = st.executeQuery(sql);
			//쿼리실행결과
			while(rs.next()) {
				
				System.out.println(rs.getString(2));//1번째 column
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
