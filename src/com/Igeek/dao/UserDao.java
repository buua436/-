package com.Igeek.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Igeek.bean.User;
import com.Igeek.utils.DaoUtils;


public class UserDao {
	//添加用户
	public int insertUser(User user)
	{
		QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
		String sql="insert into users values(?,?,?,?)";
		try {
			return runner.update(sql,user.getUserName(),user.getPassWord(),user.getUserMoney(),user.getYesOrno());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//根据用户名查询用户
	public User findByBrand(String name) {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
		String sql = "select * from user where username=? ";
		try {
			return runner.query(sql, new BeanHandler<User>(User.class),name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//更改用户余额
	public int updateUser(User user,int balance)
	{
		QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
		String sql="update user set balance=? where username=?";
		try {
			return runner.update(sql,balance,user.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
