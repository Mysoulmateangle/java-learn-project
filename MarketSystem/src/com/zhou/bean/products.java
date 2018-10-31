package com.zhou.bean;

public class products {
	private String productId;
	private String name;
	private double price;
	private int stock;//货物储备
	private String addTime;
	private int uid;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public products(String productId, String name, double price, int stock, String addTime, int uid) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.addTime = addTime;
		this.uid = uid;
	}
	public products() {
		super();
	}
	@Override
	public String toString() {
		return "products [productId=" + productId + ", name=" + name + ", price=" + price + ", stock=" + stock
				+ ", addTime=" + addTime + ", uid=" + uid + "]";
	}
	
	
}
