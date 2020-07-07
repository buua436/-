package com.Igeek.client;

import java.util.List;
import java.util.Scanner;

import com.Igeek.bean.Brand;
import com.Igeek.bean.Car;
import com.Igeek.bean.CarType;
import com.Igeek.bean.User;
import com.Igeek.dao.BrandDao;
import com.Igeek.dao.CarDao;
import com.Igeek.dao.CarTypeDao;
import com.Igeek.dao.UserDao;

/**
 * 系统界面
 * 
 * @author 86181
 *
 */
public class SecondCarMainSystem {
	private Scanner in = new Scanner(System.in);
	private CarDao cdao = new CarDao();
	private UserDao uDao = new UserDao();
	private CarTypeDao cyDao = new CarTypeDao();
	private BrandDao bDao = new BrandDao();
	private User uNow = null;

	public void start() {
		System.out.println("欢迎来到极客瓜子二手车市场....");
		System.out.println("1.登录\t2.注册\t3.查看最新二手车\t4.搜索车辆\t5.退出系统");
		String choose = in.next();
		switch (choose) {
		case "1":
			login();// 登录
			break;
		case "2":
			register();// 注册
			break;
		case "3":
			lookNewCars();// 查看最新二手车
			break;
		case "4":
			searchCars();// 搜索车辆
			break;
		case "5":
			exit();// 搜索退出系统
			break;
		default:
			System.out.println("选择有误，请重新选择。");
			start();// 递归调用:在方法中调用该方法本身。
		}

	}

	// 登录
	public void login() {
		System.out.println("----------用户登录界面----------");
		int random = (int) (1000 + Math.random() * 8999);
		System.out.println("请输入用户名：");
		String name = in.next();
		if (uDao.findByName(name) == null) {
			System.out.println("该用户名未注册，请核对后重试。");
			start();
		} else {
			System.out.println("请输入密码：");
			String password = in.next();
			if (!uDao.findByName(name).getPassWord().equals(password)) {
				System.out.println("密码有误，请重试");
				start();// 回到主菜单
			}
			System.out.println("请输入验证码(" + random + ")：");
			int userIn = in.nextInt();
			while (random != userIn) {
				random = (int) (1000 + Math.random() * 8999);
				System.out.println("验证码输入有误，请重试。");
				System.out.println("验证码(" + random + ")：");
				userIn = in.nextInt();
			}
			uNow = uDao.findByName(name);// 保存当前登录的用户
			searchCars();
		}
	}

	// 注册
	private void register() {
		System.out.println("-----------新用户注册界面----------");
		System.out.println("请输入用户名：");
		String name = in.next();
		while (uDao.findByName(name).getUserName().equals(name)) {
			System.out.println("用户名已存在");
			System.out.println("请输入用户名：");
			name = in.next();
		}
		System.out.println("请输入密码：");
		String password = in.next();
		System.out.println("请确认密码：");
		String checkpassword = in.next();
		while (!password.equals(checkpassword)) {
			System.out.println("您两次输入的密码不一致，请重试");
			System.out.println("请输入密码：");
			password = in.next();
			System.out.println("请确认密码：");
			checkpassword = in.next();
		}
		System.out.println("请输入账户余额");
		double money = in.nextDouble();
		System.out.println("是否是管理员1.是 0.否");
		int is = in.nextInt();
		System.out.println("已将您的信息导入系统，当前您的账户有10000000.00RMB，尽情选购吧！");
		uDao.insertUser(new User(name, password, money, is));
		start();
	}

	// 搜索车辆
	public void searchCars() {
		System.out.println("--------搜索车辆--------");
		System.out.println("1.根据品牌搜索\n2.根据价格搜索\n3.根据上牌日期搜索\n4.返回主菜单");
		Scanner in = new Scanner(System.in);
		String choose = in.next();
		switch (choose) {
		case "1":
			searchByBrand();// 根据品牌搜索
			break;
		case "2":
			searchByPrice();// 根据价格搜索
			break;
		case "3":
			searchByDate();// 根据上牌日期搜索
			break;
		case "4":
			start();// 返回主菜单
			break;
		// 输入其它就返回
		default:
			searchCars();
		}
	}

	// 登录后，普通用户主菜单
	// 登录后，管理员主菜单
	// 后台管理菜单
	// 品牌管理--添加品牌信息
	// 车型管理菜单--添加删除车型

	// 搜索退出系统
	public void exit() {
		// TODO Auto-generated method stub
		System.out.println("谢谢使用本系统！再见！");
		System.exit(0);
	}

	// 根据品牌查找
	public void searchByBrand() {
		List<Brand> list = bDao.findAllBrand();
		printBrandList(list);
	}

	// 输出品牌信息
	private void printBrandList(List<Brand> list) {
		if (list == null || list.size() == 0) {
			System.out.println("暂无品牌信息！");
			searchCars();
		}
		System.out.println("序号\t品牌");
		int count = 1;
		for (Brand brand : list) {
			System.out.println(count + "\t" + brand.getBrandName());
			count++;
		}
		selectBrand(list);
	}

	// 选择品牌
	private void selectBrand(List<Brand> list) {
		System.out.println("请选择:");
		int x = in.nextInt();
		printCarTypeList(cyDao.findByBrand(list.get(x - 1)));
	}

	// 输出车型
	private void printCarTypeList(List<CarType> list) {
		if (list == null || list.size() == 0) {
			System.out.println("暂无车型信息！");
			searchCars();
		}
		System.out.println("序号\t车型");
		int count = 1;
		for (CarType cartype : list) {
			System.out.println(count + "\t" + cartype.getTypeName());
			count++;
		}
		selectCarType(list);
	}
	//选择车型
	private void selectCarType(List<CarType> list) {
		System.out.println("请选择:");
		int x = in.nextInt();
		printCarList(cdao.findByBrand(list.get(x - 1)));
	}

	// 根据价格区间查找
	public void searchByPrice() {
		// 请选择价格区间
		System.out.println("请输入价格区间:");
		// 根据价格区间查找回集合
		System.out.println("最小值:");
		int min = in.nextInt();
		System.out.println("最大值:");
		int max = in.nextInt();
		List<Car> list = cdao.findByPrice(min, max);
		printCarList(list);
	}

	// 根据上牌日期查找
	private void searchByDate() {
		System.out.println("请输入上牌年份：");
		int firstYear = in.nextInt();
		System.out.println("请输入上牌月份：");
		int firstMonth = in.nextInt();
		System.out.println("请输入上牌年份：");
		int secondYear = in.nextInt();
		System.out.println("请输入上牌月份：");
		int secondMonth = in.nextInt();
		// 取数据库查
		List<Car> cars = cdao.findByDate(firstYear, firstMonth, secondYear, secondMonth);
		// 验证，显示员工数据
		printCarList(cars);
	}

	// 根据车辆Id查找
	private void searchByID() {
		// TODO Auto-generated method stub
		System.out.println("请输入汽车ID：");
		int id = in.nextInt();
		// 取数据库查
		Car cars = cdao.findByCarId(id);
		// 验证，显示员工数据
		System.out.println(cars);
		System.out.println("请选择:");
		if(uNow==null)
		{	
			System.out.println("1.主菜单");
			int x=in.nextInt();
			if(x==1)
				start();
			else
				start();
		}
		else
		{
			System.out.println("1.购买\t2.主菜单");
			int x=in.nextInt();
			if(x==1)
				buy(cars);
			else
				start();
		}

	}

	// 查看最新10两二手车
	private void lookNewCars() {
		// 查询结果
		List<Car> list = cdao.findLastedTenCars();
		// 打印车辆简单信息
		printCarList(list);
	}

	// 3）展现简单车辆信息
	private void printCarList(List<Car> list) {
		if (list == null || list.size() == 0) {
			System.out.println("暂无车辆信息！");
			start();
		}
		System.out.println("序号\t品牌\t车型\t里程数\t价格\t发布时间");
		int count = 1;
		for (Car car : list) {
			System.out.println(count + "\t" + car.getBrandName() + "\t" + car.getTypeName() + "\t" + car.getMileage()
					+ "\t" + car.getPrice() + "\t" + car.getReleaseDate());
			count++;
		}
		selectcar(list);
	}
	//输出详细信息
	private void selectcar(List<Car> list) {
		System.out.println("请选择:");
		int x = in.nextInt();
		Car car = list.get(x-1);
		System.out.println(car);
		System.out.println("请选择:");
		if(uNow==null)
		{	
			System.out.println("1.主菜单");
			x=in.nextInt();
			if(x==1)
				start();
			else
				start();
		}
		else
		{
			System.out.println("1.购买\t2.主菜单");
			x=in.nextInt();
			if(x==1)
				buy(car);
			else
				start();
		}
	}

	private void buy(Car car) {
		if(uNow.getUserMoney()<car.getPrice())
		{
			System.out.println("余额不足");
			start();
		}
		else
		{
			int x=uDao.updateUser(uNow, uNow.getUserMoney()-car.getPrice());
			uNow.setUserMoney(uNow.getUserMoney()-car.getPrice());
			cdao.updateIsBought(car.getCarID());
			if(x==1)
				System.out.println("购买成功");
			start();
		}
	}

	
}
