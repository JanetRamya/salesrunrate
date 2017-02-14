package com.botree.salesrunrate.entity;

import java.io.Serializable;
import java.util.Date;

public abstract class MongoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String modUserCode;
	private Date modDt;

	public String getModUserCode() {
		return modUserCode;
	}

	public void setModUserCode(String modUserCode) {
		this.modUserCode = modUserCode;
	}

	public Date getModDt() {
		return modDt;
	}

	public void setModDt(Date modDt) {
		this.modDt = modDt;
	}

}
