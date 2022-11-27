package com.sf.projectspecificmethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.salesforce.base.SalesforceBase;
import com.sf.utilities.ReadExcel;

public class ProjectSpecificMethod extends SalesforceBase{
	
	public String excelFileName;
	public static Properties prop;
	@BeforeSuite
	public void init()
	{
		System.out.println("At Before Suite");
		createTestReport();
	}
	
	@DataProvider(name = "excelData")
	public Object[][] optyData() throws IOException
	{
		Object[][] data = ReadExcel.readExcelData(excelFileName);
		return data;
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("At Before Class");
		createTestcaseEntry("testcaseName", "testDesc", "author", "category");
	}
	
	//@Parameters({"url","username","password"})
	@BeforeMethod
	public void launchBrowserAndLoadURL() throws IOException
	{
		System.out.println("At Before Test");
		startIteration("testcaseName");
		//File downloadFolder = new File("D:\\Workspace\\Selenium\\files\\");
		//downloadFolder.mkdir();
		//Map<String, Object> preferences = new HashMap<String, Object>();
		//preferences.put("profile.default_content_settings.popups", 0);
		//preferences.put("download.default_directory", "D:\\Workspace\\Selenium\\files\\");
		
		//options.setExperimentalOption("prefs", preferences);
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(new File("src/main/resources/config.properties"));
		prop.load(fis);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String pwd = prop.getProperty("password");

		openURLInChromeBrowser(url);
		
		typeText(locateElement("id", "username"), username);
		typeText(locateElement("id", "password"), pwd); 
		clickElement(locateElement("id", "Login")); 
		
		String title = getTitleOfThePage();
		System.out.println("Title is : " + title);
		if (title.contains("Salesforce - Developer Edition"))
		{
			clickElement(locateElement("xpath", "(//a[text()='Switch to Lightning Experience'])[1]")); 
		}
	}
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("At After Test");
		closeTheBrowser();
	}
	@AfterSuite
	public void quitBrowser()
	{
		System.out.println("At After Suite");
		quitTheBrowser();
		publish();
	}

}
