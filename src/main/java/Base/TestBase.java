package Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtReportx;
import utility.ReadData;

public class TestBase {
	public ExtentReports report=ExtReportx.getReportInstance();
	public ExtentTest logger;
	public static WebDriver driver;
//https://github.com/Prashant-012/Swag-Lab-repository.git
	//token-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
	public void initilize() throws IOException {
		String browser=ReadData.readPropertyFile("Browser");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			driver=new ChromeDriver(options);
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(ReadData.readPropertyFile("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
}
