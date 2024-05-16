package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.TestBase;

public class IBAobj extends TestBase {

	public  WebDriver driver;
	DefineTheTarget defineTheTarget;
	Rules rules;
	TraditionalMenu traditionalMenu;

	public  IBAobj(WebDriver driver) {

		this.driver=driver;

	}


	private static final String IBATitle="//span[contains(text(),'Ingredient Based Analysis')]";
	private static final String General_Item="//input[@type='search'  or @placeholder='General Item (GI)']";
	private static final String AllCheckboxGI="//div[@class='cstm-checkbox']/..";
	private static final String Loader="//span[@class='pwm-spinner-message']//span[text()='Loading Menu Items...']";
	private static final String SearchListText="//ul//li//span";
	private static final String Loader1="//span[@class='pwm-spinner-message']//span[text()='Loading...']";



	public WebElement GetCheckboxGI(int i) {

		String CheckboxGI="//input[@type='checkbox' and @id='A"+i+"']";

		return Element(CheckboxGI);
	}


	public boolean ValidateUI_IBA() {


		try {

			InvisibilityofElement(Loader1, 8);
			if( (VisibilityofELement(IBATitle, 10)==true &&
					VisibilityofELement(General_Item, 10)==true ))
			{
				TestBase.result("Verifed IBA Page and General_Item Serach is visible", true);
			}

			else {

				return false ;
			}

			if (GetCheckboxGI(1).isSelected()==true && Element(AllCheckboxGI).isDisplayed()==true ) {

				TestBase.result("Verifed Enable Checkbox is selected By Default", true);

			} else {

				return false ;
			}

			return true;


		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;
	}


	public Boolean GISerchFilter() {


		try {
			prop.load(fs);
			String SearchValue=prop.getProperty("GeneralItemValue");
			Boolean Val2=Sendval(General_Item, SearchValue);
			InvisibilityofElement(Loader, 10);

			if (Val2==true) {

				TestBase.result("Verifed The general item list should get populated after entering 3 chars", true);

			} else {

				return false;

			}

			VisibilityofELement(SearchListText, 10);
			List<String> Complete_Text_List=ListStringElements(SearchListText);

			
			Boolean Val=false;
			for(int i=0; i<Complete_Text_List.size();i++) {

				Val=Complete_Text_List.get(i).contains(SearchValue);
				
				if(Val==false)
				{
					break;
				}
				
			}



			if (Val==true) {

				TestBase.result("Verifed General item list related to 'Given Text' should get displayed", true);

			} else {

				return false;

			}

			return true;


		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}


}
