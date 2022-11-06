package com.sf.hybridtestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.hybridpages.HomePageHybrid;
import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class TC010_CreateDashboardHybrid extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "CreateDash";
	}
	@Test(dataProvider = "excelData")
	public void createOptyTC01Hybrid(String name, String toastMessage) throws InterruptedException
	{
		new HomePageHybrid().clickAppLauncher().clickViewAll().clickDashboard().clickNewDashboard().enterDashboardName(name)
		.clickCreateButton().clickSaveButton().verifyToastMessage(toastMessage).clickDoneButton().verifyDashboardName(name);
	}

}
