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
}
