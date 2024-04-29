package StepDefinitions;

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
	     
		 menugrid =new MenuGrid(driver);
		 TestBase.result("Validate MenuGrid Features",menugrid. User_validate_Recipes_And_OtherField());
		  
	 }
	 
	 @Then("User Validates Current KPI Values")
	 public void user_validates_current_kpi_values() {
	     
		 menugrid =new MenuGrid(driver);
		 TestBase.result("Validate KPI Values",menugrid. User_Verify_KPI_Values());
		 
		 
	 }
}

