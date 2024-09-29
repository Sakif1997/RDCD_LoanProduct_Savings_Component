package Utilities;

import org.openqa.selenium.By;


public class SavingsProductMake extends methods{
	//public By dashbord_w = By.name("samityName");
	public By ProshashonikSetup_cl = By.xpath("//span[contains(text(),'প্রশাসনিক সেটআপ')]");
	public By ProductBabosthapona_cl = By.xpath("//span[contains(text(),'প্রোডাক্ট ব্যবস্থাপনা')]");
	public By SavingsProductCreateMenu_w_cl = By.xpath("//span[contains(text(),'সঞ্চয়ী প্রোডাক্ট তৈরি')]");
	public By Saving_ProductInfo_Page_w = By.xpath("//span[contains(text(),'সেভিংস প্রোডাক্ট এর তথ্য')]");
	public By CreateSavingProdutButton_cl = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]");
	public By ProductInfoPage_w = By.xpath("//div[@id='demo-simple-select']");
	
	
	public void ProductInfoPage() throws InterruptedException{
		//WaitElement(dashbord_w);
		WaitElementClick(ProshashonikSetup_cl);
		WaitElementClick(ProductBabosthapona_cl);
		Thread.sleep(2000);
		WaitElementClick(SavingsProductCreateMenu_w_cl);
		WaitElementClick(Saving_ProductInfo_Page_w);
		click(CreateSavingProdutButton_cl);
		WaitElement(ProductInfoPage_w);
	}

}
