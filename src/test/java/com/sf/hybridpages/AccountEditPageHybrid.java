package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.projectspecmethod.ProjectSpecMethods;

public class AccountEditPageHybrid extends ProjectSpecMethods{
	
	public AccountEditPageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public AccountEditPageHybrid enterPhone(String phone)
	{
		driver.findElement(By.xpath(prop.getProperty("AccountEditPage.Phone.xpath"))).sendKeys(phone);
		return this;
	}
	
	public AccountEditPageHybrid selectTypeAsTechnologyPartner()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountEditPage.Type.xpath"))).click();
		WebElement type = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.TypeAsTechnologyPartner.xpath")));
		executor.executeScript("arguments[0].click();", type);
		return this;
	}
	
	public AccountEditPageHybrid selectIndustryAsHealthCare()
	{
		WebElement click_industry = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.Industry.xpath")));
		executor.executeScript("arguments[0].click();", click_industry);
		WebElement industry = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.IndustryAsHealthcare.xpath")));
		executor.executeScript("arguments[0].click();", industry);
		return this;
	}
	
	public AccountEditPageHybrid enterBillingAddress(String billingAddress)
	{
		WebElement billingStreet = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.BillingAddress.xpath")));
		executor.executeScript("arguments[0].value='"+ billingAddress +"';", billingStreet);
		return this;
	}
	
	public AccountEditPageHybrid enterShippingAddress(String shippingAddress)
	{
		WebElement shippingStreet = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.ShippingAddress.xpath")));
		executor.executeScript("arguments[0].value='"+ shippingAddress +"';", shippingStreet);
		return this;
	}
	
	public AccountEditPageHybrid selectCustomerPriorityAsLow()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.CustomerPriority.xpath"))));
		WebElement customerPriority = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.CustomerPriority.xpath")));
		executor.executeScript("arguments[0].click();", customerPriority);
		WebElement customerPriorityValue = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.CustomerPriorityAsLow.xpath")));
		executor.executeScript("arguments[0].click();", customerPriorityValue);
		return this;
	}
	
	public AccountEditPageHybrid selectslaAsSilver()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.SLA.xpath"))));
		WebElement sla = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.SLA.xpath")));
		executor.executeScript("arguments[0].click();", sla);
		WebElement slaValue = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.SLAasSilver.xpath")));
		executor.executeScript("arguments[0].click();", slaValue);
		return this;
	}
	
	public AccountEditPageHybrid selectActiveAsNo()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.Active.xpath"))));
		WebElement active = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.Active.xpath")));
		executor.executeScript("arguments[0].click();", active);
		WebElement activeValue = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.ActiveAsNo.xpath")));
		executor.executeScript("arguments[0].click();", activeValue);
		return this;
	}
	
	public AccountEditPageHybrid selectUpsellOptyAsNo()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.UpsellOpportunity.xpath"))));
		WebElement upsellOpty = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.UpsellOpportunity.xpath")));
		executor.executeScript("arguments[0].click();", upsellOpty);
		WebElement upsellOptyValue = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.UpsellOpportunityAsNo.xpath")));
		executor.executeScript("arguments[0].click();", upsellOptyValue);
		return this;
	}
	
	public AccountDetailsPageHybrid clickSaveButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.SaveButton.xpath"))));
		driver.findElement(By.xpath(prop.getProperty("AccountEditPage.SaveButton.xpath"))).click();
		return new AccountDetailsPageHybrid(driver);
	}

}
