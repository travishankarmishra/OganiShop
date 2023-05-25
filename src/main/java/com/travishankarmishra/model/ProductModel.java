package com.travishankarmishra.model;

import java.util.List;

public class ProductModel {

	private String category;
	private int serial_no; //primary key
	private List<ProductImages> img_urls;
	private String name;
	private int rate;
	private float price;
	private String currency;
	private String brief_intro;
	private int Available_quantity; //to check availability and cart max quantity
	private int pincode; // to know shipping time
	private float weight;
	private String description;
	private List<RelatedProduct> related_product_serial_no;
	public ProductModel(String category, int serial_no, List<ProductImages> img_urls, String name, int rate,
			float price, String currency, String brief_intro, int available_quantity, int pincode, float weight,
			String description, List<RelatedProduct> related_product_serial_no) {
		super();
		this.category = category;
		this.serial_no = serial_no;
		this.img_urls = img_urls;
		this.name = name;
		this.rate = rate;
		this.price = price;
		this.currency = currency;
		this.brief_intro = brief_intro;
		Available_quantity = available_quantity;
		this.pincode = pincode;
		this.weight = weight;
		this.description = description;
		this.related_product_serial_no = related_product_serial_no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
	}
	public List<ProductImages> getImg_urls() {
		return img_urls;
	}
	public void setImg_urls(List<ProductImages> img_urls) {
		this.img_urls = img_urls;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getBrief_intro() {
		return brief_intro;
	}
	public void setBrief_intro(String brief_intro) {
		this.brief_intro = brief_intro;
	}
	public int getAvailable_quantity() {
		return Available_quantity;
	}
	public void setAvailable_quantity(int available_quantity) {
		Available_quantity = available_quantity;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<RelatedProduct> getRelated_product_serial_no() {
		return related_product_serial_no;
	}
	public void setRelated_product_serial_no(List<RelatedProduct> related_product_serial_no) {
		this.related_product_serial_no = related_product_serial_no;
	}
	@Override
	public String toString() {
		return "ProductModel [category=" + category + ", serial_no=" + serial_no + ", img_urls=" + img_urls + ", name="
				+ name + ", rate=" + rate + ", price=" + price + ", currency=" + currency + ", brief_intro="
				+ brief_intro + ", Available_quantity=" + Available_quantity + ", pincode=" + pincode + ", weight="
				+ weight + ", description=" + description + ", related_product_serial_no=" + related_product_serial_no
				+ "]";
	}
	
	
	
}
