package StepDefinitions;

import static utils.ExtentReport.startTest;

import org.openqa.selenium.WebDriver;

import PageObjects.Rules;
import io.cucumber.java.en.*;

public class Rules_Validation {
	
	Rules rules;
	
	private WebDriver driver;
	
	 public Rules_Validation() {
	        this.driver = TestBase.getDriver();
	    }
	 
	 
	 @Then("User Save Rules in Beverage option")
	 public void user_save_rules_in_beverage_option() {
	     
		 rules=new Rules(driver);
			TestBase.Logger = startTest("User validates PerDay funtionality of rules  ", "Validate Add 'Per day' to frequency option for fruit, vegetables, milk");
		TestBase.result("Verified that after selecting packaging type as Bulk & per day frequency for the milk type any, the defined no. of milk type any servings should be required per day in the menu else rules should triggered", rules.FillBeverage_Milk());
	 }
	 
	 
	 @Then("User Save Rules in Morning Beverage option")
	 public void user_save_rules_in_morning_beverage_option() {
	     
		 rules=new Rules(driver);
			TestBase.Logger = startTest("User validates PerDay funtionality of rules  ", "Validate Add 'Per day' to frequency option for fruit, vegetables, milk");
		TestBase.result("Verified that after selecting packaging type as Bulk & per day frequency for the morning beverage type any, the defined no. of milk servings should be required in the menu else rules should triggred ", rules.FillBeverage_Morning());
	 
	 }

	 @Then("User Save Rules in Morning Vegan option")
	 public void user_save_rules_in_morning_vegan_option() {
	     
		 rules=new Rules(driver);
			TestBase.Logger = startTest("User validates PerDay funtionality of rules  ", "Validate Add 'Per day' to frequency option for fruit, vegetables, milk");
		TestBase.result("Verified that after selecting packaging type as PC & per day frequency for the morning Vegan type any, the defined no. of milk servings should be required in the menu else rules should triggred ", rules.FillBeverage_MorningVegan());
	 
	 }
	 
	 @Then("user should only add recipe with defined packaging type in the menu else rule should be triggred")
	 public void user_should_only_add_recipe_with_defined_packaging_type_in_the_menu_else_rule_should_be_triggred() {
	   

		 rules=new Rules(driver);
			TestBase.Logger = startTest("User validates PerDay funtionality of rules  ", "Validate Add 'Per day' to frequency option for fruit, vegetables, milk");
		TestBase.result("Verify that user should only add recipe with defined packaging type in the menu else rule should be triggred", rules.OnePercentMilk());
	 
		 
	 }

	 
	 @Then("user should only add recipe with defined serving size in the menu else rule should be triggred")
	 public void user_should_only_add_recipe_with_defined_serving_size_in_the_menu_else_rule_should_be_triggred() {
	    
		 rules=new Rules(driver);
			TestBase.Logger = startTest("User validates PerDay funtionality of rules  ", "Validate Add 'Per day' to frequency option for fruit, vegetables, milk");
		TestBase.result("Verify that user should only add recipe with defined serving size in the menu else rule should be triggred", rules.OnePercentMilkServing());
	 
		 
	 }


	 
}
