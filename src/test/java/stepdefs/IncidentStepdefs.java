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
public class IncidentStepdefs {
	TestEnvironment testEnv;
	com.pega.test.pega_sample_testframework.PlatformBrowser browser;
	private PegaWebDriver pegaDriver;
	private EditCaseType editCaseType;
	private PlatformObjectsBean objBean;
	

	@Inject
	public IncidentStepdefs(PlatformTestEnvironment testEnv, PlatformObjectsBean objBean) {
		this.testEnv = testEnv;
		pegaDriver = testEnv.getPegaDriver();
		browser = (PlatformBrowser) testEnv.getBrowser();
		
		this.objBean = objBean;
	}
	
	
	@When("I select incident type {string} with subtype {string}")
	public void i_select_incident_type_with_subtype(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I search by {string} having category like {string} and cost {int}")
	public void i_search_by_having_category_like_and_cost(String string, String string2, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("i select the {string} product")
	public void i_select_the_product(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("i provide contact info with manual address")
	public void i_provide_contact_info_with_manual_address() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("i select {string} for resolution method")
	public void i_select_for_resolution_method(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("i review the case and submit")
	public void i_review_the_case_and_submit() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
}
