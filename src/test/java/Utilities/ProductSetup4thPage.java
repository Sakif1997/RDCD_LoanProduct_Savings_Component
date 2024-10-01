package Utilities;

import org.openqa.selenium.By;

public class ProductSetup4thPage extends methods{
	public By page_wait = By.xpath("//button[@aria-label='প্রয়োজনীয় ডকুমেন্ট যোগ করুন']");
	public By NecessaryDocuments_dropDiv = By.xpath("//div[@id='demo-simple-select']");
	public By Karjaloi_DropDivKey = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]");
	public By PersonSelect_dropVisibletxt = By.xpath("//select[@id='projectName']");
	public By SaveButton = By.xpath("//button[@aria-label='সংরক্ষণ করুন']");
	
	public void ProductSendPage(String PersonName) throws InterruptedException{
		WaitElement(page_wait);
		DropdownByDivKeybord(NecessaryDocuments_dropDiv, 0);
		Thread.sleep(2000);
		DropdownByDivKeybord(Karjaloi_DropDivKey, 4);
		DropDOwnSelectByVisibleTxt(PersonSelect_dropVisibletxt, PersonName);
		Thread.sleep(2000);
		click(SaveButton);

	}

}
