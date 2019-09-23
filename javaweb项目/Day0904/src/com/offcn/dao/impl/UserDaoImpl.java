package com.offcn.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import com.offcn.utils.C3P0Utils;

public class UserDaoImpl implements UserDao {

	
	public User findUserByUsernameAndPassword(String username, String password) {
		
		User user = null;
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		
		try {
			user = qr.query(sql,new BeanHandler<>(User.class),username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int insertUser(User user) {
		
		int result = 0;
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into user values(null,?,?,?,?,?,?)";
		
		try {
			result = qr.update(sql,new Object[]{user.getUsername(),user.getPassword(),user.getName(),user.getSex(),user.getEmail(),user.getBirthday()});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public User findUserByUsername(String username) {
        User user = null;
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from user where username=?";
		
		try {
			user = qr.query(sql,new BeanHandler<>(User.class),username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
