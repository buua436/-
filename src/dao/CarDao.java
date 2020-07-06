package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.Car;
import bean.CarType;
import utils.DaoUtils;

public class CarDao {
	// 最新发布的10两二手车
	public List<Car> lookNewCars() {
		QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
		String sql = "select c.*,b.brandName,t.typeName from cars c,brand b,cartype t where b.brandid=t.brandid and t.typeid=c.typeid and c.isselled=0 order by releaseDate desc limit 10";
		try {
			return runner.query(sql, new BeanListHandler<Car>(Car.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 根据价格查询
	public List<Car> searchByPrice(int min, int max) {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
		String sql = "select c.*,b.brandName,t.typeName from cars c,brand b,cartype t where b.brandid=t.brandid and t.typeid=c.typeid and c.price between ? and ? and c.isselled=0 order by releaseDate desc limit 10";
		try {
			return runner.query(sql, new BeanListHandler<Car>(Car.class), min, max);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 根据车型查询
	public List<Car> searchByBrand(CarType type) {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
		String sql = "select c.*,b.brandName,t.typeName from cars c,brand b,cartype t where b.brandid=t.brandid and t.typeid=c.typeid and c.typeid=? and c.isselled=0 order by releaseDate desc limit 10";
		try {
			return runner.query(sql, new BeanListHandler<Car>(Car.class), type.getTypeID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 根据上牌日期查询
	public List<Car> searchByDate(int firstYear, int firstMonth, int secondYear, int secondMonth) {
		QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
		String sql = "select c.*,b.brandName,t.typeName from cars c,brand b,cartype t where b.brandid=t.brandid and t.typeid=c.typeid and c.isselled=0 and DATE_FORMAT(releaseDate,'%Y') BETWEEN ? and ? and DATE_FORMAT(releaseDate,'%m') BETWEEN ? and ? order by releaseDate desc limit 10";
		try {
			return runner.query(sql, new BeanListHandler<Car>(Car.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 根据车辆Id查询
	public List<Car> searchByCarId(int id) {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
		String sql = "select c.*,b.brandName,t.typeName from cars c,brand b,cartype t where b.brandid=t.brandid and t.typeid=c.typeid and c.carid=? and c.isselled=0 order by releaseDate desc limit 10";
		try {
			return runner.query(sql, new BeanListHandler<Car>(Car.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 卖出车辆
	public int updateIsBought(int id) {
		QueryRunner runner = new QueryRunner(DaoUtils.dataSource);
		String sql = "update cars set isselled=1 where carid=?";
		try {
			return runner.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
