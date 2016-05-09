package com.shop.cart.service;

import java.math.BigDecimal;
import java.util.List;

import com.shop.cart.domain.Product;

public interface ShoppingService {
	
	final String PRODUCT_ORANGE="Orange";
	final String PRODUCT_APPLE="Apple";

	BigDecimal calculateCartAmount(List<Product> productList)
			throws Exception;

	int calculateOffers(Product product) throws Exception;
	

}
