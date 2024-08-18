package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.TestBase;

public class ExtReportx extends TestBase {

	static ExtentReports report;
	
	public static ExtentReports getReportInstance() {
		if(report==null) {
			String reportName=new SimpleDateFormat("dd-mm-YYYY ss-mm-HH").format(new Date()) ;
			ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter("C:\\Users\\HP\\eclipse-workspace\\Automation Framework\\SSqure\\ExtendsReports\\"+reportName+".html");
			report=new ExtentReports();
			report.attachReporter(htmlReporter);
			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("Environment", "SIT");
			report.setSystemInfo("Build", "101.02.02");
			report.setSystemInfo("Browser", "chrome");
			htmlReporter.config().setDocumentTitle("Regression Test Documents");
			htmlReporter.config().setReportName("Regression Test Report");
		}
		return report;
		
	}
}
