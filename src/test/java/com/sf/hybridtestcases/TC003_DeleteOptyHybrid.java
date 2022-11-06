package com.sf.hybridtestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.hybridpages.HomePageHybrid;
import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class TC003_DeleteOptyHybrid extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "DeleteOpty";
	}
	@Test(dataProvider = "excelData", dependsOnMethods = "com.sf.hybridtestcases.TC002_EditOptyHybrid.editOptyTC02Hybrid")
	public void deleteOptyTC03Hybrid(String expectedText, String searchText)
	{
		new HomePageHybrid().clickAppLauncher().clickSales().clickOpportunityLabel().searchOpportunity(searchText).openOpportunity()
		.deleteOpportunity().confirmDelete().clearSearchText().searchOpportunity(searchText).verifyNoItemsDisplayedMessage(expectedText);
	}

}
