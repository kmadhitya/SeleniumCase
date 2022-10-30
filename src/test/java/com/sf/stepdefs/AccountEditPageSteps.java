package com.sf.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.When;

public class AccountEditPageSteps extends BasicSteps {
	
	@When ("I enter Phone {string}")
	public void enterPhone(String phone)
	{
		driver.findElement(By.xpath(prop.getProperty("AccountEditPage.Phone.xpath"))).sendKeys(phone);
	}
	
	@When ("I select Type as Technology Partner")
	public void selectTypeAsTechnologyPartner()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountEditPage.Type.xpath"))).click();
		WebElement type = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.TypeAsTechnologyPartner.xpath")));
		executor.executeScript("arguments[0].click();", type);
	}
	
	@When ("I select Industry as HealthCare")
	public void selectIndustryAsHealthCare()
	{
		WebElement click_industry = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.Industry.xpath")));
		executor.executeScript("arguments[0].click();", click_industry);
		WebElement industry = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.IndustryAsHealthcare.xpath")));
		executor.executeScript("arguments[0].click();", industry);
	}
	
	@When ("I enter Billing Address {string}")
	public void enterBillingAddress(String billingAddress)
	{
		WebElement billingStreet = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.BillingAddress.xpath")));
		executor.executeScript("arguments[0].value='"+ billingAddress +"';", billingStreet);
	}
	
	@When ("I enter Shipping Address {string}")
	public void enterShippingAddress(String shippingAddress)
	{
		WebElement shippingStreet = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.ShippingAddress.xpath")));
		executor.executeScript("arguments[0].value='"+ shippingAddress +"';", shippingStreet);
	}
	
	@When ("I select Customer Priority as Low")
	public void selectCustomerPriorityAsLow()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.CustomerPriority.xpath"))));
		WebElement customerPriority = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.CustomerPriority.xpath")));
		executor.executeScript("arguments[0].click();", customerPriority);
		WebElement customerPriorityValue = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.CustomerPriorityAsLow.xpath")));
		executor.executeScript("arguments[0].click();", customerPriorityValue);
	}
	
	@When ("I select SLA as Silver")
	public void selectslaAsSilver()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.SLA.xpath"))));
		WebElement sla = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.SLA.xpath")));
		executor.executeScript("arguments[0].click();", sla);
		WebElement slaValue = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.SLAasSilver.xpath")));
		executor.executeScript("arguments[0].click();", slaValue);
	}
	
	@When ("I select Active as No")
	public void selectActiveAsNo()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.Active.xpath"))));
		WebElement active = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.Active.xpath")));
		executor.executeScript("arguments[0].click();", active);
		WebElement activeValue = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.ActiveAsNo.xpath")));
		executor.executeScript("arguments[0].click();", activeValue);
	}
	
	@When ("I select Upsell Opty as No")
	public void selectUpsellOptyAsNo()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountEditPage.UpsellOpportunity.xpath"))));
		WebElement upsellOpty = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.UpsellOpportunity.xpath")));
		executor.executeScript("arguments[0].click();", upsellOpty);
		WebElement upsellOptyValue = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.UpsellOpportunityAsNo.xpath")));
		executor.executeScript("arguments[0].click();", upsellOptyValue);
	}

}
