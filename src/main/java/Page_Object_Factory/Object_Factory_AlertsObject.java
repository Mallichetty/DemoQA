package Page_Object_Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Object_Factory_AlertsObject 
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
	//By Alerts = By.xpath("//*[text()='Alerts']");
	By Frame1locator =By.id("sampleHeading");
	
	
	public Object_Factory_AlertsObject(WebDriver driver) {
		this.driver = driver;
	} 
	
	public WebElement HomeAlertclick() 
	{
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
	
	public WebElement NewWindowClick()
	{

		return driver.findElement(NewWindow);

	}
	
	public WebElement NewWindowMessageClick()
	{
		return driver.findElement(NewWindowMessage);

	}
	public WebElement HomePagelink()
	{
		return driver.findElement(homescreenLink);
	}
	
	public WebElement FrameClick()
	{
		
		return driver.findElement(Frames);
	}
	
	public WebElement GetFrame1Text() 
	{
		return driver.findElement(Frame1locator);
	
	}
	
	public WebElement GetFrame2text() 
	{
		
		return driver.findElement(Frame1locator);
	}
	
//	public WebElement alertclick()
//	{
//		
//		return driver.findElement(Alerts);
//	}
	
}
