package com.sathya.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

import com.sathya.springboot.entity.ProductEntity;
import com.sathya.springboot.product.ProductModel;
import com.sathya.springboot.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	public void saveProductDetails(ProductModel productModel)
	{
		double stockValue;
		stockValue=productModel.getPrice()*productModel.getQuantity();
		double discountPrice;
		discountPrice=productModel.getPrice()*productModel.getDiscountRate()/100;
		double taxPrice;
		taxPrice=productModel.getPrice()*18/100;
		double offerPrice;
        offerPrice=productModel.getPrice()-discountPrice;
        double finalPrice;
        finalPrice=offerPrice+taxPrice;
        
        ProductEntity productEntity=new ProductEntity();
        
        productEntity.setName(productModel.getName());
        productEntity.setBrand(productModel.getBrand());
        productEntity.setMadeIn(productModel.getMadeIn());
        productEntity.setPrice(productModel.getPrice());
        productEntity.setQuantity(productModel.getQuantity());
        productEntity.setDiscountRate(productModel.getDiscountRate());
        productEntity.setDiscountPrice(discountPrice);
        productEntity.setFinalPrice(finalPrice);
        productEntity.setStockValue(stockValue);
        productEntity.setOfferPrice(offerPrice);
        productEntity.setTaxPrice(taxPrice);
        
        productRepository.save(productEntity);
}
	public List<ProductEntity> getAllProducts() {
		List<ProductEntity> products=productRepository.findAll();
		return products;
	}
	public ProductEntity searchByProductId(Long id) {
	
		Optional <ProductEntity>optionalData=productRepository.findById(id);
		if(optionalData.isPresent())
		{
		ProductEntity product=optionalData.get();
		return product;
		}
		else
		{
			return null;
		}
	}
	public void deleteProductById(Long id) 
	{
		productRepository.deleteById(id);
		
	}
	public ProductModel editProductById(Long id ) 
	{
		
Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        
        if (optionalProduct.isPresent())
        {
            ProductEntity productEntity = optionalProduct.get();
            
            
            ProductModel productModel = new ProductModel();
            
            productModel.setName(productEntity.getName());
            productModel.setBrand(productEntity.getBrand());
            productModel.setMadeIn(productEntity.getMadeIn());
            productModel.setPrice(productEntity.getPrice());
            productModel.setQuantity(productEntity.getQuantity());
            productModel.setDiscountRate(productEntity.getDiscountRate());
            
            return productModel;
            
        } else {
            
            return null; 
        }
		
	}
	public void updateProduct(Long id,ProductEntity productModel)
	{
		Optional<ProductEntity> optionalData=productRepository.findById(productModel.getId());
		
		if(optionalData.isPresent())
		{
			ProductEntity productEntity  = optionalData.get();
			double stockValue;
			stockValue=productModel.getPrice()*productModel.getQuantity();
			double discountPrice;
			discountPrice=productModel.getPrice()*productModel.getDiscountRate()/100;
			double taxPrice;
			taxPrice=productModel.getPrice()*18/100;
			double offerPrice;
	        offerPrice=productModel.getPrice()-discountPrice;
	        double finalPrice;
	        finalPrice=offerPrice+taxPrice;
			productEntity.setName(productModel.getName());
	        productEntity.setBrand(productModel.getBrand());
	        productEntity.setMadeIn(productModel.getMadeIn());
	        productEntity.setPrice(productModel.getPrice());
	        productEntity.setQuantity(productModel.getQuantity());
	        productEntity.setDiscountRate(productModel.getDiscountRate());
	        productEntity.setDiscountPrice(discountPrice);
	        productEntity.setFinalPrice(finalPrice);
	        productEntity.setStockValue(stockValue);
	        productEntity.setOfferPrice(offerPrice);
	        productEntity.setTaxPrice(taxPrice);
	        
	        productRepository.save(productEntity);
		}
		
	}
	
	
	
}