package com.sf.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.pages.HomePage;
import com.sf.projectspecmethod.ProjectSpecMethods;

public class TC006_DeleteAccnt extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "DeleteAccount";
	}
	@Test(dataProvider = "excelData", dependsOnMethods = "com.sf.testcases.TC005_EditAccnt.editAccountTC05")
	public void deleteOptyTC06(String expectedText, String searchText)
	{
		new HomePage(driver).clickAppLauncher().clickSales().clickAccountLabel().searchAccount(searchText).openFirstAccount().deleteAccount()
		.confirmDeleteAccount().clearSearchText().searchAccount(searchText).verifyNoItemsToDisplay(expectedText);
	}


}
