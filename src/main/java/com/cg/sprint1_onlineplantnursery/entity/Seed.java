package com.cg.sprint1_onlineplantnursery.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Seed extends Product{
	

	@NotBlank(message = "Name is required")
	@Column(unique = true)
	private String commonName;
	
	@Enumerated(EnumType.STRING)
	private BloomTime bloomTime;
	private String watering;
	
	@Enumerated(EnumType.STRING)
	private Difficulty difficultyLevel;
	private String temperature;
	private String typeOfSeed;
	private String description;

	@NotNull
	@Positive(message = "A positive value of seeds per packet required")
	private Integer seedsPerPacket;

	public enum Difficulty implements Serializable{
	    EASY, MEDIUM, HARD;	
	}
	
	public enum BloomTime implements Serializable{
	    WINTER, SUMMER, AUTUMN, MONSOON;
		
		public String getStatus() {
			return this.name();
		}
	}
	

	public Seed(@NotBlank(message = "Name is required") String commonName, BloomTime bloomTime, String watering,
			Difficulty difficultyLevel, String temperature, String typeOfSeed, String description,
			@NotNull @Positive(message = "A positive value of seeds per packet required") Integer seedsPerPacket) {
		super();
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.typeOfSeed = typeOfSeed;
		this.description = description;
		this.seedsPerPacket = seedsPerPacket;
	}

	public Seed(int cost, int stock, @NotBlank(message = "Name is required") String commonName, BloomTime bloomTime,
			String watering, Difficulty difficultyLevel, String temperature, String typeOfSeed, String description,
			@NotNull @Positive(message = "A positive value of seeds per packet required") Integer seedsPerPacket) {
		super(cost, stock);
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.typeOfSeed = typeOfSeed;
		this.description = description;
		this.seedsPerPacket = seedsPerPacket;
	}

	public Seed(int id, int cost, int stock, Type type, @NotBlank(message = "Name is required") String commonName,
			BloomTime bloomTime, String watering, Difficulty difficultyLevel, String temperature, String typeOfSeed,
			String description,
			@NotNull @Positive(message = "A positive value of seeds per packet required") Integer seedsPerPacket) {
		super(id, cost, stock, type);
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.typeOfSeed = typeOfSeed;
		this.description = description;
		this.seedsPerPacket = seedsPerPacket;
	}

	public Seed(int cost, int stock, Type type, @NotBlank(message = "Name is required") String commonName,
			BloomTime bloomTime, String watering, Difficulty difficultyLevel, String temperature, String typeOfSeed,
			String description,
			@NotNull @Positive(message = "A positive value of seeds per packet required") Integer seedsPerPacket) {
		super(cost, stock, type);
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.typeOfSeed = typeOfSeed;
		this.description = description;
		this.seedsPerPacket = seedsPerPacket;
	}

	public Seed() {
		super();
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

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSeedsPerPacket() {
		return seedsPerPacket;
	}
	public void setSeedsPerPacket(Integer seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}

	public String getTypeOfSeed() {
		return typeOfSeed;
	}

	public void setTypeOfSeed(String typeOfSeed) {
		this.typeOfSeed = typeOfSeed;
	}

	@Override
	public String toString() {
		return "Seed [commonName=" + commonName + ", bloomTime=" + bloomTime + ", watering=" + watering
				+ ", difficultyLevel=" + difficultyLevel + ", temperature=" + temperature + ", typeOfSeed=" + typeOfSeed
				+ ", description=" + description + ", seedsPerPacket=" + seedsPerPacket + "]";
	}

}
