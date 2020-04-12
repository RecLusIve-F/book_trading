package com.entity;

public class Orderitem {
	
	
	private int orderitemid;
	private int quantity;
	private double subtotal;
	private int bid;
	private String bname;
	private double price;
	private int oid;
	
	public void setOrderitemid(int orderitemid) {
        this.orderitemid =  orderitemid;
    }
	
	public void setQuantity(int quantity) {
        this.quantity =  quantity;
    }
	
	public void setSubtotal(double subtotal) {
        this.subtotal =  subtotal;
    }
	
	public void setBid(int bid) {
        this.bid =  bid;
    }
	
	public void setBname(String bname) {
        this.bname =  bname;
    }
	
	public void setPrice(double price) {
        this.price =  price;
    }
	
	public void setOid(int oid) {
        this.oid =  oid;
    }
	
	public int getOrderitemid() {
	    return orderitemid;
	}
	
	public int getQuantity() {
	    return quantity;
	}
	
	public double getSubtotal() {
	    return subtotal;
	}
	
	public int getBid() {
	    return bid;
	}
	
	public String getBname() {
	    return bname;
	}
	
	public double getPrice() {
	    return price;
	}
	
	public int getOid() {
	    return oid;
	}
}
