package com.sf.hybridtestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.hybridpages.HomePageHybrid;
import com.sf.projectspecmethod.ProjectSpecMethods;

public class TC001_CreateOptyHybrid extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "CreateOpty";
	}
	@Test(dataProvider = "excelData")
	public void createOptyTC01Hybrid(String name, String toastExpectedText)
	{
		new HomePageHybrid().clickAppLauncher();
		//.clickSales().clickOpportunityLabel().clickNewButton().enterOpportunityName(name)
		//.selectCloseDateAsToday().selectStageAsNeedsAnalysis("Needs Analysis").clickSaveButton().verifyToastMessage(toastExpectedText).verifyOpportunityName(name);
	}

}
