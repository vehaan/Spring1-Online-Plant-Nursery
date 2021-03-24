package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.sprint1_onlineplantnursery.entity.Planter;
import com.cg.sprint1_onlineplantnursery.entity.Product;
import com.cg.sprint1_onlineplantnursery.entity.Type;

@Service
public interface IProductService {
	
	Product addProduct(Product product);

	Product updateProduct(Product product);

	Product deleteProduct(Product product);

	Product getProductById(int productId);

	List<Product> getProducts();

	List<Product> costLowToHigh();

	List<Product> costHighToLow();

	List<Product> filterByType(Type type);

}
