package com.crmshopping.businessbean;

import com.crmshopping.dao.CustomerDao;
import com.crmshopping.dto.Customer;
import com.crmshopping.util.DataAccessException;

public class CustomerBean {
	CustomerDao customerDao=new CustomerDao();
	public boolean isValidUser(String CustomerId,String Password) throws DataAccessException
	{
		
		
		return customerDao.isValidUser(CustomerId, Password);
		
		
	}

	public Customer getCustomerById(String customerId) {
		Customer customer=null;
		try {
			customer=customerDao.getCustomerById(customerId);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return customer;
	}

	public boolean addCustomer(Customer customer) {
		boolean success=false;
		String id=null;
		CustomerDao customerDao = new CustomerDao();
		try {
			return success=customerDao.createCustomer(customer);
		}
		 catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

}
