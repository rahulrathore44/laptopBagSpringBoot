package com.laptop.laptopbag.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "Laptop")
@JsonRootName("Laptop")
public class LaptopDetails {
	private static final long serialVersionUID = 3357278725091907367L;

	private int id;

	public int getId() {
		return id;
	}

	//@XmlElement(name = "Id")
	@JsonProperty("Id")
	public void setId(int id) {
		this.id = id;
	}

	private String laptopName;

	//@XmlElement(name = "LaptopName")
	
	public String getLaptopName() {
		return laptopName;
	}

	@JsonProperty("LaptopName")
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	private String brandName;

	//@XmlElement(name = "BrandName")
	@JsonProperty("BrandName")
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	private Features features;

	//@XmlElement(name = "Features")
	@JsonProperty("Features")
	public Features getFeatures() {
		return features;
	}

	public void setFeatures(Features features) {
		this.features = features;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof LaptopDetails))
			return false;
		return ((LaptopDetails) obj).id == this.id;
	}
}
