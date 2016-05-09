package com.shop.cart.domain;

import java.math.BigDecimal;

public class Product {
	
	private String name;
	private int quantity;
	private int offerQuantity;
	private BigDecimal price;
	private BigDecimal totalPrice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getOfferQuantity() {
		return offerQuantity;
	}
	public void setOfferQuantity(int offerQuantity) {
		this.offerQuantity = offerQuantity;
	}

}
