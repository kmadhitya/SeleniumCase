package com.sf.hybridpages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class FilesHomePageHybrid extends ProjectSpecMethods{
	
	/*public FilesHomePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public FilesHomePageHybrid clickShowMoreActionDropdown()
	{
		explicitWaitStatement("xpath", "//tbody/tr[1]/td[4]");
		clickElement(locateElement("xpath", "//tbody/tr[1]/td[4]"));
		return this;
	}
	
	public FilesHomePageHybrid clickPublicLink()
	{
		explicitWaitStatement("xpath", "(//a[@title='Public Link'])[1]");
		clickElement(locateElement("xpath", "(//a[@title='Public Link'])[1]"));
		return this;
	}
	
	public FilesHomePageHybrid clickDownload()
	{
		explicitWaitStatement("xpath", "(//a[@title='Download'])[1]");
		clickElement(locateElement("xpath", "(//a[@title='Download'])[1]"));
		return this;
	}
	
	public FilesHomePageHybrid clickShare()
	{
		explicitWaitStatement("xpath", "(//a[@title='Share'])[1]");
		clickElement(locateElement("xpath", "(//a[@title='Share'])[1]"));
		return this;
	}
	
	public FilesHomePageHybrid clickSearchPeople()
	{
		explicitWaitStatement("xpath", "//input[@title='Search People']");
		clickElement(locateElement("xpath", "//input[@title='Search People']"));
		return this;
	}
	
	public FilesHomePageHybrid selectDerrick()
	{
		explicitWaitStatement("xpath", "//div[@title='Derrick Dsouza']");
		clickElement(locateElement("xpath", "//div[@title='Derrick Dsouza']"));
		return this;
	}
	
	public FilesHomePageHybrid verifyCantShareWithOwnerMessage()
	{
		explicitWaitStatement("xpath", "//div[@class='lookupCmp']/ul/li");
		String actualText = getTheActualText(locateElement("xpath", "//div[@class='lookupCmp']/ul/li"));
		Assert.assertEquals(actualText, "Can't share file with the file owner.");
		return this;
	}
	

	
	public FilesHomePageHybrid verifyLinkTextFieldIsDisabled()
	{
		explicitWaitStatement("xpath", "//input[@name='publicLinkURL']");
		//String attribute = driver.findElement(By.xpath("//input[@name='publicLinkURL']")).getAttribute("readonly");
		String attribute = getAttributeValue(locateElement("xpath", "//input[@name='publicLinkURL']"), "readonly");
		System.out.println(attribute);
		//Assert.assertFalse(condition);
		Assert.assertNotNull(attribute);
		return this;
	}
	
	public FilesHomePageHybrid closePublicLinkWindow()
	{
		explicitWaitStatement("xpath", "//button[@title='Close this window']//lightning-primitive-icon");
		clickElement(locateElement("xpath", "//button[@title='Close this window']//lightning-primitive-icon"));
		return this;
	}
	
	public FilesHomePageHybrid clickUploadFiles()
	{
		explicitWaitStatement("xpath", "//div[@title='Upload Files']");
		clickElement(locateElement("xpath", "//div[@title='Upload Files']"));
		return this;
	}
	
	public FilesHomePageHybrid uploadFiles() throws AWTException
	{
		Robot rb = new Robot();
		 
	    // copying File path to Clipboard
	    StringSelection str = new StringSelection("C:\\Users\\ADITHYA\\fileUpload1.txt");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	 
	     // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
		return this;
	}
	
	
	public FilesHomePageHybrid doneUploadFiles()
	{
		explicitWaitStatement("xpath", "//span[text()='Done']");
		clickElement(locateElement("xpath", "//span[text()='Done']"));
		return this;
	}
	
	public FilesHomePageHybrid clickViewFileDetails()
	{
		explicitWaitStatement("xpath", "(//a[@title='View File Details'])[1]");
		clickElement(locateElement("xpath", "(//a[@title='View File Details'])[1]"));
		return this;
	}
	
	
}
