package com.koushik.CRM.dao;

import java.util.List;
import com.koushik.CRM.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomer();
	public void saveCustomer(Customer customer);
	public Customer getCustomer(int theId);
	public List<Customer> getCustomerByName(String name);
	public void deleteCustomer(int theId);
}
