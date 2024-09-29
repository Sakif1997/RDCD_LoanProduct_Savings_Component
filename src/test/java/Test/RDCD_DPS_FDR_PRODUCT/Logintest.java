package Test.RDCD_DPS_FDR_PRODUCT;


import Browser.BrowserSetup;
import Utilities.Login;

public class Logintest extends BrowserSetup {
	Login login =new Login();
	public void loggedIn(String Server,String ID, String Password, String ComponentName, String UserType, String DoptorName) throws InterruptedException{
		getDriver().get(Server);
		Thread.sleep(2000);
		//for  loan
		//login.LoggedIn("rd500000006261", "123", "লোন", null, null);
		//for COOP user
		//login.LoggedIn("200000071781", "123", "কোপ",  "ইউজার", null);
		//for Coop ব্যবহারকারী
		login.LoggedIn(ID, Password, ComponentName, UserType, DoptorName);
		Thread.sleep(20000);


	}

}
