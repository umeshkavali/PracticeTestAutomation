package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='username']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement btnLogIn;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement btnLogout;
	
	public void serUserName(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickLogIn()
	{
		btnLogIn.click();
	}
	
	public void clickLogout()
	{
		btnLogout.click();
	}
}
