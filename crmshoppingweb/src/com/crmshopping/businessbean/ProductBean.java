package com.crmshopping.businessbean;





import java.util.ArrayList;

import com.crmshopping.dao.ProductDao;
import com.crmshopping.dto.Agent;
import com.crmshopping.dto.Product;




import com.crmshopping.util.DataAccessException;
import com.sun.org.apache.bcel.internal.generic.ALOAD;

public class ProductBean {
	ProductDao productDao= new ProductDao();
	public ArrayList<Product> getProductsByCategoryId(String CategoryId) throws DataAccessException{
	
		return productDao.getProductByCategoryId(CategoryId);
	
	
	}
	public Agent getAgentByProduct(String productId) {
		Agent agent=null;
		try {
			agent=productDao.getAgentByProductId(productId);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return agent;
	}

}
