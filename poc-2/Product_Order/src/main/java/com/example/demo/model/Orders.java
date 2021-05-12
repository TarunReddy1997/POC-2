package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Orders {
	@Id
	private int oid;
	private int quantity;
	@CreationTimestamp
	private LocalDateTime time;
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;
	
	public Orders() {
		super();
	}

	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", quantity=" + quantity + ", time=" + time + ", product=" + product + "]";
	}

	
	


}
