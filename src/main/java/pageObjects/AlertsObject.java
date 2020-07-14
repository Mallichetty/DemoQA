package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertsObject 
{
	WebDriver driver;
	By Aclick = By.xpath("//div[@class='category-cards']/div[3]");
	By BW = By.xpath("//span[text()='Browser Windows']"); 
	By NewTab =By.id("tabButton");
	By SampleTab = By.id("sampleHeading");
	By NewWindow = By.id("windowButton");
	By NewWindowMessage = By.id("messageWindowButton");
	By homescreenLink = By.xpath("//a[@href= 'https://demoqa.com']");
	By Frames = By.xpath("//span[text()='Frames']");
	
	public AlertsObject(WebDriver driver) {
		this.driver = driver;
	} 
	
	public WebElement HomeAlertclick() {
		return driver.findElement(Aclick);
	}
	
	public WebElement bWindowClick() {
		return driver.findElement(BW);
	} 
	
	public WebElement NewTabCLick()
	{
		return driver.findElement(NewTab);
	}
	public WebElement sampleTabOpen()
	{
		return driver.findElement(SampleTab);
	}
	
	public void NewWindowClick()
	{
		try 
		{
		driver.findElement(NewWindow).click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void NewWindowMessageClick()
	{
		try {
		driver.findElement(NewWindowMessage).click();
	}
		catch(Exception e) {
			
		}
	}
	public WebElement HomePagelink()
	{
		return driver.findElement(homescreenLink);
	}
	
	public void FrameClick()
	{
		try
		{
			driver.findElement(Frames).click();
		}
		catch(Exception e)
		{
			System.out.println("Error frame didnt Clicked ");
		}
	}
	
	public void GetFrame1Text() throws Throwable
	{
		try 
		{
		driver.switchTo().frame("frame1");
		System.out.println(driver.findElement(By.id("sampleHeading")).getText()+"alerts");
		}
		catch(Exception e )
		{
			System.out.println("Error frame text didnt captured ");
		}
		
	}
	
	public void GetFrame2text() throws Throwable
	{
		try
		{
			driver.switchTo().frame("frame2");
			System.out.println(driver.findElement(By.id("sampleHeading")).getText() + "alerts 2");
		}
		catch(Exception e)
		{
			System.out.println("Error frame text 2 didnt captured ");
		}
	}
}
