package com.sf.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.base.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class TC008_EditALead extends ProjectSpecMethods {
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "EditLead";
	}
	@Test(dataProvider = "excelData")
	public void editLeadTC08(String LastName, String Expected) throws InterruptedException {
		
		new HomePage(driver).clickAppLauncher().clickSales().clickLeadLabel();
		
		
	}

}
