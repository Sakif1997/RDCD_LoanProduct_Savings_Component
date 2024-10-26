package Utilities;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Browser.BrowserSetup;

public class ProductSetup1stPage_FDR extends methods{
	public By SelectFDR_dropdown = By.xpath("//div[@id='demo-simple-select']");//মেয়াদী সঞ্চয়(এফ ডি আর)
	public By Prokolpo_drop = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]");
	public By ProductName_in_bangla = By.name("productName");//প্রোডাক্ট অটোমেশন 
	public By ProductMunafaPosting_drop = By.xpath("//div[5]//div[1]//div[1]//div[1]");//ম্যাচুরিটি
	public By MaturityPokriaName_drop = By.xpath("//div[6]//div[1]//div[1]//div[1]");//মুনাফা হার
	public By LowestAmmount_in = By.name("lowestInsAmount");//1000
	public By HighestAmmount_in = By.name("highestInsAmount");//100000
	public By Gunitok_in =By.name("installmentRateMultiplier");//1000
	public By ProductGL_Drop= By.xpath("//input[@id='demo-simple-select']");//Fixed Deposit Scheme
	public By MinusGL_Drop = By.id("demo-simple-select2");//Honourarium
	public By SavePage_cl = By.xpath("//button[@aria-label='সংরক্ষণ করুন']");
	public By Nextpage_w = By.name("duration");
	

	
	public void FillupFirstProductSetupPage(String ProductName, String Lowest_Ammount, String Highest_Amount, String Gunitok_amount) throws InterruptedException{
		//DropDOwnSelectByVisibleTxt(SelectFDR_dropdown, "মেয়াদী সঞ্চয়(এফ ডি আর)");
		Thread.sleep(2000);
		DropdownSelectByDivClass(SelectFDR_dropdown, 2);
		ExtentTest test = BrowserSetup.extent.createTest("FDR product select page","FDR Product Setup: 1ststep");
		test.log(Status.INFO, "Select from Dropdown, Fillup product Name and all related informations");
        test.pass("Product page appeared", MediaEntityBuilder.createScreenCaptureFromPath(methods.captureScreenshot("Screenshot1.png")).build());
		DropdownSelectByDivClass(Prokolpo_drop, 0);
		Fieldvalue(ProductName_in_bangla, ProductName);
		Thread.sleep(2000);
		DropdownSelectByDivClass(ProductMunafaPosting_drop, 0);
		DropdownSelectByDivClass(MaturityPokriaName_drop, 0);
		Fieldvalue(LowestAmmount_in, Lowest_Ammount);
		Fieldvalue(HighestAmmount_in, Highest_Amount);
		Fieldvalue(Gunitok_in, Gunitok_amount);
		Thread.sleep(2000);
		DropdownByInput(ProductGL_Drop, "Fixed Deposit Scheme", 2);
		//DropDOwnSelectByVisibleTxt(ProductGL_Drop, "Fixed Deposit Scheme" );
		DropdownByInput(MinusGL_Drop, "Honourarium",1);
        test.pass("FDR first page setup", MediaEntityBuilder.createScreenCaptureFromPath(methods.captureScreenshot("Screenshot2.png")).build());
		Thread.sleep(2000);
		click(SavePage_cl);
		WaitElement(Nextpage_w);
	}
}
