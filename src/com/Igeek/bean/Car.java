package com.Igeek.bean;

import java.util.Date;

public class Car {
	private String brandName;
	private String typeName;
	
	//car�Լ�������...
	private int brandID;
	//���ͱ�ţ����ںͳ��͵�ID����
	private int typeID;
	//����ĳһ����ı��
	private int carID;
	//�����
	private int mileage;
	//�۸�
	private int price;
	//����ʱ��
	private Date releaseDate;//Calendar
	//����Ϊ������Ϣ������Ϊ��ϸ��Ϣ
	//����
	private double displacement;
	//����ʱ��
	private Date licenceDate;
	//���������
	private String cluth; 
	//�Ƿ񱻹���true��ʾ�ѱ����򣬲�������ʾ�ڶ��ֳ���Ϣ��
	private boolean isBought;
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getBrandID() {
		return brandID;
	}
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public double getDisplacement() {
		return displacement;
	}
	public void setDisplacement(double displacement) {
		this.displacement = displacement;
	}
	public Date getLicenceDate() {
		return licenceDate;
	}
	public void setLicenceDate(Date licenceDate) {
		this.licenceDate = licenceDate;
	}
	public String getCluth() {
		return cluth;
	}
	public void setCluth(String cluth) {
		this.cluth = cluth;
	}
	public boolean isBought() {
		return isBought;
	}
	public void setBought(boolean isBought) {
		this.isBought = isBought;
	}
	@Override
	public String toString() {
		return "Car [brandName=" + brandName + ", typeName=" + typeName + ", brandID=" + brandID + ", typeID=" + typeID
				+ ", carID=" + carID + ", mileage=" + mileage + ", price=" + price + ", releaseDate=" + releaseDate
				+ ", displacement=" + displacement + ", licenceDate=" + licenceDate + "]";
	}
}
