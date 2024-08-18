package testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import Base.TestBase;
import pages.InventoryPage;
import pages.LoginPage;
import utility.ScreenShot;

public class InventoryPageTest extends TestBase {
	
	LoginPage login;
	InventoryPage invent;
	@BeforeMethod
	public void setup() throws IOException {
		initilize();
		login=new LoginPage();
		invent=new InventoryPage();
		login.loginApplication();
		
		
	}
	@Test
	public void verifyTitle() {
		String actTitle=invent.verifyTitle();
		String expTitle="Products";
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log("Title of Inventory Page "+actTitle);
	}
	@Test
	public void verifyIcon() {
		boolean result=invent.verifyTweeterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Tweeter Logo is Present= "+result);
	}
	@Test
	public void add4Product() throws InterruptedException {
		String expCount="4";
		String actCount=invent.add4Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Count of added Product is "+actCount);
	}
	
	@Test
	public void removeProduct() throws InterruptedException  {
		String expCount="2";
		String actCount=invent.remove2Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total Count is= "+actCount);
	}
	
	@AfterMethod
	public void tearDown(ITestResult it) throws IOException {
		if(it.FAILURE==it.getStatus()) {
			ScreenShot.sc(it.getName());
			
		}
		report.flush();
		driver.quit();
	}
	
	

}
