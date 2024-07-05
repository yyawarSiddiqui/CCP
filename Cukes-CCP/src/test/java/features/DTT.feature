
Feature: Login to ARAMARK CCP Portal and DTT Field Validation
 

  Background: Login to CCP Portal 	
  Given User is on Prima Web Master Homepage
  When USer login to the portal
  
  
  Scenario: Verifying the DTT Fields
  Given User goes to Menu Section
  Then User Move to  DTT page  
  And validates the ScreenTitle
    
  
  Scenario: Verifying the DTT Field(Second Scenario)
  Given User goes to Menu Section
  Then User Move to  DTT page
  And Validate Name is Required field
  
   Scenario: Verifying the DTT Field(Third Scenario)
  Given User goes to Menu Section
  Then User Move to  DTT page
  And Validate MealPeriod is Required field
  
  Scenario: Verifying the DTT Field(Fourth Scenario)
  Given User goes to Menu Section
  Then User Move to  DTT page
  And Validate RDAtype is Required field
  
  
  Scenario: Verifying the DTT Field(Fifth Scenario)
  Given User goes to Menu Section
  Then User Move to  DTT page
  And Validate Description is Non-MAndatory field
  
  
   Scenario: Verifying the DTT Field(Sixth Scenario)
  Given User goes to Menu Section
  Then User Move to  DTT page
  And Validate Name field should accept only Hundered characters
  
  
   Scenario: Verifying the DTT Field(Seventh Scenario)
  Given User goes to Menu Section
  Then User Move to  DTT page
  And Validate Service channel should be Corrections and auto populated always
  
  
   Scenario: Verifying the DTT Field(Eight Scenario)
  Given User goes to Menu Section
  Then User Move to  DTT page
  And Validate Calorie Level Functionality
  
  
 
  Scenario: Verifying the DTT Field(Ninth Scenario)
  Given User goes to Menu Section
  Then User Move to  DTT page
  And Verify the functionality of the Status dropdown 
  
  
   Scenario: Verifying the DTT Field(Tenth Scenario)
  Given User goes to Menu Section
  Then User Move to  DTT page
  And Verify the functionality of the Number of Cycle Weeks dropdown 
  
  
  
  