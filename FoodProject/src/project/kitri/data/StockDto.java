package project.kitri.data;

// 재고 Dto

public class StockDto {

	private String foodCtg; // 음식종류
	private String stockName; // 재고명
	private String restAmt; // 잔여수량
	private String unitCost; // 단가

	public String getFoodCtg() {
		return foodCtg;
	}

	public void setFoodCtg(String foodCtg) {
		this.foodCtg = foodCtg;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getRestAmt() {
		return restAmt;
	}

	public void setRestAmt(String restAmt) {
		this.restAmt = restAmt;
	}

	public String getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}

}
