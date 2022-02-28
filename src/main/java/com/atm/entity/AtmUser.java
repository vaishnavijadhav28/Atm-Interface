package com.atm.entity;

public class AtmUser {
	
	
	 int uId;
	 String uname;
	 String uaddress;
	 String pin;
	  long balnce;
	  long phone;
	  String email;
	  
	  
	public AtmUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AtmUser(int uId, String uname, String uaddress, String pin, long balnce, long phone, String email) {
		super();
		this.uId = uId;
		this.uname = uname;
		this.uaddress = uaddress;
		this.pin = pin;
		this.balnce = balnce;
		this.phone = phone;
		this.email = email;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public long getBalnce() {
		return balnce;
	}
	public void setBalnce(long balnce) {
		this.balnce = balnce;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	  
	  

}
