package com.dcl.service;

import java.util.List;

import com.dcl.requestdto.AddProduct;
import com.dcl.requestdto.UpdateRequest;
import com.dcl.responsedto.ProductDto;

public interface ProductService {
	
  ProductDto addProduct(AddProduct request);
  
  ProductDto getProductById(Integer productId);
  
  List<ProductDto> getAllProduct();
  
  void deleteProductById(Integer productId);
  
  ProductDto updateProduct(Integer productId,UpdateRequest request);
  

}
