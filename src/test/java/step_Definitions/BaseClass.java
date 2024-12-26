package step_Definitions;

import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.*;
import page_Objects.CartPageObjects;
import page_Objects.LoginPageObjects;
import page_Objects.MainPageObjects;
import utilities.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver;
	
	public LoginPageObjects loginPg;
	public MainPageObjects mainPg;
	public CartPageObjects cartPg;
	
	public static Logger log;
	
	public ReadConfig readConfig;
	

	
	
}
