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

import com.google.inject.Inject;
import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.prpc.portal.DesignerStudioPortal;
import com.pega.prpc.workobjects.EditCaseType;
import com.pega.test.pega_sample_testframework.PlatformBrowser;
import com.pega.test.pega_sample_testframework.PlatformObjectsBean;
import com.pega.test.pega_sample_testframework.PlatformTestEnvironment;

import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class DesignerStudioStepdefs {
	TestEnvironment testEnv;
	com.pega.test.pega_sample_testframework.PlatformBrowser browser;
	private PegaWebDriver pegaDriver;
	private EditCaseType forecast;
	private DesignerStudioPortal dsPortal;
	private PlatformObjectsBean objBean;

	@Inject
	public DesignerStudioStepdefs(PlatformTestEnvironment testEnv, PlatformObjectsBean objBean) {
		this.testEnv = testEnv;
		pegaDriver = testEnv.getPegaDriver();
		browser = (PlatformBrowser) testEnv.getBrowser();
		dsPortal = browser.getPortal(DesignerStudioPortal.class);
		
		this.objBean = objBean;
		
		
	}
	
	@When("^user navigates to cases explorer$")
	public void user_navigates_to_cases_explorer() throws Throwable {
		dsPortal.navigateToCasesExplorer();
	}

	@When("^creates a new case type \"([^\"]*)\"$")
	public void creates_a_new_case_type(String caseName) throws Throwable {
	   EditCaseType editCaseType = dsPortal.createCase(objBean.putTimeStampedValue(caseName));
	   objBean.setEditCaseType(editCaseType);
	}
	
	
}
