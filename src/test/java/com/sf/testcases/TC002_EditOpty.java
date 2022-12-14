package com.sf.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class TC002_EditOpty extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "EditOpty";
	}
	@Test(dataProvider = "excelData", dependsOnMethods = "com.sf.testcases.TC001_CreateOpty.createOptyTC01")
	public void editOptyTC02(String stage)
	{
		new HomePage(driver).clickAppLauncher().clickSales().clickOpportunityLabel().openOpportunity().editOpportunity().clearAndSelectDate()
		.selectStageAsPerceptionAnalysis().selectDeliveryStatusFromNoneToInprogress().clickSaveButton().selectDetailsTab()
		.verifyCloseDate().verifyStage(stage);
	}

}
