package com.hcl.customer.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.ToString;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor

public class Customer {

	@NotEmpty(message="Please provide name.")
	private String custName;
	
	//@NotNull(message="Please provide accountNumber.")
	private long accountNumber;
	
	//@NotEmpty(message="Please provide Customer MobileNo.")
	//@Size(min=10, max=10, message = "Name should be between 5-10 digit.")
	private long custMobNum;
	
	@NotBlank(message="Please provide Customer Role.")
	private String custRole;
	
	@NotEmpty(message="Please provide Address.")
	private List<Address> address;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getCustMobNum() {
		return custMobNum;
	}

	public void setCustMobNum(long custMobNum) {
		this.custMobNum = custMobNum;
	}

	public String getCustRole() {
		return custRole;
	}

	public void setCustRole(String custRole) {
		this.custRole = custRole;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	


	

}