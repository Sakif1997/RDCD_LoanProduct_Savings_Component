package Utilities;
import static Browser.BrowserSetup.getDriver;

import java.io.ByteArrayInputStream;
import java.time.Duration;

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
	public void DropDOwnSelectByVisibleTxt(By locator, String text) {
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
	public void Hover(By locator){
		Actions action = new Actions(getDriver());
		action.moveToElement(getElement(locator)).perform();
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
	

}
