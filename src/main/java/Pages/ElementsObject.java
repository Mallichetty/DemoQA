package Pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Page_Object_Factory.Object_Factory_ElementsObjects;
import resources.Base;

public class ElementsObject extends Base 
{
	
	Object_Factory_ElementsObjects EO = new Object_Factory_ElementsObjects(driver);
	public static Logger log = LogManager.getLogger(ElementsObject.class.getName());

	public void HomeScreenElementClick() {
		EO.HomeElementclick().click();
		log.info("HomeSreenElementClicked");
	}

	public void WebTableClick() {
		//Object_Factory_ElementsObjects EO = new Object_Factory_ElementsObjects(driver);
		Actions A = new Actions(driver);
		WebElement element = EO.Webclick();
		A.moveToElement(element);
		A.click();
		A.build().perform();
		log.info("webTable clicked");
	}

	public ArrayList<String> getDepartment() {
		//Object_Factory_ElementsObjects EO = new Object_Factory_ElementsObjects(driver);
		ArrayList<String> alist = new ArrayList<String>();

		WebElement value = EO.GetColumnNameDep();
		List<WebElement> columnspy = value.findElements(By.xpath("//div[@class='rt-tbody']/div/div/div[6]"));
		for (WebElement i : columnspy) {
			alist.add(i.getText());
		}
		System.out.println(alist);
		return alist;
	}

	public void addBtnClick() {
		//Object_Factory_ElementsObjects EO = new Object_Factory_ElementsObjects(driver);
		EO.AddBtnClick().click();
		log.info("AddBtn Clicked");
	}

	public ArrayList<String> getAge() {
		//Object_Factory_ElementsObjects EO = new Object_Factory_ElementsObjects(driver);
		ArrayList<String> a = new ArrayList<String>();
		List<WebElement> listAge = EO.GetColumnNameAge();
		for (WebElement j : listAge) {
			a.add(j.getText());
		}
		return a;
	}

	public void fillForm() {

		ElementsObject EO = new ElementsObject();
		ArrayList<String> finale = EO.getDepartment();
		ArrayList<String> age = EO.getAge();
		// String[] strArr = new String[finale.size()];
		// finale.toArray(strArr);
		// System.out.println(strArr);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(finale.get(0));
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(finale.get(1));
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(finale.get(2) + "@gmail.com");
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys(age.get(0));
		driver.findElement(By.xpath("//input[@id='salary']")).sendKeys(age.get(1));
		driver.findElement(By.xpath("//input[@id='department']")).sendKeys(age.get(2));
		driver.findElement(By.xpath("//button[@id='submit']")).click();

	}

	public void HomePageClick() {
		//Object_Factory_ElementsObjects EO = new Object_Factory_ElementsObjects(driver);
		EO.HomePagelink().click();
		log.info("HomePage clicked");
	}
}
