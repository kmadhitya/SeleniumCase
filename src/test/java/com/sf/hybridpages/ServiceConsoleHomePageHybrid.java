package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class ServiceConsoleHomePageHybrid extends ProjectSpecMethods{
	
	/*public ServiceConsoleHomePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public ServiceConsoleHomePageHybrid clickServiceControlDropdown()
	{
		explicitWaitStatement("xpath", "//button[@title='Show Navigation Menu']/lightning-primitive-icon");
		clickElement(locateElement("xpath", "//button[@title='Show Navigation Menu']/lightning-primitive-icon"));
		return this;
	}
	
	public FilesHomePageHybrid clickFiles()
	{
		explicitWaitStatement("xpath", "//div[@role='listbox']//span[text()='Files']");
		clickElement(locateElement("xpath", "//div[@role='listbox']//span[text()='Files']"));
		return new FilesHomePageHybrid();
	}

}
