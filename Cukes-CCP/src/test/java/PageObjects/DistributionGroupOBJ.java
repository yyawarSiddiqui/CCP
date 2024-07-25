
package PageObjects;

import org.openqa.selenium.WebDriver;

import StepDefinitions.TestBase;
import utils.RandomStringGenerator;

public class DistributionGroupOBJ extends TestBase {

	public WebDriver driver;
	public static String PC="";

	public DistributionGroupOBJ(WebDriver driver) {

		this.driver=driver;

	}

	private static final String
	CreateDistGrp="//button//span[.='+ Create Distribution Group']";

	private static final String CreateDistGrpInputBox="//input[@placeholder='Enter Group Name']";
	private static final String CreateDistGrpButton="//button[.='Create']";
	private static final String AddProfitcenterLink="//p//a[.='Add Profit Center']";
	private static final String SearchProfitsiteinput="//label[.=' Site/PC:']/../..//input[@type='text']";
	private static final String SearchProfitsiteinputSearchButton="//label[.=' Site/PC:']/../..//input[@type='text']/..//div";
	private static final String LoaderGLobal="//span[@class='pwm-spinner-message']";
	private static final String SelectProfitsiteCheckBox="//input[@id='PCID_0']";
	private static final String SaveProfitsiteCheckBox="//button[@type='button']//span[.='Save and Return']";
	private static final String SaveDistGrp="//button[@type='button']//span[.='Save']";
	

	
	public Boolean clickCreateDistGrp() {

		click(CreateDistGrp);
		return true;


	} 


	public Boolean EnterdistgrpName() {

		try {
			
			 PC=RandomStringGenerator.generateRandomString(5);
			Sendval(CreateDistGrpInputBox, PC);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return true;


	} 

	public Boolean clickCreateDistGroup() {

		click(CreateDistGrpButton);
		return true;


	} 

	public Boolean clickAddProfitcenter() {

		jsClick(AddProfitcenterLink);
		return true;

	} 

	public Boolean EnterSiteSearchprofitandSearch() {

		try {
			Sendval(SearchProfitsiteinput, "ABB");


		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return true;


	} 


	public Boolean clickSearchProfitCenter() {

		click(SearchProfitsiteinputSearchButton);
		VisibilityofELement(LoaderGLobal, 2);
		InvisibilityofElement(LoaderGLobal, 20);
		return true;


	} 

	public Boolean SelectProfitsiteCheckBox() {

		click(SelectProfitsiteCheckBox);
		click(SaveProfitsiteCheckBox);
		VisibilityofELement(LoaderGLobal, 2);
		InvisibilityofElement(LoaderGLobal, 20);
		jsClick(SaveDistGrp);
		VisibilityofELement(LoaderGLobal, 2);
		InvisibilityofElement(LoaderGLobal, 20);
		return true;


	} 








}


