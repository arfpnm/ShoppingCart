package com.shop.cart.service;

import java.util.List;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.shop.cart.domain.Product;

@Service
public class ShoppingServiceImpl implements ShoppingService{
	
	@Override
	public BigDecimal calculateCartAmount(List<Product> productList) throws Exception{

		if(productList == null || productList.isEmpty())
			return BigDecimal.ZERO;
		BigDecimal totalAmount = new BigDecimal(0);
		for(Product product : productList){
			BigDecimal productPrice = product.getPrice();
			int offerQuantity = calculateOffers(product);
			BigDecimal productTotalPrice = productPrice.multiply(BigDecimal.valueOf(offerQuantity));
			product.setTotalPrice(productTotalPrice);
			totalAmount=totalAmount.add(productTotalPrice);
		}		
		return totalAmount;
	}
	
	@Override
	public int calculateOffers(Product product) throws Exception{
			int offerQuantity = 0;
			String productName = product.getName();
			int quantity = product.getQuantity();
			offerQuantity =	quantity != 0 ? (quantity/2 + quantity % 2) : 0;

			if(productName != null && productName.equalsIgnoreCase(PRODUCT_ORANGE)){
				if(quantity == 2){
					offerQuantity = quantity;
				}
			}
		return offerQuantity;
	}
}
