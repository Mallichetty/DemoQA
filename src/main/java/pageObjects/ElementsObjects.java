package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsObjects 
{
	WebDriver driver;
	
	By Elementclick= By.xpath("//div[@class='category-cards']/div[1]");
	
	public  ElementsObjects(WebDriver driver)
	{
		this.driver= driver;
	}
	
	 
	public WebElement HomeElementclick()
	{
		
		return driver.findElement(Elementclick);
	}
	
	
}
