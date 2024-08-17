package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class ScreenShot extends TestBase {
public static String getDate() {
	return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
	
}
public static void sc(String nameOfMethod ) throws IOException {
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest=new File("C:\\Users\\HP\\eclipse-workspace\\Automation Framework\\SSqure\\ScreenShot\\"+nameOfMethod+"--"+getDate()+".jpeg");
	FileHandler.copy(src, dest);
}
}
