/**
 * 
 */
package com.crmshopping.businessbean;

import java.util.ArrayList;

import com.crmshopping.dao.CategoryDao;
import com.crmshopping.dto.Category;
import com.crmshopping.util.DataAccessException;

/**
 * @author Administrator
 *
 */
public class CategoryBean {
	CategoryDao categoryDao = new CategoryDao();
	public ArrayList<Category> getCategories(String superCategoryId) throws DataAccessException{
		return categoryDao.getAllCategories(superCategoryId);
	}

	





}
