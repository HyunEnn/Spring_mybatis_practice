package com.ssafy.spring.dto;

public class MobileDto {

	private String mobileCode;
	private String model;
	private String price;
	private String company;
	public String getMobileCode() {
		return mobileCode;
	}
	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "MobileDto [mobileCode=" + mobileCode + ", model=" + model + ", price=" + price + ", company=" + company
				+ "]";
	}
	
}
