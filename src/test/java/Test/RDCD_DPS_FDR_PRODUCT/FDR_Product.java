package Test.RDCD_DPS_FDR_PRODUCT;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Browser.BrowserSetup;
import Utilities.ProductSetup1stPage_FDR;
import Utilities.ProductSetup2ndPage;
import Utilities.ProductSetup3rdPage;
import Utilities.ProductSetup4thPage;
import Utilities.SavingsProductMake;
public class FDR_Product extends BrowserSetup {
	
	Logintest log_in = new Logintest();
	SavingsProductMake SPM = new SavingsProductMake();
	ProductSetup1stPage_FDR Firstpage = new ProductSetup1stPage_FDR();
	ProductSetup2ndPage Secondpage = new ProductSetup2ndPage();
	ProductSetup3rdPage ThirdPage = new ProductSetup3rdPage();
	ProductSetup4thPage fourthPage = new ProductSetup4thPage();
	//methods method = new methods();
	@Test
	public void ProductSetup() throws InterruptedException{
		ExtentTest test = extent.createTest("FDR Product Make","FDR Product Setup: 4step");
		test.log(Status.INFO, "Starting testing process");
		log_in.loggedIn("http://10.11.200.30:3050/login","200000054203", "123", "লোন", null, null);
		test.pass("Successfully logged In");
		SPM.ProductInfoPage();
		//test.pass("screenshot 64", MediaEntityBuilder.createScreenCaptureFromBase64String(methods.captureScreenshot_base64()).build());
		//test.pass("Product page appeared");
		Firstpage.FillupFirstProductSetupPage("প্রোডাক্ট অটোমেশন 015-২০২৪", "1000", "100000", "1000");//product Bangla Name, Lowest amount, highest amount, gunitok
        //test.pass("Product page appeared", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		//test.addScreenCaptureFromPath("testedpage.png");
		String[] MunafaRateValues = { "5", "5.25", "5.50", "5.75", "6", "6.25", "6.50", "6.75", "7", "7.5", null, null, null, null, null };
		//test.addScreenCaptureFromPath("testedpage.png");
		//test.pass("Product Setup First page");
        //test.pass("Product Setup First page", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		Secondpage.FillupSecondProductSetupPage("01/02/2020","১২০ মাস",10,MunafaRateValues);
		//test.addScreenCaptureFromPath("testedpage.png");
		//test.pass("Product Setup Secound page");
        //test.pass("Product Setup Second page", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		ThirdPage.AddingCharge("01/02/2021", "3");//karjokoritarik and charge rate
		//test.addScreenCaptureFromPath("testedpage.png");
		//test.pass("Product Setup Third page");
        //test.pass("Product Setup Third page", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		fourthPage.ProductSendPage("গৌতম ভৌমিক (যুগ্ম পরিচালক)");
		//test.addScreenCaptureFromPath("testedpage.png");
        //test.pass("Product Setup Fourth page", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		Thread.sleep(3000);
		test.info("test completed");
	}

}


