package com.offcn.service.impl;

import java.util.List;

import com.offcn.bean.Category;
import com.offcn.dao.CategoryDao;
import com.offcn.dao.impl.CategoryDaoImpl;
import com.offcn.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao dao = new CategoryDaoImpl();
			
	public List<Category> getAllCategory() {
		
		return dao.findAllCategory();
	}

}
