package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class cartPage extends TestBase {
	@FindBy(xpath = "//button[@id='checkout']")
	private WebElement checkOutBtn;
	
	
	public cartPage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyCartPageTitle() {
		return driver.getTitle();
		
	}
	public String verifyCartPageURL() {
		return driver.getCurrentUrl();
		
	}
	public void clickOncheckbtn() {
		checkOutBtn.click();
	}
}
