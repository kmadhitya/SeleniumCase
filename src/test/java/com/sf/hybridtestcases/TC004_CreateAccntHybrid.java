package com.sf.hybridtestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.hybridpages.HomePageHybrid;
import com.sf.hybridprojectspecmethod.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class TC004_CreateAccntHybrid extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "CreateAccount";
	}
	@Test(dataProvider = "excelData")
	public void createAccountTC04Hybrid(String accountName) {
		
		new HomePageHybrid().clickAppLauncher().clickSales().clickAccountLabel().clickNewButton()
		.enterAccountName(accountName).selectOwnershipAsPublic().clickSaveButton().verifyAccountName(accountName);
		
	}
}
