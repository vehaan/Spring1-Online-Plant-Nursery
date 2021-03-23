package com.cg.sprint1_onlineplantnursery.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Plant {
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer height;
	private String spread;
	@Column(unique = true)
	@NotBlank(message = "Name is necessary")
	private String commonName;  //NotEmpty
	private String bloomTime;
	private String medicinalOrCulinaryUse;
	private String difficultyLevel;
	private String temparature;
	private String typeOfPlant;
	private String description;
	@NotNull
	@Positive(message = "Stock should be specified and should be a positive number")
	private Integer stock; //NotEmpty
	@Positive(message = "Plant cost should be specified and should be a positive number")
	private double cost;  //Positive and NotEmtpy
	
	

	public Plant() {
		// TODO Auto-generated constructor stub
	}



	public Plant(Integer id, Integer height, String spread, @NotBlank(message = "Name is necessary") String commonName,
			String bloomTime, String medicinalOrCulinaryUse, String difficultyLevel, String temparature,
			String typeOfPlant, String description,
			@NotNull @Positive(message = "Stock should be specified and should be a positive number") Integer stock,
			@Positive(message = "Plant cost should be specified and should be a positive number") double cost) {
		super();
		this.id = id;
		this.height = height;
		this.spread = spread;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
		this.difficultyLevel = difficultyLevel;
		this.temparature = temparature;
		this.typeOfPlant = typeOfPlant;
		this.description = description;
		this.stock = stock;
		this.cost = cost;
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



	public String getCommonName() {
		return commonName;
	}



	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}



	public String getBloomTime() {
		return bloomTime;
	}



	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}



	public String getMedicinalOrCulinaryUse() {
		return medicinalOrCulinaryUse;
	}



	public void setMedicinalOrCulinaryUse(String medicinalOrCulinaryUse) {
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
	}



	public String getDifficultyLevel() {
		return difficultyLevel;
	}



	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}



	public String getTemparature() {
		return temparature;
	}



	public void setTemparature(String temparature) {
		this.temparature = temparature;
	}



	public String getTypeOfPlant() {
		return typeOfPlant;
	}



	public void setTypeOfPlant(String typeOfPlant) {
		this.typeOfPlant = typeOfPlant;
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
		return "Plant [id=" + id + ", height=" + height + ", spread=" + spread + ", commonName=" + commonName
				+ ", bloomTime=" + bloomTime + ", medicinalOrCulinaryUse=" + medicinalOrCulinaryUse
				+ ", difficultyLevel=" + difficultyLevel + ", temparature=" + temparature + ", typeOfPlant="
				+ typeOfPlant + ", description=" + description + ", Stock=" + stock + ", Cost=" + cost + "]";
	}

	
	
}