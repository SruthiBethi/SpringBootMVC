package com.sathya.springboot.entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Entity
@Table(name = "Product")
public class ProductEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;

		private String name;
		private String brand;
		private String madeIn;
		private double price;
		private int quantity;
		private double discountRate;
		private double taxPrice;
		private double discountPrice;
		private double offerPrice;
		private double finalPrice;
		@Column(name = "ST")
		private double stockValue;
	}

