package project.kitri.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

	////////////////////////////////
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
	
	//�Ѱ��� food ����
	public FoodDto selectFood(String food_name) {
		FoodDto foodDto = new FoodDto(); // FoodDto�� OrderHstrDto, StockDto �����س���
		
		conn = null;					//����
		PreparedStatement stmt = null;	//���
		rs = null;						//���
		
		
		try {
			conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "select food_ctg, food_name, food_price "
					+ "from food "
					+ "where food.food_name = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, food_name);//?�� ���ڹ���
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				foodDto.setFoodCtg(rs.getString("food_ctg"));
				foodDto.setFoodName(rs.getString("food_name"));
				foodDto.setFoodPrice(rs.getInt("food_price"));
								
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
	
	//food_name ����Ʈ ��� (ī�װ���)
		public List<String> getFoodnamelist(String foodctg) {
			List<String> list = new ArrayList<String>();
			
			conn = null;					//����
			PreparedStatement stmt = null;	//���
			rs = null;	
			
			try {
				conn = DriverManager.getConnection(url, user, pw);
				
				String sql= "select food_name from food "
							+ "where food_ctg = ?";
						
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, foodctg);
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					String food_name = rs.getString("food_name");
					list.add(food_name);
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
			return list ;
		}
	//Order���� insert�ϱ�
		public void insertOrder(String food_name, String member_id,String pay_num,int order_amt) {
			
			conn = null;					//����
			PreparedStatement stmt = null;	//���
			rs = null;	
			
			try {
				conn = DriverManager.getConnection(url, user, pw);
				
				String sql= "insert into order_hstr(food_name,member_id,pay_num,order_amt,pay_date) "
						+ "values(?,?,?,?,?)";
						
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, food_name);
				stmt.setString(2, member_id);
				stmt.setString(3, pay_num);
				stmt.setInt(4, order_amt);
				stmt.setString(5, "");//////////////////////
				rs = stmt.executeQuery();
				
				
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
		}
		

}