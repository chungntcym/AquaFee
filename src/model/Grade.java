package model;

import java.sql.Date;

public class Grade {

	private int id;
	private int grade;
	private int value;
	private float price;
	private Date startDate;
	
	public Grade(int id, int grade, int value, float price, Date startDate) {
		super();
		this.id = id;
		this.grade = grade;
		this.value = value;
		this.price = price;
		this.startDate = startDate;
	}

	public Grade() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
		
}
