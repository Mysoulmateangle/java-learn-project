package com.zhou.bean;

public class phone {
	private int id;
	private String brand;
	private String type;
	private int price;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public phone(int id, String brand, String type, int price) {
		super();
		this.id = id;
		this.brand = brand;
		this.type = type;
		this.price = price;
	}

	@Override
	public String toString() {
		return "phone [id=" + id + ", brand=" + brand + ", type=" + type + ", price=" + price + "]";
	}
	

}
