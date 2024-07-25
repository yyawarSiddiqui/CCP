
package PageObjects;

import java.util.List;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.TestBase;

public class MenuReviewObj extends TestBase{

	public WebDriver driver;
	MenuGrid menugrid;
	DefineTheTarget dtt;

	public MenuReviewObj(WebDriver driver) {

		this.driver=driver;

	}

	private static final String  MenuReviewButton="//li//span[text()='Menu Review']";
	private static final String Loader1="//span[@class='pwm-spinner-message']//span[text()='Loading...']";
	private static final String LoaderGlobal="//span[@class='pwm-spinner-message']";
	private static final String  MenuAnalysisButton="//li//span[text()='Menu Analysis']";
	private static final String  RegionNameColumn="//th//button[text()='Region Name']";
	private static final String  MenuNamedata="//table//th//button[ .='Menu Name']/following::*//td[2]//a";
	private static final String  Visibletable="//table//tr[1]//td[2]";
	private static final String  SearchMenuReview="//button[.='Search']";
	private static final String  UpdatedRegionNameMenu="//button[.='Region Name']/../../../..//tr[1]//td[3]";
	
	
	
	public Boolean clickonMenuReview() {

		try {
			driver.findElement(By.xpath(MenuReviewButton)).click();
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;


	} 

	public Boolean clickonMenuAnalysisButton() {

		try {
			
			InvisibilityofElement(LoaderGlobal, 20);
			driver.findElement(By.xpath(MenuAnalysisButton)).click();
			VisibilityofELement(Loader1, 4);
			InvisibilityofElement(Loader1, 20);
			return true;
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;


	} 

	public Boolean VerifyRegionNameisDisplayed() {

		 Boolean isRegionNameVisible=VisibilityofELement(RegionNameColumn, 20);

		if (isRegionNameVisible==true) {
			
			return true;
			
		} else {

			return false;
		}


	} 
	

	public Boolean UpdateRegionNameandVerify() {

		try {
			menugrid=new MenuGrid(driver);
			dtt=new DefineTheTarget(driver);
			VisibilityofELement(Visibletable, 20);
			List<WebElement> elems=driver.findElements(By.xpath(MenuNamedata));
			for(WebElement ele:elems) {
				ele.click();
				break;
			}
			VisibilityofELement(LoaderGlobal, 4);
			InvisibilityofElement(LoaderGlobal, 20);
			
			menugrid.ClickKPIArrowDown();
			menugrid.ClickEditTargetButton();
			VisibilityofELement(LoaderGlobal, 4);
			InvisibilityofElement(LoaderGlobal, 20);
			dtt.selectRegion();
			dtt.click_SaveButton();
			String UpdatedRegionName=dtt.RegionNameText;
			click(SearchMenuReview);
			VisibilityofELement(Loader1, 2);
			InvisibilityofElement(Loader1, 40);
			if (Element(UpdatedRegionNameMenu).getText().equalsIgnoreCase(UpdatedRegionName)) {
				
				return true;
				
			} else {

				return false;
			}
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;


	} 

}
