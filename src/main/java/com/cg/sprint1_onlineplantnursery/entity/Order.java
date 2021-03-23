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
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Test_Order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ_FOR_ORDER", initialValue = 101, allocationSize = 1)
	private Integer bookingId;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate bookingDate;
	
	@NotBlank
	private String transactionMode;
	
	@NotNull
	@Positive(message = "Quantity must be positive")
	private int quantity; // total quantity, i.e., planter+plant+seed
	
	private double totalCost;
	
	@CollectionTable(name = "Test_Plant")
	@ElementCollection
	private Map<Integer, Integer> plants = new HashMap<Integer, Integer>(); //Plantid -> Quantity bought 
	
	@CollectionTable(name = "Test_Seed")
	@ElementCollection
	private Map<Integer, Integer> seeds = new HashMap<Integer, Integer>();
	 
	@CollectionTable(name = "Test_Planter")
	@ElementCollection
	private Map<Integer, Integer> planters = new HashMap<Integer, Integer>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Customer customer;
	
	public Order() {
		super();
	}

	public Order(@NotNull LocalDate bookingDate, @NotBlank String transactionMode,
			@NotNull @Positive(message = "Quantity must be positive") int quantity, double totalCost) {
		super();
		this.bookingDate = bookingDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	public Order(Integer bookingId, @NotNull LocalDate bookingDate, @NotBlank String transactionMode,
			@NotNull @Positive(message = "Quantity must be positive") int quantity, double totalCost) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	//Any one of following Plant or Seed or Planter
	public Order(@NotNull LocalDate bookingDate, @NotBlank String transactionMode,
			@NotNull @Positive(message = "Quantity must be positive") int quantity, double totalCost,
			Map<Integer, Integer> plants, Customer customer) {
		super();
		this.bookingDate = bookingDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.plants = plants;
		this.customer = customer;
	}

	public Order(Integer bookingId, @NotNull LocalDate bookingDate, @NotBlank String transactionMode,
			@NotNull @Positive(message = "Quantity must be positive") int quantity, double totalCost,
			Map<Integer, Integer> plants, Customer customer) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.plants = plants;
		this.customer = customer;
	}

	//Any two of Plant or Seed or Planter
	public Order(@NotNull LocalDate bookingDate, @NotBlank String transactionMode,
			@NotNull @Positive(message = "Quantity must be positive") int quantity, double totalCost,
			Map<Integer, Integer> plants, Map<Integer, Integer> seeds, Customer customer) {
		super();
		this.bookingDate = bookingDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.plants = plants;
		this.seeds = seeds;
		this.customer = customer;
	}

	public Order(Integer bookingId, @NotNull LocalDate bookingDate, @NotBlank String transactionMode,
			@NotNull @Positive(message = "Quantity must be positive") int quantity, double totalCost,
			Map<Integer, Integer> plants, Map<Integer, Integer> seeds, Customer customer) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.plants = plants;
		this.seeds = seeds;
		this.customer = customer;
	}

	//Constructor with all the 3
	public Order(@NotNull LocalDate bookingDate, @NotBlank String transactionMode,
			@NotNull @Positive(message = "Quantity must be positive") int quantity, double totalCost,
			Map<Integer, Integer> plants, Map<Integer, Integer> seeds, Map<Integer, Integer> planters,
			Customer customer) {
		super();
		this.bookingDate = bookingDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.plants = plants;
		this.seeds = seeds;
		this.planters = planters;
		this.customer = customer;
	}

	public Order(Integer bookingId, @NotNull LocalDate bookingDate, @NotBlank String transactionMode,
			@NotNull @Positive(message = "Quantity must be positive") int quantity, double totalCost,
			Map<Integer, Integer> plants, Map<Integer, Integer> seeds, Map<Integer, Integer> planters,
			Customer customer) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.plants = plants;
		this.seeds = seeds;
		this.planters = planters;
		this.customer = customer;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
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

	public Map<Integer, Integer> getPlants() {
		return plants;
	}

	public void setPlants(Map<Integer, Integer> plants) {
		this.plants = plants;
	}

	public Map<Integer, Integer> getSeeds() {
		return seeds;
	}

	public void setSeeds(Map<Integer, Integer> seeds) {
		this.seeds = seeds;
	}

	public Map<Integer, Integer> getPlanters() {
		return planters;
	}

	public void setPlanters(Map<Integer, Integer> planters) {
		this.planters = planters;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingDate == null) ? 0 : bookingDate.hashCode());
		result = prime * result + ((bookingId == null) ? 0 : bookingId.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((planters == null) ? 0 : planters.hashCode());
		result = prime * result + ((plants == null) ? 0 : plants.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((seeds == null) ? 0 : seeds.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transactionMode == null) ? 0 : transactionMode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (bookingDate == null) {
			if (other.bookingDate != null)
				return false;
		} else if (!bookingDate.equals(other.bookingDate))
			return false;
		if (bookingId == null) {
			if (other.bookingId != null)
				return false;
		} else if (!bookingId.equals(other.bookingId))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (planters == null) {
			if (other.planters != null)
				return false;
		} else if (!planters.equals(other.planters))
			return false;
		if (plants == null) {
			if (other.plants != null)
				return false;
		} else if (!plants.equals(other.plants))
			return false;
		if (quantity != other.quantity)
			return false;
		if (seeds == null) {
			if (other.seeds != null)
				return false;
		} else if (!seeds.equals(other.seeds))
			return false;
		if (Double.doubleToLongBits(totalCost) != Double.doubleToLongBits(other.totalCost))
			return false;
		if (transactionMode == null) {
			if (other.transactionMode != null)
				return false;
		} else if (!transactionMode.equals(other.transactionMode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", transactionMode=" + transactionMode
				+ ", quantity=" + quantity + ", totalCost=" + totalCost + ", plants=" + plants + ", seeds=" + seeds
				+ ", planters=" + planters + ", customer=" + customer + "]";
	}
	
}
