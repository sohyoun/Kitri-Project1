package project.kitri.data;

// �����ֹ� Dto

public class OrderHstrDto {
	private String foodNum; // �����ڵ�
	private String memberId; // ȸ��ID
	private String payNum; // ������ȣ
	private int orderAmt; // ���ļ���

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