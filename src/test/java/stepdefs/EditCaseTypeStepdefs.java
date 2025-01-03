/*
 * $Id$
 *
 * Copyright (c) 2018  Pegasystems Inc.
 * All rights reserved.
 *
 * This  software  has  been  provided pursuant  to  a  License
 * Agreement  containing  restrictions on  its  use.   The  software
 * contains  valuable  trade secrets and proprietary information  of
 * Pegasystems Inc and is protected by  federal   copyright law.  It
 * may  not be copied,  modified,  translated or distributed in  any
 * form or medium,  disclosed to third parties or used in any manner
 * not provided for in  said  License Agreement except with  written
 * authorization from Pegasystems Inc.
*/

package stepdefs;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.prpc.workobjects.EditCaseType;
import com.pega.test.pega_sample_testframework.PlatformBrowser;
import com.pega.test.pega_sample_testframework.PlatformObjectsBean;
import com.pega.test.pega_sample_testframework.PlatformTestEnvironment;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class EditCaseTypeStepdefs {
	TestEnvironment testEnv;
	com.pega.test.pega_sample_testframework.PlatformBrowser browser;
	private PegaWebDriver pegaDriver;
	private EditCaseType editCaseType;
	private PlatformObjectsBean objBean;
	

	@Inject
	public EditCaseTypeStepdefs(PlatformTestEnvironment testEnv, PlatformObjectsBean objBean) {
		this.testEnv = testEnv;
		pegaDriver = testEnv.getPegaDriver();
		browser = (PlatformBrowser) testEnv.getBrowser();
		
		this.objBean = objBean;
	}
	
	@Then("^the new case type should be created$")
	public void the_new_case_type_should_be_created() throws Throwable {
	    editCaseType = objBean.getEditCaseType();
	    Assert.assertTrue(editCaseType.verifyElement(By.xpath("//span[text()='Data model']")));
	}

	@When("^user saves the case type$")
	public void user_saves_the_case_type() throws Throwable {
		editCaseType = objBean.getEditCaseType();
		editCaseType.save();
	}

	@Then("^the case type should be saved successfully without any errors$")
	public void the_case_type_should_be_saved_successfully_without_any_errors() throws Throwable {
		editCaseType = objBean.getEditCaseType();
	    Assert.assertFalse(editCaseType.verifyElement(By.xpath("//*[@node_name='pyRuleFormHeaderMessagesInner']//*[contains(text(),'error')]")));
	}
	
	
}
