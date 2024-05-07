package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.TestBase;

public class ClosestMenuObj extends TestBase {

	public  WebDriver driver;
	DefineTheTarget defineTheTarget;
	Rules rules;
	TraditionalMenu traditionalMenu;

	public  ClosestMenuObj(WebDriver driver) {

		this.driver=driver;

	}


	private static final String Search_Closeset="//button[@type='button' and text()='Search']";
	private static final String Menu_Place="//input[@id=\"MenuName\" and @maxlength='40']"; 
	private static final String Total_Filters="//select[@class='dropdown ' ]/..";
	private static final String Total_Filters_Disabled="//div[@class='row select_box_wapper w-100']";
	private static final String Reset="//button[@type='button' and text()='Reset']";
	
	

	public WebElement GetClosestMenuFilter(int i) {

		String DropDownTitle="//select[@id='dropwown - "+i+"']";

		return Element(DropDownTitle);

	}
	
	public String GetValuesFilter(int i) {

		String DropDownTitle="//select[@id='dropwown - "+i+"']/following-sibling::*[1]";

		return  DropDownTitle;

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
		
		List<String> NumberofCycleWeeksDropDownActual=new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8"));

		defineTheTarget=new DefineTheTarget(driver); 
		rules=new Rules(driver);
		traditionalMenu=new TraditionalMenu(driver);
		
		try {
			
			defineTheTarget.Create_Menu_For_Closest(); 
			rules.Click_On_CreateMenu();
			rules.Click_to_BuildCLosestMenu();
			VisibilityofELement(Search_Closeset, 10);
              

			if(VerifyTotalClosestMenuFilter()==true) {

				TestBase.result("All Closest Menu Search Filter is available", true); 
				

			}
			
			else {
				 return false;
			}

			Boolean Val1=Element(Menu_Place).isDisplayed(); 
			String Max_Menu_Length=Element(Menu_Place).getAttribute("maxlength");

			if(Val1==true && Max_Menu_Length.equalsIgnoreCase("40")) {

					
				TestBase.result("MenuName Field is Verified", true); 
				

			}
			
			else {
				
				 return false;
			}
			
			Sendval(Menu_Place, prop.getProperty("MenuName"));
			click(Search_Closeset);
			Boolean Val2=Element(Total_Filters_Disabled).isDisplayed();
			Boolean Val3=traditionalMenu.GetFirst_Menu_Name(1).isDisplayed();
			
            if(Val2==true && Val3==true) {
            	
            	TestBase.result("Menu name filter functionality is verified", true); 
				
            }
            
        	else {
				 return false;
			}
            
          
          click(Reset);  
          
         String NumberofCycleWeeks= GetValuesFilter(0); //Number of Cycle Weeks
         List<String> NumberofCycleWeeksDropDown = GetDropDownOptions(NumberofCycleWeeks);  
          
         compareLists(NumberofCycleWeeksDropDown, NumberofCycleWeeksDropDownActual);
        	    
        	
		} 
		
		catch (InterruptedException e) {

			e.printStackTrace(); 
			
			return false;
             
		}
		return false;
		

	}
	


}
