package com.Igeek.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Igeek.bean.Brand;
import com.Igeek.bean.CarType;
import com.Igeek.bean.User;
import com.Igeek.utils.DaoUtils;

public class BrandDao {
	//查询品牌
		public List<Brand> findAllBrand() {
			// TODO Auto-generated method stub
			QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
			String sql = "select * from brand";
			try {
				return runner.query(sql, new BeanListHandler<Brand>(Brand.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	//插入品牌
		public int insertBrand(Brand brand)
		{
			QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
			String sql="insert into brand values(?,?,?)";
			try {
				return runner.update(sql,brand.getBrandID(),brand.getBrandName(),brand.getBremarks());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
}
