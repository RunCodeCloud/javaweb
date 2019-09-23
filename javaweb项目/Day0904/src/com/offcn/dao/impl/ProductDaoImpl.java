package com.offcn.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import com.offcn.utils.C3P0Utils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public int insertProduct(Product product) {
		int result = 0;
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into product values(null,?,?,?,?,?,?,?,?,?)";
		
		try {
			result = qr.update(sql,new Object[]{product.getName(),product.getColor(),product.getPrice(),product.getIntroduction(),product.getImage(),product.getState(),product.getVersion(),product.getBirthday(),product.getCategory().getId()});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
