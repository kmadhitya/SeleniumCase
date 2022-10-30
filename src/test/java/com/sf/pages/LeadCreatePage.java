package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sf.base.ProjectSpecMethods;

public class LeadCreatePage extends ProjectSpecMethods {
	
	public LeadCreatePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public LeadCreatePage selectSalutationAsMr()
	{
		driver.findElement(By.xpath("//label[text()='Salutation']/following-sibling::div[1]//button")).click();
		driver.findElement(By.xpath("//label[text()='Salutation']/following-sibling::div[1]//span[text()='Mr.']")).click();
		return this;
	}
	
	public LeadCreatePage enterLastName(String name)
	{
		driver.findElement(By.xpath("//label[text()='Last Name']/following-sibling::div[1]/input")).sendKeys(name);
		return this;
	}
	
	public LeadCreatePage enterCompanyName(String company)
	{
		driver.findElement(By.xpath("//label[text()='Company']/following-sibling::div[1]/input")).sendKeys(company);
		return this;
	}
	
	public LeadDetailsPage clickSaveButton()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountCreatePage.SaveButton.xpath"))).click();
		return new LeadDetailsPage(driver);
	}

}
