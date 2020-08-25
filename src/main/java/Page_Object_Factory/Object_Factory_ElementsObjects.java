package Page_Object_Factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class Object_Factory_ElementsObjects extends Base{
	

	By Elementclick = By.xpath("//div[@class='category-cards']/div[1]");
	By WebTableClick = By.xpath("//*[text()='Web Tables']");
	By addrecordclick = By.id("addNewRecordButton");
	By columnNameDep = By.xpath("//div[@class='rt-tr']/div[6]"); 
	By columnNameAge = By.xpath("//div[@class='rt-tbody']/div/div/div[3]");
	By homescreenLink = By.xpath("//a[@href= 'https://demoqa.com']");
 
	public Object_Factory_ElementsObjects(WebDriver driver)
	{
		this.driver =driver;
	}

	public WebElement HomeElementclick() 
	{

		return driver.findElement(Elementclick);
	} 

	public WebElement Webclick() {

		return driver.findElement(WebTableClick);
	}

	

	public WebElement AddBtnClick() {

		return driver.findElement(addrecordclick);
	}

	public WebElement GetColumnNameDep() {

		return driver.findElement(columnNameDep);
	}

	public List<WebElement> GetColumnNameAge() {

		return driver.findElements(columnNameAge);
	}
	
	public WebElement HomePagelink()
	{
		return driver.findElement(homescreenLink);
	}

}
