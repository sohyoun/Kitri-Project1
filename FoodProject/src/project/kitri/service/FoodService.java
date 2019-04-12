package project.kitri.service;

import java.util.Vector;

import javax.swing.JTable;

import project.kitri.data.FoodDto;
import project.kitri.food.FoodController;
import project.kitri.food.FoodFrame;

public class FoodService {
	
	public FoodController foodController;
	public FoodFrame ff;
	
	public FoodDto foodDto;
	
	public FoodService(FoodController foodController) {
		this.foodController = foodController;
		ff = foodController.foodFrame;
		foodDto = new FoodDto();
	}

	public void plus() {
		
	}

	public void minus() {
		
	}

	public void oneCancel() {
		
	}

	public void totalCancel() {
		
	}

	public void cancelOrder() {
		
	}

	public void completeOrder() {
		
	}

	public void foodProccess(String btname) {//food메뉴 버튼 눌렀을 때00000000000
		//db에서 bt와 이름이 같은 row의 정보 빼오기
		FoodDto food1 = FoodDao.getInstance().selectFood(btname);		
		int count =foodController.foodFrame.tM.getRowCount();
		
		//받아온 정보를 Vector로 만들기 
		Vector row = new Vector();
		row.addElement(count+1);
		row.addElement(food1.getFoodCtg());
		row.addElement(food1.getFoodName());
		row.addElement(1);//주문수량
		row.addElement(food1.getFoodPrice());
//		System.out.println(row);
		
		//받아온 정보가 Jtable에 있을 경우 주문 수량 올리기!!!!
		//JTable을 한줄씩 for문 돌리기.
		
		
		
		//Jtable에 추가
		foodController.foodFrame.tM.addRow(row);
		
	}
}
