package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class LeadHomePageHybrid extends ProjectSpecMethods {
	
	/*public LeadHomePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public LeadCreatePageHybrid clickNewButton()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountHomePage.NewButton.xpath"))).click();
		return new LeadCreatePageHybrid(driver);
	}
	
	public LeadDetailsPageHybrid openLead()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Kumar'])[1]")));
		WebElement leadName = driver.findElement(By.xpath("(//a[text()='Kumar'])[1]"));
		executor.executeScript("arguments[0].click();", leadName);
		return new LeadDetailsPageHybrid(driver);
	}

}
