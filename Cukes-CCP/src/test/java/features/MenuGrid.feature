 Feature: Menu Grid Page and it's Validation
 
 Background: Login to CCP Portal 	
  Given User is on Prima Web Master Homepage
  When USer login to the portal
 
 
 

    Scenario: Verifying User Updates CopyMenu Name Check the MenuGrid Functionality
   Given User goes to Menu Section  
   And  User Copies Menu 
   And verify User Updates the MenuName and Validate MenuGrid Features
   
   

    Scenario: Verifying the KPI Values on Copying 
   Given User goes to Menu Section  
   And  User Copies Menu 
   And User Validates Current KPI Values
   
   
  
   
   
   Scenario: Verifying the Target Values on Copying 
   Given User goes to Menu Section  
   And  User Copies Menu 
   And verify User Validates the Target Value	
    
   