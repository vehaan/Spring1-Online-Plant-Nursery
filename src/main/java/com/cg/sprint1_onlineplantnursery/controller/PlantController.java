package com.cg.sprint1_onlineplantnursery.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint1_onlineplantnursery.entity.Plant;
import com.cg.sprint1_onlineplantnursery.exception.PlantIdNotFoundException;
import com.cg.sprint1_onlineplantnursery.service.IPlantService;

@RestController
@RequestMapping("/plant")
public class PlantController extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.csrf().disable();
	}
	
	Logger logger = LoggerFactory.getLogger(PlantController.class);

	@Autowired
	private IPlantService plantService;

	@PostMapping("/addNewPlant")
	public ResponseEntity<Plant> addNewPlant(@Valid @RequestBody Plant plant) {
		plantService.addNewPlant(plant);
		return new ResponseEntity<Plant>(plant, HttpStatus.CREATED);
	}
	
	@PostMapping("/addPlantStock/{commonName}/{stock}")
	public ResponseEntity<Plant> addPlantStock(@PathVariable String commonName, @PathVariable int stock){
		logger.trace("adding "+stock+" plants to the stock");
		return new ResponseEntity<Plant>(plantService.addPlantStock(commonName,stock), HttpStatus.CREATED);
	}
	

	@PutMapping("update/{id}")
	public ResponseEntity<Plant> updatePlant(@Valid @RequestBody Plant plant, @PathVariable int id) {
		 logger.trace("updating the whole plant having id "+ id);  
		plantService.updatePlant(plant, id);
		return new ResponseEntity<Plant>(plant, HttpStatus.CREATED);
	}
	
	@PatchMapping("/partialUpdate/{id}")
	public ResponseEntity<Plant> partialUpdate(@RequestBody Map<Object, Object> fields, @PathVariable("id") int id) {
	  logger.trace("updating partially using partialUpadate");    
	  return new ResponseEntity<Plant>(plantService.partialUpdatePlant(fields, id), HttpStatus.OK);
	}
	
	//@Transactional
	@DeleteMapping()
	public ResponseEntity<Plant> deletePlant(@RequestBody Plant plant) throws PlantIdNotFoundException{
		logger.trace("deleting the whole plant");
		plantService.deletePlant(plant);
		return new ResponseEntity<Plant>(plant, HttpStatus.OK);
	}
	
	@DeleteMapping("decreaseStock/{commonName}/{stock}")       
	public ResponseEntity<Plant> decreaseStock(@PathVariable String commonName, @PathVariable int stock){
		logger.trace("decreasing stock of plant "+commonName+" by quantity "+ stock);
		return new ResponseEntity<Plant>(plantService.decreaseStock(commonName,stock), HttpStatus.OK);
	}

	@GetMapping("/viewPlant/{id}")
	public ResponseEntity<Plant> viewPlant(@PathVariable Integer id) {
		logger.trace("fetching the plant with id "+ id);
		return new ResponseEntity<Plant>(plantService.getPlant(id), HttpStatus.OK);
	}

	@GetMapping("/viewPlant/commonName/{commonName}")
	public ResponseEntity<Plant> viewPlant(@PathVariable String commonName){
		logger.trace("fetching "+commonName+" plant");
		return new ResponseEntity<Plant>(plantService.getPlant(commonName), HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<Plant>> viewAllPlants() {
		logger.trace("fetching all the plants");
		return new ResponseEntity<List<Plant>>(plantService.getAllPlants(), HttpStatus.OK);
	}

	@GetMapping("/typeOfPlant/{typeOfPlant}")
	public ResponseEntity<List<Plant>> viewAllPlants(@PathVariable String typeOfPlant) {
		logger.trace("searching the plants of type "+typeOfPlant);
		return new ResponseEntity<List<Plant>>(plantService.getAllPlants(typeOfPlant), HttpStatus.OK);
	}

}
