package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass
{
	
	public static WebDriver driver;
    public static Properties p;
  	     
public static WebDriver initilizeBrowser() throws IOException
{
	
	if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
	{

		switch(getProperties().getProperty("browser").toLowerCase()) 
		{
		
		case "chrome":
	        driver=new ChromeDriver(); break;
	    case "edge":
	    	driver=new EdgeDriver(); break;
	    case "firefox":
	    	driver = new FirefoxDriver(); break;

	    default:
	        System.out.println("No matching browser");
		}
	
	}
	
	 driver.manage().deleteAllCookies(); 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	 return driver;
	 
}

public static WebDriver getDriver() 
{
	return driver;
}
	

public static Properties getProperties() throws IOException
{		 
    FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
   		
    p=new Properties();
	p.load(file);
	return p;
}

public void waitForElementToBeClickable(int time, WebElement locator) 
{
    new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.elementToBeClickable(locator));
}

public void waitForElementToBePresent(int time, WebElement locator) 
{
    new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(locator));
}

public void waitUntilElementNotDisplayed(int time, WebElement locator) 
{
    new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.invisibilityOf(locator));
}

}
