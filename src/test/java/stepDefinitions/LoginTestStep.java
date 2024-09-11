package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.BasePage;
import pageObjects.LoginPage;

public class LoginTestStep
{
//	public WebDriver driver;
	public LoginPage lp;
	
	
	@Given("User navigates to Login Page")
	public void user_navigates_to_login_page() 
	{
		lp=new LoginPage(BaseClass.getDriver());
	}
	
	
	@Then("User should enter the username as {string}")
	public void user_should_enter_the_username_as(String mail) 
	{
		lp = new LoginPage(BaseClass.getDriver());				
	    lp.serUserName(mail);
	}

	@Then("User should enter the password as {string}")
	public void user_should_enter_the_password_as(String pwd) 
	{		
		lp = new LoginPage(BaseClass.getDriver());				
	    lp.setPassword(pwd);
	}

	@Then("User should click on Submit button")
	public void user_should_click_on_submit_button() 
	{
	   lp.clickLogIn();
	}

	@Then("User should verify the URL as practicetestautomation logged in successfully")
	public void user_should_verify_the_url_as_practicetestautomation_logged_in_successfully()
	{
		
		String actual_Url = BaseClass.getDriver().getCurrentUrl();
		String expected_Url = "https://practicetestautomation.com/logged-in-successfully/";
		Assert.assertEquals(actual_Url, expected_Url);
		System.out.println("URL is Successfully verified");
				
//		if(BaseClass.getDriver().getCurrentUrl().equals("https://practicetestautomation.com/logged-in-successfully/"))
//		{
//			System.out.println("URL Verified Successfully!");
//		}
//		
//		else
//		{
//			System.out.println("Couldn't be able to verify the URL");
//		}		

	}

	@Then("User should verify the text as Congratulations or successfully logged in")
	public void user_should_verify_the_text_as_congratulations_or_successfully_logged_in()
	{
	    String actual_text = BaseClass.getDriver().findElement(By.xpath("//strong[contains(text(),'Congratulations student. You successfully logged i')]")).getText();
	    String expected_text = "Congratulations student. You successfully logged in!";
	    
	    if(actual_text.equals(expected_text))
	    {
	    	System.out.println("Verified the Text Successfully");
	    }
	    
	    else
	    {
	    	System.out.println("Couldn't not be able to Verified the Text");
	    }
	}

	@Then("User should verify the Logout displayed on the page")
	public void user_should_verify_the_logout_displayed_on_the_page() 
	{
	    boolean logout = BaseClass.getDriver().findElement(By.xpath("//a[normalize-space()='Log out']")).isDisplayed();
	    System.out.println("Logout button Display Status is:"+logout);
	}

	
	
	@Then("User should click on Logout button")
	public void user_should_click_on_logout_button() 
	{
	   lp.clickLogout();
	}

	@Then("Finally User should click on close the browser")
	public void finally_user_should_click_on_close_the_browser() 
	{
		BaseClass.getDriver().quit();
	}
}
