package Utilities;

import org.openqa.selenium.By;

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

	
	public void FillupFirstProductSetupPage(String ProductName) throws InterruptedException{
		DropDOwnSelectByVisibleTxt(SelectFDR_dropdown, "মেয়াদী সঞ্চয়(এফ ডি আর)");
		DropDOwnSelectByVisibleTxt(Prokolpo_drop, "পিডিবিএফ তহবিল");
		Fieldvalue(ProductName_in_bangla, ProductName);
		DropDOwnSelectByVisibleTxt(ProductMunafaPosting_drop, "ম্যাচুরিটি");
		DropDOwnSelectByVisibleTxt(MaturityPokriaName_drop, "মুনাফা হার");
		Fieldvalue(LowestAmmount_in, "1000");
		Fieldvalue(HighestAmmount_in, "100000");
		Fieldvalue(Gunitok_in, "1000");
		DropDOwnSelectByVisibleTxt(ProductGL_Drop, "Fixed Deposit Scheme");
		DropDOwnSelectByVisibleTxt(MinusGL_Drop, "Honourarium");
		click(SavePage_cl);
		WaitElement(Nextpage_w);
	}
}
