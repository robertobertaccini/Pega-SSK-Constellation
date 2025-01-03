package com.pega.test.pega_sample_testframework;

import com.pega.config.ObjectBean;
import com.pega.prpc.workobjects.EditCaseType;

public class PlatformObjectsBean extends ObjectBean{

	private EditCaseType editCaseType;

	public EditCaseType getEditCaseType() {
		return editCaseType;
	}

	public void setEditCaseType(EditCaseType editCaseType) {
		this.editCaseType= editCaseType;
	}
}