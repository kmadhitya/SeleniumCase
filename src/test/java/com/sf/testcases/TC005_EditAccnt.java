package com.sf.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.base.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class TC005_EditAccnt extends ProjectSpecMethods{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "EditAccount";
	}
	@Test(dataProvider = "excelData")
	public void editAccountTC05(String phone, String billingAddress, String shippingAddress, String typeValue)
	{
		new HomePage().clickAppLauncher().clickSales().clickAccountLabel().openAccount().editAccount()
		.enterPhone(phone).selectTypeAsTechnologyPartner().selectIndustryAsHealthCare().enterBillingAddress(billingAddress)
		.enterShippingAddress(shippingAddress).selectCustomerPriorityAsLow().selectslaAsSilver().selectActiveAsNo()
		.selectUpsellOptyAsNo().clickSaveButton().selectDetailsTab().verifyType(typeValue);
	}

}
