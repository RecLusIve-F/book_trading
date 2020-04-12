package com.entity;

public class User {
	
	
	   private int uid;
       private String username; 
       private String password;
       private String address;
       private String telephone;
       
       
       
       public void setUid(int uid) {
	        this.uid =  uid;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }
	    
	    public void setPassword(String password) {
	        this.password =  password;
	    }
	    
	    public void setAddress(String address) {
	        this.address = address;
	    }
	    
	    public void setTelephone(String telephone) {
	        this.telephone = telephone;
	    }
	    
	    public int getUid() {
	        return uid;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public  String getPassword() {
	        return password;
	    }
	    
	    public String getAddress() {
	        return address;
	    }
	    
	    public String getTelephone() {
	        return telephone;
	    }
}
