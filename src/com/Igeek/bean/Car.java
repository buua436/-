package com.Igeek.bean;

import java.util.Date;

public class Car {
	private String brandName;
	private String typeName;
	
	//car自己的属性...
	private int brandID;
	//车型编号，用于和车型的ID关联
	private int typeID;
	//具体某一款车辆的编号
	private int carID;
	//里程数
	private int mileage;
	//价格
	private int price;
	//发布时间
	private Date releaseDate;//Calendar
	//以上为基本信息，以下为详细信息
	//排量
	private double displacement;
	//上牌时间
	private Date licenceDate;
	//离合器类型
	private String cluth; 
	//是否被购买，true表示已被购买，不会再显示在二手车信息中
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
