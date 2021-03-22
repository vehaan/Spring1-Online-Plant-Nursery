package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint1_onlineplantnursery.entity.Order;
import com.cg.sprint1_onlineplantnursery.entity.Plant;
import com.cg.sprint1_onlineplantnursery.entity.Planter;
import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.exception.OrderIdNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.IOrderRepository;
import com.cg.sprint1_onlineplantnursery.repository.IPlantRepository;

@Service
public class IOrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository orderRepository;
	
	
	  @Autowired IPlantService plantService;
	  
	  @Autowired IPlantRepository plantRepository;
	  
	  @Autowired IPlanterService planterService;
	  
	  @Autowired ISeedService seedService;
	 
	//public Order selectOrder(Order order) {
		
	//}
	
	@Override
	public Order addOrder(Order order) {
		
		Map<Integer, Integer> pmap = order.getPlants();
		
		for(Map.Entry<Integer, Integer> entry : pmap.entrySet()) {
			plantService.deletePlant(plantRepository.viewPlant(entry.getKey()));
		}
		 
		
		//Plant p = order.getPlants().entrySet()
		
		
		/*
		 * Map<Planter, Integer> pr = order.getPlanters(); Integer prquantity =
		 * pr.entrySet().stream().findFirst().get().getValue(); //Ordered quantity of
		 * planters Integer prstock =
		 * pr.entrySet().stream().findFirst().get().getKey().getPlanterStock();
		 * //Updating the quantity of planters prstock -= prquantity;
		 * pr.entrySet().stream().findFirst().get().getKey().setPlanterStock(prstock);
		 * System.out.println("Updated planter stock");
		 */
		
		/*
		 * Map<Plant, Integer> p = order.getPlants(); Integer pquantity =
		 * p.entrySet().stream().findFirst().get().getValue(); //Ordered quantity of
		 * plants Integer pstock =
		 * p.entrySet().stream().findFirst().get().getKey().getPlantsStock(); //Updating
		 * the quantity of plants pstock -= pquantity;
		 * p.entrySet().stream().findFirst().get().getKey().setPlantsStock(pstock);
		 * System.out.println("Updated plant stock");
		 */

		/*
		 * Map<Seed, Integer> s = order.getSeeds(); Integer squantity =
		 * s.entrySet().stream().findFirst().get().getValue(); //Ordered quantity of
		 * seeds Integer sstock =
		 * s.entrySet().stream().findFirst().get().getKey().getSeedsStock(); //Updating
		 * the quantity of seeds sstock -= squantity;
		 * s.entrySet().stream().findFirst().get().getKey().setSeedsStock(sstock);
		 * System.out.println("Updated seed stock");
		 */
		return orderRepository.save(order);
	}
	 // Stock +, - is to be included
	@Override
	public Order updateOrder(Order order) {
		Optional<Order> orderToBeUpdated = orderRepository.findById(order.getBookingId());
		if(orderToBeUpdated.isPresent())
			orderRepository.save(order);
		return orderToBeUpdated.orElseThrow(()->new OrderIdNotFoundException("Order with id: "+order.getBookingId()+" is not found"));
	}
	
	@Override
	public Order updateOrder(int bookingId) {
		Order orderToBePatched = orderRepository.findById(bookingId).get();
		Optional<Order> ord = orderRepository.findById(bookingId);
			if(ord.isPresent())
				orderRepository.save(orderToBePatched);
		return ord.orElseThrow(()->new OrderIdNotFoundException("Order with id: "+bookingId+" is not found"));
	}
	
	@Override
	public Order deleteOrder(int bookingId) {
		Optional<Order> orderToBeRemoved = orderRepository.findById(bookingId);
		if(orderToBeRemoved.isPresent())
			orderRepository.deleteById(bookingId);
		return orderToBeRemoved.orElseThrow(()-> new OrderIdNotFoundException("Order with id: "+bookingId+" is not found"));
	}

	@Override
	public Order viewOrder(int bookingId){
		Optional<Order> orderOptional = orderRepository.findById(bookingId);
		return orderOptional.orElseThrow(()-> new OrderIdNotFoundException("Order with id: "+bookingId+" is not found"));
	}

	@Override
	public List<Order> viewAllOrders() {
		return orderRepository.findAll();
	}
	
}
