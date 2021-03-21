package com.cg.sprint1_onlineplantnursery.entity;

public class SeedLink {
	
	private String link;
	private String rel;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
	public SeedLink(String link, String rel) {
		super();
		this.link = link;
		this.rel = rel;
	}
	
	public SeedLink() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
