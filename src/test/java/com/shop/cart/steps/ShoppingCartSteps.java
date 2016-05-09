package com.shop.cart.steps;


import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration("/cucumber.xml")
@WebAppConfiguration
public class ShoppingCartSteps {

	String url = null;
	String response = null;

	@Autowired
	WebApplicationContext context;
	private MockMvc mockMvc;

	@Before 
	public void setUp() { 
		mockMvc = MockMvcBuilders 
				.webAppContextSetup(context).build(); 
	} 

	@Given("^a shopping cart items information url \"(.*?)\"$")
	public void a_shopping_cart_items_information_url(String url) throws Throwable {
		this.url = url;
	}

	@When("^I send a following json which includes shopping items$")
	public void i_send_a_following_json_which_includes_shopping_items(String jsonString) throws Throwable {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		MvcResult mvcResult = mockMvc.perform(post(url).contentType("application/json") .content(jsonString)) .andExpect(status().isOk()).andReturn();
		response = mvcResult.getResponse().getContentAsString();
	}

	@Then("^the total billing amount should be \"(.*?)\"$")
	public void the_total_billing_amount_should_be(String cartAmount) throws Throwable {
		assertTrue(cartAmount.equalsIgnoreCase(response));
	}

}
