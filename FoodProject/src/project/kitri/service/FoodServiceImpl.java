package project.kitri.service;

import project.kitri.data.FoodDto;
import project.kitri.data.OrderHstrDto;
import project.kitri.food.FoodController;

public class FoodServiceImpl implements FoodService{
	FoodController foodController;
	
	FoodDto foodDto;//음식dto
	/*
	private String foodNum; // 음식코드
	private String foodCtg; // 음식종류
	private String foodName; // 음식이름
	private String foodPrice; // 음식가격
	 */
	
	OrderHstrDto orderHstrDto;//음식주문dto
	/*
	private String foodNum; // 음식코드
	private String memberId; // 회원ID
	private String payNum; // 결제번호
	private int orderAmt; // 음식수량
	 */
	
	
	public FoodServiceImpl(FoodController foodController) {
		this.foodController = foodController;
		foodDto = new FoodDto();
		orderHstrDto = new OrderHstrDto();
	}
	
	@Override
	public void plus() {
		System.out.println("더하기");
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
