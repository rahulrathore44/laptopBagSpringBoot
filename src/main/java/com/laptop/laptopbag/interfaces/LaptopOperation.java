package com.laptop.laptopbag.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.laptop.laptopbag.model.Features;
import com.laptop.laptopbag.model.LaptopDetails;

public class LaptopOperation implements Ioperation {
	private static List<LaptopDetails> details = new ArrayList<LaptopDetails>();
	private static final Logger oLog = LoggerFactory.getLogger(LaptopOperation.class);
	
	@Override
	public List<LaptopDetails> getAllLaptops() {
		if(details.isEmpty())
			details.add(getDefaultData());
		oLog.info(details.toString());
		return details;
	}

	@Override
	public LaptopDetails addLaptopDetail(LaptopDetails laptop) {
		if(!details.contains(laptop))
			details.add(laptop);
		return laptop;
	}
	
	private LaptopDetails getDefaultData(){
    	LaptopDetails data = new LaptopDetails();
    	Features feature = new Features();
    	feature.setFeatures(Arrays.asList("8th Generation Intel® Core™ i5-8300H",
    			"Windows 10 Home 64-bit English",
    			"NVIDIA® GeForce® GTX 1660 Ti 6GB GDDR6",
    			"8GB, 2x4GB, DDR4, 2666MHz"));
    	
    	data.setId(1);
    	data.setLaptopName("Alienware M17");
    	data.setBrandName("Alienware");
    	data.setFeatures(feature);
    	
    	return data;
    	
    }

	@Override
	public LaptopDetails updateLaptopDetail(LaptopDetails laptop) {
		LaptopDetails data = searchLaptop(laptop.getId());
		if(data != null){
			details.remove(data);
			details.add(laptop);
			return laptop;
		}
		return null;
	}

	@Override
	public int deleteLaptopBag(int id) {
		LaptopDetails data = searchLaptop(id);
		if(data != null){
			details.remove(data);
			return data.getId();
		}
		return -1;
	}

	@Override
	public LaptopDetails searchLaptop(int id) {
		for (LaptopDetails laptopDetails : details) {
			if(laptopDetails.getId() == id)
				return laptopDetails;
		}
		return null;
	}

	@Override
	public LaptopDetails searchLaptop(int id, String laptopName) {
		for (LaptopDetails laptopDetails : details) {
			if(laptopDetails.getId() == id && laptopName.equalsIgnoreCase(laptopDetails.getLaptopName()))
				return laptopDetails;
		}
		return null;
	}
}
