package com.travishankarmishra.model;

import java.util.List;

public class ProductImages {

	private int serial_no;
	private int imageid;
	private String imageurl;
	public ProductImages(int serial_no, int imageid, String imageurl) {
		super();
		this.serial_no = serial_no;
		this.imageid = imageid;
		this.imageurl = imageurl;
	}
	public int getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
	}
	public int getImageid() {
		return imageid;
	}
	public void setImageid(int imageid) {
		this.imageid = imageid;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	

	
}
