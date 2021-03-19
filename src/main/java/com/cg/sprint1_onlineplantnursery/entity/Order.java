package com.cg.sprint1_onlineplantnursery.entity;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Component
@Entity
@Table(name = "ORDERS")
public class Order {

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")

	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ_FOR_ORDER", initialValue = 701, allocationSize = 1)
	private Integer bookingId;
	private LocalDate date1;
	private String transactionMode;
	private int quantity; // total quantity, i.e., planter+plant+seed

	private double totalCost;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Customer customer;

	public Order() {
		super();
	}

	public Order( LocalDate date, String transactionMode, int quantity, double totalCost) {
		super();
		this.date1 = date;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	public Order(Integer bookingId, LocalDate date1, String transactionMode, int quantity, double totalCost,
			Customer customer) {
		super();
		this.bookingId = bookingId;
		this.date1 = date1;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.customer = customer;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getDate() {
		return date1;
	}

	public void setDate(LocalDate date) {
		this.date1 = date;
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
    @JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [bookingId=" + bookingId + ", date=" + date1 + ", transactionMode=" + transactionMode
				+ ", quantity=" + quantity + ", totalCost=" + totalCost + "]";
	}

}