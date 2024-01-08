package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product extends BaseEntity{
	// name (unique) , description ,category(enum) , price , 
	//available stock(int),expiryDate:LocalDate
	
	@Column(name="product_name",length=20, unique=true)
	private String name;
	@Column(name="description",length=100)
	private String description;
	@Enumerated(EnumType.STRING)
	private ProductType category;
	@Column(name="price")
	private double price;
	@Column(name="available_stock")
	private int availableStock;
	@Column(name="expiry_date")
	private LocalDate expiryDate;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductType getCategory() {
		return category;
	}
	public void setCategory(ProductType category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailableStock() {
		return availableStock;
	}
	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Product(String name, String description, ProductType category, double price, int availableStock,
			LocalDate expiryDate) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.availableStock = availableStock;
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "ProductId="+getId()+ "[name=" + name + ", description=" + description + ", category=" + category + ", price=" + price
				+ ", availableStock=" + availableStock + ", expiryDate=" + expiryDate + "]";
	}
	
	
}
