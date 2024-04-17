package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import StepDefinitions.TestBase;

public class Modules extends TestBase {

public WebDriver driver;
	
	public Modules(WebDriver driver) {
		
	this.driver=driver;
	
	}
	
	
	private static final String Menu="//div[@class='tile menus']";
	private static final String  Recipes="//div[@class='tile recipes']";
	private static final String  Nutrition="//div[@class='tile nutrition']";
	private static final String  NewRecipes="//div[@class='tile newrecipes']";
	private static final String  Products="//div[@class='tile product']";
	private static final String  ingredientTransparency="//div[@class='tile ingredientTransparency']";
	private static final String  LocationPermission="//div[@class='tile location']";
	private static final String  AdministrationandSupport="//div[@class='tile global-config']";
	private static final String  Notifications="//a[@id='notifications-link']//span[contains(text(),'Notifications') ]";
	private static final String  Logout="	//a[@class='notif-link' and text()='Logout']";
	private static final String  Dashboard="//div[@id=\"nav-icon\"]/..";
	
	
	
	public Boolean clickonMenu() {
	           
		VisibilityofELement(Menu,7);
		 driver.findElement(By.xpath(Menu)).click();
		 return true;
	}
	
	
}
