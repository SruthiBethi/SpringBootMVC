package com.sathya.springboot.product;

import org.springframework.web.bind.annotation.GetMapping;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	
	@NotBlank(message = "Product Name Cannot Be Blank")
	private String name;
	
	@NotBlank(message = "Band Cannot Be Blank")
	private String brand;
	
	@NotBlank(message = "Made In Cannot Be Blank")
	private String madeIn;
	
	@Positive(message = "Price Must Be Greater Than Zero")
	private double price;
	
	@Min(value = 1, message = "Quantity Must Be Atleast One")
	private int quantity;
	
	@DecimalMax(value = "100.0", message = "Discount Rate Cannot Be Exceeded 100")
	private double discountRate;
	
}
