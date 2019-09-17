package org.lanqiao.entity;

public class Food {
	private Integer foodId;

	private Integer shopId;

	private String foodName;

	private String foodPrice;

	private Integer foodStock;

	private String foodPath;

	private String foodIntro;

	private Integer ftyId;

	private Integer foodMonSale;

	private String foodStatus;

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName == null ? null : foodName.trim();
	}

	public String getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice == null ? null : foodPrice.trim();
	}

	public Integer getFoodStock() {
		return foodStock;
	}

	public void setFoodStock(Integer foodStock) {
		this.foodStock = foodStock;
	}

	public String getFoodPath() {
		return foodPath;
	}

	public void setFoodPath(String foodPath) {
		this.foodPath = foodPath == null ? null : foodPath.trim();
	}

	public String getFoodIntro() {
		return foodIntro;
	}

	public void setFoodIntro(String foodIntro) {
		this.foodIntro = foodIntro == null ? null : foodIntro.trim();
	}

	public Integer getFtyId() {
		return ftyId;
	}

	public void setFtyId(Integer ftyId) {
		this.ftyId = ftyId;
	}

	public Integer getFoodMonSale() {
		return foodMonSale;
	}

	public void setFoodMonSale(Integer foodMonSale) {
		this.foodMonSale = foodMonSale;
	}

	public String getFoodStatus() {
		return foodStatus;
	}

	public void setFoodStatus(String foodStatus) {
		this.foodStatus = foodStatus == null ? null : foodStatus.trim();
	}
}