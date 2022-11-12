package com.sf.hybridtestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.hybridpages.HomePageHybrid;
import com.sf.hybridprojectspecmethod.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class TC006_DeleteAccntHybrid extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "DeleteAccount";
	}
	@Test(dataProvider = "excelData", dependsOnMethods = "com.sf.hybridtestcases.TC005_EditAccntHybrid.editAccountTC05Hybrid")
	public void deleteOptyTC06Hybrid(String expectedText, String searchText)
	{
		new HomePageHybrid().clickAppLauncher().clickSales().clickAccountLabel().searchAccount(searchText).openFirstAccount().deleteAccount()
		.confirmDeleteAccount().clearSearchText().searchAccount(searchText).verifyNoItemsToDisplay(expectedText);
	}
}
