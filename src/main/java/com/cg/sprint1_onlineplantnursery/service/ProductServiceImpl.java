package com.cg.sprint1_onlineplantnursery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint1_onlineplantnursery.entity.Plant;
import com.cg.sprint1_onlineplantnursery.entity.Planter;
import com.cg.sprint1_onlineplantnursery.entity.Product;
import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.exception.ResourceNotFoundException;
import com.cg.sprint1_onlineplantnursery.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IPlanterService planterService;
	
	@Autowired
	private IPlantService plantService;
	
	@Autowired
	private ISeedService seedService;

	@Override
	public Product addProduct(Product product) {
		if (product instanceof Planter) {
			return planterService.addPlanter((Planter)product);
		}else if(product instanceof Seed) {
			return seedService.addSeed((Seed)product);
		}
		return plantService.addNewPlant((Plant)product);
	}
	

	@Override
	public List<Product> getProducts() {
		List<Product> list = new ArrayList<Product>();
		List<Planter> planterList = planterService.getPlanters();
		List<Plant> plantList = plantService.getAllPlants();
		List<Seed> seedList = seedService.getSeeds();
		for(Planter p:planterList) {
			list.add((Product)p);
		}
		for(Plant p:plantList) {
			list.add((Product)p);
		}
		for(Seed s:seedList) {
			list.add((Product)s);
		}
		return list;
	}

	@Override
	public Product updateProduct(Product product) {
		if (product instanceof Planter) {
			return planterService.updatePlanter((Planter)product);
		}else if(product instanceof Seed) {
			return seedService.updateSeed((Seed)product);
		}
		return plantService.updatePlant((Plant)product, product.getId());
	}

	@Override
	public Product deleteProduct(Product product) {
		if (product instanceof Planter) {
			return planterService.deletePlanter((Planter)product);
		}else if(product instanceof Seed) {
			return seedService.deleteSeed((Seed)product);
		}
		return plantService.deletePlant((Plant)product);
	}

	@Override
	public Product getProductById(int productId) {
		List<Product> products = getProducts().stream().filter((p) -> p.getId() == productId).collect(Collectors.toList());
		if (products.size() == 0)
			throw new ResourceNotFoundException("No product found with the given id");
		return products.get(0);
	}

}