package project.kitri.data;

// 음식 Dto

public class FoodDto {

	public OrderHstrDto orderHstrDto = new OrderHstrDto();
	private String foodCtg; // 음식종류
	private String foodName; // 음식이름
	private int foodPrice; // 음식가격
	private String stock1name;
	private int stock1num;
	private String stock2name;
	private int stock2num;
	private String stock3name;
	private int stock3num;

	//////////////////////////////////////////
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

	//////////////////////////////////////////////
	public String getStock1name() {
		return stock1name;
	}

	public void setStock1name(String stock1name) {
		this.stock1name = stock1name;
	}

	public int getStock1num() {
		return stock1num;
	}

	public void setStock1num(int stock1num) {
		this.stock1num = stock1num;
	}

	public String getStock2name() {
		return stock2name;
	}

	public void setStock2name(String stock2name) {
		this.stock2name = stock2name;
	}

	public int getStock2num() {
		return stock2num;
	}

	public void setStock2num(int stock2num) {
		this.stock2num = stock2num;
	}

	public String getStock3name() {
		return stock3name;
	}

	public void setStock3name(String stock3name) {
		this.stock3name = stock3name;
	}

	public int getStock3num() {
		return stock3num;
	}

	public void setStock3num(int stock3num) {
		this.stock3num = stock3num;
	}

}
