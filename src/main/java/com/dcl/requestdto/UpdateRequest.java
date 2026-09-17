package com.dcl.requestdto;

import lombok.Data;

@Data
public class UpdateRequest {
	
	private String productName;
	
	private Double price;
	
	private String brand;

}
