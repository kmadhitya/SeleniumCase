package com.sf.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.base.ProjectSpecMethods;

public class FilesHomePage extends ProjectSpecMethods{
	
	public FilesHomePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public FilesHomePage clickShowMoreActionDropdown()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[4]")));
		driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).click();
		return this;
	}
	
	public FilesHomePage clickPublicLink()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Public Link'])[1]")));
		driver.findElement(By.xpath("(//a[@title='Public Link'])[1]")).click();
		return this;
	}
	
	public FilesHomePage clickDownload()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Download'])[1]")));
		driver.findElement(By.xpath("(//a[@title='Download'])[1]")).click();
		return this;
	}
	
	public FilesHomePage clickShare()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Share'])[1]")));
		driver.findElement(By.xpath("(//a[@title='Share'])[1]")).click();
		return this;
	}
	
	public FilesHomePage clickSearchPeople()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search People']")));
		driver.findElement(By.xpath("//input[@title='Search People']")).click();
		return this;
	}
	
	public FilesHomePage selectDerrick()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Derrick Dsouza']")));
		driver.findElement(By.xpath("//div[@title='Derrick Dsouza']")).click();
		return this;
	}
	
	public FilesHomePage verifyCantShareWithOwnerMessage()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lookupCmp']/ul/li")));		
		String actualText = driver.findElement(By.xpath("//div[@class='lookupCmp']/ul/li")).getText();
		Assert.assertEquals(actualText, "Can't share file with the file owner.");
		return this;
	}
	

	
	public FilesHomePage verifyLinkTextFieldIsDisabled()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='publicLinkURL']")));
		String attribute = driver.findElement(By.xpath("//input[@name='publicLinkURL']")).getAttribute("readonly");
		System.out.println(attribute);
		//Assert.assertFalse(condition);
		Assert.assertNotNull(attribute);
		return this;
	}
	
	public FilesHomePage closePublicLinkWindow()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Close this window']//lightning-primitive-icon")));
		driver.findElement(By.xpath("//button[@title='Close this window']//lightning-primitive-icon")).click();
		return this;
	}
	
	public FilesHomePage clickUploadFiles()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Upload Files']")));
		driver.findElement(By.xpath("//div[@title='Upload Files']")).click();
		return this;
	}
	
	public FilesHomePage uploadFiles() throws AWTException
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
	
	
	public FilesHomePage doneUploadFiles()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Done']")));
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		return this;
	}
	
	public FilesHomePage clickViewFileDetails()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='View File Details'])[1]")));
		driver.findElement(By.xpath("(//a[@title='View File Details'])[1]")).click();
		return this;
	}
	
	
}
