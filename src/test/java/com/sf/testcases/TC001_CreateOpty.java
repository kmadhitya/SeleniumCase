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
		new HomePage().clickAppLauncher().clickSales().clickOpportunityLabel().clickNewButton().enterOpportunityName(name)
		.selectCloseDateAsToday().selectStageAsNeedsAnalysis().clickSaveButton().verifyToastMessage(toastExpectedText).verifyOpportunityName(name);
	}

}
