package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import pages.LoginPage;
import utility.ReadData;
import utility.ScreenShot;

public class VerifyMultiCreadTest extends TestBase{
	LoginPage login;
	@BeforeMethod
	public void setup() throws IOException {
		initilize();
		login=new LoginPage();
	}
	
	@DataProvider(name = "Validation")
	public Object[][] getData(){
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"standard_user","secret_sauce"},//locked_out_user
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"}
			
			
		};
		
	}
	@Test(dataProvider = "Validation")
	public void verifyMultiCredentialsTest(String un,String pass) throws EncryptedDocumentException, IOException {
		
		
		String actUrl=login.verifyMultiCredentials(un, pass);
		String expUrl=ReadData.readExecl(0, 0);
		SoftAssert s=new SoftAssert();
		s.assertEquals(actUrl, expUrl);
		s.assertAll();
		
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
