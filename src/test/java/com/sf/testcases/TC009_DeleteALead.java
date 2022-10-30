package com.sf.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sf.base.ProjectSpecMethods;

public class TC009_DeleteALead extends ProjectSpecMethods {
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "DeleteLead";
	}
	@Test(dataProvider = "excelData")
	public void deleteLeadTC09() throws InterruptedException {
		
		
	}

}
