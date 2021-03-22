package com.cg.sprint1_onlineplantnursery.entity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "t_order")
public class Order {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ_FOR_ORDER", initialValue = 101, allocationSize = 1)
	private Integer bookingId;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate orderDate;
	
	@NotBlank
	private String transactionMode;
	
	@NotNull
	private int quantity; // total quantity, i.e., planter+plant+seed
	
	private double totalCost;
	
	@CollectionTable(name = "t_Plant")
	@ElementCollection
	private Map<Integer, Integer> plants = new HashMap<Integer, Integer>(); //Plantid -> Quantity bought 
	
	@CollectionTable(name = "t_Seed")
	@ElementCollection
	//@OneToMany(cascade = CascadeType.ALL) 
	private Map<Integer, Integer> seeds = new HashMap<Integer, Integer>();
	 
	@CollectionTable(name = "t_Planter")
	@ElementCollection
	//@OneToMany(cascade = CascadeType.ALL) 
	private Map<Integer, Integer> planters = new HashMap<Integer, Integer>();
	
	//@OneToOne
	//@JoinColumn(name = "CUSTOMER_ID") 
	//private Customer customer;
	 
	//@OneToMany Map<Integer, Plant> key - plantid
	
	public Map<Integer, Integer> getSeeds() {
		return seeds;
	}

	public void setSeeds(Map<Integer, Integer> seeds) {
		this.seeds = seeds;
	}

	public Order() {
		super();
	}
	
	public Order(@NotNull LocalDate orderDate, @NotBlank String transactionMode, @NotNull int quantity,
			double totalCost) {
		super();
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	//constructor with id for testing purpose
	public Order(Integer bookingId, @NotNull LocalDate orderDate, @NotBlank String transactionMode,
			@NotNull int quantity, double totalCost) {
		super();
		this.bookingId = bookingId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	public Order(Integer bookingId, @NotNull LocalDate orderDate, @NotBlank String transactionMode,
			@NotNull int quantity, double totalCost, Map<Integer, Integer> plants) {
		super();
		this.bookingId = bookingId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.plants = plants;
	}
	
	
	
	public Order(Integer bookingId, @NotNull LocalDate orderDate, @NotBlank String transactionMode,
			@NotNull int quantity, double totalCost, Map<Integer, Integer> plants, Map<Integer, Integer> seeds) {
		super();
		this.bookingId = bookingId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.plants = plants;
		this.seeds = seeds;
	}

	
	
	public Order(Integer bookingId, @NotNull LocalDate orderDate, @NotBlank String transactionMode,
			@NotNull int quantity, double totalCost, Map<Integer, Integer> plants, Map<Integer, Integer> seeds,
			Map<Integer, Integer> planters) {
		super();
		this.bookingId = bookingId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.plants = plants;
		this.seeds = seeds;
		this.planters = planters;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	
	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	
	  public Map<Integer, Integer> getPlants() { return plants; }
	  
	  public void setPlants(Map<Integer, Integer> plants) { this.plants = plants; }

	public Map<Integer, Integer> getPlanters() {
		return planters;
	}

	public void setPlanters(Map<Integer, Integer> planters) {
		this.planters = planters;
	}	
	
	//If mapping elements are working fine then implement equals() and toString()
	
}
