package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.Brand;
import bean.CarType;
import utils.DaoUtils;

public class CarTypeDao {
	//≤È—Ø¿‡–Õ
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
}
