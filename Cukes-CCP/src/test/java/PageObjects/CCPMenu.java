package PageObjects;

import org.openqa.selenium.WebDriver;

import StepDefinitions.TestBase;

public class CCPMenu extends TestBase{

	
public WebDriver driver;
	
	public CCPMenu(WebDriver driver) {
		
	this.driver=driver;
	
	}

	private static final String MenuOption="//span[@class='btn-role']//span[contains(text(),'Menus')]";
	private static final String StationOption="//span[@class='btn-role']//span[contains(text(),'Stations')]";
	private static final String MenuAnalysisOption="//span[@class='btn-role']//span[contains(text(),'Menu Analysis')]";
	private static final String Dashboard="//a[@class=\"page-header-option menu-items\"]//span[contains(text(),'Dashboard')]";
	private static final String IngredientTransparency="//a[@class=\"page-header-option menu-items\"]//span[contains(text(),'Ingredient Transparency')]";
	private static final String NewRecipes="//button[@type=\"button\"]//span[contains(text(),'New Recipes')]";
	private static final String Recipes="//button[@type=\"button\"]//span[text()='Recipes']";
	private static final String  Products ="//button[@type=\"button\"]//span[text()='Products']";
	private static final String  Nutrition ="//button[@type=\"button\"]//span[text()='Nutrition']";  
	private static final String  Location ="//button[@type=\"button\"]//span[text()='Location Permission']";
	private static final String Administration="//button[@type=\"button\"]//span[text()='Administration']";
	private static final String Profile="//div[@class='pwm-custom-dropdown profile-dropdown']";
	private static final String Home="//span[text()='Home']";
	private static final String Traditional_Menus="//span[text()='Traditional Menus']";
	private static final String Traditional_Stations="//span[text()='Traditional Stations']";
	private static final String Menu_Analysis="//span[text()='Menu Analysis']";
	private static final String Cost_Bucket_Maintenance="//span[text()='Cost Bucket Maintenance']";
	private static final String Reports="//span[text()='Reports']";
	private static final String Distribution_Group="//span[text()='Distribution Group']";
	
	
	
	
	
	
	
	public boolean clickonMenuOption() {
		
		
		try {
			
			VisibilityofELement(MenuOption,6);
			jsClick(MenuOption);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
public boolean clickonTraditional_Menus() {
		
		
		try {
			
			VisibilityofELement(Traditional_Menus,6);
			jsClick(Traditional_Menus);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
}
