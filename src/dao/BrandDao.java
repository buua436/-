package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.Brand;
import bean.CarType;
import utils.DaoUtils;

public class BrandDao {
	//≤È—Ø∆∑≈∆
		public List<Brand> findByBrandId(int brandid) {
			// TODO Auto-generated method stub
			QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
			String sql = "select * from cartype where brandid=? ";
			try {
				return runner.query(sql, new BeanListHandler<Brand>(Brand.class), brandid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

}
