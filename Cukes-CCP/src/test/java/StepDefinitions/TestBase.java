package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
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

	public static WebDriver driver;
	static ExtentTest  Logger;
	public  static Properties prop=new Properties();
	public static FileInputStream fs ;
	InputStream data;
	public static JSONObject Value;

	public String FileDownloadPath=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"data"+File.separator+"Downloads";

	@Before
	public void setup() throws Exception { 

		fs = null;
		String QaURL = null;

		// Set up Chrome options
		ChromeOptions options = new ChromeOptions();

		// Set custom download directory
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory",FileDownloadPath);
		prefs.put("download.prompt_for_download", false);
		options.setExperimentalOption("prefs", prefs);
		//options.addArguments("--headless");

		// Disable Safe Browsing 
		options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://172.20.22.23:81/PRIMAWebMaster/Pages/Menus/MenuIngredientBasedAnalysis.aspx");




		// Set the custom download directory
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.dir", FileDownloadPath);
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf"); // Set MIME types you want to download automatically
		profile.setPreference("pdfjs.disabled", true); // Disable PDF viewer

		// Disable Safe Browsing
		profile.setPreference("browser.safebrowsing.enabled", false);
		profile.setPreference("browser.safebrowsing.malware.enabled", false);

		// Add arguments
		FirefoxOptions optionsfirefox = new FirefoxOptions();
		optionsfirefox.setProfile(profile);
		optionsfirefox.addPreference("network.trr.mode", 2);
	//	options.addArguments("--headless"); // Uncomment this if you want to run in headless mode
		optionsfirefox.addArguments("--unsafely-treat-insecure-origin-as-secure=http://172.20.22.23:81/PRIMAWebMaster/Pages/Menus/MenuIngredientBasedAnalysis.aspx");


		// System.out.println(Value.getJSONObject("TraditionalMenu").toString());		


		try {

			String dataFileName = "data/TestData.json";
			data= getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener=new JSONTokener(data);
			Value=new JSONObject(tokener);

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
		if(driver==null && "chrome".equalsIgnoreCase(prop.getProperty("browser"))) {

			WebDriverManager.chromedriver().setup(); 
			driver= new ChromeDriver(options); 
			driver.get(QaURL);
			driver.manage().window().maximize();

		}

		else if(driver==null && "firefox".equalsIgnoreCase(prop.getProperty("browser"))) {

			WebDriverManager.firefoxdriver().setup(); 
			driver= new FirefoxDriver(optionsfirefox); 
			driver.get(QaURL);
			driver.manage().window().maximize();
		}

		else if(driver==null && "edge".equalsIgnoreCase(prop.getProperty("browser"))) {

			WebDriverManager.edgedriver().setup(); 
			driver= new EdgeDriver(); 
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

	public static boolean VisibilityofWebELement(WebElement Elem, long Time) {

		try {
			WebDriverWait Mywait = new WebDriverWait(driver, Duration.ofSeconds(Time));
			Mywait.until(ExpectedConditions.visibilityOf(Elem));
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

		try {
			VisibilityofELement(Ele, 20);
			driver.findElement(By.xpath(Ele)).click();
			return true;

		} catch (Exception e) {

			try {
				driver.findElement(By.xpath(Ele)).click(); //Retry
				return true;

			} catch (Exception Retry) {
				// TODO Auto-generated catch block
				Retry.printStackTrace();
				return false;
			}

		}
	}

	public static WebElement Element(String Ele) {

		VisibilityofELement(Ele, 7);
		WebElement Element=driver.findElement(By.xpath(Ele));
		return Element;

	}

	public static List<WebElement> Elements(String Ele) {

		VisibilityofELement(Ele, 20);
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

	public static List<Integer> ListIntElements(String Ele) {

		List<WebElement> Elements=driver.findElements(By.xpath(Ele));


		List<Integer> list_Text=new ArrayList<Integer>();

		for(WebElement Element:Elements) {

			int Text=Integer.parseInt(Element.getText());
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

		VisibilityofELement(Elem, 20);
		WebElement Element=driver.findElement(By.xpath(Elem));
		click(Elem);
		Select sc=new Select(Element);
		sc.selectByValue(value);
		return true;


	}

	public WebElement GetSelectedDropDown(String Elem )  {

		VisibilityofELement(Elem, 20);
		WebElement Element=driver.findElement(By.xpath(Elem));
		Select sc=new Select(Element);
		WebElement SelectedElement=sc.getFirstSelectedOption();
		return SelectedElement;


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

		String Name=generateMenuString();
		VisibilityofELement(Elem, 10);
		driver.findElement(By.xpath(Elem)).sendKeys(Name);
		return Name;

	}

	public boolean Sendval(String Elem, String Values) throws InterruptedException {

		VisibilityofELement(Elem, 10);
		driver.findElement(By.xpath(Elem)).sendKeys(Values);
		return true;


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

	public List<WebElement> ListElementsbyWait(String Ele, long Time) {


		WebDriverWait Mywait = new WebDriverWait(driver, Duration.ofSeconds(Time));
		List<WebElement> val=Mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Ele)));
		return val;


	}	



	public static boolean compareLists(List<String> list1, List<String> list2) {
		// Check if lists have the same size
		if (list1.size() == list2.size()) {
			// Iterate through elements and compare them
			for (int i = 0; i < list1.size(); i++) {
				if (!list1.get(i).equals(list2.get(i))) {
					// If elements are not equal, return false
					return false;
				}
			}
			// If all elements are equal, return true
			return true;
		} else {
			// If sizes are different, return false
			return false;
		}
	}



	public boolean ClickAction(WebElement Elem) throws InterruptedException {

		Actions act=new Actions(driver);

		act.moveToElement(Elem).click(Elem).build().perform();

		return true;

	}


	public boolean ScrollElement(WebElement Elem) throws InterruptedException {

		Actions act=new Actions(driver);

		act.scrollToElement(Elem).build().perform();

		return true;

	}


	public boolean MoveAction(WebElement Elem) throws InterruptedException {

		Actions act=new Actions(driver);

		act.moveToElement(Elem).build().perform();

		return true;

	}



	public boolean ClickActionEnter(String Elem) throws InterruptedException {

		VisibilityofELement(Elem,10 );
		Actions act=new Actions(driver);

		act.sendKeys(Keys.ENTER).perform();

		return true;

	}

	public String GetTableValueByIndex(int r, int c)  {


		String CellValue=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td["+c+"]")).getText();

		return CellValue;

	}

	public String getCurrentURL() throws InterruptedException {

		return driver.getCurrentUrl();

	}



	public  boolean isDescendingOrder(List<Integer> list) {

		if (list == null || list.size() == 0) {
			return true; 
		}

		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) < list.get(i + 1)) {
				return false; 
			}
		}

		return true;
	}


	public  boolean isAscendingOrder(List<Integer> list) {

		if (list == null || list.size() == 0) {
			return true; 
		}

		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > list.get(i + 1)) {
				return false; 
			}
		}

		return true;
	}

	public Boolean SwitchWindow(int i)  {

		Set<String> Windows=driver.getWindowHandles();
		List<String> WinList=new ArrayList<String>(Windows);
		String Tab=WinList.get(i);
		driver.switchTo().window(Tab);
		return true;

	}

	public boolean OpenNewWindowTab()  {

		((JavascriptExecutor) driver).executeScript("window.open();");

		return true;

	} 

	public String getText(String Elem)  {

		VisibilityofELement(Elem, 10);
		String text=driver.findElement(By.xpath(Elem)).getText();

		return text;

	}



}





