package com.dcl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.requestdto.AddProduct;
import com.dcl.requestdto.UpdateRequest;
import com.dcl.response.ApiResponse;
import com.dcl.responsedto.ProductDto;
import com.dcl.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService pservice; 
	
	// response entity -> inbuilt class used to give http response for user rest api ui(https codes,response body)
	
	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody AddProduct request){
		ProductDto dto = pservice.addProduct(request);
		return ResponseEntity.ok(new ApiResponse<>("product added successfully",dto,HttpStatus.OK)); 
	}
	
	
	@GetMapping("/get/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable Integer productId){
		ProductDto dto = pservice.getProductById(productId);
		return ResponseEntity.ok(new ApiResponse<>("productInfo", dto, HttpStatus.OK));
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getAllProduct(){
		List<ProductDto> plist = pservice.getAllProduct();
		return ResponseEntity.ok(new ApiResponse<>("All products", plist, HttpStatus.OK));
	}
	
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
		pservice.deleteProductById(productId);
		return ResponseEntity.ok(new ApiResponse<>("deleted successfully!",null, HttpStatus.OK));
	}
	
	
	@PutMapping("/update/{productId}")
	public ResponseEntity<?> updateProduct(@PathVariable Integer productId,@RequestBody UpdateRequest request){
		ProductDto dto = pservice.updateProduct(productId, request); 
		return ResponseEntity.ok(new ApiResponse<>("updated successfully", dto, HttpStatus.OK));
	}
	
	
	
	

}
