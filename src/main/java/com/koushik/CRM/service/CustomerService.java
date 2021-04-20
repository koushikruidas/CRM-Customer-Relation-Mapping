package com.koushik.CRM.service;

import java.util.List;
import com.koushik.CRM.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers(); 
	public void saveCustomer(Customer customer);
}
