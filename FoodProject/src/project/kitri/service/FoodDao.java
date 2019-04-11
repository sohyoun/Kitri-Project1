package project.kitri.service;

import java.sql.*;
import java.util.Vector;

import project.kitri.data.FoodDto;
import project.kitri.data.OrderHstrDto;
import project.kitri.data.StockDto;

public class FoodDao {

	private Connection conn;
	private ResultSet rs;

	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "project1";
	String pw = "project1";

	//////// ???????????????????????////////////////////////
	private static FoodDao instance = new FoodDao(); // 싱글톤 : 자기자신 객체 생성

	private FoodDao() {
	}

	public static FoodDao getInstance() {//외부에서 클래스명. getInstance()를 호출하면 이 클래스의 객체가 반환됨
		String driver = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driver);//JDBC 드라이버 로딩 : ojdbc.jar파일에 있는 OracleDriver
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return instance;
	}
	//////////////////////////////////////////////////////////

//	public void insert(FoodDto foodDto) {
//		PreparedStatement stmt = null;
//		//PreparedStatement : SQL문을 precompile하고 store 함.sql문을 여기저기서 용이하게 쓸 수 있게 함.
//		conn = null;
//		rs = null;
//		try {
//			String sql = "insert into food values(?,?,?,?)";//sql 쿼리
//			conn = DriverManager.getConnection(url, user, pw);//Connection 생성
//			stmt.setString(1, foodDto.getFoodNum());
//			stmt.setString(2, foodDto.getFoodCtg());
//			stmt.setString(3, foodDto.getFoodName());
//			stmt.setInt(4, foodDto.getFoodPrice());////// ????????왜 String이지?? int 하면 오류
//			stmt.executeUpdate();// sql문 execute(실행)
//		} catch (SQLException e) {
////			e.printStackTrace();
//			System.out.println("연결 실패" + e.getStackTrace());
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if(stmt != null)
//					stmt.close();
//				if(conn != null)
//					conn.close();
//			} catch (SQLException e) {
////				e.printStackTrace();
//				System.out.println("해제 실패" + e.getStackTrace());
//			}
//		}
//	}
	//한개의 food 정보
	public FoodDto selectFood(String food_name) {
		FoodDto foodDto = new FoodDto(); // FoodDto에 OrderHstrDto, StockDto 생성해놓음
		
		conn = null;					//연결
		PreparedStatement stmt = null;	//명령
		rs = null;						//결과
		
		
		try {
			conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "select food_ctg, food_name , order_amt, food_price, rest_amt "
					+ "from food, order_hstr, stock "
					+ "where food.food_num = order_hstr.food_num "
					+ "and food.food_ctg = stock.food_ctg "
					+ "and food.food_name = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, food_name);//?의 숫자번쨰
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				foodDto.setFoodCtg(rs.getString("food_ctg"));
				foodDto.setFoodName(rs.getString("food_name"));
				foodDto.setFoodPrice(rs.getInt("food_price"));
				
				foodDto.orderHstrDto.setOrderAmt(rs.getInt("order_amt"));
				
				foodDto.stockDto.setRestAmt(rs.getString("rest_amt"));
			}
			
			
		} catch (SQLException e) {
			System.out.println("연결 실패" + e.getStackTrace());
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("해제 실패" + e.getStackTrace());
			}
		}
		return foodDto;
	}
	
	//리스트 출력
	public Vector getFoodList() {
		Vector data = new Vector();
		
		conn = null;					//연결
		PreparedStatement stmt = null;	//명령
		rs = null;	
		
		try {
			conn = DriverManager.getConnection(url, user, pw);
			
			String sql= "select food_ctg, food_name , order_amt, food_price, rest_amt "
					+ "from food, order_hstr, stock "
					+ "where food.food_num = order_hstr.food_num "
					+ "and food.food_ctg = stock.food_ctg ";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				String no="";
				String food_ctg = rs.getString("food_ctg");
				String food_name = rs.getString("food_name");
				String order_amt = rs.getString("order_amt");
				String food_price = rs.getString("food_price");
				String rest_amt = rs.getString("rest_amt");
				
				Vector row = new Vector();
				
				row.add(no);///////////????????
				row.add(food_ctg);
				row.add(food_name);
				row.add(order_amt);
				row.add(food_price);
				row.add(rest_amt);
				
				data.add(row);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("해제 실패" + e.getStackTrace());
			}
		}
		return data;
	}
	
	//update 수량 고치기 / 재고 고치기

}