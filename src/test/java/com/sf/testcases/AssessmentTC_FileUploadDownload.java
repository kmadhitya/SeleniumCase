package com.sf.testcases;

import org.testng.annotations.Test;

import com.sf.base.ProjectSpecMethods;
import com.sf.pages.HomePage;

public class AssessmentTC_FileUploadDownload extends ProjectSpecMethods {
	
	@Test()
	public void fileUploadDownload()
	{
		new HomePage(driver).clickAppLauncher().clickServiceConsole().clickServiceControlDropdown().clickFiles().clickShowMoreActionDropdown()
		.clickPublicLink().verifyLinkTextFieldIsDisabled().closePublicLinkWindow().clickShowMoreActionDropdown().clickDownload()
		.clickShowMoreActionDropdown().clickShare().clickSearchPeople().selectDerrick().verifyCantShareWithOwnerMessage()
		.closePublicLinkWindow().clickUploadFiles();
	}

}
