package com.offcn.bean;

import java.util.Date;

public class Product {
	
	private int id;
	private String name;
	private String color;
	private double price;
	private String introduction;
	private String image;
	private String state;
	private String version;
	private Date birthday;
	private Category category;
	

	public Product() {
		super();
	}
	public Product(int id, String name, String color, double price, String introduction, String image, String state,
			String version, Date birthday, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.introduction = introduction;
		this.image = image;
		this.state = state;
		this.version = version;
		this.birthday = birthday;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
