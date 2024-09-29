package Utilities;

import org.openqa.selenium.By;

public class ProductSetup2ndPage extends methods{
	public By ProductName_wait = By.name("productName");
	public By Date_in = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]");//01/02/2020
	public By timePeriod_dropselect = By.xpath("//select[@id='numberDuration']");//১২০ মাস
	public By SaveButton_click = By.xpath("//button[@aria-label='সংরক্ষণ করুন']");
	
	public By FirstYear_in = By.xpath("(//input[@name='profitRate'])[1]");
	public By SecondYear_in = By.xpath("(//input[@name='profitRate'])[2]");
	public By ThirdYear_in = By.xpath("(//input[@name='profitRate'])[3]");
	public By FourthYear_in = By.xpath("(//input[@name='profitRate'])[4]");
	public By FifthYear_in = By.xpath("(//input[@name='profitRate'])[5]");
	public By SixYear_in = By.xpath("(//input[@name='profitRate'])[6]");
	public By SeventhYear_in = By.xpath("(//input[@name='profitRate'])[7]");
	public By EightYear = By.xpath("(//input[@name='profitRate'])[8]");
	public By NineYear_in = By.xpath("(//input[@name='profitRate'])[9]");
	public By TenYear_in = By.xpath("(//input[@name='profitRate'])[10]");
	public By ElevenYear_in = By.xpath("(//input[@name='profitRate'])[11]");
	public By TwelveYear = By.xpath("(//input[@name='profitRate'])[12]");
	public By TherteenYear_in = By.xpath("(//input[@name='profitRate'])[13]");
	public By forteenYear_in = By.xpath("(//input[@name='profitRate'])[14]");
	public By fifteenYear_in = By.xpath("(//input[@name='profitRate'])[15]");
	public By NextButton_cl = By.xpath("//button[contains(text(),'পরবর্তী ধাপ')]");
	
	public void FillupSecondProductSetupPage(String ActivationDate, String Duration, String Year1,String Year2,String Year3,String Year4,String Year5,String Year6,String Year7,String Year8,String Year9,String Year10,String Year11,String Year12,String Year13, String Year14,String Year15) throws InterruptedException{
		WaitElement(ProductName_wait);
		Thread.sleep(2000);
		Fieldvalue(Date_in, ActivationDate);
		DropDownCLickSelect(Date_in, Duration);
		//if(Duration=="১২০ মাস")
		Fieldvalue(FirstYear_in, Year1);
		Fieldvalue(FirstYear_in, Year2);
		Fieldvalue(FirstYear_in, Year3);
		Fieldvalue(FirstYear_in, Year4);
		Fieldvalue(FirstYear_in, Year5);
		Fieldvalue(FirstYear_in, Year6);
		Fieldvalue(FirstYear_in, Year7);
		Fieldvalue(FirstYear_in, Year8);
		Fieldvalue(FirstYear_in, Year9);
		Fieldvalue(FirstYear_in, Year10);
		Fieldvalue(FirstYear_in, Year11);
		Fieldvalue(FirstYear_in, Year12);
		Fieldvalue(FirstYear_in, Year13);
		Fieldvalue(FirstYear_in, Year14);
		Fieldvalue(FirstYear_in, Year15);
		Thread.sleep(2000);
		click(NextButton_cl);

	}



}
