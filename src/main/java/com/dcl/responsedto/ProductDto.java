package com.dcl.responsedto;

import lombok.Data;

//response dto should be shown in ui

@Data
public class ProductDto {
	
	private Integer productId;
	
	private String productName;
	
	private Double price;
	
	private String brand;

}
