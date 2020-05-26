package com.laptop.laptopbag.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Features {
	private List<String> features;

	public Features() {
		features = new ArrayList<String>();
	}
	
	//@XmlElement(name="Feature")
	@JsonProperty("Feature")
	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

}
