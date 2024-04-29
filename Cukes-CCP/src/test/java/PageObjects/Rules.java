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
	
	
	
	
	public boolean Click_On_CreateMenu() {
		
		jsClick(Create_Menu_Rules);
		InvisibilityofElement(Loader_CreateMenu, 40);
				
		return true;
		
		
	}
	
	

}
