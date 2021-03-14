package com.cg.sprint1_onlineplantnursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint1_onlineplantnursery.entity.Planter;
import com.cg.sprint1_onlineplantnursery.service.IPlanterServiceImpl;

@RestController
@RequestMapping("/rest")
public class IPlanterController extends WebSecurityConfigurerAdapter {

	@Autowired
	private IPlanterServiceImpl planterService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
       super.configure(http);
       http.csrf().disable();
    }
	
	@PostMapping("/planters")
	public Planter addPlanter(@RequestBody Planter planter) {
		return planterService.addPlanter(planter);
	}
	
	@GetMapping("/planters")
	public List<Planter> getAllPlanters(){
		return planterService.viewAllPlanters();
	}
	
	@GetMapping("/planters/{id}")
	public Planter getPlanterById(@PathVariable int id){
		return planterService.viewPlanter(id);
	}
	
	@PutMapping("/planter/{id}")
	public Planter update(@RequestBody Planter planter) {
		return planterService.updatePlanter(planter);
	}
	
	@DeleteMapping("/planter")
	public Planter delete(@RequestBody Planter planter) {
		return planterService.deletePlanter(planter);
	}
	
}
