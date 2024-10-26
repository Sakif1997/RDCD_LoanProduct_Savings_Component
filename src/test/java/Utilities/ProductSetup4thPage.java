package Utilities;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Browser.BrowserSetup;

public class ProductSetup4thPage extends methods{
	public By page_wait = By.xpath("//button[@aria-label='প্রয়োজনীয় ডকুমেন্ট যোগ করুন']");
	public By NecessaryDocuments_dropDiv = By.xpath("//div[@id='demo-simple-select']");
	public By Karjaloi_DropDivKey = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]");
	public By PersonSelect_dropVisibletxt = By.xpath("//select[@id='projectName']");
	public By SaveButton = By.xpath("//button[@aria-label='সংরক্ষণ করুন']");
	
	public void ProductSendPage(String PersonName) throws InterruptedException{
		WaitElement(page_wait);
		ExtentTest test = BrowserSetup.extent.createTest("প্রয়োজনীয় ডকুমেন্ট page","FDR Product Setup: 4th step");
		test.log(Status.INFO, "Select প্রয়োজনীয় ডকুমেন্ট for the product");
        test.pass("প্রয়োজনীয় ডকুমেন্ট page appeared", MediaEntityBuilder.createScreenCaptureFromPath(methods.captureScreenshot("Screenshot8.png")).build());
		DropdownByDivKeybord(NecessaryDocuments_dropDiv, 0);
		Thread.sleep(2000);
		DropdownByDivKeybord(Karjaloi_DropDivKey, 4);
		Thread.sleep(2000);
		DropDOwnSelectByVisibleTxt(PersonSelect_dropVisibletxt, PersonName);
        test.pass("প্রয়োজনীয় ডকুমেন্ট page setup", MediaEntityBuilder.createScreenCaptureFromPath(methods.captureScreenshot("Screenshot9.png")).build());
		Thread.sleep(2000);
		click(SaveButton);

	}

}
