package com.salesforce.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnderstandingReport {
	
	public static void main(String[] args) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./reports/snap1.png"));
		
		ExtentReports extent = new ExtentReports();
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File("./reports/index.html"));
		htmlReporter.setAppendExisting(true);
		extent.attachReporter(htmlReporter);
		
		ExtentTest test = extent.createTest("Create Lead");
		test.assignAuthor("Adhitya");
		test.assignCategory("Smoke");
		
		ExtentTest node = test.createNode("Iteration 2");
		
		MediaEntityModelProvider snap = MediaEntityBuilder.createScreenCaptureFromPath("./snap.png").build();
		
		node.log(Status.PASS, "Create Lead link is clicked", snap);
		node.log(Status.PASS, "Company name is entered");
		node.log(Status.PASS, "First name is entered");
		node.log(Status.PASS, "Create Lead button is clicked");
		
		extent.flush();
	}
	
	
	

}
