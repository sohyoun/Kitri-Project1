package project.kitri.data;

// ���� Dto

public class FoodDto {

	private String foodNum; // �����ڵ�
	private String foodCtg; // ��������
	private String foodName; // �����̸�
	private String foodPrice; // ���İ���

	public String getFoodNum() {
		return foodNum;
	}

	public void setFoodNum(String foodNum) {
		this.foodNum = foodNum;
	}

	public String getFoodCtg() {
		return foodCtg;
	}

	public void setFoodCtg(String foodCtg) {
		this.foodCtg = foodCtg;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
	}

}
