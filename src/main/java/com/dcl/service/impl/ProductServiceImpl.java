package com.dcl.service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dcl.entity.Product;
import com.dcl.exception.AppException;
import com.dcl.repository.ProductRepo;
import com.dcl.requestdto.AddProduct;
import com.dcl.requestdto.UpdateRequest;
import com.dcl.responsedto.ProductDto;
import com.dcl.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo prepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ProductDto addProduct(AddProduct request) {
		// TODO Auto-generated method stub
//		Product p = new Product();
//		p.setProductName(request.getProductName());
//		p.setPrice(request.getPrice());
//		p.setBrand(request.getBrand());
		
		Product p = mapper.map(request,Product.class);
		p = prepo.save(p);
		
//		ProductDto dto = new ProductDto();
//		dto.setProductId(p.getProductId());
//		dto.setProductName(p.getProductName());
//		dto.setPrice(p.getPrice());
//		dto.setBrand(p.getBrand());
//		return dto;
		
		return mapper.map(p,ProductDto.class);
	}

	@Override
	public ProductDto getProductById(Integer productId) {
		Product p = prepo.findById(productId).orElse(null);
		
		if(p == null) {
			throw new AppException("product not found", HttpStatus.NOT_FOUND);
		}
		
//		ProductDto dto = new ProductDto();
//		dto.setProductId(p.getProductId());
//		dto.setProductName(p.getProductName());
//		dto.setBrand(p.getBrand());
//		dto.setPrice(p.getPrice());
//		return dto;
		
		return mapper.map(p, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> plist = prepo.findAll();
		
//		Function<Product, ProductDto> function = (p)-> {
////			ProductDto dto = new ProductDto();
////			dto.setProductId(p.getProductId());
////			dto.setProductName(p.getProductName());
////			dto.setBrand(p.getBrand());
////			dto.setPrice(p.getPrice());
////			return dto;
//			
//			return mapper.map(p, ProductDto.class);
//		};
		
//	List<ProductDto> dtoList = plist.stream().map(function).collect(Collectors.toList());
		
	List<ProductDto> dtoList = plist.stream().map((p)->mapper.map(p, ProductDto.class)).collect(Collectors.toList());

	return dtoList;
	}

	
	@Override
	public void deleteProductById(Integer productId) {
		Product p = prepo.findById(productId).orElseThrow(()->new RuntimeException("product not found"));
		prepo.deleteById(productId);
	}

	@Override
	public ProductDto updateProduct(Integer productId, UpdateRequest request) {
		// TODO Auto-generated method stub
		Product existing = prepo.findById(productId).orElseThrow(()->new RuntimeException("pproduct not found"));
//		existing.setProductName(request.getProductName());
//		existing.setPrice(request.getPrice());
//		existing.setBrand(request.getBrand());
		
		mapper.map(request, existing);
		Product updated = prepo.save(existing);
		
//		ProductDto dto = new ProductDto();
//		dto.setProductId(updated.getProductId());
//		dto.setProductName(updated.getProductName());
//		dto.setBrand(updated.getBrand());
//		dto.setPrice(updated.getPrice());
//		return dto;
		
		return mapper.map(updated, ProductDto.class);
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
