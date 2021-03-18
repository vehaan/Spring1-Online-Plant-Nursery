package com.cg.sprint1_onlineplantnursery.entity;

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
	private Integer Id;
	private Integer Height;
	private String Spread;
	@NotBlank(message = "Name is necessary")
	private String commonName;  //NotEmpty
	private String bloomTime;
	private String medicinalOrCulinaryUse;
	private String difficultyLevel;
	private String temparature;
	private String typeOfPlant;
	private String Description;
	@NotNull
	@Positive(message = "Stock should be specified and should be a positive number")
	private Integer Stock; //NotEmpty
	@Positive(message = "Plant cost should be specified and should be a positive number")
	private double Cost;  //Positive and NotEmtpy
	
	

	public Plant() {
		// TODO Auto-generated constructor stub
	}



	public Plant(Integer id, Integer height, String spread, @NotBlank(message = "Name is necessary") String commonName,
			String bloomTime, String medicinalOrCulinaryUse, String difficultyLevel, String temparature,
			String typeOfPlant, String description,
			@NotNull @Positive(message = "Stock should be specified and should be a positive number") Integer stock,
			@Positive(message = "Plant cost should be specified and should be a positive number") double cost) {
		super();
		Id = id;
		Height = height;
		Spread = spread;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
		this.difficultyLevel = difficultyLevel;
		this.temparature = temparature;
		this.typeOfPlant = typeOfPlant;
		Description = description;
		Stock = stock;
		Cost = cost;
	}



	public Integer getId() {
		return Id;
	}



	public void setId(Integer id) {
		Id = id;
	}



	public Integer getHeight() {
		return Height;
	}



	public void setHeight(Integer height) {
		Height = height;
	}



	public String getSpread() {
		return Spread;
	}



	public void setSpread(String spread) {
		Spread = spread;
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
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	public Integer getStock() {
		return Stock;
	}



	public void setStock(Integer stock) {
		Stock = stock;
	}



	public double getCost() {
		return Cost;
	}



	public void setCost(double cost) {
		Cost = cost;
	}



	@Override
	public String toString() {
		return "Plant [Id=" + Id + ", Height=" + Height + ", Spread=" + Spread + ", commonName=" + commonName
				+ ", bloomTime=" + bloomTime + ", medicinalOrCulinaryUse=" + medicinalOrCulinaryUse
				+ ", difficultyLevel=" + difficultyLevel + ", temparature=" + temparature + ", typeOfPlant="
				+ typeOfPlant + ", Description=" + Description + ", Stock=" + Stock + ", Cost=" + Cost + "]";
	}

	

	
	
}