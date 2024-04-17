
  package PageObjects;
  
  import org.openqa.selenium.By; 
  import org.openqa.selenium.WebDriver;
  
  public class loginpage {
  
  public WebDriver driver;
  
  public loginpage(WebDriver driver) {
  
  this.driver=driver;
  
  }
  
  private static final String
  Login="//div[@class=\"loginButton\"]//a[text()=\"Login\"]";
  
  public Boolean click() {
  
  driver.findElement(By.xpath(Login)).click();
return true;
  
  
  } }
 