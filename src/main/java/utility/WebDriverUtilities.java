package utility;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilities {
	public static void handledropDown(WebElement ele,String text) {
		Select s= new Select(ele);
		s.selectByVisibleText(text);
		//s.selectByIndex(text);
}
	public static void getlocation(WebElement ele) {
		Point p=ele.getLocation();
		int x=p.getX();
		int y=p.getY();
	}
	
	public static void mouseHover(WebDriver driver, WebElement ele) {
		Actions a= new Actions(driver);
		a.moveToElement(ele).perform();;
	}
	public static void draganddrop(WebDriver driver,WebElement src,WebElement dest) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}
	public static void switchFrame(WebDriver driver) {
		driver.switchTo().frame(0);
	}
	public static void switchBack(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public static void alertpopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public static void scrollBar(WebDriver driver,int x,int y) {
		JavascriptExecutor  js= (JavascriptExecutor)driver;
		//js.executeScript("windows.scrollBy("+x+","+y+")");
		js.executeScript("window.scrollBy(" +x + ","+y+")");
	}
	public static void switchTabs(WebDriver driver) {
		Set<String> child=driver.getWindowHandles();
		
		for(String b: child) {
			driver.switchTo().window(b);
		}
		
		
	}
	public static void doubleClick(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
}
