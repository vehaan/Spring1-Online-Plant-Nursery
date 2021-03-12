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
	
}
