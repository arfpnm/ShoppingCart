package com.shop.cart.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//@Ignore
@RunWith(Cucumber.class) 
@CucumberOptions(glue = {"com.shop.cart.steps"}, features = { "src/test/resources/shoppingcart" })
public class ShoppingCartTest {


	
	
}
