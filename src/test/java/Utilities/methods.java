package Utilities;
import static Browser.BrowserSetup.getDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.print.attribute.PrintServiceAttribute;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Allure;
public class methods {
	public WebElement getElement(By locator) {
		return getDriver().findElement(locator);
	}
	public void click(By locator) {
		getElement(locator).click();
	}
	public String PageTitle() {
		String Pagetitle= getDriver().getTitle();
		return Pagetitle;
	}
	public void Fieldvalue(By locator, String text) {
		getElement(locator).sendKeys(text);
	}
	public String getText(By locator) {
		WebElement element = getElement(locator);
		return element.getText();
	}
	public void WaitElement(By locator) {
		WebDriverWait element = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		element.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void WaitElementClick(By locator) {
		WebDriverWait element = new WebDriverWait(getDriver(),Duration.ofSeconds(20));
		element.until(ExpectedConditions.visibilityOfElementLocated(locator));
		getElement(locator).click();
	}
	public void DropDownSelectBySerialNumber(By locator, int SerialNumber) {
		WebDriverWait element = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		element.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(getElement(locator));
		select.selectByIndex(SerialNumber);
	}
	public void DropdownSelectbyKeybord(By locator, int ListNumber) {
		click(locator);
		Actions action = new Actions(getDriver());
		for(int i=0; i<ListNumber; i++) {
			action.keyDown(Keys.ARROW_DOWN);
		}
		action.keyDown(Keys.ENTER);
		action.build().perform();
	}
	public void DropDOwnSelectByVisibleTxt(By locator, String text) {
		WebDriverWait element = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		element.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	public void DropDownCLickSelect(By locator, String text) {
		click(locator);
		WebDriverWait element = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		element.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
		
	}
	public void AlertMessage() {
		String alertMessage =getDriver().switchTo().alert().getText();
		System.out.println(alertMessage);
	}
	public void ClickDropDownDiv(By locator) {
		click(locator);
		Actions action =new Actions(getDriver());
		action.keyDown(Keys.ENTER);
		action.build().perform();
	}
	public void takeScreenshot(String name) {
		Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
	}
	public void KeybordInputSelectOption(By locator,String text){
	click(locator);
	Fieldvalue(locator, text);
	Actions action = new Actions(getDriver());
	action.keyDown(Keys.ARROW_DOWN);
	action.keyDown(Keys.ENTER);
	action.build().perform();
	}
//	public void DropdownSelectDiv(By locator, String elementName) {
//		click(locator);
//		Actions action = new Actions(getDriver());
//			action.keyDown(Keys.ARROW_DOWN);
//			action.keyDown(Keys.ENTER);
//			action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL);
//			action.build().perform();

//	}
	public void DropDownSelectElement(By locator, int serialnumber) {
		Select	select = new Select(getElement(locator));
		select.selectByIndex(serialnumber);//
	}
	public void SelectByVissibleTxt(By locator, String text) {
		Select	select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	public void Hover(By locator){
		Actions action = new Actions(getDriver());
		action.moveToElement(getElement(locator)).perform();
	}
	public void DropdownByInput(By locator, String input, int Listnumber) {
		click(locator);
		Fieldvalue(locator, input);
		Actions action = new Actions(getDriver());
		for(int i=0; i<Listnumber; i++) {
			action.keyDown(Keys.ARROW_DOWN);
		}
		action.keyDown(Keys.ENTER);
		action.build().perform();
	}
	public void DropdownByDivKeybord(By locator, int Listnumber) {
		click(locator);
		Actions action = new Actions(getDriver());
		for(int i=0; i<Listnumber; i++) {
			action.keyDown(Keys.ARROW_DOWN);
		}
		action.keyDown(Keys.ENTER);
		action.build().perform();
	}
	
	JavascriptExecutor js;
	public void ScrollDown() {
	js = (JavascriptExecutor)getDriver();
	js.executeScript("window.scrollTo(0,document.body.scrollHeight");
	}
	public void ScrollUp() {
		// TODO Auto-generated constructor stub
		js =(JavascriptExecutor)getDriver();
		js.executeScript("document.body.scrollHeight,0");
	}
	public void ScrollDownByPageElem(By locator){
		js = (JavascriptExecutor)getDriver();
		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", locator);

	}
	public void DropdownSelectByDivClass(By locator, int n) {
		click(locator);
		Actions action = new Actions(getDriver());
		for(int i=0; i<n;i++) {
		action.keyDown(Keys.ARROW_DOWN);
		}
		action.keyDown(Keys.ENTER);
		action.build().perform();
	}
	public static String captureScreenshot_base64() {
		TakesScreenshot takesScreenshot =(TakesScreenshot)getDriver();
		String base64Code =takesScreenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot saved Succefully");
		return base64Code;
	}
	public static String captureScreenshot(String filename, String FileLocation) {
		TakesScreenshot takesScreenshot =(TakesScreenshot)getDriver();
		File sourceFile =takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(FileLocation +filename);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return destFile.getAbsolutePath();
		
	}
	

}
