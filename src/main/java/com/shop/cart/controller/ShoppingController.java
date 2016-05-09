package com.shop.cart.controller;
/**
 * @author arif.mohammed
 */
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.shop.cart.domain.Product;
import com.shop.cart.service.ShoppingService;

@RestController
@ResponseBody
public class ShoppingController {

	static Logger LOGGER = LoggerFactory.getLogger(ShoppingController.class);
	
	@Autowired
	ShoppingService shoppingService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test()
			throws Exception {
			return "Hello - `welcome to the API world";
	}
	
	/**
	 * @param shoppingItemsJson
	 * @param httpServletRequest
	 * @return
	 * @throws Exception
	 * json eg: [{"name":"Apple","quantity":4, "price" : 0.60}, {"name":"Orange","quantity":3, "price" : 0.25}]
	 */
	@RequestMapping(value = "/shop", method = RequestMethod.POST)
	public String getCartAmount(@RequestBody String shoppingItemsJson, HttpServletRequest httpServletRequest)
			throws Exception {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		//Product shoppingCart = new ObjectMapper().readValue(shoppingItemsJson, Product.class);
		//create an list of shopping cart from json array
		//BigDecimal totalAmount = shoppingCart = shoppingService.calculateCartAmount(shoppingCart);
		List<Product> productList = new ObjectMapper().readValue(shoppingItemsJson,
				TypeFactory.defaultInstance().constructCollectionType(List.class,  
				   Product.class));
		BigDecimal totalCartAmount = shoppingService.calculateCartAmount(productList);
		return ow.writeValueAsString(totalCartAmount);
	}

}