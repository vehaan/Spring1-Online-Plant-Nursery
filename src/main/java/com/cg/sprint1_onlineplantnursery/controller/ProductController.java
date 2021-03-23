package com.cg.sprint1_onlineplantnursery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint1_onlineplantnursery.entity.Plant;
import com.cg.sprint1_onlineplantnursery.entity.Planter;
import com.cg.sprint1_onlineplantnursery.entity.Product;
import com.cg.sprint1_onlineplantnursery.service.IPlantService;
import com.cg.sprint1_onlineplantnursery.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	IProductService productService;	
	
	@PostMapping("/products/planters")
	public ResponseEntity<Product> addProduct(@RequestBody Planter planter) {
		Product product =  productService.addProduct(planter);
			return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	@PostMapping("/products/plants")
	public ResponseEntity<Product> addProduct(@RequestBody Plant plant) {
		Product product =  productService.addProduct(plant);
			return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> product =  productService.getProducts();
			return new ResponseEntity<List<Product>>(product,HttpStatus.OK);
	}
	
	

}
