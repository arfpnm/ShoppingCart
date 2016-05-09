Feature: Shopping cart
   
  Scenario: create cart billing
    Given  a shopping cart items information url "/shop"
    When I send a following json which includes shopping items
     """
 	[{"name":"Apple","quantity":4, "price" : 0.60}, {"name":"Orange","quantity":4, "price" : 0.25}]
 	 """
    Then the total billing amount should be "1.70"



	
 
