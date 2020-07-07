package com.Igeek.test;

import java.sql.SQLException;
import java.util.List;

import com.Igeek.bean.Car;
import com.Igeek.bean.User;
import com.Igeek.client.SecondCarMainSystem;
import com.Igeek.dao.CarDao;
import com.Igeek.dao.UserDao;
import com.Igeek.utils.DaoUtils;

public class TestUserDao {
	public static void main(String[] args) {
//		User user=new UserDao().findByName("allen");
//		System.out.println(user);
//		List<Car> cars=new CarDao().findByPrice(50000, 70000);
//		for(Car car:cars)
//			System.out.println(car);
		new SecondCarMainSystem().start();
	}
}
