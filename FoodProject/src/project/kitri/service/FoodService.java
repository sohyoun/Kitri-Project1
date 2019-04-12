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

	public void foodProccess(String btname) {//food�޴� ��ư ������ ��00000000000
		//db���� bt�� �̸��� ���� row�� ���� ������
		FoodDto food1 = FoodDao.getInstance().selectFood(btname);		
		int count =foodController.foodFrame.tM.getRowCount();
		
		//�޾ƿ� ������ Vector�� ����� 
		Vector row = new Vector();
		row.addElement(count+1);
		row.addElement(food1.getFoodCtg());
		row.addElement(food1.getFoodName());
		row.addElement(1);//�ֹ�����
		row.addElement(food1.getFoodPrice());
//		System.out.println(row);
		
		//�޾ƿ� ������ Jtable�� ���� ��� �ֹ� ���� �ø���!!!!
		//JTable�� ���پ� for�� ������.
		
		
		
		//Jtable�� �߰�
		foodController.foodFrame.tM.addRow(row);
		
	}
}
