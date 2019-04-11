package project.kitri.data;

// 음식 Dto

public class FoodDto {

	public OrderHstrDto orderHstrDto = new OrderHstrDto();
	public StockDto stockDto = new StockDto();
	private String foodNum; // 음식코드
	private String foodCtg; // 음식종류
	private String foodName; // 음식이름
	private int foodPrice; // 음식가격

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
