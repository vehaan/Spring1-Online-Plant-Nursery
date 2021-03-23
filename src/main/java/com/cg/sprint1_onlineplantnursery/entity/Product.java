//package com.cg.sprint1_onlineplantnursery.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Positive;
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Entity
//public class Product {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;
//	@NotNull
//	@Positive(message = "Stock should be specified and should be a positive number")
//	private Integer stock; //NotEmpty
//	@Positive(message = "cost should be specified and should be a positive number")
//	private double cost;  //Positive and NotEmtpy
//	
//	
//	
//	public Product() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
//
//
//	public Product(Integer id,
//			@NotNull @Positive(message = "Stock should be specified and should be a positive number") Integer stock,
//			@Positive(message = "cost should be specified and should be a positive number") double cost) {
//		super();
//		this.id = id;
//		this.stock = stock;
//		this.cost = cost;
//	}
//
//
//
//
//	public Product(
//			@NotNull @Positive(message = "Stock should be specified and should be a positive number") Integer stock,
//			@Positive(message = "cost should be specified and should be a positive number") double cost) {
//		super();
//		this.stock = stock;
//		this.cost = cost;
//	}
//
//
//
//
//	public Integer getId() {
//		return id;
//	}
//
//
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//
//	public Integer getStock() {
//		return stock;
//	}
//
//
//
//	public void setStock(Integer stock) {
//		this.stock = stock;
//	}
//
//
//
//	public double getCost() {
//		return cost;
//	}
//
//
//
//	public void setCost(double cost) {
//		this.cost = cost;
//	}
//
//
//
//	
//	
//}
