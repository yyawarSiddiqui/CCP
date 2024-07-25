package StepDefinitions;

import static utils.ExtentReport.startTest;

import org.openqa.selenium.WebDriver;
import PageObjects.ClosestMenuObj;
import PageObjects.DefineTheTarget;
import PageObjects.DistributionGroupOBJ;
import PageObjects.MenuReviewObj;
import PageObjects.Modules;
import PageObjects.TraditionalMenu;
import io.cucumber.java.en.*;

public class DistributionGroupValidation {

	DefineTheTarget  defineTheTarget;
	ClosestMenuObj closestMenuObj;
	private WebDriver driver;
	MenuReviewObj menuReview;
	Modules modules;
	DistributionGroupOBJ distributionGroupOBJ;
	TraditionalMenu traditionalMenu;

	public DistributionGroupValidation() {
		this.driver = TestBase.getDriver();
	}

	
	@Then("User Verfiy Region Name with Distribution group")
	public void user_verfiy_region_name_with_distribution_group() {
		
		distributionGroupOBJ=new DistributionGroupOBJ(driver);
		traditionalMenu=new TraditionalMenu(driver);
		defineTheTarget=new DefineTheTarget(driver);
		
		TestBase.Logger = startTest("User Verify Region Name in Distribution Group", "");
		TestBase.result("Click on DistGrp" , distributionGroupOBJ.clickCreateDistGrp());
		TestBase.result("Enter Distribution group" , distributionGroupOBJ.EnterdistgrpName());
		TestBase.result("Click Create on  Distribution group" , distributionGroupOBJ.clickCreateDistGroup());
		TestBase.result("Click and Add Profit Center" , distributionGroupOBJ.clickAddProfitcenter());
		TestBase.result("Enter PC and Search" , distributionGroupOBJ.EnterSiteSearchprofitandSearch());
		TestBase.result("Search Profit Center" , distributionGroupOBJ.clickSearchProfitCenter());
		TestBase.result("Select Profit Center" , distributionGroupOBJ.SelectProfitsiteCheckBox());
		TestBase.result("Move to TraditionalMenu" , traditionalMenu.MovetoTraditionalMenu());
		TestBase.result("Click on Search" , traditionalMenu.Validate_EditDTT_Page());
		TestBase.result("Click on Search" , defineTheTarget.selectProfitCenterGroup());
		
		
		
		
		
	   
	}



}
