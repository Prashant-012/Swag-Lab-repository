package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase  {
	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement userTextBox;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passTextBox;
	
	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement loginBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String loginApplication() throws IOException {
		userTextBox.sendKeys(ReadData.readPropertyFile("Username"));
		passTextBox.sendKeys(ReadData.readPropertyFile("Password"));
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyMultiCredentials(String Username,String Pass) {
		logger=report.createTest("Login to Sauc Lab Application");
		userTextBox.sendKeys(Username);
		logger.log(Status.INFO, "Username is Entered");
		passTextBox.sendKeys(Pass);
		logger.log(Status.INFO, "Password is Entered");
		loginBtn.click();
		logger.log(Status.INFO, "Login Button is Clicked");
		logger.log(Status.PASS, "Login is Sucessfull");
		return driver.getCurrentUrl();
		
	}
	
	public String VerifyURLofApplication(){
		return driver.getCurrentUrl();
	}
	
	public String VerifyTitleofApplication() {
		return driver.getTitle();
	}


	

	
}
