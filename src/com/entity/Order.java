package com.entity;

public class Order {
	
	
	private int oid;
	private String orderTime;
	private int total;
	private int status;
	private String address;
	private int uid;
	
	
	public void setOid(int oid) {
        this.oid =  oid;
    }
	
	public void setOrderTime(String orderTime) {
        this.orderTime =  orderTime;
        
    }
	
	public void setTotal(int total) {
        this.total =  total;
    }
	
	public void setStatus(int oid) {
        this.oid =  oid;
    }
	
	public void setAddress(String address) {
        this.address =  address;
    }
	
	public void setUid(int uid) {
        this.uid =  uid;
    }
	
	public int getOid() {
        return oid;
    }
	
	public String getOrderTime() {
	    return orderTime;
	}
	
	public int getTotal() {
        return total;
    }

	public int getStatus() {
        return status;
    }
	
	public String getAddress() {
        return address;
    }
	
	public int getUid() {
        return uid;
    }
}
