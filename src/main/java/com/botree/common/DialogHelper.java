package com.botree.common;

import java.io.Serializable;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.salesrunrate.util.SpringContext;

@Component("dialogHelper")
@Scope("session")
public class DialogHelper implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(DialogHelper.class);

	private AbstractBean bean;
	private boolean alert = false;

	private String errorMessage = "Not Defined";
	private String code = "Code";
	private String header = "Heading";
	private String severity = "alert";

	public DialogHelper() {
		// constructor without parameter
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public AbstractBean getBean() {
		return bean;
	}

	public void setBean(AbstractBean bean) {
		this.bean = bean;
		if (this.bean.getHeader() != null && "Route".equalsIgnoreCase(this.bean.getHeader())) {
			setHeader("Beat");
		} else {
			setHeader(this.bean.getHeader());
		}
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean getAlert() {
		return alert;
	}

	/**
	 *
	 * @param set
	 *            to true if alert icon should be used, otherwise information
	 *            icon will be shown in dialogs
	 */
	public void setAlert(boolean alert) {
		this.alert = alert;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 *
	 * @param message
	 *            will be displayed in the dialog
	 */
	public void setErrorMessage(String errorMessage) {
		RequestContext.getCurrentInstance().addCallbackParam("hasErrors", true);
		this.errorMessage = errorMessage;
	}

	public void delete() {
		try {
			RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
			bean.delete();
		} catch (Exception e) {
			LOG.error("Error while deleting bean of type " + this.getClass().getSimpleName(), e);
			String msg = SpringContext.getMessage("E_DELETE_FAILED");
			setErrorMessage(msg);
		}
	}

	public void setSearchPage() {
		bean.setSearchPage();
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

}
