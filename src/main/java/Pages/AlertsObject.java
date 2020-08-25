package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Page_Object_Factory.Object_Factory_AlertsObject;
import resources.Base;

public class AlertsObject extends Base
{
	
	Object_Factory_AlertsObject AO = new Object_Factory_AlertsObject(driver);
	public static Logger log = LogManager.getLogger(AlertsObject.class.getName());
	String current = "" ;
	
	
	public void HomeScreenClick()
	{
		AO.HomePagelink().click();
		log.info("navigated back to homescreen");	
	}

	public void HomeAlertClick()
	{
		driver.manage().window().maximize();
		AO.HomeAlertclick().click();
		log.info("clicked on alert link in home screen");
	}
	
	public void FrameLinkClick() throws AWTException
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		WebDriverWait WDW = new WebDriverWait(driver, 10);
		WDW.until(ExpectedConditions.elementToBeClickable(AO.FrameClick()));
		AO.FrameClick().click();
		log.info("Switched to Frames");
	}

	public void getFrame1text()
	{
		driver.switchTo().frame("frame1");
		String text1 = AO.GetFrame1Text().getText();
		log.info(text1);
		System.out.println(text1);
	}
	
	public void getFrame2text() throws AWTException
	{
		driver.switchTo().defaultContent();
		Robot r = new Robot();
		r.mouseWheel(50);
		driver.switchTo().frame("frame2");
		String text2= AO.GetFrame2text().getText();
		log.info(text2);
		System.out.println(text2);
		r.keyPress(KeyEvent.VK_PAGE_UP);
		driver.switchTo().defaultContent();
	}
	
	public void BrowserWindowClick()
	{
		AO.bWindowClick().click();
		log.info("Browser window clicked");
	}
	
	public void NewTabButtonClick()
	{
		AO.NewTabCLick().click();
		current = driver.getWindowHandle();
		Set<String> handle = driver.getWindowHandles();
		for (String i : handle) {
			if (!i.equalsIgnoreCase(current))
				driver.switchTo().window(i);
		}
		String TabText = AO.sampleTabOpen().getText();
		System.out.println(TabText);
		log.info(TabText);
		driver.close();
	}
	
	public void NewWindowButtonClick()
	{
		driver.switchTo().window(current);
		AO.NewWindowClick().click();
		Set<String> handle1 = driver.getWindowHandles();
		for (String j : handle1) {
			if (!j.equalsIgnoreCase(current)) {
				driver.switchTo().window(j);
				driver.manage().window().maximize();
			}
		}
		String WindowText= AO.sampleTabOpen().getText();
		System.out.println(WindowText);
		log.info(WindowText);
		driver.close();
	}
	
	public void newWindowMessageButtonClick()
	{
		driver.switchTo().window(current);
		AO.NewWindowMessageClick().click();
		driver.manage().window().maximize();
		//driver.close();
		driver.switchTo().window(current);
	}
}

