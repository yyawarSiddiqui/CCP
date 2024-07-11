Feature: Rules Page and it's Validation

 Background: Login to CCP Portal 	
  Given User is on Prima Web Master Homepage
  When USer login to the portal
  
  


  Scenario: Verify that  rules should triggered 
  Given User goes to Menu Section
  Then User Move to  DTT page  
  Then User Creates and validates RulePage Title
	Then User Save Rules in Beverage option
	
	
 	 
  Scenario: Verify that  rules should triggered 
  Given User goes to Menu Section
  Then User Move to  DTT page  
  Then User Creates and validates RulePage Title
	Then User Save Rules in Morning Beverage option
	
	

	Scenario: Verify that  rules should triggered 
  Given User goes to Menu Section
  Then User Move to  DTT page  
  Then User Creates and validates RulePage Title
	Then User Save Rules in Morning Vegan option
	
		
	
	Scenario: Verify that  rules should triggered 
  Given User goes to Menu Section
  Then User Move to  DTT page  
  Then User Creates and validates RulePage Title
	Then user should only add recipe with defined packaging type in the menu else rule should be triggred
	
	
	

	Scenario: Verify that  rules should triggered 
  Given User goes to Menu Section
  Then User Move to  DTT page  
  Then User Creates and validates RulePage Title
	Then user should only add recipe with defined serving size in the menu else rule should be triggred
	
	