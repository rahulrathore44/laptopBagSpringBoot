package com.laptop.laptopbag.interfaces;

import java.util.List;

import com.laptop.laptopbag.model.LaptopDetails;

public interface Ioperation {
	public List<LaptopDetails> getAllLaptops();
	public LaptopDetails addLaptopDetail(LaptopDetails laptop);
	public LaptopDetails updateLaptopDetail(LaptopDetails laptop);
	public int deleteLaptopBag(int id);
	public LaptopDetails searchLaptop(int id);
	public LaptopDetails searchLaptop(int id,String laptopName);
}
