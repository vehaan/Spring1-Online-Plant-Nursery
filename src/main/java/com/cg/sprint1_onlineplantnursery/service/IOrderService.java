package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;

import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.exception.OrderIdNotFoundException;

public interface IOrderService {
	Order addOrder(Order order);
	
	Order updateOrder(Order order);
	
	Order deleteOrder(int bookingId);
	
	Order viewOrder(int bookingId);
	
	List<Order> viewAllOrders();
	
	Order patchOrder(Order order);
}