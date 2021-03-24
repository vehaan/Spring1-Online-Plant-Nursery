package com.cg.sprint1_onlineplantnursery.controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.entity.Type;
import com.cg.sprint1_onlineplantnursery.entity.Difficulty;
import com.cg.sprint1_onlineplantnursery.service.ISeedService;

@RestController
//@RequestMapping("/products")
public class SeedController{
	
	@Autowired
	private ISeedService seedService;
	 
	@PostMapping("/seeds")
	public ResponseEntity<Seed> addSeed(@Valid @RequestBody Seed seed){
		seedService.addSeed(seed);
		return new ResponseEntity<Seed>(seed,HttpStatus.CREATED);
	}
	
	@PutMapping("/seeds")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed) {
		seedService.updateSeed(seed);
		return new ResponseEntity<Seed>(seed,HttpStatus.CREATED);
	}
	
	@PutMapping("/seeds/{commonName}/{stock}")
	public ResponseEntity<Seed> addStock(@PathVariable String commonName,@PathVariable int stock){
		return new ResponseEntity<Seed>(seedService.addStock(commonName, stock),HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/seeds/id/{id}")
	public ResponseEntity<Seed> updateSeed(@PathVariable int id, @RequestBody Map<Object,Object> fields){
		return new ResponseEntity<Seed>(seedService.updateSeed(id,fields),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/seeds")
	public ResponseEntity<Seed> deleteSeed(@RequestBody Seed seed){
		return new ResponseEntity<Seed> (seedService.deleteSeed(seed),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/seeds/name/{commonName}/{stock}")
	public ResponseEntity<Seed> buySeeds(@PathVariable String commonName,@PathVariable int stock){
		return new ResponseEntity<Seed>(seedService.buySeeds(commonName, stock),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/seeds/id/{id}/{stock}")
	public ResponseEntity<Seed> buySeeds(@PathVariable int id,@PathVariable int stock){
		return new ResponseEntity<Seed>(seedService.buySeeds(id, stock),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/seeds/id/{id}")
	public ResponseEntity<Seed> deleteSeedById(@PathVariable int id){
		return new ResponseEntity<Seed>(seedService.deleteSeedById(id),HttpStatus.OK);
	}
		
	@GetMapping("/seeds/id/{id}")
	public ResponseEntity<Seed> getSeed(@PathVariable int id){
		return new ResponseEntity<Seed>(seedService.getSeed(id),HttpStatus.OK);	
	}
	
	@GetMapping("/seeds/commonName/{commonName}")
	public ResponseEntity<Seed> getSeed(@PathVariable String commonName) {
		return new ResponseEntity<Seed>(seedService.getSeed(commonName),HttpStatus.ACCEPTED);	
	}
	
	@GetMapping("/seeds")
	public ResponseEntity<List<Seed>> getSeeds(){
		List<Seed> seedList = seedService.getSeeds();
		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/seeds/typeOfSeed/{typeOfSeed}")
	public ResponseEntity<List<Seed>> getSeeds(@PathVariable String typeOfSeed){
		List<Seed> seedList = seedService.getSeeds(typeOfSeed);
		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/seeds/costLowToHigh")
	public ResponseEntity<List<Seed>> costLowToHigh(){
		List<Seed> seeds = seedService.costLowToHigh();
		return new ResponseEntity<List<Seed>>(seeds,HttpStatus.OK);
	}
		
	@GetMapping("/seeds/costHighToLow")
	public ResponseEntity<List<Seed>> costHighToLow(){
		List<Seed> seeds = seedService.costHighToLow();
		return new ResponseEntity<List<Seed>>(seeds,HttpStatus.OK);
	}
	
	@GetMapping("/seeds/filterbytype/{type}")
	public ResponseEntity<List<Seed>> filterByType(@PathVariable Type type){
		List<Seed> seeds = seedService.filterSeedByType(type);
		return new ResponseEntity<List<Seed>>(seeds,HttpStatus.OK);
	}
	
	@GetMapping("/seeds/filterbydifficulty/{difficulty}")
	public ResponseEntity<List<Seed>> filterByDifficulty(@PathVariable Difficulty difficulty){
		List<Seed> seeds = seedService.filterSeedByDifficulty(difficulty);
		return new ResponseEntity<List<Seed>>(seeds,HttpStatus.OK);
	}
}