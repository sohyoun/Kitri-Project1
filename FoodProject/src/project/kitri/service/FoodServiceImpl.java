package project.kitri.service;

import project.kitri.data.FoodDto;
import project.kitri.data.OrderHstrDto;
import project.kitri.food.FoodController;

public class FoodServiceImpl implements FoodService{
	FoodController foodController;
	
	FoodDto foodDto;//����dto
	/*
	private String foodNum; // �����ڵ�
	private String foodCtg; // ��������
	private String foodName; // �����̸�
	private String foodPrice; // ���İ���
	 */
	
	OrderHstrDto orderHstrDto;//�����ֹ�dto
	/*
	private String foodNum; // �����ڵ�
	private String memberId; // ȸ��ID
	private String payNum; // ������ȣ
	private int orderAmt; // ���ļ���
	 */
	
	
	public FoodServiceImpl(FoodController foodController) {
		this.foodController = foodController;
		foodDto = new FoodDto();
		orderHstrDto = new OrderHstrDto();
	}
	
	@Override
	public void plus() {
		System.out.println("���ϱ�");
	}

	@Override
	public void minus() {
		
	}

	@Override
	public void oneCancel() {
		
	}

	@Override
	public void totalCancel() {
	
	}

	@Override
	public void cancelOrder() {
	
	}

	@Override
	public void completeOrder() {
	
	}

}
