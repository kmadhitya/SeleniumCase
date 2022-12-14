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
		folder = new File("./reports/"+date);
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
		MediaEntityModelProvider snap = null;
		if (!status.equalsIgnoreCase("INFO"))
		{
		try
		{
			long snapNumber = takeSnap();
			snap = MediaEntityBuilder.createScreenCaptureFromPath("./../../"+folder+"/"+snapNumber+".png").build();
		}
		catch(IOException e)
		{}
		}
		if (status.equalsIgnoreCase("PASS"))
		{
			node.log(Status.PASS, step, snap);
		}
		else if(status.equalsIgnoreCase("FAIL"))
		{
			node.log(Status.FAIL, step, snap);
		}
		else if(status.equalsIgnoreCase("WARNING"))
		{
			node.log(Status.WARNING, step, snap);
		}
		else if(status.equalsIgnoreCase("INFO"))
		{
			node.log(Status.INFO, step);
		}
	}
	
	public void publish()
	{
		extent.flush();
	}

}
