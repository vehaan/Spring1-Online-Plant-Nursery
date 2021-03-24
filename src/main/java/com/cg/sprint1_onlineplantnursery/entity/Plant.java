package com.cg.sprint1_onlineplantnursery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;

//import com.cg.sprint1_onlineplantnursery.util.plant.BloomTime;
//import com.cg.sprint1_onlineplantnursery.util.plant.Difficulty;

@Entity
public class Plant{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ApiModelProperty(notes = "Provide in inches")							//changed
	private Integer height;
	private String spread;
	
	@Enumerated(EnumType.STRING)
	private BloomTime bloomTime;

	private String medicinalOrCulinaryUse;
	@Enumerated(EnumType.STRING)
	private Difficulty difficultyLevel;
	
	private String temperature;
	private String typeOfPlant;
	@Column(unique = true)
	@NotBlank(message = "Name is necessary")
	private String commonName;  //NotEmpty

	private String description;
	
	@Positive(message = "Stock should be specified and should be a positive number")
	private Integer stock; //NotEmpty
	@Positive(message = "cost should be specified and should be a positive number")
	private double cost;  //Positive and NotEmtpy


	

	public Plant() {
		// TODO Auto-generated constructor stub
	}





	public Plant(Integer id, Integer height, String spread, BloomTime bloomTime, String medicinalOrCulinaryUse,
			Difficulty difficultyLevel, String temperature, String typeOfPlant,
			@NotBlank(message = "Name is necessary") String commonName, String description,
			@Positive(message = "Stock should be specified and should be a positive number") Integer stock,
			@Positive(message = "cost should be specified and should be a positive number") double cost) {
		super();
		this.id = id;
		this.height = height;
		this.spread = spread;
		this.bloomTime = bloomTime;
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.typeOfPlant = typeOfPlant;
		this.commonName = commonName;
		this.description = description;
		this.stock = stock;
		this.cost = cost;
	}



	public Plant(Integer height, String spread, BloomTime bloomTime, String medicinalOrCulinaryUse,
			Difficulty difficultyLevel, String temperature, String typeOfPlant,
			@NotBlank(message = "Name is necessary") String commonName, String description,
			@Positive(message = "Stock should be specified and should be a positive number") Integer stock,
			@Positive(message = "cost should be specified and should be a positive number") double cost) {
		super();
		this.height = height;
		this.spread = spread;
		this.bloomTime = bloomTime;
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.typeOfPlant = typeOfPlant;
		this.commonName = commonName;
		this.description = description;
		this.stock = stock;
		this.cost = cost;
	}



	public Difficulty getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(Difficulty difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	

	public enum Difficulty{
		EASY, MEDIUM, HARD;
	}

	public enum BloomTime {
		WINTER, SUMMER, MONSOON, AUTUMN;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getSpread() {
		return spread;
	}

	public void setSpread(String spread) {
		this.spread = spread;
	}




	public BloomTime getBloomTime() {
		return bloomTime;
	}

	public void setBloomTime(BloomTime bloomTime) {
		this.bloomTime = bloomTime;
	}

	public String getMedicinalOrCulinaryUse() {
		return medicinalOrCulinaryUse;
	}


	public void setMedicinalOrCulinaryUse(String medicinalOrCulinaryUse) {
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
	}


	public String getTemparature() {
		return temperature;
	}




	public void setTemparature(String temperature) {
		this.temperature = temperature;
	}




	public String getTypeOfPlant() {
		return typeOfPlant;
	}




	public void setTypeOfPlant(String typeOfPlant) {
		this.typeOfPlant = typeOfPlant;
	}




	public String getCommonName() {
		return commonName;
	}




	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Integer getStock() {
		return stock;
	}




	public void setStock(Integer stock) {
		this.stock = stock;
	}




	public double getCost() {
		return cost;
	}




	public void setCost(double cost) {
		this.cost = cost;
	}




	@Override
	public String toString() {
		return "Plant [id=" + id + ", height=" + height + ", spread=" + spread + ", bloomTime=" + bloomTime
				+ ", medicinalOrCulinaryUse=" + medicinalOrCulinaryUse + ", difficultyLevel=" + difficultyLevel
				+ ", temperature=" + temperature + ", typeOfPlant=" + typeOfPlant + ", commonName=" + commonName
				+ ", description=" + description + ", stock=" + stock + ", cost=" + cost + "]";
	}




	
	
}