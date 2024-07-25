package StepDefinitions;

import static utils.ExtentReport.startTest;

import org.openqa.selenium.WebDriver;
import PageObjects.ClosestMenuObj;
import PageObjects.DefineTheTarget;
import PageObjects.MenuReviewObj;
import PageObjects.Modules;
import io.cucumber.java.en.*;

public class MenuReview {

	DefineTheTarget  defineTheTarget;
	ClosestMenuObj closestMenuObj;
	private WebDriver driver;
	MenuReviewObj menuReview;
	Modules modules;

	public MenuReview() {
		this.driver = TestBase.getDriver();
	}


	@Given("User goes to Menu Review Section")
	public void user_goes_to_menu_review_section() {

		TestBase.Logger = startTest("User goes to  Menu Review  page ", "Validate the different field validation");
		menuReview=new MenuReviewObj(driver);
		modules=new Modules(driver);
		TestBase.result("Click on Menu" , modules.clickonMenu());
		TestBase.result("Validate Menu Analysis button is clicked" , menuReview.clickonMenuAnalysisButton());
		TestBase.result("Validate Menu Review Button is clicked" , menuReview.clickonMenuReview());

	}


	@Then("User Verify Region Name column")
	public void user_verify_region_name_column() {

		TestBase.Logger = startTest("User goes to Verify Region Name column ","");
		menuReview=new MenuReviewObj(driver);
		TestBase.result("Validate Menu Region Name is visibl to user" , menuReview.VerifyRegionNameisDisplayed());

	}
	
	
	@Then("User Update Region Name and Verify")
	public void user_update_region_name_and_verify() {
	   
		TestBase.Logger = startTest("User goes to Verify Region Name column ","");
		menuReview=new MenuReviewObj(driver);
		TestBase.result("Validate Menu Region Name is visibl to user" , menuReview.UpdateRegionNameandVerify());
		
	}


}
