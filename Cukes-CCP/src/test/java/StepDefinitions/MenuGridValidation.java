package StepDefinitions;

import static utils.ExtentReport.startTest;

import org.openqa.selenium.WebDriver;

import PageObjects.MenuGrid;
import io.cucumber.java.en.*;

public class MenuGridValidation {

	MenuGrid menugrid;

	private WebDriver driver;
	
	 public MenuGridValidation() {
		 
	        this.driver = TestBase.getDriver();
	    }

	 
	 @Then("verify User Updates the MenuName and Validate MenuGrid Features")
	 public void verify_user_updates_the_menu_name_and_validate_menu_grid_features() throws InterruptedException {
	     
		 TestBase.Logger = startTest("User goes to MenuGrid ", "Validate the features");
		 menugrid =new MenuGrid(driver);
		 TestBase.result("Validate MenuGrid Features",menugrid. User_validate_Recipes_And_OtherField());
		  
	 }
	 
	 @Then("User Validates Current KPI Values")
	 public void user_validates_current_kpi_values() throws InterruptedException {
	     
		 TestBase.Logger = startTest("User opens Kpi MenuGrid ", "Validate the KPI Values");
		 menugrid =new MenuGrid(driver);
		 TestBase.result("Validate KPI Values",menugrid. User_Verify_KPI_Values());
		 
		 
	 }
	 
	 @Given("verify User Validates the Target Value")
	 public void verify_user_validates_the_target_value() throws InterruptedException {
	     
		 menugrid =new MenuGrid(driver);
		 TestBase.result("validates User verify the Target Values by DTT Values ",menugrid.User_validate_TargetValues());	
			
	 }
}

