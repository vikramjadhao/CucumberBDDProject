package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPageObjects {

	WebDriver driver;

	WebDriver ldriver;
	
	public MainPageObjects(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	
	@FindBy(id = "react-burger-menu-btn") WebElement burgerMenuBtn;
	
	@FindBy(id = "logout_sidebar_link") WebElement logoutBtn;
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack") WebElement backpackBtn;
	
	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt") WebElement tshirtBtn;
	
	@FindBy(id = "add-to-cart-sauce-labs-bike-light") WebElement addBikeLightBtn;
	
	@FindBy(id = "remove-sauce-labs-bike-light") WebElement removeBikeLightBtn;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']") WebElement cartBtn;
	
	@FindBy(xpath = "//select[@class='product_sort_container']") WebElement dropdown;
	
	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket") WebElement jacket;
	
	
	public void clickOnBurgerMenuBtn()
	{
		burgerMenuBtn.click();
	}
	
	public void clickOnLogoutBtn()
	{
		logoutBtn.click();
	}
	
	public void addBackpackToCart()
	{
		backpackBtn.click();
	}
	
	public void addTshirtToCart()
	{
		tshirtBtn.click();
	}
	
	public void addBikeLight_ToCart()
	{
		addBikeLightBtn.click();
	}
	
	public void removeBikeLight_FromCart()
	{
		removeBikeLightBtn.click();
	}
	
	public void clickOnCartBtn()
	{
		cartBtn.click();
	}
	
	public void clickOnDropdown()
	{
		dropdown.click();
	}
	
	public void selectDropdownOptn()
	{
		Select s = new Select(dropdown);
		
		s.selectByIndex(3);
	}
	
	public void addJacket_ToCart()
	{
		jacket.click();
	}
	
}
