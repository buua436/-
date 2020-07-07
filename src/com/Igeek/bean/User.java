package com.Igeek.bean;

public class User {
	//用户名
	private String userName;
	//密码
	private String passWord;
	//用户电话
	private String userTel="";
	//金额
	private double userMoney;
	//是否是管理员
	private int yesOrno;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public Double getUserMoney() {
		return userMoney;
	}
	public void setUserMoney(Double userMoney) {
		this.userMoney = userMoney;
	}
	public int getYesOrno() {
		return yesOrno;
	}
	public void setYesOrno(int yesOrno) {
		this.yesOrno = yesOrno;
	}
	public User(String userName, String passWord, double userMoney, int yesOrno) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.userMoney = userMoney;
		this.yesOrno = yesOrno;
	}
	public User() {
		super();
	}
	
	
	
	
	
}
