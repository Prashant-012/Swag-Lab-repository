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
import pages.LoginPage;
import utility.ReadData;
import utility.ScreenShot;

public class LoginPageTest extends TestBase {
	LoginPage login;
	@BeforeMethod
	public void setup() throws IOException {
		initilize();
		login=new LoginPage();
	}
	@Test
	public void LoginToAppTest() throws IOException, InterruptedException {
		String ActUrl=login.loginApplication();
		String ExptUrl=ReadData.readExecl(0, 0);//https://www.saucedemo.com/inventory.html(0,0)
		Assert.assertEquals(ActUrl, ExptUrl);
		
	}
   @Test
   public void VerifyURLofApplicationTest() throws EncryptedDocumentException, IOException, InterruptedException {
	   String Acturl=login.VerifyURLofApplication();
	   System.out.println(Acturl);
	   String ExpUrl=ReadData.readExecl(1, 0);//https://www.saucedemo.com/(1,0)
	   Assert.assertEquals(Acturl, ExpUrl);
	   Reporter.log("Url of swag lab ="+Acturl);
	   
	   }
   
   @Test
   public void VerifyTitleofApplicationTest() throws EncryptedDocumentException, IOException, InterruptedException {
	   String ActTitle=login.VerifyTitleofApplication();
	   System.out.println(ActTitle);
	   String ExptTitle=ReadData.readExecl(2, 0);//Swag Labs(2,0)
	   Assert.assertEquals(ActTitle,ExptTitle );
	   
   }
   @AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult it) throws IOException, InterruptedException {
	   if(ITestResult.FAILURE==it.getStatus()) {
			ScreenShot.sc(it.getName());
			
		}
		report.flush();
		driver.quit();
	}
}
