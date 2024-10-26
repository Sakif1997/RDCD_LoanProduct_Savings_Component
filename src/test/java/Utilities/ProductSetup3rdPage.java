package Utilities;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Browser.BrowserSetup;

public class ProductSetup3rdPage extends methods{
	public By ProductChargePageIcon_click = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/button[1]/div[1]");
	public By ProductChargePage_wait = By.xpath("//button[@aria-label='প্রোডাক্ট চার্জ যোগ করুন']");
	public By Charge_dropdivselect = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]");
	public By KarjokoriTarikh_in = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[3]/div[1]/div[1]/input[1]");
	public By chargeType_dropdiv = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[4]/div[1]/div[1]/div[1]");
	public By chargeRate_in = By.name("chargeAmount");
	public By GL_dropdivselect = By.xpath("//div[6]//div[1]//div[1]//div[1]");
	public By savepageButton = By.xpath("//button[@aria-label='সংরক্ষণ করুন']");
	public By savebutton_cl = By.xpath("//button[@aria-label='সংরক্ষণ করুন']");
	public void AddingCharge(String date, String Chargerate) throws InterruptedException {
		click(ProductChargePageIcon_click);
		ExtentTest test = BrowserSetup.extent.createTest("প্রোডাক্টের চার্জ page","FDR Product Setup: 3rd step");
		test.log(Status.INFO, "Setup প্রোডাক্টের related চার্জ");
        test.pass("প্রোডাক্টের চার্জ page appeared", MediaEntityBuilder.createScreenCaptureFromPath(methods.captureScreenshot("Screenshot6.png")).build());
		WaitElement(ProductChargePage_wait);
		DropdownSelectByDivClass(Charge_dropdivselect, 0);
		Fieldvalue(KarjokoriTarikh_in, date);
		Thread.sleep(2000);
		DropdownSelectbyKeybord(chargeType_dropdiv, 1);

		Fieldvalue(chargeRate_in, Chargerate);
		DropdownSelectByDivClass(GL_dropdivselect, 1);
		Thread.sleep(2000);
        test.pass("প্রোডাক্টের চার্জ setup", MediaEntityBuilder.createScreenCaptureFromPath(methods.captureScreenshot("Screenshot7.png")).build());
		click(savebutton_cl);
	}

}
