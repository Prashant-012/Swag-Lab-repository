package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.cartPage;
import utility.ReadData;
import utility.ScreenShot;

public class CartPageTest extends TestBase {
	LoginPage login;
	InventoryPage invent;
	cartPage cart;
	
	@BeforeMethod
	public void setup() throws IOException {
		initilize();
		login=new LoginPage();
		invent=new InventoryPage();
		login.loginApplication();
		cart=new cartPage();
		invent.clickOnCartIcon();
		
	}
	
	@Test
	public void verifyCheckoutTitleTest() throws EncryptedDocumentException, IOException {
		String actTitle=cart.verifyCartPageTitle();
		String expTitle= ReadData.readExecl(2, 0);
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log(expTitle);
	}
	@Test
	public void verifyCartPageURLTest() throws EncryptedDocumentException, IOException {
		String actTitle=cart.verifyCartPageURL();
		String expURL=ReadData.readExecl(3, 0);
		Reporter.log(expURL);
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
