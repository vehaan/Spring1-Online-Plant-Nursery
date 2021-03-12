package com.cg.sprint1_onlineplantnursery.repository;

import java.util.List;

import com.cg.sprint1_onlineplantnursery.entity.Order;

public interface IOrderRepository {
	Order addOrder(Order order);
	Order updateOrder(Order order);
	Order deleteOrder(int orderId);
	Order viewOrder(int  orderId);
	List<Order> viewAllOrders();

}
