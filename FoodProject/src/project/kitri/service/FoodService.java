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

	public void drinkProcess(String bt) {// drink���� ��ư ��������
				//db���� bt�� �̸��� ���� row�� ���� ������
				FoodDao.getInstance().selectFood(bt);
				//select ~~~
				//from food,order,stock
				//where food_name = bt;
				
				//�޾ƿ� ������ Jtable�� ���̱�
				FoodDao.getInstance().getFoodList();
				Vector row = new Vector();
				
				row.addElement(FoodDao.getInstance().getFoodList().get(0));
				row.addElement(FoodDao.getInstance().getFoodList().get(1));
				row.addElement(FoodDao.getInstance().getFoodList().get(2));
				row.addElement(FoodDao.getInstance().getFoodList().get(3));
				row.addElement(FoodDao.getInstance().getFoodList().get(4));
				row.addElement(FoodDao.getInstance().getFoodList().get(5));
				System.out.println(row);
				//���̺� ���̱�.....
				//setdataVector �����ϱ�
				//addrow ���̱�
//				JTable listT = new JTable(tM);
//			      listT.setFillsViewportHeight(true);
	}

	public void snackProcess() {
		
	}

	public void noodleProcess() {
		
	}

	public void instFoodProcess() {
		
	}
}
