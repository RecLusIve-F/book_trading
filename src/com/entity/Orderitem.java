package com.entity;

public class Orderitem {
	
	
	private int orderitemid;
	private int quantity;
	private int subtotal;
	private int bid;
	private String bname;
	private int price;
	private int oid;
	
	public void setOrderitemid(int orderitemid) {
        this.orderitemid =  orderitemid;
    }
	
	public void setQuantity(int quantity) {
        this.quantity =  quantity;
    }
	
	public void setSubtotal(int subtotal) {
        this.subtotal =  subtotal;
    }
	
	public void setBid(int bid) {
        this.bid =  bid;
    }
	
	public void setBname(String bname) {
        this.bname =  bname;
    }
	
	public void setPrice(int price) {
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
	
	public int getSubtotal() {
	    return subtotal;
	}
	
	public int getBid() {
	    return bid;
	}
	
	public String getBname() {
	    return bname;
	}
	
	public int getPrice() {
	    return price;
	}
	
	public int getOid() {
	    return oid;
	}
}
