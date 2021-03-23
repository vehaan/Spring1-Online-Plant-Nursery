package com.cg.sprint1_onlineplantnursery.entity;

import javax.persistence.Embeddable;

@Embeddable
public class AddOns {
	
	private boolean greetingCard;
	private String fertilizerSample;
	
	public boolean isGreetingCard() {
		return greetingCard;
	}
	public void setGreetingCard(boolean greetingCard) {
		this.greetingCard = greetingCard;
	}
	
	public String getFertilizerSample() {
		return fertilizerSample;
	}
	public void setFertilizerSample(String fertilizerSample) {
		this.fertilizerSample = fertilizerSample;
	}
	
	public AddOns(boolean greetingCard, String fertilizerSample) {
		super();
		this.greetingCard = greetingCard;
		this.fertilizerSample = fertilizerSample;
	}
	public AddOns() {
		super();
	}
	
	
	
	
	
	
}
