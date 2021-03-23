package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.sprint1_onlineplantnursery.entity.Product;

@Service
public interface IProductService {
	
	Product addProduct(Product product);

	Product updateProduct(Product product);

	Product deleteProduct(Product product);

	Product getProductById(int productId);

	List<Product> getProducts();

}
