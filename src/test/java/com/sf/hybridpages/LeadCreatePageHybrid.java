package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class LeadCreatePageHybrid extends ProjectSpecMethods {
	
	public LeadCreatePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public LeadCreatePageHybrid selectSalutationAsMr()
	{
		driver.findElement(By.xpath("//label[text()='Salutation']/following-sibling::div[1]//button")).click();
		driver.findElement(By.xpath("//label[text()='Salutation']/following-sibling::div[1]//span[text()='Mr.']")).click();
		return this;
	}
	
	public LeadCreatePageHybrid enterLastName(String name)
	{
		driver.findElement(By.xpath("//label[text()='Last Name']/following-sibling::div[1]/input")).sendKeys(name);
		return this;
	}
	
	public LeadCreatePageHybrid enterCompanyName(String company)
	{
		driver.findElement(By.xpath("//label[text()='Company']/following-sibling::div[1]/input")).sendKeys(company);
		return this;
	}
	
	public LeadDetailsPageHybrid clickSaveButton()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountCreatePage.SaveButton.xpath"))).click();
		return new LeadDetailsPageHybrid(driver);
	}

}
