package com.koushik.CRM.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koushik.CRM.entity.Customer;

@Repository // This annotation always apply to DAO implementations
public class CustomerDaoImplementation implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomer() {
		// Get the current session
		Session session = sessionFactory.getCurrentSession();
		
		// Create query
		Query<Customer> theQuery = session.createQuery("from Customer", Customer.class);
//		Customer cust1 = session.get(Customer.class, 1);
//		Customer cust2 = session.get(Customer.class, 2);
		
		// Execute the query
		List<Customer> customers = theQuery.getResultList();
//		List<Customer> customers = new ArrayList<Customer>();
//		customers.add(cust1);
//		customers.add(cust2);
		
		//return the list
		return customers;
	}

}
