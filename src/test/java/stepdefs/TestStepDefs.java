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
import com.pega.test.pega_sample_testframework.PlatformBrowser;
import com.pega.test.pega_sample_testframework.PlatformTestEnvironment;

import io.cucumber.java.en.Given;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class TestStepDefs {
	TestEnvironment testEnv;
	com.pega.test.pega_sample_testframework.PlatformBrowser browser;
	private PegaWebDriver pegaDriver;
	

	@Inject
	public TestStepDefs(PlatformTestEnvironment testEnv) {
		this.testEnv = testEnv;
		pegaDriver = testEnv.getPegaDriver();
		System.out.println("printing...");
		browser = (PlatformBrowser) testEnv.getBrowser();
		
	}

	@Given("^A User prints \"([^\"]*)\"$")
	public void a_User_prints(String arg1) throws Throwable {
	    System.out.println("Printing "+arg1);
	}


}
