package step_Definitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import page_Objects.CartPageObjects;
import page_Objects.LoginPageObjects;
import page_Objects.MainPageObjects;
import utilities.ReadConfig;

public class StepDef extends BaseClass {
	
	
	@Before(order=1)
	public void setUp1()
	{
		readConfig = new ReadConfig();
		
		String browserName = readConfig.getBrowser();
		
		switch (browserName.toLowerCase())
		{
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
				
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
					
			default:
				driver = null;
				break;		
		}
		
		log = LogManager.getLogger("StepDef");
		System.out.println("Set Up 1 method executed..!!");
		
		log.info("setUp_1 executed");
	}
	
	
/* 
  	@Before(order=2)
	public void setUp2()
	{
		System.out.println("Set Up 2 method executed..!!");
		
		driver = new EdgeDriver();
	}
*/	

/*	
  	@Before("@smoke")
	public void setUp1()
	{
		System.out.println("Set Up method 1 executed..!!");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Before("@regression")
	public void setUp2()
	{
		System.out.println("Set Up method 2 executed..!!");
		
		driver = new EdgeDriver();
	}
*/	
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser()
	{
	   loginPg = new LoginPageObjects(driver);
	   mainPg = new MainPageObjects(driver);
	   cartPg = new CartPageObjects(driver);
	   
	   log.info("chrome browser launched");
	}

	
	@When("User opens URL {string}")
	public void user_opens_url(String url)
	{
	    driver.get(url);
		log.info("url openend");
	}

	@When("User enters Username as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password)
	{
	    loginPg.enterUsername(username);
	    loginPg.enterPassword(password);
	    
	    log.info("username and password entered");
	}

	
	@When("Click on Login Button")
	public void click_on_login_button() 
	{
	    loginPg.clickOnLoginBtn();
	    
	    log.info("user clicked on login button");
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	    String actualTitle = driver.getTitle();
	    
	    if(expectedTitle.equals(actualTitle))
	    {
	    	log.warn("Test Passed : Login Feature : Page title matched");
	    	Assert.assertTrue(true);
	    }
	    
	    else
	    {
	    	Assert.assertTrue(false);
	    	log.warn("Test Failed : Login Feature : Page title not matched");
	    	
	    }
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}
	
	
	@When("User click on Logout button")
	public void user_click_on_logout_button() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		mainPg.clickOnBurgerMenuBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		mainPg.clickOnLogoutBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		log.info("user clicked on logout button");
	}
	

/*	@Then("close the browser")
	public void close_the_browser()
	{
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.quit();
	   
	   log.info("browser closed");
	}
*/
	
	
		//////   Add and Remove items to cart  ////////
	
	
	@When("User added Backpack to the Cart")
	public void user_added_backpack_to_the_cart() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		mainPg.addBackpackToCart();
		
		log.info("user added backpack to the cart");
	}

	@When("User added T-shirt to the Cart")
	public void user_added_t_shirt_to_the_cart()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    mainPg.addTshirtToCart();
	    
	    log.info("user added tshirt to the cart");
	}

	@When("User added Bike Light to the Cart and removed it from Cart")
	public void user_added_bike_light_to_the_cart_and_removed_it_from_cart()
	{
	   mainPg.addBikeLight_ToCart();
	   log.info("user added bike light to the cart");
	   
	   mainPg.removeBikeLight_FromCart();
	   log.info("user removed bike light to the cart");
	}

	@When("User click on Cart button to checkout the added items")
	public void user_click_on_cart_button_to_checkout_the_added_items() 
	{
	   mainPg.clickOnCartBtn();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   
	   cartPg.verifyCartText();
	   
	   log.info("user click on cart");
	}

	@Then("User verified the items {string} and {string} has been added to Cart.")
	public void user_verified_the_items_and_has_been_added_to_cart(String product1, String product2)
	{
	   cartPg.verifyBackpackInCart(product1);
	   cartPg.verifyTshirtInCart(product2);
	   
	   log.info("cart items are correct");
	}
	
	
	
		///////  Add Jacket to the cart  ////////
	
	
	@When("User click on Filter Dropdown")
	public void user_click_on_filter_dropdown() 
	{
	   mainPg.clickOnDropdown();
	   log.info("user clicked on dropdown");
	}

	@When("User selected Price\\(high to low) option")
	public void user_selected_price_high_to_low_option()
	{
	   mainPg.selectDropdownOptn();
	   log.info("user selected the high to low filter option");
	}


	@When("User click on Jacket")
	public void user_click_on_jacket()
	{
		mainPg.addJacket_ToCart();
		log.info("user added jacket on cart");
	}
	
	@Then("User verified the Jacket has been added to Cart.")
	public void user_verified_the_jacket_has_been_added_to_cart()
	{
		cartPg.verifyJacketInCart();
		log.warn("jacket has been added to cart");
	}
	
	
	//@After(order=2)
	public void tearDown1(Scenario sc)
	{
		if(sc.isFailed()==true)
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File("C:\\Users\\HP\\eclipse-workspace\\Cucumber_Framework\\failed_screenshots\\failedTest.png");
			
			try 
			{
				FileUtils.copyFile(source, target);
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		
			log.info("screenshot cpatured");
		}
		
		System.out.println("Tear Down 1 method executed..!!");
		driver.quit();
		
		log.info("tear down 1 executed");
	}
	
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			// attach image file report (data, media type, name of the attachment)
			scenario.attach(screenshot, "image/png", scenario.getName());
			
		}
	}
	
/*	
 	@After(order=1)
	public void tearDown2()
	{
		System.out.println("Tear Down 2 method executed..!!");
		driver.quit();
	}
*/	
	
	
/*
	@BeforeStep
	public void beforeStepMethod()
	{
		System.out.println("This is Before Step");
	}
	
	@AfterStep
	public void afterStepMethod()
	{
		System.out.println("This is After Step");
	}
	
*/
	
	
	
}

