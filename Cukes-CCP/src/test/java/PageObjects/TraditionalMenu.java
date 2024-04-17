package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.TestBase;

public class TraditionalMenu extends TestBase{

public  WebDriver driver;
CCPMenu ccp;

	
	public TraditionalMenu(WebDriver driver) {
		
	this.driver=driver;
	
	}
	
	
private static final String Add="//button[@type='button' and text()='Add']";
private static final String Serach="//button[@type='button' and text()='Search']";
private static final String Clearbtn="//button[@type='button' and text()='Clear All']";
private static final String Menu_Box="//input[@class='pwm-input-control']";
private static final String Menu_Table_value="//table[@class='search-result']//tr//td[1]//p";
private static final String Loader="//span[@class='pwm-spinner-message']";
private static final String Heading_Rules_Page="//h2[@class='mb-0' and text()='Product Requirements & Restrictions']";
private static final String Save="//button[@type='button' and text()='Save']";
private static final String Nutmeg_Radio_No="(//span[@class='radiobtn'])[2]";
private static final String Edit_Menu="//h2[@class='header-info-label' and text()='Edit Menu']";
private static final String Edit_Rules="//button[@type='button' and text()='Edit Rules']";



public  boolean clickonAdd() {
	
	VisibilityofELement(Add, 8);
	jsClick(Add);
	return true;
	
}


public  boolean Validate_Menucreated() {
	
	DefineTheTarget dt=new DefineTheTarget(driver);
	try {
		ccp=new CCPMenu(driver);
		
		String Menu_Name=dt.Create_Menu();
		ccp.clickonTraditional_Menus();
		Sendval(Menu_Box, Menu_Name);
		InvisibilityofElement(Loader, 10);
		click(Serach);
	    VisibilityofELement(Menu_Table_value, 8);	
		boolean val=Element(Menu_Table_value).getText().equalsIgnoreCase(Menu_Name);
		
		if(val==true) {
			TestBase.result("Validate Menu created is Verified on Search Page", val);
			
			return true;
		}
		
		
	} catch (InterruptedException e) {
		
		e.printStackTrace();
		
	}
	return false;
	
	
	
}

public  boolean Validate_RulePage_Title() {
	
	DefineTheTarget dt=new DefineTheTarget(driver);
	try {
		dt.Create_Menu();
		boolean val=VisibilityofELement(Heading_Rules_Page, 8);
		if(val==true) {
			
	          return val;		
		}
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	}
	return false;
	
}


public  boolean Validate_rules_are_saved() {
	
	DefineTheTarget dt=new DefineTheTarget(driver);
	try {
		dt.Create_Menu();
		InvisibilityofElement(Loader, 10);
		click(Nutmeg_Radio_No);
		click(Save);
		InvisibilityofElement(Loader, 10);
		return true;
		
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	}
	return false;
	
}

public  boolean Validate_EditMenu_Title() throws InterruptedException {
	
	InvisibilityofElement(Loader, 10);
	click(Serach);
	InvisibilityofElement(Loader, 10);
	WebElement Ele=ListWebElement(Menu_Table_value).get(0);
	Ele.click();
	InvisibilityofElement(Loader, 10);
	if (VisibilityofELement(Edit_Menu, 10)==true) {
		return true;
	}
	return false;
	
	
}


public  boolean Validate_EditRules_Page()  {
	
	InvisibilityofElement(Loader, 10);
	click(Serach);
	InvisibilityofElement(Loader, 10);
	WebElement Ele=ListWebElement(Menu_Table_value).get(0);
	Ele.click();
	InvisibilityofElement(Loader, 10);
	click(Edit_Rules);
	if (VisibilityofELement(Heading_Rules_Page, 10)==true) {
		return true;
	}
	return false;
	
	
}

}
