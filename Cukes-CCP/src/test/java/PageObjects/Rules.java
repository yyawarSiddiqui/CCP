package PageObjects;

import org.openqa.selenium.WebDriver;

import StepDefinitions.TestBase;

public class Rules extends TestBase {
	
	public  WebDriver driver;
	
	public Rules(WebDriver driver) {

		this.driver=driver;
		
	}
	
	private static final String Create_Menu_Rules="//button[@type='button' and text()='Create Menu']";
	private static final String Loader_CreateMenu="//span[@class='pwm-spinner-message']//span[text()='Loading Menu Items...']";
	private static final String Build_closeset_Menu="//span[contains(text(),'I want to build a menu by using an existing menu, which is close to the target')]";
	
	
	
	
	
	public boolean Click_On_CreateMenu() {
		
		jsClick(Create_Menu_Rules);
		InvisibilityofElement(Loader_CreateMenu, 40);
		TestBase.result("Create Menu is Successfully Clicked" , true);
		return true;
		
		
	}
	
public boolean Click_to_BuildCLosestMenu() {
		
		jsClick(Build_closeset_Menu);
		InvisibilityofElement(Loader_CreateMenu, 20);
		TestBase.result("Clickk to Build Closest Menu Is Successfully Clicked" , true);		
		return true;
		
		
	}
	
	

}
