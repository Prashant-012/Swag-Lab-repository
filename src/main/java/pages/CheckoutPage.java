package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckoutPage extends TestBase {
	@FindBy(xpath = "//span[text()='Checkout: Your Information']")
	private WebElement checkoutTitle;

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckoutPageTitle() {
		return checkoutTitle.getText();
		
	}
	public String verifyCheckoutPageURL() {
		return driver.getCurrentUrl();
		
	}
}
