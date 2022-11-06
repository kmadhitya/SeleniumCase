package com.sf.hybridtestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.hybridpages.HomePageHybrid;
import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class TC002_EditOptyHybrid extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "EditOpty";
	}
	@Test(dataProvider = "excelData", dependsOnMethods = "com.sf.hybridtestcases.TC001_CreateOptyHybrid.createOptyTC01Hybrid")
	public void editOptyTC02Hybrid(String stage)
	{
		new HomePageHybrid().clickAppLauncher().clickSales().clickOpportunityLabel().openOpportunity().editOpportunity().clearAndSelectDate()
		.selectStageAsPerceptionAnalysis().selectDeliveryStatusFromNoneToInprogress().clickSaveButton().selectDetailsTab()
		.verifyCloseDate().verifyStage(stage);
	}

}
