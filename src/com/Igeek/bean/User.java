package com.Igeek.bean;

public class User {
	//�û���
	private String userName;
	//����
	private String passWord;
	//�û��绰
	private String userTel="";
	//���
	private double userMoney;
	//�Ƿ��ǹ���Ա
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
