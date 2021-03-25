package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;

import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.entity.TransactionMode;

public interface IOrderService {
	Order addOrder(Order order);
	
	Order deleteOrder(int bookingId);
	
	Order viewOrder(int bookingId);
	
	List<Order> viewAllOrders();
	
	Order patchOrder(Order order);

	List<Order> sortOrderLowToHigh();

	List<Order> sortOrderHighToLow();

	List<Order> filterByTransactionMode(TransactionMode transactionMode);

	
}