package com.cg.sprint1_onlineplantnursery.entity;

import java.time.LocalDate;

public class Order {
	private Integer bookingOrderId;
	private LocalDate orderDate;
	private String transactionMode;
	private int quantity;
	private double totalCost;
	private Planter planters;
}
