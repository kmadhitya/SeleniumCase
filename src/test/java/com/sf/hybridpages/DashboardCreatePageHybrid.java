package com.sf.hybridpages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class DashboardCreatePageHybrid extends ProjectSpecMethods {
	
	/*public HomePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public DashboardCreatePageHybrid enterDashboardName(String name)
	{
		explicitWaitForFrame(locateElement("xpath", prop.getProperty("DashboardCreatePage.SwitchToFrame.xpath")));
		//switchToTheIFrameUsingWebElement(locateElement("xpath", prop.getProperty("DashboardCreatePage.SwitchToFrame.xpath")));
		explicitWaitStatement("xpath", prop.getProperty("DashboardCreatePage.EnterName.xpath"));
		typeText(locateElement("xpath", prop.getProperty("DashboardCreatePage.EnterName.xpath")), name);
		return this;
	}
	
	public DashboardCreatePageHybrid clickCreateButton()
	{
		clickElement(locateElement("xpath", prop.getProperty("DashboardCreatePage.CreateButton.xpath")));
		return this;
	}
	
	public DashboardCreatePageHybrid clickSaveButton() throws InterruptedException
	{
		explicitWaitForFrame(locateElement("xpath", prop.getProperty("DashboardCreatePage.SwitchToFrame.xpath")));
		explicitWaitStatement("xpath", prop.getProperty("DashboardCreatePage.SaveButton.xpath"));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("DashboardCreatePage.SaveButton.xpath")));
		return this;
	}
	
	public DashboardCreatePageHybrid verifyToastMessage(String toastExpectedText)
	{
		switchBackFromFrame();
		explicitWaitStatement("xpath", prop.getProperty("DashboardCreatePage.ToastMessage.xpath"));
		String toastText = getTheActualText(locateElement("xpath", prop.getProperty("OpportunityDetailsPage.ToastMessage.xpath")));
		System.out.println("Toast message is : " + toastText);
		Assert.assertEquals(toastText, toastExpectedText);
		return this;
	}
	
	public DashboardCreatePageHybrid clickDoneButton()
	{
		explicitWaitForFrame(locateElement("xpath", prop.getProperty("DashboardCreatePage.SwitchToFrame.xpath")));
		explicitWaitStatement("xpath", prop.getProperty("DashboardCreatePage.DoneButton.xpath"));
		clickElement(locateElement("xpath", prop.getProperty("DashboardCreatePage.DoneButton.xpath")));
		return this;
	}
	
	public DashboardCreatePageHybrid verifyDashboardName(String name)
	{
		explicitWaitStatement("xpath", prop.getProperty("DashboardCreatePage.DashboardName.xpath"));
		String actualText = getTheActualText(locateElement("xpath", prop.getProperty("DashboardCreatePage.DashboardName.xpath")));
		Assert.assertEquals(actualText, name);
		return this;
	}

}
