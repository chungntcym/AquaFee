package model;

import java.sql.Timestamp;

public class TKPayment {
	
	int customerId;
	String fullname;
	String address;
	String type;
	int waterMeterValue;
	float price;
	Timestamp paymentTime;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getWaterMeterValue() {
		return waterMeterValue;
	}
	public void setWaterMeterValue(int waterMeterValue) {
		this.waterMeterValue = waterMeterValue;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Timestamp getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Timestamp paymentTime) {
		this.paymentTime = paymentTime;
	}
	public TKPayment(int customerId, String fullname, String address, String type, int waterMeterValue, float price,
			Timestamp paymentTime) {
		super();
		this.customerId = customerId;
		this.fullname = fullname;
		this.address = address;
		this.type = type;
		this.waterMeterValue = waterMeterValue;
		this.price = price;
		this.paymentTime = paymentTime;
	}
	
	public TKPayment(){}

}
