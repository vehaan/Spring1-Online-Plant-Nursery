package com.cg.sprint1_onlineplantnursery.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue(value="Product")
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int cost;
	private int stock;
	@Enumerated(EnumType.STRING)
	private Type type;
	

	public Product(int cost, int stock, Type type) {
		super();
		this.cost = cost;
		this.stock = stock;
		this.type = type;
	}
	public Product(int id, int cost, int stock, Type type) {
		super();
		this.id = id;
		this.cost = cost;
		this.stock = stock;
		this.type = type;
	}
	public Product(int id, int cost, int stock) {
		super();
		this.id = id;
		this.cost = cost;
		this.stock = stock;
	}
	
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Product() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", cost=" + cost + ", stock=" + stock + "]";
	}
	public Product(int cost, int stock) {
		super();
		this.cost = cost;
		this.stock = stock;
	}
	


	

}
