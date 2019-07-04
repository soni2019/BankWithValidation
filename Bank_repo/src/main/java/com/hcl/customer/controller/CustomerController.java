package com.hcl.customer.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.customer.model.Customer;
import com.hcl.customer.serviceImpl.CustomerServiceImpl;
@RestController
@RequestMapping("/bank")
public class CustomerController {

		@Autowired
		CustomerServiceImpl customerServiceImpl;
		
		@PostMapping("/addCustomer")
		public HashMap<Long, Customer> addCustomer(@Valid @RequestBody Customer customer) {
			HashMap<Long, Customer> cust =customerServiceImpl.addCustomer(customer);
			//return new ResponseEntity<Customer>(HttpStatus.CREATED);
			return cust;
			
		}
		@PutMapping("/updateCustomer/{accountNumber}")
		public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable long accountNumber)
		{
			Customer cust=customerServiceImpl.updateCustomer(customer, accountNumber);
			
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		}

		@GetMapping("/findCustomer/{accountNumber}")
			public ResponseEntity<Customer> findCustomer(@PathVariable long accountNumber,
					@RequestParam(value="custName",required= false) String custName,
					//@RequestParam(value="custMobNum",required= false) long custMobNum,
					@RequestParam(value="custRole",required= false) String custRole					
			){
			Customer cust = customerServiceImpl.findCustomer(accountNumber,custName,custRole);			
			return new ResponseEntity<Customer>(cust,HttpStatus.OK);
		}
		@DeleteMapping("/deleteByAccountNumber/{accountNumber}")
		public ResponseEntity<String> deleteCustomer(@PathVariable long accountNumber){
			customerServiceImpl.deleteCustomer(accountNumber);			
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		}


	
	


