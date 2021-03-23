package com.cg.sprint1_onlineplantnursery.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Seed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@NotBlank(message = "Name is required")
	@Column(unique = true)
	private String commonName;
	
	@Enumerated(EnumType.STRING)
	private BloomTime bloomTime;
	private String watering;
	
	@Enumerated(EnumType.STRING)
	private Difficulty difficultyLevel;
	private String temperature;
	private String type;
	private String description;
	
	@NotNull
	@Positive(message = "A positive value of stock required")
	private Integer stock;

	@NotNull
	@Positive(message = "A positive value of cost required")
	private double cost;

	@NotNull
	@Positive(message = "A positive value of seeds per packet required")
	private Integer seedsPerPacket;
	
	@Embedded
	private AddOns addOns;
	
	public AddOns getAddOns() {
		return addOns;
	}
	public void setAddOns(AddOns addOns) {
		this.addOns = addOns;
	}

	public Seed(@NotBlank(message = "Name is required") String commonName, BloomTime bloomTime, String watering,
			Difficulty difficultyLevel, String temperature, String type, String description,
			@NotNull @Positive(message = "A positive value of stock required") Integer stock,
			@NotNull @Positive(message = "A positive value of cost required") double cost,
			@NotNull @Positive(message = "A positive value of seeds per packet required") Integer seedsPerPacket,
			AddOns addOns) {
		super();
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.type = type;
		this.description = description;
		this.stock = stock;
		this.cost = cost;
		this.seedsPerPacket = seedsPerPacket;
		this.addOns = addOns;
	}
	public Seed(Integer id, @NotBlank(message = "Name is required") String commonName, BloomTime bloomTime,
			String watering, Difficulty difficultyLevel, String temperature, String type, String description,
			@NotNull @Positive(message = "A positive value of stock required") Integer stock,
			@NotNull @Positive(message = "A positive value of cost required") double cost,
			@NotNull @Positive(message = "A positive value of seeds per packet required") Integer seedsPerPacket,
			AddOns addOns) {
		super();
		this.id = id;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.type = type;
		this.description = description;
		this.stock = stock;
		this.cost = cost;
		this.seedsPerPacket = seedsPerPacket;
		this.addOns = addOns;
	}



	public enum Difficulty {
	    EASY, MEDIUM, HARD;
	}
	
	public enum BloomTime {
	    WINTER, SUMMER, AUTUMN, MONSOON;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public BloomTime getBloomTime() {
		return bloomTime;
	}
	public void setBloomTime(BloomTime bloomTime) {
		this.bloomTime = bloomTime;
	}

	public String getWatering() {
		return watering;
	}
	public void setWatering(String watering) {
		this.watering = watering;
	}

	public Difficulty getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(Difficulty difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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

	public Integer getSeedsPerPacket() {
		return seedsPerPacket;
	}
	public void setSeedsPerPacket(Integer seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}
	
	public Seed(Integer id, @NotBlank(message = "Name is required") String commonName, BloomTime bloomTime,
			String watering, Difficulty difficultyLevel, String temperature, String type, String description,
			@NotNull @Positive(message = "A positive value of stock required") Integer stock,
			@NotNull @Positive(message = "A positive value of cost required") double cost,
			@NotNull @Positive(message = "A positive value of seeds per packet required") Integer seedsPerPacket) {
		super();
		this.id = id;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.type = type;
		this.description = description;
		this.stock = stock;
		this.cost = cost;
		this.seedsPerPacket = seedsPerPacket;
	}
	

	
	public Seed(@NotBlank(message = "Name is required") String commonName, BloomTime bloomTime, String watering,
			Difficulty difficultyLevel, String temperature, String type, String description,
			@NotNull @Positive(message = "A positive value of stock required") Integer stock,
			@NotNull @Positive(message = "A positive value of cost required") double cost,
			@NotNull @Positive(message = "A positive value of seeds per packet required") Integer seedsPerPacket) {
		super();
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.type = type;
		this.description = description;
		this.stock = stock;
		this.cost = cost;
		this.seedsPerPacket = seedsPerPacket;
	}
	
	public Seed() {
		super();
	}
	
	@Override
	public String toString() {
		return "Seed [id=" + id + ", commonName=" + commonName + ", bloomTime=" + bloomTime + ", watering=" + watering
				+ ", difficultyLevel=" + difficultyLevel + ", temperature=" + temperature + ", type=" + type
				+ ", description=" + description + ", stock=" + stock + ", cost=" + cost + ", seedsPerPacket="
				+ seedsPerPacket + "]";
	}
	
	

}
