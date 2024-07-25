Feature: Rules Page and it's Validation

  Background: Login to CCP Portal
    Given User is on Prima Web Master Homepage
    When USer login to the portal

@test
 Scenario: Verifying the Region Name
    Given User goes to Menu Section
    Then User  Moves to  Distribution group Page
    Then User Verfiy Region Name with Distribution group