package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.base.ProjectSpecMethods;

public class AccountEditPage extends ProjectSpecMethods{
	
	public AccountEditPage enterPhone(String phone)
	{
		driver.findElement(By.xpath("//label[text()='Phone']/following-sibling::div/input")).sendKeys(phone);
		return this;
	}
	
	public AccountEditPage selectTypeAsTechnologyPartner()
	{
		driver.findElement(By.xpath("//label[text()='Type']/following-sibling::div[1]//button")).click();
		WebElement type = driver.findElement(By.xpath("//span[@title='Technology Partner']"));
		executor.executeScript("arguments[0].click();", type);
		return this;
	}
	
	public AccountEditPage selectIndustryAsHealthCare()
	{
		WebElement click_industry = driver.findElement(By.xpath("//label[text()='Industry']/following-sibling::div[1]//button"));
		executor.executeScript("arguments[0].click();", click_industry);
		WebElement industry = driver.findElement(By.xpath("//span[@title='Healthcare']"));
		executor.executeScript("arguments[0].click();", industry);
		return this;
	}
	
	public AccountEditPage enterBillingAddress(String billingAddress)
	{
		WebElement billingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following-sibling::div/textarea"));
		executor.executeScript("arguments[0].value='"+ billingAddress +"';", billingStreet);
		return this;
	}
	
	public AccountEditPage enterShippingAddress(String shippingAddress)
	{
		WebElement shippingStreet = driver.findElement(By.xpath("//label[text()='Shipping Street']/following-sibling::div/textarea"));
		executor.executeScript("arguments[0].value='"+ shippingAddress +"';", shippingStreet);
		return this;
	}
	
	public AccountEditPage selectCustomerPriorityAsLow()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Customer Priority']/following-sibling::div[1]//button")));
		WebElement customerPriority = driver.findElement(By.xpath("//label[text()='Customer Priority']/following-sibling::div[1]//button"));
		executor.executeScript("arguments[0].click();", customerPriority);
		WebElement customerPriorityValue = driver.findElement(By.xpath("//span[@title='Low']"));
		executor.executeScript("arguments[0].click();", customerPriorityValue);
		return this;
	}
	
	public AccountEditPage selectslaAsSilver()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='SLA']/following-sibling::div[1]//button")));
		WebElement sla = driver.findElement(By.xpath("//label[text()='SLA']/following-sibling::div[1]//button"));
		executor.executeScript("arguments[0].click();", sla);
		WebElement slaValue = driver.findElement(By.xpath("//span[@title='Silver']"));
		executor.executeScript("arguments[0].click();", slaValue);
		return this;
	}
	
	public AccountEditPage selectActiveAsNo()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Active']/following-sibling::div[1]//button")));
		WebElement active = driver.findElement(By.xpath("//label[text()='Active']/following-sibling::div[1]//button"));
		executor.executeScript("arguments[0].click();", active);
		WebElement activeValue = driver.findElement(By.xpath("(//span[text()='No'])[1]"));
		executor.executeScript("arguments[0].click();", activeValue);
		return this;
	}
	
	public AccountEditPage selectUpsellOptyAsNo()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Upsell Opportunity']/following-sibling::div[1]//button")));
		WebElement upsellOpty = driver.findElement(By.xpath("//label[text()='Upsell Opportunity']/following-sibling::div[1]//button"));
		executor.executeScript("arguments[0].click();", upsellOpty);
		WebElement upsellOptyValue = driver.findElement(By.xpath("(//span[text()='No'])[1]"));
		executor.executeScript("arguments[0].click();", upsellOptyValue);
		return this;
	}
	
	public AccountDetailsPage clickSaveButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return new AccountDetailsPage();
	}

}
