package com.offcn.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.offcn.bean.Category;
import com.offcn.dao.CategoryDao;
import com.offcn.utils.C3P0Utils;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> findAllCategory() {
		List<Category> list = null;
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from category";
		
		try {
			list = qr.query(sql,new BeanListHandler<>(Category.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
