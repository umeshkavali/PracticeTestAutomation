package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class PositiveStep 
{
	WebDriver driver;
	LoginPage lp;
	
	
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
		String actual_Title = driver.getTitle();
		
		if(actual_Title.equals("Logged In Successfully | Practice Test Automation"))
		{
			System.out.println("Title Validated Successfully");
		}
		
		else
		{
			System.out.println("Couldn't validate the Title");
//			driver.close();
		}
	}

	@Then("User should verify the text as Congratulations or successfully logged in")
	public void user_should_verify_the_text_as_congratulations_or_successfully_logged_in()
	{
	    String actual_text = driver.findElement(By.xpath("//strong[contains(text(),'Congratulations student. You successfully logged i')]")).getText();
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
	    boolean logout = driver.findElement(By.xpath("//a[normalize-space()='Log out']")).isDisplayed();
	    System.out.println(logout);
	}

	
	
	@Then("User should click on Logout button")
	public void user_should_click_on_logout_button() 
	{
	   lp.clickLogout();
	}

	@Then("Finally User should click on close the browser")
	public void finally_user_should_click_on_close_the_browser() 
	{
	   driver.quit();
	}
}
