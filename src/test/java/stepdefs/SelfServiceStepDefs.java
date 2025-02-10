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

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.prpc.portal.DesignerStudioPortal;
import com.pega.prpc.portal.SelfServicePortal;
import com.pega.prpc.workobjects.EditCaseType;
import com.pega.prpc.workobjects.Incident;
import com.pega.test.pega_sample_testframework.PlatformBrowser;
import com.pega.test.pega_sample_testframework.PlatformObjectsBean;
import com.pega.test.pega_sample_testframework.PlatformTestEnvironment;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class SelfServiceStepDefs {
	TestEnvironment testEnv;
	com.pega.test.pega_sample_testframework.PlatformBrowser browser;
	private PegaWebDriver pegaDriver;
	private EditCaseType editCaseType;
	private PlatformObjectsBean objBean;
	private SelfServicePortal ssPortal;
	
	public static final By username = By.id("txtUserID");
	public static final By password = By.id("txtPassword");
	public static final By sub = By.id("sub");
	public static final By incident = By.xpath("//span[text()='Incident']/ancestor::button");

	@Inject
	public SelfServiceStepDefs(PlatformTestEnvironment testEnv, PlatformObjectsBean objBean) {
		this.testEnv = testEnv;
		pegaDriver = testEnv.getPegaDriver();
		browser = (PlatformBrowser) testEnv.getBrowser();
		ssPortal = browser.getPortal(SelfServicePortal.class);
		this.objBean = objBean;
	}
	

	@When("I create a new incident")
	public Incident i_create_a_new_incident() {
		
		return ssPortal.createCase("Incident");
	}


	
}
