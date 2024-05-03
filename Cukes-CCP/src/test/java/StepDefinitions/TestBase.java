package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentReport;
import static utils.generateString.*;

public class TestBase {

	private static WebDriver driver;
	static ExtentTest  Logger;
	public  static Properties prop=new Properties();
	public static FileInputStream fs ;
	InputStream data;
	 public static JSONObject Value;
	
	
@Before
public void setup() throws Exception { 
		
	 fs = null;
	 String QaURL = null;
	 
	 try {
		 
		 String dataFileName = "data/TestData.json";
		data= getClass().getClassLoader().getResourceAsStream(dataFileName);
		JSONTokener tokener=new JSONTokener(data);
		Value=new JSONObject(tokener);
      // System.out.println(Value.getJSONObject("TraditionalMenu").toString());		
		
	 }catch(Exception e) {
		 
		 e.printStackTrace();
	 }finally {
		 
		 if(data!=null) {
			 data.close();
		 }
		 
	 }
	 
	 
	 
	try {
		fs = new FileInputStream(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"data"+File.separator+"config.properties");
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	}
	
	try {
		prop.load(fs);
		  QaURL=prop.getProperty("url");
	} catch (IOException e) {

		e.printStackTrace();
	}
	   if(driver==null ) {
		   
			   WebDriverManager.chromedriver().setup(); 
				driver= new ChromeDriver(); 
				driver.get(QaURL);
				driver.manage().window().maximize();
			
	   }
		
	}

	@After
	public void teardown() { 
		if (driver != null) 
		{ 
			driver.quit();
			driver=null;
			
	}
		}
	
	public static WebDriver getDriver() {
		
		return driver;
	}

	
public void  Sleep(int i) throws InterruptedException {
		
		Thread.sleep(i);
	}
	
	public static void result(String msg,Boolean data) {
	
		try {
			if (data==true) {
				msg = msg + " -  Passed";
					Logger.log(Status.PASS, MarkupHelper.createLabel(msg, ExtentColor.GREEN));
				}
			 else if (data==false) {
				
				// if(screenshotEnabled) {
				String screenshot = TestBase.getScreenshot(TestBase.getDriver());
				Logger.fail(msg, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
				
			}
		} catch (Exception e) {
			String screenshot = TestBase.getScreenshot(TestBase.getDriver());
			Logger.fail(msg, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
			e.printStackTrace();
		} 
	
		ExtentReport.extent.flush();
		
	}
	
	private static String getScreenshot(WebDriver driver2) {
		
		String screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return screenshot;
	}

	public static boolean VisibilityofELement(String Ele, long Time) {

		try {
			WebDriverWait Mywait = new WebDriverWait(driver, Duration.ofSeconds(Time));
			Mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Ele)));
			return true;
		} catch (Exception e) {

			return false;

		}
		

	}
	public static void jsClick(String Elem) {
	
		VisibilityofELement(Elem, 15);
		WebElement Ele =driver.findElement(By.xpath(Elem));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Ele);
	         	
	}
	
	public  boolean click(String Ele) {
		
		VisibilityofELement(Ele, 8);
		driver.findElement(By.xpath(Ele)).click();
		return true;
		
	}
	
public static WebElement Element(String Ele) {
	
		VisibilityofELement(Ele, 7);
		WebElement Element=driver.findElement(By.xpath(Ele));
		return Element;
		
	}

public static List<WebElement> Elements(String Ele) {
	
	VisibilityofELement(Ele, 7);
	List<WebElement> Elements=driver.findElements(By.xpath(Ele));
	return Elements;
	
}

public static List<String> ListStringElements(String Ele) {
	
	List<WebElement> Elements=driver.findElements(By.xpath(Ele));
	
	
	List<String> list_Text=new ArrayList<String>();
        
	for(WebElement Element:Elements) {
		
		String Text=Element.getText();
		//System.out.println(Text);
		list_Text.add(Text);
	}
	// Convert the set to a list
  //  List<String> textList = new ArrayList<>(list_Text);
    // Return the list of unique text values
	
    return list_Text;
	
}

public static List<WebElement>  ListWebElement(String Ele) {
	
	List<WebElement> Elements=driver.findElements(By.xpath(Ele));
	
	
	
	List<WebElement> resultList = new ArrayList<>();
        
	for(WebElement Element:Elements) {
		
		resultList.add(Element);
	}
    
    return resultList;
	
}
	
	public String getTitle() {
		
		String Pagetitle=driver.getTitle();
		return Pagetitle;
		
		
	}
	
	public Boolean SelectDropDown(String Elem , String value)  {
		
		VisibilityofELement(Elem, 5);
		WebElement Element=driver.findElement(By.xpath(Elem));
		jsClick(Elem);
		Select sc=new Select(Element);
		sc.selectByValue(value);
		return true;
		
			
	}
	
public WebElement GetSelectedDropDown(String Elem )  {
		
		VisibilityofELement(Elem, 20);
		WebElement Element=driver.findElement(By.xpath(Elem));
		Select sc=new Select(Element);
		WebElement SelctedElement=sc.getFirstSelectedOption();
		return SelctedElement;
		
			
	}

public List<String> GetDropDownOptions(String Elem )  {
	
	List<String> New_List=new ArrayList<String>();
	VisibilityofELement(Elem, 5);
	WebElement Element=driver.findElement(By.xpath(Elem));
	Select sc=new Select(Element);
	List<WebElement> AllElement=sc.getOptions();
	for(WebElement SingleElement:AllElement) {
		
		String TextDropDown=SingleElement.getText();
		New_List.add(TextDropDown);
		
		
	}
		
	return New_List;
	
		
}

	public String SendText(String Elem) throws InterruptedException {
		
		String Name=RandaomName();
		VisibilityofELement(Elem, 10);
		driver.findElement(By.xpath(Elem)).sendKeys(Name);
		return Name;
		
	}
	
public void Sendval(String Elem, String Values) throws InterruptedException {
		
		driver.findElement(By.xpath(Elem)).sendKeys(Values);;
		
		
	}
	
	public boolean InvisibilityofElement(String Ele, long Time) {
		
		try {
			WebDriverWait Mywait = new WebDriverWait(driver, Duration.ofSeconds(Time));
			Boolean val=Mywait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Ele)));
			return val;
			
		} catch (Exception e) {

			return false;

		}
	}	

	
}
