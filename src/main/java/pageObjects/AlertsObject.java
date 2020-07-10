package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertsObject 
{
	WebDriver driver;
	By SliderElementClick = By.xpath("//div[@class='category-cards']/div[3]");
	By WebTableClick1 = By.xpath("//div[@class='element-group']/div[1]/ul/li[4]");
	
	public AlertsObject(WebDriver driver) {
		this.driver = driver;
	} 
	
	public WebElement sliderclick()
	{
		return driver.findElement(SliderElementClick);
	}
	
	public WebElement Webclick1() {

		return driver.findElement(WebTableClick1);
	}
}
