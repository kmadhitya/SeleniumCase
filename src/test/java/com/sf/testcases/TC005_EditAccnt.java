package com.sf.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.pages.HomePage;
import com.sf.projectspecmethod.ProjectSpecMethods;

public class TC005_EditAccnt extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "EditAccount";
	}
	@Test(dataProvider = "excelData", dependsOnMethods = "com.sf.testcases.TC004_CreateAccnt.createAccountTC04")
	public void editAccountTC05(String phone, String billingAddress, String shippingAddress, String typeValue)
	{
		new HomePage(driver).clickAppLauncher().clickSales().clickAccountLabel().openFirstAccount().editAccount()
		.enterPhone(phone).selectTypeAsTechnologyPartner().selectIndustryAsHealthCare().enterBillingAddress(billingAddress)
		.enterShippingAddress(shippingAddress).selectCustomerPriorityAsLow().selectslaAsSilver().selectActiveAsNo()
		.selectUpsellOptyAsNo().clickSaveButton().selectDetailsTab().verifyType(typeValue);
	}

}
