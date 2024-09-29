package Test.RDCD_DPS_FDR_PRODUCT;
import org.testng.annotations.Test;

import Browser.BrowserSetup;
import Utilities.ProductSetup1stPage_FDR;
import Utilities.ProductSetup2ndPage;
import Utilities.SavingsProductMake;
public class FDR_Product extends BrowserSetup {
	
	Logintest log_in = new Logintest();
	SavingsProductMake SPM = new SavingsProductMake();
	ProductSetup1stPage_FDR Firstpage = new ProductSetup1stPage_FDR();
	ProductSetup2ndPage Secondpage = new ProductSetup2ndPage();
	
	@Test
	public void ProductSetup() throws InterruptedException{
		log_in.loggedIn("http://10.11.200.30:3050/login","200000054203", "123", "লোন", null, null);
		SPM.ProductInfoPage();
		Firstpage.FillupFirstProductSetupPage("প্রোডাক্ট অটোমেশন", "1000", "100000", "1000");//product Bangla Name, Lowest amount, highest amount, gunitok
		Secondpage.FillupSecondProductSetupPage("01/02/2020","১২০ মাস", "5", "5.25", "5.50", "5.75", "6", "6.25", "6.50", "6.75", "7", "7.5", null, null, null, null, null);
	
	
	
	}

}


