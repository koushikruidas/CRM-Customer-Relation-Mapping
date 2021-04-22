package com.koushik.CRM.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koushik.CRM.dao.CustomerDao;
import com.koushik.CRM.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		List<Customer> customers = customerDao.getCustomer();
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomers(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		Customer customer = customerDao.getCustomer(theId);
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDao.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> getCustomerByName(String name) {
		List<Customer> customer = customerDao.getCustomerByName(name);
		return customer;
	}
}
