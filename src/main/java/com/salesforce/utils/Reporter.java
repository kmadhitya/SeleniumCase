package com.salesforce.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Reporter {
	
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test, node;
	public static File folder;
	
	public void createTestReport()
	{
		String date = new SimpleDateFormat("dd-MMM-yy").format(new Date());
		File folder = new File("./reports/"+date);
		if(!folder.exists())
		{
			folder.mkdir();
		}
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(new File(folder+"/index.html"));
		htmlReporter.setAppendExisting(true);
		extent.attachReporter(htmlReporter);
	}
	
	public ExtentTest createTestcaseEntry(String testcase, String testDesc, String author, String category)
	{
		test = extent.createTest(testcase, testDesc);
		test.assignAuthor("Adhitya");
		test.assignCategory("Smoke");
		return test;
	}
	
	public ExtentTest startIteration(String node)
	{
		this.node = test.createNode(node);
		return this.node;
	}
	
	public abstract long takeSnap();
	
	public void reportStep(String step, String status)
	{
		long snapNumber = takeSnap();
		MediaEntityModelProvider snap = null;
		try
		{
			snap = MediaEntityBuilder.createScreenCaptureFromPath("./snap.png").build();
		}
		catch(IOException e)
		{}
		if (status.equalsIgnoreCase("PASS"))
		{
			test.log(Status.PASS, step);
		}
		else if(status.equalsIgnoreCase("FAIL"))
		{
			test.log(Status.FAIL, step, snap);
		}
	}
	
	public void publish()
	{
		extent.flush();
	}

}
