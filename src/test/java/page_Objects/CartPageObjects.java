package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class CartPageObjects {
	
	WebDriver driver;
	
	WebDriver ldriver;
	
	public CartPageObjects(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	
	@FindBy(xpath = "//span[@class='title']") WebElement yourCartText;
	
	@FindBy(xpath = "(//div[@class='inventory_item_name'])[1]") WebElement backpackText;
	
	@FindBy(xpath = "(//div[@class='inventory_item_name'])[2]") WebElement tshirtText;
	
	@FindBy(xpath = "//div[@class='inventory_item_name']") WebElement jacketText;
	
	public void verifyCartText()
	{
		Assert.assertTrue(yourCartText.isDisplayed());
	}
	
	public void verifyBackpackInCart(String product1)
	{
		String actualProduct1 = backpackText.getText();
		
		if (product1.equals(actualProduct1))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}
	
	public void verifyTshirtInCart(String product2)
	{
		String actualProduct2 = tshirtText.getText();
		
		if (product2.equals(actualProduct2))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}
	
	public void verifyJacketInCart()
	{
		String actualItem = jacketText.getText();
		String expectedItem = "Sauce Labs Fleece Jacket";
		
		if(expectedItem.equals(actualItem))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}
	
}
