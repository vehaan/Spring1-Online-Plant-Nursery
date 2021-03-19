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
import org.springframework.web.bind.annotation.RestController;
import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.exception.SeedIdNotFoundException;
import com.cg.sprint1_onlineplantnursery.service.ISeedService;

@RestController
public class SeedController extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ISeedService seedService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    super.configure(http);
	    http.csrf().disable();
	}
	 
	@PostMapping("/seeds")
	public ResponseEntity<Seed> addSeed(@Valid @RequestBody Seed seed){
		seedService.addSeed(seed);
		return new ResponseEntity<Seed>(seed,HttpStatus.CREATED);
	}
	
	@PutMapping("/seeds")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed) throws SeedIdNotFoundException{
//		if(seedService.getSeed(seed.getId()).isPresent())
//		{
			seedService.updateSeed(seed);
			return new ResponseEntity<Seed>(seed,HttpStatus.CREATED);
//		}
//		else 
//		{
//			throw new SeedIdNotFoundException("Invalid Seed ID...Cannot update");
//		}
	}
	
	@DeleteMapping("/seeds")
	public ResponseEntity<Seed> deleteSeed(@RequestBody Seed seed) throws SeedIdNotFoundException{
//		if(seedService.getSeed(seed.getId()).isPresent())
//		{
			Seed seedDeleted = seedService.deleteSeed(seed);
			return new ResponseEntity<Seed> (seedDeleted,HttpStatus.ACCEPTED);
//		}
//		else {
//			throw new SeedIdNotFoundException("Cannot be deleted...(Invalid seed Id)");
//		}	
	}
		
	@GetMapping("/seeds/id/{id}")
	public ResponseEntity<Seed> getSeed(@PathVariable int id) throws SeedIdNotFoundException{
//		if(seedService.getSeed(id).isPresent()) {
			Seed seedRes = seedService.getSeed(id);
			return new ResponseEntity<Seed>(seedRes,HttpStatus.OK);
//		}
//		else {
//			throw new SeedIdNotFoundException("Invalid Seed ID...Cannot fetch entities ");
//		}
		
	}
	
	@GetMapping("/seeds/commonName/{commonName}")
	public ResponseEntity<Seed> getSeed(@PathVariable String commonName){
			Seed seedRes = seedService.getSeed(commonName);
			return new ResponseEntity<Seed>(seedRes,HttpStatus.ACCEPTED);	
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
}
