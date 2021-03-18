package com.cg.sprint1_onlineplantnursery.controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint1_onlineplantnursery.entity.Plant;
import com.cg.sprint1_onlineplantnursery.service.IPlantServiceImpl;

@RestController
@RequestMapping("/rest")
public class PlantController extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.csrf().disable();
	}

	@Autowired
	private IPlantServiceImpl plantService;

	@PostMapping("/plants")
	public ResponseEntity<Plant> addPlant(@Valid @RequestBody Plant plant) {
		plantService.addPlant(plant);
		return new ResponseEntity<Plant>(plant, HttpStatus.CREATED);
	}

	@PutMapping("/plants")
	public ResponseEntity<Plant> updatePlant(@Valid @RequestBody Plant plant) throws NullPointerException {
		if (plantService.viewPlant(plant.getId()).isPresent()) {
			plantService.updatePlant(plant);
			return new ResponseEntity<Plant>(plant, HttpStatus.CREATED);
		} else {
			throw new NullPointerException("This plant does not exists!");
		}
	}

	@DeleteMapping("/plants")
	public ResponseEntity<Plant> deletePlant(@RequestBody Plant plant) throws NullPointerException {

		if (plantService.viewPlant(plant.getId()).isPresent()) {

			if (plant.getStock() == 1) {
				plantService.deletePlant(plant);
			} else {
				int stock = plant.getStock() - 1;
				plant.setStock(stock);
				plantService.updatePlant(plant);
				
			}

			return new ResponseEntity<Plant>(plant, HttpStatus.OK);
		} else {
			throw new NullPointerException("This plant does not exists!");
		}

	}

	@GetMapping("/plants/id/{id}")
	public ResponseEntity<Optional<Plant>> viewPlant(@PathVariable Integer id) {
		Optional<Plant> obj = plantService.viewPlant(id);
		return new ResponseEntity<Optional<Plant>>(obj, HttpStatus.OK);
	}

	@GetMapping("/plants/commonName/{commonName}")
	public ResponseEntity<Plant> viewPlant(@PathVariable String commonName) {
		Plant plant = plantService.viewPlant(commonName);
		return new ResponseEntity<Plant>(plant, HttpStatus.OK);
	}

	@GetMapping("/plants")
	public ResponseEntity<List<Plant>> viewAllPlants() {
		List<Plant> plantList = plantService.viewAllPlants();
		return new ResponseEntity<List<Plant>>(plantList, HttpStatus.OK);
	}

	@GetMapping("/plants/typeOfPlant/{typeOfPlant}")
	public ResponseEntity<List<Plant>> viewAllPlants(@PathVariable String typeOfPlant) {
		List<Plant> plantList = plantService.viewAllPlants(typeOfPlant);
		return new ResponseEntity<List<Plant>>(plantList, HttpStatus.OK);
	}

}
