package Test.RDCD_DPS_FDR_PRODUCT;

import org.testng.annotations.Test;

import Browser.BrowserSetup;
import Utilities.Login;

public class Logintest extends BrowserSetup {
	Login login =new Login();
	@Test
	public void loggedIn() throws InterruptedException{
		getDriver().get("http://10.11.200.30:3090/login");
		Thread.sleep(2000);
		//for  loan
		//login.LoggedIn("rd500000006261", "123", "লোন", null, null);
		//for COOP user
		//login.LoggedIn("200000071781", "123", "কোপ",  "ইউজার", null);
		//for Coop ব্যবহারকারী
		login.LoggedIn("01686026037", "123", "কোপ",  "ব্যবহারকারী", "সমবায় অধিদপ্তর");
		Thread.sleep(20000);


	}

}
