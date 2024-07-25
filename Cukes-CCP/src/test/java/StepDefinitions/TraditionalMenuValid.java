package StepDefinitions;

import static utils.ExtentReport.startTest;

import org.openqa.selenium.WebDriver;

import PageObjects.Rules;
import PageObjects.TraditionalMenu;
import io.cucumber.java.en.*;

public class TraditionalMenuValid {
	
	Rules rules;
	
	private WebDriver driver;
	TraditionalMenu traditionalMenu;
	
	 public TraditionalMenuValid() {
	        this.driver = TestBase.getDriver();
	    }

	 @Then("User Verify Region Name column on Traditional Menu Page")
	 public void user_verify_region_name_column_on_traditional_menu_page() {
	    
		 TestBase.Logger = startTest("User Verify Region Name ", "Validate the Region NAme Column");

		 traditionalMenu =new TraditionalMenu(driver);
			TestBase.result("Verify Region NAme Column is not present on Traditional Menu search page" , traditionalMenu.SearchHeaderValuesTraditionalMenu());
	 }
	 
	 @Then("User  Moves to  Distribution group Page")
	 public void user_verify_region_name_column_on_distribution_group_page() {
		 
		 TestBase.Logger = startTest("User Verify Region Name ", "Validate the Region NAme Column");

		 traditionalMenu =new TraditionalMenu(driver);
			TestBase.result("Verify Region NAme Column is not present on  Distribution group page" , traditionalMenu.MovetoDistributionGroup());
	 }
	 
	


	 
}
