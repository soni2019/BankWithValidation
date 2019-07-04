package com.hcl.customer.serviceImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.hcl.customer.exception.DataNotFoundException;
import com.hcl.customer.model.Customer;
import com.hcl.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	public static HashMap<Long, Customer> hm = new HashMap<>();

	//static Customer customer = new Customer();
	
	static {
		/*Address official= new Address();
		official.setCity("mangalore");
		official.setPincode(574239);
		official.setState("karnataka");
		official.setTypeOfAddress("office Address");
		
		List<Address> listadd = new ArrayList<Address>();
		
		listadd.add(official);
	
		
		
		Customer cust1 = new Customer();
		cust1.setAccountNumber(1234l);
		cust1.setCustMobNum(2345l);
		cust1.setCustName("name1");
		cust1.setCustRole("custRole1");
		cust1.setAddress(listadd);
		hm.put(cust1.getAccountNumber(), cust1);*/
		Customer cust= parseJson();
		hm.put(cust.getAccountNumber(), cust);
	}
	
	@Override
	public HashMap<Long, Customer> addCustomer(Customer customer) {
		hm.put(customer.getAccountNumber(), customer);
		//System.out.println(hm);
		return hm;

	}

	@Override
	public Customer updateCustomer(Customer customer, long accountNumber) {

		if (customer != null && hm.containsKey(accountNumber)) {
			 customer= hm.put(accountNumber, customer);
			/*return "Customer detils updated succesfully";
		} else {
			throw new DataNotFoundException("No Record Avaliable");
		}*/
		}return customer;
	}

	@Override
	public Customer findCustomer(long accountNumber, String custName, String custRole) {
		Customer customer = null;
		if (accountNumber>0 ) {
			customer=hm.get(accountNumber);
			return customer;
		}else if(custName!=null) {
			customer=hm.get(custName);
			return customer;
		}else if(custRole!=null)
		{
			customer=hm.get(custRole);
			return customer;
		}
		
		else {
			throw new DataNotFoundException("No Record Avaliable");
		}
		
	}

	@Override
	public String deleteCustomer(long accountNumber) {
		Customer customer = null;
		if (hm.containsKey(accountNumber)) {
			customer = hm.remove(accountNumber);
			return "Sucessfully deleted";
		}

		else {
			throw new DataNotFoundException("No Record Avaliable");
		}
	}

	public static Customer parseJson()
	{
		Gson gson = new Gson();
		Customer customer=null;
        try (Reader reader = new FileReader("E:\\soniwork\\Bank_repo\\src\\main\\resources\\customer.json")) {

            // Convert JSON File to Java Object
          customer = gson.fromJson(reader, Customer.class);
          
			
			// print staff object
            System.out.println(customer);

        } catch (IOException e) {
            e.printStackTrace();
        }
		return customer; 
		
	}
	/*public static void main(String args []) {
		
	}*/
}