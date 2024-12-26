package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	WebDriver ldriver;
	
	public LoginPageObjects(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	
	@FindBy(id = "user-name") WebElement username;
	
	@FindBy(id = "password") WebElement password;
	
	@FindBy(id = "login-button") WebElement loginBtn;
	
	
	public void enterUsername(String uName)
	{
		username.sendKeys(uName);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
	
	
}
