package project.kitri.data;

// 음식주문 Dto

public class OrderHstrDto {
	private String foodNum; // 음식코드
	private String memberId; // 회원ID
	private String payNum; // 결제번호
	private int orderAmt; // 음식수량

	public String getFoodNum() {
		return foodNum;
	}

	public void setFoodNum(String foodNum) {
		this.foodNum = foodNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPayNum() {
		return payNum;
	}

	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}

	public int getOrderAmt() {
		return orderAmt;
	}

	public void setOrderAmt(int orderAmt) {
		this.orderAmt = orderAmt;
	}

}
