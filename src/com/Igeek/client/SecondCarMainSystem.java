package com.Igeek.client;

import java.awt.print.Printable;
import java.util.List;
import java.util.Scanner;

import com.Igeek.bean.Car;
import com. Igeek.dao.CarDao;

/**
 * 系统界面
 * @author 86181
 *
 */
public class SecondCarMainSystem {
	private Scanner in = new Scanner(System.in);
	private CarDao cdao = new CarDao();
	
	
	public void start()
	{
		System.out.println("欢迎来到极客瓜子二手车市场....");
		System.out.println("1.登录\t2.注册\t3.查看最新二手车\t4.搜索车辆\t5.退出系统");
		String choose = in.next();
		switch(choose)
		{
		case "1":
			//
			break;
		case "2":
			//
			break;
		case "3":
			lookNewCars();
			break;
		case "4":
			//
			break;
		}
		
		
	}
	
	//根据价格区间查找
	public void searchByPrice()
	{
		//请选择价格区间
		
		//根据价格区间查找回集合
		int min=5;
		int max = 10;
		List<Car> list = cdao.findByPrice(min,max);
		printCarList(list);
	}
	
	//查看最新10两二手车
	private void lookNewCars() {
		//查询结果
		List<Car> list = cdao.findLastedTenCars();
		
		//打印车辆简单信息
		printCarList(list);
		
	}
	//3）展现简单车辆信息
	private void printCarList(List<Car> list) {
		if(list==null || list.size()==0)
		{
			System.out.println("暂无车辆信息！");
			return ;
		}
		System.out.println("序号\t品牌\t车型\t里程数\t价格\t发布时间");
		int count = 1;
		for (Car car : list) {
			System.out.println(count+"\t"+car.getBrandName()+"\t"+car.getTypeName()+"\t"+car.getMileage()+"\t"+car.getPrice()+"\t"+car.getReleaseDate());
		}
		
	}
	
}
