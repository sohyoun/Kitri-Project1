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
	private static FoodDao instance = new FoodDao(); // �̱��� : �ڱ��ڽ� ��ü ����

	private FoodDao() {
	}

	public static FoodDao getInstance() {//�ܺο��� Ŭ������. getInstance()�� ȣ���ϸ� �� Ŭ������ ��ü�� ��ȯ��
		String driver = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driver);//JDBC ����̹� �ε� : ojdbc.jar���Ͽ� �ִ� OracleDriver
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return instance;
	}
	//////////////////////////////////////////////////////////

//	public void insert(FoodDto foodDto) {
//		PreparedStatement stmt = null;
//		//PreparedStatement : SQL���� precompile�ϰ� store ��.sql���� �������⼭ �����ϰ� �� �� �ְ� ��.
//		conn = null;
//		rs = null;
//		try {
//			String sql = "insert into food values(?,?,?,?)";//sql ����
//			conn = DriverManager.getConnection(url, user, pw);//Connection ����
//			stmt.setString(1, foodDto.getFoodNum());
//			stmt.setString(2, foodDto.getFoodCtg());
//			stmt.setString(3, foodDto.getFoodName());
//			stmt.setInt(4, foodDto.getFoodPrice());////// ????????�� String����?? int �ϸ� ����
//			stmt.executeUpdate();// sql�� execute(����)
//		} catch (SQLException e) {
////			e.printStackTrace();
//			System.out.println("���� ����" + e.getStackTrace());
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
//				System.out.println("���� ����" + e.getStackTrace());
//			}
//		}
//	}
	//�Ѱ��� food ����
	public FoodDto selectFood(String food_name) {
		FoodDto foodDto = new FoodDto(); // FoodDto�� OrderHstrDto, StockDto �����س���
		
		conn = null;					//����
		PreparedStatement stmt = null;	//���
		rs = null;						//���
		
		
		try {
			conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "select food_ctg, food_name , order_amt, food_price, rest_amt "
					+ "from food, order_hstr, stock "
					+ "where food.food_num = order_hstr.food_num "
					+ "and food.food_ctg = stock.food_ctg "
					+ "and food.food_name = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, food_name);//?�� ���ڹ���
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				foodDto.setFoodCtg(rs.getString("food_ctg"));
				foodDto.setFoodName(rs.getString("food_name"));
				foodDto.setFoodPrice(rs.getInt("food_price"));
				
				foodDto.orderHstrDto.setOrderAmt(rs.getInt("order_amt"));
				
				foodDto.stockDto.setRestAmt(rs.getString("rest_amt"));
			}
			
			
		} catch (SQLException e) {
			System.out.println("���� ����" + e.getStackTrace());
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("���� ����" + e.getStackTrace());
			}
		}
		return foodDto;
	}
	
	//����Ʈ ���
	public Vector getFoodList() {
		Vector data = new Vector();
		
		conn = null;					//����
		PreparedStatement stmt = null;	//���
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
				System.out.println("���� ����" + e.getStackTrace());
			}
		}
		return data;
	}
	
	//update ���� ��ġ�� / ��� ��ġ��

}