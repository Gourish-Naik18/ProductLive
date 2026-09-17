package com.dcl.requestdto;

import lombok.Data;

//req dto object

@Data
public class AddProduct {
	
	
	private String productName;  //field should match with the enetity
	
	private Double price;
	
	private String brand;
	

}
