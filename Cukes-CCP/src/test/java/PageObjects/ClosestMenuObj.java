package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.TestBase;

public class ClosestMenuObj extends TestBase {

	public  WebDriver driver;
	DefineTheTarget defineTheTarget;
	Rules rules;

	public  ClosestMenuObj(WebDriver driver) {

		this.driver=driver;

	}


	private static final String Search_Closeset="//button[@type='button' and text()='Search']";
	private static final String Menu_Place="//input[@id=\"MenuName\" and @maxlength='40']"; 
	private static final String Total_Filters="//select[@class='dropdown ' ]/..";


	public WebElement GetClosestMenuFilter(int i) {

		String DropDownTitle="//select[@id='dropwown - "+i+"']";

		return Element(DropDownTitle);


	}

	public boolean VerifyTotalClosestMenuFilter() {

		int Total_DropDown=ListWebElement(Total_Filters).size();

		Boolean AllElementPresent=false;

		if (Total_DropDown <= 25) {
			
			for (int i = 0; i < Total_DropDown; i++) {
				
				if (!GetClosestMenuFilter(i).isDisplayed()) 
				
				{
					AllElementPresent = false;
					break; 
				} 
				else {
					AllElementPresent = true;
				}
			}
			return AllElementPresent;
		}

		return false;
	}





	public boolean GetCLosestMenuPageTitle() {

		defineTheTarget=new DefineTheTarget(driver);
		rules=new Rules(driver);
		try {
			defineTheTarget.Create_Menu();
			rules.Click_On_CreateMenu();
			rules.Click_to_BuildCLosestMenu();
			return VisibilityofELement(Search_Closeset, 10);


		} catch (InterruptedException e) {

			e.printStackTrace();
		}



		return false;
	}



	public boolean VerifyClosestMenuPageFilter() {

		defineTheTarget=new DefineTheTarget(driver); 
		rules=new Rules(driver);
		try {
			String Menu_Name=defineTheTarget.Create_Menu_For_Closest(); 
			rules.Click_On_CreateMenu();
			rules.Click_to_BuildCLosestMenu();
			VisibilityofELement(Search_Closeset, 10);


			if(VerifyTotalClosestMenuFilter()==true) {

				TestBase.result("All Closest Menu Search Filter is available", true); 

			}

			Boolean Val1=Element(Menu_Place).isDisplayed(); 
			String Max_Menu_Length=Element(Menu_Place).getAttribute("maxlength");

			if(Val1==true && Max_Menu_Length.equalsIgnoreCase("40")) {

				//	Sendval(Menu_Place, Menu_Name);
				TestBase.result("MenuName Field is Verified", true); 

			}


		} catch (InterruptedException e) {

			e.printStackTrace(); 

		}



		return true;

	}

}
