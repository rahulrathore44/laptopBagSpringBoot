package com.laptop.laptopbag.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Features {
	private List<String> feature;

	public Features() {
		feature = new ArrayList<String>();
	}

	// @XmlElement(name="Feature")
	@JsonProperty("Feature")
	public List<String> getFeatures() {
		return feature;
	}

	public void setFeatures(List<String> features) {
		this.feature = features;
	}

}
