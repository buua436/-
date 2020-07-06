package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.Brand;
import bean.CarType;
import bean.User;
import utils.DaoUtils;

public class BrandDao {
	//查询品牌
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
