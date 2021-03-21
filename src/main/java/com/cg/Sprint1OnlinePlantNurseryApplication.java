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
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
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
	      "Online Plant Nursery: Planter", 
	      "API for Planter module", 
	      "1.0", 
	      "https://www.google.com/", 
	      new Contact("Vehaan Singh Kundra", "https://www.google.com/", "vehaanskundra@gmail.com"), 
	      "License of API", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	}
	//http://localhost:9191/OnlinePlantNursery/swagger-ui/index.html

}
