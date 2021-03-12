package com.cg.sprint1_onlineplantnursery.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Planter {
	@Id
	private Integer planterId;
	private float planterheight;
	private int planterCapacity;
	private int drinageHoles;
	private String planterColor;
	private String planterShape;
	private int planterStock;
	private int planterCost;
	
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Plant> plants;
//	
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Seed> seeds;

	/*
	 * public Planter(Integer planterId, float planterheight, int planterCapacity,
	 * int drinageHoles, String planterColor, String planterShape, int planterStock,
	 * int planterCost, List<Plant> plants, List<Seed> seeds) { super();
	 * this.planterId = planterId; this.planterheight = planterheight;
	 * this.planterCapacity = planterCapacity; this.drinageHoles = drinageHoles;
	 * this.planterColor = planterColor; this.planterShape = planterShape;
	 * this.planterStock = planterStock; this.planterCost = planterCost; this.plants
	 * = plants; this.seeds = seeds; }
	 */
	

	public Planter(Integer planterId, float planterheight, int planterCapacity, int drinageHoles, String planterColor,
			String planterShape, int planterStock, int planterCost) {
		super();
		this.planterId = planterId;
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
	}



	/*
	 * public List<Plant> getPlants() { return plants; }
	 * 
	 * public List<Seed> getSeeds() { return seeds; }
	 * 
	 * public void setPlants(List<Plant> plants) { this.plants = plants; }
	 * 
	 * public void setSeeds(List<Seed> seeds) { this.seeds = seeds; }
	 */

	public Planter() {
		super();
	}

	public Integer getPlanterId() {
		return planterId;
	}

	public void setPlanterId(Integer planterId) {
		this.planterId = planterId;
	}

	public float getPlanterheight() {
		return planterheight;
	}

	public void setPlanterheight(float planterheight) {
		this.planterheight = planterheight;
	}

	public int getPlanterCapacity() {
		return planterCapacity;
	}

	public void setPlanterCapacity(int planterCapacity) {
		this.planterCapacity = planterCapacity;
	}

	public int getDrinageHoles() {
		return drinageHoles;
	}

	public void setDrinageHoles(int drinageHoles) {
		this.drinageHoles = drinageHoles;
	}

	public String getPlanterColor() {
		return planterColor;
	}

	public void setPlanterColor(String planterColor) {
		this.planterColor = planterColor;
	}

	public String getPlanterShape() {
		return planterShape;
	}

	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}

	public int getPlanterStock() {
		return planterStock;
	}

	public void setPlanterStock(int planterStock) {
		this.planterStock = planterStock;
	}

	public int getPlanterCost() {
		return planterCost;
	}

	public void setPlanterCost(int planterCost) {
		this.planterCost = planterCost;
	}



	@Override
	public String toString() {
		return "Planter [planterId=" + planterId + ", planterheight=" + planterheight + ", planterCapacity="
				+ planterCapacity + ", drinageHoles=" + drinageHoles + ", planterColor=" + planterColor
				+ ", planterShape=" + planterShape + ", planterStock=" + planterStock + ", planterCost=" + planterCost
				+ "]";
	}

	/*
	 * @Override public String toString() { return "Planter [planterId=" + planterId
	 * + ", planterheight=" + planterheight + ", planterCapacity=" + planterCapacity
	 * + ", drinageHoles=" + drinageHoles + ", planterColor=" + planterColor +
	 * ", planterShape=" + planterShape + ", planterStock=" + planterStock +
	 * ", planterCost=" + planterCost + ", plants=" + plants + ", seeds=" + seeds +
	 * "]"; }
	 */
}
