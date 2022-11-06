package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class AccountEditPage extends ProjectSpecMethods{
	
	public AccountEditPage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public AccountEditPage enterPhone(String phone)
	{
		driver.findElement(By.xpath(prop.getProperty("AccountEditPage.Phone.xpath"))).sendKeys(phone);
		return this;
	}
	
	public AccountEditPage selectTypeAsTechnologyPartner()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountEditPage.Type.xpath"))).click();
		WebElement type = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.TypeAsTechnologyPartner.xpath")));
		executor.executeScript("arguments[0].click();", type);
		return this;
	}
	
	public AccountEditPage selectIndustryAsHealthCare()
	{
		WebElement click_industry = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.Industry.xpath")));
		executor.executeScript("arguments[0].click();", click_industry);
		WebElement industry = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.IndustryAsHealthcare.xpath")));
		executor.executeScript("arguments[0].click();", industry);
		return this;
	}
	
	public AccountEditPage enterBillingAddress(String billingAddress)
	{
		WebElement billingStreet = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.BillingAddress.xpath")));
		executor.executeScript("arguments[0].value='"+ billingAddress +"';", billingStreet);
		return this;
	}
	
	public AccountEditPage enterShippingAddress(String shippingAddress)
	{
		WebElement shippingStreet = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.ShippingAddress.xpath")));
		executor.executeScript("arguments[0].value='"+ shippingAddress +"';", shippingStreet);
		return this;
	}
	
	public AccountEditPage selectCustomerPriorityAsLow()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.CustomerPriority.xpath"))));
		WebElement customerPriority = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.CustomerPriority.xpath")));
		executor.executeScript("arguments[0].click();", customerPriority);
		WebElement customerPriorityValue = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.CustomerPriorityAsLow.xpath")));
		executor.executeScript("arguments[0].click();", customerPriorityValue);
		return this;
	}
	
	public AccountEditPage selectslaAsSilver()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.SLA.xpath"))));
		WebElement sla = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.SLA.xpath")));
		executor.executeScript("arguments[0].click();", sla);
		WebElement slaValue = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.SLAasSilver.xpath")));
		executor.executeScript("arguments[0].click();", slaValue);
		return this;
	}
	
	public AccountEditPage selectActiveAsNo()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.Active.xpath"))));
		WebElement active = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.Active.xpath")));
		executor.executeScript("arguments[0].click();", active);
		WebElement activeValue = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.ActiveAsNo.xpath")));
		executor.executeScript("arguments[0].click();", activeValue);
		return this;
	}
	
	public AccountEditPage selectUpsellOptyAsNo()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.UpsellOpportunity.xpath"))));
		WebElement upsellOpty = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.UpsellOpportunity.xpath")));
		executor.executeScript("arguments[0].click();", upsellOpty);
		WebElement upsellOptyValue = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.UpsellOpportunityAsNo.xpath")));
		executor.executeScript("arguments[0].click();", upsellOptyValue);
		return this;
	}
	
	public AccountDetailsPage clickSaveButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.SaveButton.xpath"))));
		driver.findElement(By.xpath(prop.getProperty("AccountEditPage.SaveButton.xpath"))).click();
		return new AccountDetailsPage(driver);
	}

}
