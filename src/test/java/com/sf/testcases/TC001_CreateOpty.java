package com.sf.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.base.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class TC001_CreateOpty extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "CreateOpty";
	}
	@Test(dataProvider = "excelData")
	public void createOptyTC01(String name, String toastExpectedText)
	{
		new HomePage(driver).clickAppLauncher().clickSales().clickOpportunityLabel().clickNewButton().enterOpportunityName(name)
		.selectCloseDateAsToday().selectStageAsNeedsAnalysis("Needs Analysis").clickSaveButton().verifyToastMessage(toastExpectedText).verifyOpportunityName(name);
	}

}
