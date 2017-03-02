package com.botree.common;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBean {
	@Autowired
	protected UserSession userSession;
	@Autowired
	private DialogHelper dialog;
	private String bean;

	public abstract String getHeader();

	public abstract void delete();

	public abstract void setSearchPage();

	public String getBean() {
		getDialog().setBean(this);
		return bean;
	}

	public void setBean(String bean) {
		this.bean = bean;
	}

	public DialogHelper getDialog() {
		return dialog;
	}

	public void setDialog(DialogHelper dialog) {
		this.dialog = dialog;
	}

}
