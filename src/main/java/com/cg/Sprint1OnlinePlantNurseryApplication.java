package com.cg;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
//@EnableSwagger2
public class Sprint1OnlinePlantNurseryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprint1OnlinePlantNurseryApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.cg"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Online Plant Nursery: Plant", 
	      "API for Plant module", 
	      "1.0", 
	      "https://www.google.com/", 
	      new Contact("Anuj Gadge", "https://www.google.com/", "anujgadge22@gmail.com"), 
	      "License of API", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	}
	
	//localhost:9898/onlinenursery/swagger-ui/
}
