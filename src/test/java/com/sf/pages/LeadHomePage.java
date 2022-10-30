package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sf.base.ProjectSpecMethods;

public class LeadHomePage extends ProjectSpecMethods {
	
	public LeadHomePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public LeadCreatePage clickNewButton()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountHomePage.NewButton.xpath"))).click();
		return new LeadCreatePage(driver);
	}

}
