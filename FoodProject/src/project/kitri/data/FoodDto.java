package project.kitri.data;

// ���� Dto

public class FoodDto {

	public OrderHstrDto orderHstrDto = new OrderHstrDto();
	public StockDto stockDto = new StockDto();
	private String foodNum; // �����ڵ�
	private String foodCtg; // ��������
	private String foodName; // �����̸�
	private int foodPrice; // ���İ���

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

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

}
