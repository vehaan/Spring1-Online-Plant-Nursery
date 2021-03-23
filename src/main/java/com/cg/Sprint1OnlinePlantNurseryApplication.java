package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Sprint1OnlinePlantNurseryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprint1OnlinePlantNurseryApplication.class, args);
		System.out.println("working");
		
		}
}