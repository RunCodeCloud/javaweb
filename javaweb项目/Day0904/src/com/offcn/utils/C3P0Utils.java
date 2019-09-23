package com.offcn.utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	
	private static DataSource ds;
	
	static{
		ds = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static Connection getConnection(){
		
		Connection conn = null;
		
		try{
			conn = ds.getConnection();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}

}
