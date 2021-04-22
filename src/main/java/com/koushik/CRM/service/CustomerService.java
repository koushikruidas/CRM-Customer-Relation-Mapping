package com.koushik.CRM.service;

import java.util.List;
import com.koushik.CRM.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers(); 
	public void saveCustomers(Customer customer);
	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
}
