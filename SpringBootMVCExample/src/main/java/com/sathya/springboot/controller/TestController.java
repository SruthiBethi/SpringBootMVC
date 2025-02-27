package com.sathya.springboot.controller;



import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.sathya.springboot.entity.ProductEntity;
import com.sathya.springboot.product.ProductModel;
import com.sathya.springboot.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	@Autowired
	ProductService productService;
	
	/*@GetMapping("/productform")
	public String getProductForm(
			) {
		return "add-product";
	} 
	*/
	/*@PostMapping("/saveProduct")
	public String saveProduct(ProductModel productModel)
	{
		productService.saveProductDetails(productModel);
		
		return "success";
	}
	*/
	@GetMapping("/getallproducts")
	public String getAllProducts(Model model)
	{
		List<ProductEntity> products=productService.getAllProducts();
		model.addAttribute("products",products );
		return "product-list";
	}
	
	@GetMapping("/searchbyproductid")
	public String getSearchByForm() 
	{
		
		return "search-product";
	}
	@PostMapping("searchById")
	public String searchByProductId(@RequestParam Long id,Model model)
	{
		ProductEntity product=productService.searchByProductId(id);
		
		model.addAttribute("product", product);
		return "search-product";
	}
	@GetMapping("/delete/{id}")
	public String deleteProductById(@PathVariable("id") Long id)
	{
		productService.deleteProductById(id);
		return "redirect:/getallproducts";
	}
	@GetMapping("/edit/{id}")
	public String editProductById(@PathVariable("id") Long id, Model model)
	{
		ProductModel productModel= productService.editProductById(id);
		
		model.addAttribute("product", productModel);
		model.addAttribute("id", id);
		return "edit-product";
	}
	
	@PostMapping("/editproductsave/{id}")
	public String updateProduct(@PathVariable("id") Long id, @ModelAttribute ProductEntity productModel) {
		
		productService.updateProduct(id,productModel);
		
		return "redirect:/getallproducts";
	}
	
	@GetMapping("/productform")
	public String getProductForm(Model model)
	{
		ProductModel productModel=new ProductModel();
		productModel.setMadeIn("India");
		productModel.setQuantity(1);
		productModel.setDiscountRate(10.0);
		
		model.addAttribute("productModel", productModel);
		
		return "add-product";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@Valid ProductModel productModel, BindingResult bindingResult,Model model) {
		
		HashMap<String, String> validationErrors=new HashMap<String, String>();
		
		if(bindingResult.hasErrors())
		{
			for(FieldError fieldError : bindingResult.getFieldErrors())
			{
				validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			
			model.addAttribute("validationErrors",validationErrors);
			
			return "add-product";
		}
		productService.saveProductDetails(productModel);
		return "redirect:/getallproducts";
	}
	
}
	

