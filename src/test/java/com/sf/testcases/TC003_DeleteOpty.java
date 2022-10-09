package com.sf.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.base.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class TC003_DeleteOpty extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "DeleteOpty";
	}
	@Test(dataProvider = "excelData")
	public void deleteOptyTC03(String expectedText, String searchText)
	{
		new HomePage().clickAppLauncher().clickSales().clickOpportunityLabel().searchOpportunity(searchText).openOpportunity()
		.deleteOpportunity().confirmDelete().clearSearchText().searchOpportunity(searchText).verifyNoItemsDisplayedMessage(expectedText);
	}

}
