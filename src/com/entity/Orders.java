package com.entity;

import java.sql.Date;

public class Orders {
	
	
	private int oid;
	private Date orderTime;
	private double total;
	private int status;
	private String address;
	private int uid;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setOid(int oid) {
        this.oid =  oid;
    }
	
	public void setOrderTime(Date orderTime) {
        this.orderTime =  orderTime;
    }
	
	public void setTotal(double total) {
        this.total =  total;
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
	
	public Date getOrderTime() {
	    return orderTime;
	}
	
	public double getTotal() {
        return total;
    }

	public String getAddress() {
        return address;
    }
	
	public int getUid() {
        return uid;
    }
}
