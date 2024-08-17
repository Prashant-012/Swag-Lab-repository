package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import utility.WebDriverUtilities;

public class InventoryPage extends TestBase {
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']")
	private WebElement productBackpack;

	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bike-light']")
	private WebElement productBikeLight;
	
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")
	private WebElement productBoltT_shirt;
	
	@FindBy(xpath ="//button[@name='remove-sauce-labs-bolt-t-shirt']")
	private WebElement removeBoltT_shirt;
	
	@FindBy(xpath = "//button[contains(@name,'add-to-cart-sauce-labs-fleece-jacket')]")
	private WebElement productJacket;
	
	@FindBy(xpath = "//button[contains(@name,'remove-sauce-labs-fleece-jacket')]")
	private WebElement removeJacket;
	
	@FindBy(xpath = "//span[@class='title']")
	private WebElement title;
	
	@FindBy(xpath = "//a[@data-test='social-twitter']")
	private WebElement tweeterIcon;
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement dropDown;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement CartIcon;
	
	public InventoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return title.getText();
		}
	
	public boolean verifyTweeterLogo() {
		return tweeterIcon.isDisplayed();
	}
	
	public String add4Product() throws InterruptedException {
		WebDriverUtilities.handledropDown(dropDown, "Price (low to high)");
		Thread.sleep(3000);
		productBikeLight.click();
		productBackpack.click();
		productBoltT_shirt.click();
		productJacket.click();
		return CartIcon.getText();
	}
	public String remove2Product() throws InterruptedException {
		add4Product();
		Thread.sleep(3000);
		removeBoltT_shirt.click();
		removeJacket.click();
		
		return CartIcon.getText();
		
	}
	
}
