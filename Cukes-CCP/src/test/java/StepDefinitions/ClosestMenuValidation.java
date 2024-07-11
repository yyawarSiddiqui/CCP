package StepDefinitions;

import static utils.ExtentReport.startTest;

import org.openqa.selenium.WebDriver;
import PageObjects.ClosestMenuObj;
import PageObjects.DefineTheTarget;
import io.cucumber.java.en.Then;

public class ClosestMenuValidation {

	DefineTheTarget  defineTheTarget;
	ClosestMenuObj closestMenuObj;
	private WebDriver driver;

	public ClosestMenuValidation() {
		this.driver = TestBase.getDriver();
	}


	@Then("User Creates the menu and Moves to Closest Menu")
	public void user_creates_the_menu_and_moves_to_closest_menu() {

		TestBase.Logger = startTest("User Verify CLosestMenuPageTitle ", "Validate the Screen Title");

		closestMenuObj =new ClosestMenuObj(driver);
		TestBase.result("Verify closest Menu" , closestMenuObj.GetCLosestMenuPageTitle());

	}


	@Then("User Creates the menu and Check list of filters on Closest Menu screen")
	public void user_creates_the_menu_and_check_list_of_filters_on_closest_menu_screen() {

		TestBase.Logger = startTest("User Verify Filter on Closest Menu ", "Validate the Filter and CLosestMenu");

		closestMenuObj =new ClosestMenuObj(driver);
		TestBase.result("Check ClosestMenu Filters" , closestMenuObj.VerifyClosestMenuPageFilter());
	}


	@Then("User Verify Filters are reset to there default filters")
	public void user_verify_filters_are_reset_to_there_default_filters() {


		TestBase.Logger = startTest(" Check after clicking on 'Reset' button all the filters should get cleared and enabled ", "Validate the Reset Filter");
		closestMenuObj =new ClosestMenuObj(driver);
		TestBase.result("Check Functionality of Resest Filters" , closestMenuObj.Verify_Filters_are_reset_to_there_default_filters());
	}

	@Then("User Verify  Search button functionality")
	public void user_verify_search_button_functionality() {

		TestBase.Logger = startTest(" Check Functionality of Search Buttons  ", "Validate the Search button functionality");
		closestMenuObj =new ClosestMenuObj(driver);
		TestBase.result("Check Functionality of Search Filter" , closestMenuObj.Verify_Search_Filter_Result());
	}

	@Then("User Verify CLosestMenu CopyFunctionality")
	public void user_verify_c_losest_menu_copy_functionality() {

		TestBase.Logger = startTest(" Check ClosestMenu Copy Function ", "Validate the Copy Menu functionality");
		closestMenuObj =new ClosestMenuObj(driver);
		TestBase.result("Check User is able to Copy Closest Menu" , closestMenuObj.Verify_CLosestMenu_CopyFunctionality());
	}

	@Then("User Verify after creating new menu from the Closest menu screen , after editing targets and Menu name it is getting updated")
	public void user_verify_after_creating_new_menu_from_the_closest_menu_screen_after_editing_targets_and_menu_name_it_is_getting_updated() {

		TestBase.Logger = startTest(" Check ClosestMenu Edit Target Functionality ", "Validate the Closest Menu's Edit Target functionality");
		closestMenuObj =new ClosestMenuObj(driver);
		TestBase.result("Check User Create new menu from the Closest menu screen and  editing targets and Menu name  is getting updated" , closestMenuObj.Editing_targets_and_Menu_name_it_is_getting_updated());

	}


	@Then("User Verify the closest Menu pagination Functionality")
	public void user_verify_the_closest_menu_pagination_functionality() {
		TestBase.Logger = startTest(" Check ClosestMenu Pagination Functionality ", "Validate the Closest Menu's Pagiantion Test Case");
		closestMenuObj =new ClosestMenuObj(driver);
		TestBase.result("Check User  is able to Navigate to different pages and Verify Other Pagination Features" , closestMenuObj.Verify_Pagination_closestMenu());

	}


	@Then("User Verify Summary Report open in new tab")
	public void user_verify_summary_report_open_in_new_tab() {

		TestBase.Logger = startTest(" Check ClosestMenu Report Functionality ", "Validate the Closest Menu's Pagiantion Test Case");
		closestMenuObj =new ClosestMenuObj(driver);
		TestBase.result("Check User  is able to Navigate to New opened repoert" , closestMenuObj.VerifySummaryReportClosestMenu());


	}


	@Then("User Verify  CasseroleSearch button functionality")
	public void user_verify_casserole_search_button_functionality() {
		TestBase.Logger = startTest(" Check ClosestMenu Report Functionality ", "Validate the Closest Menu's Pagiantion Test Case");
		closestMenuObj =new ClosestMenuObj(driver);
		TestBase.result("Check User  is able to Search with Given Values" , closestMenuObj.Verify_Casserrole_Filter_Result());

	}
}
