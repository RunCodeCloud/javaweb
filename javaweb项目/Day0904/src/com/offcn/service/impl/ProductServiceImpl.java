package com.offcn.service.impl;

import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import com.offcn.dao.impl.ProductDaoImpl;
import com.offcn.service.ProductService;

public class ProductServiceImpl implements ProductService {

	ProductDao dao = new ProductDaoImpl();
	
	public int addProduct(Product product) {
		
		return dao.insertProduct(product);
	}

}
