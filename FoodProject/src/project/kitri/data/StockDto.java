package project.kitri.data;

// ��� Dto

public class StockDto {

	private String foodCtg; // ��������
	private String stockName; // ����
	private int restAmt; // �ܿ�����
	private String unitCost; // �ܰ�

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

	public int getRestAmt() {
		return restAmt;
	}

	public void setRestAmt(int restAmt) {
		this.restAmt = restAmt;
	}

	public String getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}

}
