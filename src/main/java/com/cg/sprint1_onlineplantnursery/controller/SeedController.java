package com.cg.sprint1_onlineplantnursery.controller;

import java.util.List;
import java.util.Optional;
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

import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.service.ISeedService;
import com.cg.sprint1_onlineplantnursery.service.ISeedServiceImpl;

@RestController
@RequestMapping("/rest")
public class SeedController extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ISeedService seedService;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	       super.configure(http);
	       http.csrf().disable();
	    }
	
	@PostMapping("/seeds")
	public ResponseEntity<Seed> addSeed(@RequestBody Seed seed){
		seedService.addSeed(seed);
		return new ResponseEntity<Seed>(seed,HttpStatus.CREATED);
	}
	
	@PutMapping("/seeds")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed){
		seedService.updateSeed(seed);
		return new ResponseEntity<Seed>(seed,HttpStatus.OK);
	}
	
	@DeleteMapping("/seeds")
	public ResponseEntity<Seed> deleteSeed(@RequestBody Seed seed){
		Seed seedDeleted = seedService.deleteSeed(seed);
		return new ResponseEntity<Seed>(seedDeleted,HttpStatus.OK);
	}
	
	@GetMapping("/seeds/id/{id}")
	public ResponseEntity<Optional<Seed>> viewSeed(@PathVariable int id){
		Optional<Seed> seedRes = seedService.viewSeed(id);
		return new ResponseEntity<Optional<Seed>>(seedRes,HttpStatus.OK);
	}
	
	@GetMapping("/seeds/commonName/{commonName}")
	public ResponseEntity<Seed> viewSeed(@PathVariable String commonName){
		Seed seedRes = seedService.viewSeed(commonName);
		return new ResponseEntity<Seed>(seedRes,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/seeds")
	public ResponseEntity<List<Seed>> viewAllSeed(){
		List<Seed> seedList = seedService.viewAllSeeds();
		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/seeds/typeOfSeed/{typeOfSeed}")
	public ResponseEntity<List<Seed>> viewAllSeed(@PathVariable String typeOfSeed){
		List<Seed> seedList = seedService.viewAllSeeds(typeOfSeed);
		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.ACCEPTED);
	}
}
