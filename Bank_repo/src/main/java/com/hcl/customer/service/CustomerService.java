package com.hcl.customer.service;

import java.util.HashMap;

import com.hcl.customer.model.Customer;

public interface CustomerService {
		
		public HashMap<Long, Customer> addCustomer(Customer customer);
		
		public Customer updateCustomer(Customer customer, long accountNumber);
		public Customer findCustomer(long accountNumber,String custName,String custRole);
		public String  deleteCustomer(long accountNumber );

	}

