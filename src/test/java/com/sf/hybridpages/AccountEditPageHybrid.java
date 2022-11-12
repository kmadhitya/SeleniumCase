package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class AccountEditPageHybrid extends ProjectSpecMethods{
	
	/*public AccountEditPageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public AccountEditPageHybrid enterPhone(String phone)
	{
		typeText(locateElement("xpath", prop.getProperty("AccountEditPage.Phone.xpath")), phone);
		return this;
	}
	
	public AccountEditPageHybrid selectTypeAsTechnologyPartner()
	{
		clickElement(locateElement("xpath", prop.getProperty("AccountEditPage.Type.xpath")));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("AccountEditPage.TypeAsTechnologyPartner.xpath")));
		return this;
	}
	
	public AccountEditPageHybrid selectIndustryAsHealthCare()
	{
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("AccountEditPage.Industry.xpath")));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("AccountEditPage.IndustryAsHealthcare.xpath")));
		return this;
	}
	
	public AccountEditPageHybrid enterBillingAddress(String billingAddress)
	{
		//WebElement billingStreet = driver.findElement(By.xpath(prop.getProperty("AccountEditPage.BillingAddress.xpath")));
		//executor.executeScript("arguments[0].value='"+ billingAddress +"';", billingStreet);
		typeTextUsingJavaScript(locateElement("xpath", prop.getProperty("AccountEditPage.BillingAddress.xpath")), billingAddress);
		return this;
	}
	
	public AccountEditPageHybrid enterShippingAddress(String shippingAddress)
	{
		typeTextUsingJavaScript(locateElement("xpath", prop.getProperty("AccountEditPage.ShippingAddress.xpath")), shippingAddress);
		return this;
	}
	
	public AccountEditPageHybrid selectCustomerPriorityAsLow()
	{
		explicitWaitStatement("xpath", prop.getProperty("AccountEditPage.CustomerPriority.xpath"));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("AccountEditPage.CustomerPriority.xpath")));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("AccountEditPage.CustomerPriorityAsLow.xpath")));
		return this;
	}
	
	public AccountEditPageHybrid selectslaAsSilver()
	{
		explicitWaitStatement("xpath", prop.getProperty("AccountEditPage.SLA.xpath"));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("AccountEditPage.SLA.xpath")));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("AccountEditPage.SLAasSilver.xpath")));
		return this;
	}
	
	public AccountEditPageHybrid selectActiveAsNo()
	{
		explicitWaitStatement("xpath", prop.getProperty("AccountEditPage.Active.xpath"));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("AccountEditPage.Active.xpath")));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("AccountEditPage.ActiveAsNo.xpath")));
		return this;
	}
	
	public AccountEditPageHybrid selectUpsellOptyAsNo()
	{
		explicitWaitStatement("xpath", prop.getProperty("AccountEditPage.UpsellOpportunity.xpath"));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("AccountEditPage.UpsellOpportunity.xpath")));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("AccountEditPage.UpsellOpportunityAsNo.xpath")));
		return this;
	}
	
	public AccountDetailsPageHybrid clickSaveButton()
	{
		explicitWaitStatement("xpath", prop.getProperty("AccountEditPage.SaveButton.xpath"));
		clickElement(locateElement("xpath", prop.getProperty("AccountEditPage.SaveButton.xpath")));
		return new AccountDetailsPageHybrid();
	}

}
