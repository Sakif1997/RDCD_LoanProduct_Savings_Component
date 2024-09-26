package Utilities;

import org.openqa.selenium.By;

public class Login extends methods{
	public By loginID = By.id("username");
	public By loginpass = By.id("password");
	public By componentName = By.name("componentName");
	public By user_radiobutton = By.xpath("/html[1]/body[1]/div[1]/div[2]/main[1]/div[2]/div[2]/div[1]/form[1]/div[4]/div[1]/fieldset[1]/div[1]/label[2]/span[2]");
	public By baboharkari_radiobutton =By.xpath("//span[contains(text(),'ব্যবহারকারী')]");
	public By DoptorName_Somobai = By.name("doptorId");
	public By loginButton = By.xpath("//button[contains(text(),'প্রবেশ করুন')]");
	public void LoggedIn(String logID, String Password, String ServiceName,String User,String Odhidoptor) {
		
		Fieldvalue(loginID, logID);
		Fieldvalue(loginpass, Password);
		if(ServiceName == "লোন") {
			DropDOwnSelectByVisibleTxt(componentName, ServiceName);
		}
		else if(ServiceName == "কোপ") {
			DropDOwnSelectByVisibleTxt(componentName, ServiceName );
			if(User == "ইউজার") {
				click(user_radiobutton);
			}
			else {
				click(baboharkari_radiobutton);
				DropDOwnSelectByVisibleTxt(DoptorName_Somobai, Odhidoptor);
			}		
		}
		click(loginButton);
	}

}
