package com.cg.sprint1_onlineplantnursery.entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

@Entity
public class Planter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Positive (message = "The height must be positive")
	private float height;
	
	@NotNull
	private String shape;
	
	@Positive (message = "The stock must be positive")
	private int stock;
	
	@Positive(message = "The cost must be a positive amount")
	private int cost;
	
	private int capacity;
	private int drainageHoles;
	private String color;
	
	public Planter(Integer id, @Positive(message = "The height must be positive") float height, String shape,
			@Positive(message = "The stock must be positive") int stock,
			@Positive(message = "The cost must be a positive amount") int cost, int capacity, int drainageHoles,
			String color) {
		super();
		this.id = id;
		this.height = height;
		this.shape = shape;
		this.stock = stock;
		this.cost = cost;
		this.capacity = capacity;
		this.drainageHoles = drainageHoles;
		this.color = color;
	}

	public Planter(@Positive(message = "The height must be positive") float height, String shape,
			@Positive(message = "The stock must be positive") int stock,
			@Positive(message = "The cost must be a positive amount") int cost, int capacity, int drainageHoles,
			String color) {
		super();
		this.height = height;
		this.shape = shape;
		this.stock = stock;
		this.cost = cost;
		this.capacity = capacity;
		this.drainageHoles = drainageHoles;
		this.color = color;
	}
	
	public Planter(@Positive(message = "The height must be positive") float height, String shape,
			@Positive(message = "The stock must be positive") int stock,
			@Positive(message = "The cost must be a positive amount") int cost) {
		super();
		this.height = height;
		this.shape = shape;
		this.stock = stock;
		this.cost = cost;
	}

	public Planter(Integer id, @Positive(message = "The height must be positive") float height, String shape,
			@Positive(message = "The stock must be positive") int stock,
			@Positive(message = "The cost must be a positive amount") int cost) {
		super();
		this.id = id;
		this.height = height;
		this.shape = shape;
		this.stock = stock;
		this.cost = cost;
	}

	public Planter() {
		super();
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getDrainageHoles() {
		return drainageHoles;
	}

	public void setDrainageHoles(int drainageHoles) {
		this.drainageHoles = drainageHoles;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Planter [id=" + id + ", height=" + height + ", shape=" + shape + ", stock=" + stock + ", cost=" + cost
				+ ", capacity=" + capacity + ", drainageHoles=" + drainageHoles + ", color=" + color + "]";
	}

	


}
