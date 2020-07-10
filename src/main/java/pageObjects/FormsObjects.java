package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsObjects {
	WebDriver driver;
	By Fclick = By.xpath("//div[@class='category-cards']/div[2]");
	By Form = By.xpath("//div[text()='Forms']"); 
	By PracticeForm = By.xpath("//*[text()='Practice Form']");
	By FirstNameTextBox = By.id("firstName");
	By LastNameTextBox = By.id("lastName");
	By EmailTextBox = By.id("userEmail");
	By SelectRadioBtn = By.xpath("//*[text()='Male']");
	By selectOption = By.id("gender-radio-1");
	By mobileNumberTextBox = By.id("userNumber");
	By subjectsTextbox = By.xpath("//div[@class='subjects-auto-complete__input']/input");
	By DOBClick = By.cssSelector("#dateOfBirthInput");
	By datePick = By.xpath("//select[@class='react-datepicker__month-select']");
	By yearPick = By.xpath("//select[@class='react-datepicker__year-select']");
	By dayPick = By.xpath("//div[@class='react-datepicker__month']/div/div");
	By checkBoxClick = By.xpath("//div[contains(@class,'custom-checkbox')]/label");
	By AddressTextBox = By.cssSelector("[id='currentAddress-wrapper'] div textarea");
	/*	@FindBy(css="[id='currentAddress-wrapper'] div textarea")
	WebElement AddressTextBox;*/
	By DropdownButton = By.xpath("//div[@class=' css-tlfecz-indicatorContainer']");
	By DynamicDDState = By.xpath("//input[@id='react-select-3-input']");
	By DynamicDDCity = By.xpath("//input[@id='react-select-4-input']");
	By SubmitClick = By.cssSelector("#submit");

	public FormsObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement HomeFormclick() {
		return driver.findElement(Fclick);
	}

	public WebElement FormClick() {
		return driver.findElement(Form);
	} 

	public WebElement PracticeFormClick() {
		return driver.findElement(PracticeForm);
	}

	public ArrayList<String> getData(String FieldNameValue) throws IOException {
		ArrayList<String> al = new ArrayList<String>();
		FileInputStream FIS = new FileInputStream("C:\\Users\\Admin\\Desktop\\DataDriven.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(FIS);
		int Sheets = wb.getNumberOfSheets();
		for (int i = 0; i < Sheets; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase("testData")) {
				XSSFSheet workingSheet = wb.getSheetAt(i);
				Iterator<Row> row = workingSheet.iterator();
				Row firstrow = row.next();
				Iterator<Cell> ci = firstrow.cellIterator();
				int k = 0;
				int columnNumber = 0;
				while (ci.hasNext()) {
					Cell column = ci.next();
					if (column.getStringCellValue().equalsIgnoreCase("FieldName")) {
						k = columnNumber;
					}
					k++;
				}

				while (row.hasNext()) {
					Row rows = row.next();
					if (rows.getCell(columnNumber).getStringCellValue().equalsIgnoreCase(FieldNameValue)) {
						Iterator<Cell> NameField = rows.cellIterator();
						while (NameField.hasNext()) {
							al.add(NameField.next().getStringCellValue());
						}
						System.out.println(al);
					}

				}
			}

		}
		return al;

	}

	public WebElement FirstNameTextBox() {
		return driver.findElement(FirstNameTextBox);
	}
	
	public WebElement LastNameTextBox()
	{
		return driver.findElement(LastNameTextBox);
	}

	public WebElement EmailTextBox() {
		return driver.findElement(EmailTextBox);
	}

	public WebElement radioBtn() {
		return driver.findElement(SelectRadioBtn);
	}
	
	public WebElement RadioSelectCheck() {
		return driver.findElement(selectOption);
	}

	public WebElement MobileTextBox() {
		return driver.findElement(mobileNumberTextBox);
	}
	
	public WebElement SubjectBox() {
		return driver.findElement(subjectsTextbox);
	}
	
	public WebElement dobTextBoxClick() {
		return driver.findElement(DOBClick);
	}
	
	public WebElement dateSelectClick() {
		return driver.findElement(datePick);
	}
	
	public WebElement yearSelectClick() {
		return driver.findElement(yearPick);
	}
	
	public List<WebElement> daySelectClick()
	{
		 return driver.findElements(dayPick);
	}
	
	public List<WebElement> checkSelect()
	{
		   return driver.findElements(checkBoxClick);
	}
	
	public WebElement Addressclick()
	{
		return driver.findElement(AddressTextBox);
	}
	
	public WebElement DDClick()
	{
		return driver.findElement(DropdownButton);
	}
	public WebElement DynamicDDClick()
	{
		return driver.findElement(DynamicDDState);
	}
	
	public WebElement DynamicDDCitySelect()
	{
		return driver.findElement(DynamicDDCity);
	}
	
	public WebElement Submission()
	{
		return driver.findElement(SubmitClick);
	}
}
