package com.pega.prpc.portal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebElement;
import com.pega.page.PortalImpl;
import com.pega.prpc.workobjects.EditCaseType;
import com.pega.util.XPathUtil;

public class DesignerStudioPortal extends PortalImpl{

	public static final By CASE_TYPES_TAB = By.xpath("//h3[text()='Case types']");
	public static final By APP_TAB = By.xpath("//h3[text()='App']");
	public static final By ADD_A_CASE_TYPE_LINK =  By.xpath(XPathUtil.getDataTestIDXpath("20141104095612021373913"));
	public static final By NEW_CASE_NAME = By.xpath("//input[contains(@name,'pyLabel')]");
	public static final By SUBMIT_NEW_CASE_CREATION =  By.xpath(XPathUtil.getDataTestIDXpath("20150317121334023740966"));
	
	public DesignerStudioPortal(TestEnvironment testEnv) {
		super(testEnv);
	}

	public void navigateToCasesExplorer() {
		PegaWebElement caseTypesTab = findElement(CASE_TYPES_TAB);
		caseTypesTab.click();
		
		findAutoComplete(CASE_TYPES_TAB).setValue("North East");
	}
	
	public void navigateToAppExplorer() {
		PegaWebElement caseTypesTab = findElement(APP_TAB);
		caseTypesTab.click();
		
		findAutoComplete(CASE_TYPES_TAB).setValue("North East");
	}
	
	public EditCaseType createCase(String caseName) {
		findElement(ADD_A_CASE_TYPE_LINK).click();
		findElement(NEW_CASE_NAME).sendKeys(caseName+Keys.TAB);
		findElement(SUBMIT_NEW_CASE_CREATION).click();
		return new EditCaseType(getActiveFrameId(true), testEnv);
	}
	
}
