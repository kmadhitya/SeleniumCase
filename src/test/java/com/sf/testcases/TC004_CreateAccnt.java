package com.sf.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.base.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class TC004_CreateAccnt extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "CreateAccount";
	}
	@Test(dataProvider = "excelData")
	public void createAccountTC04(String accountName) {
		
		new HomePage().clickAppLauncher().clickSales().clickAccountLabel().clickNewButton()
		.enterAccountName(accountName).selectOwnershipAsPublic().clickSaveButton();
		
	}

}
