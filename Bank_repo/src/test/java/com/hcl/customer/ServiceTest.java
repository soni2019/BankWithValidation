package com.hcl.customer;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.customer.model.Address;
import com.hcl.customer.model.Customer;
import com.hcl.customer.serviceImpl.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
	
	
	@Mock
	CustomerServiceImpl customerServiceImpl;
	//@InjectMocks
	//CustomerServiceImpl customerServiceImpl1;
	
	
	
	@Test
	public void addCustomerTest() {
	List<Address> addresses = new ArrayList<Address>();
	Address address= new Address();
	address.setCity("patna");
	address.setPincode(45621);
	address.setState("Samastipur");
	address.setTypeOfAddress("office");
	
	addresses.add(address);
		
	Customer customer= new Customer();
	customer.setAccountNumber(123);
	customer.setCustMobNum(45623);
	customer.setCustName("soni");
	customer.setCustRole("HR");
	customer.setAddress(addresses);
	
	HashMap<Long, Customer> customerData= new HashMap<Long, Customer>();
	customerData.put(customer.getAccountNumber(), customer);
	when(customerServiceImpl.addCustomer(any())).thenReturn(customerData);
	HashMap<Long,Customer> expectedValue = customerServiceImpl.addCustomer(customer);
	assertEquals(expectedValue, customerData);
	
	}

}
