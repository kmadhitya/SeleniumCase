package com.sf.hybridactions;

import org.openqa.selenium.WebElement;

public interface ElementActions {
	
	public WebElement locateElement(String locator, String value);
	
	public void typeText(WebElement ele, String text);
	
	public void clearAndTypeText(WebElement ele, String text);
	
	public void typeTextUsingJavaScript(WebElement ele, String text);
	
	public void clickElement(WebElement ele);
	
	public void clickElementUsingJavaScript(WebElement ele);
	
	public String getTitleOfThePage();
	
	public String getTheActualText(WebElement ele);
	
	public void explicitWaitStatement(String locator, String locatorValue);

}
