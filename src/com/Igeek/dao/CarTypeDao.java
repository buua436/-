package com.Igeek.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Igeek.bean.Brand;
import com.Igeek.bean.CarType;
import com.Igeek.utils.DaoUtils;

public class CarTypeDao {
	//查询类型
	public List<CarType> findByBrand(Brand brand) {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
		String sql = "select * from cartype where brandid=? ";
		try {
			return runner.query(sql, new BeanListHandler<CarType>(CarType.class), brand.getBrandID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//插入车型
	public int insertCarType(CarType type)
	{
		QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
		String sql="insert into cartype values(?,?,?)";
		try {
			return runner.update(sql,type.getBrandID(),type.getTypeName(),type.getBrandID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//删除车型
	public int deleteCarType(CarType type)
	{
		new CarDao().deleteByType(type.getTypeID());
		QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
		String sql = "delete from cartype where typeid=?";
		try {
			return runner.update(sql, type.getTypeID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;	
	}
}
