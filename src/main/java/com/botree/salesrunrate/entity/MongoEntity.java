package com.botree.salesrunrate.entity;

import java.io.Serializable;

public abstract class MongoEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String modUserCode;
	private String modDt;
	public String getModUserCode() {
		return modUserCode;
	}
	public void setModUserCode(String modUserCode) {
		this.modUserCode = modUserCode;
	}
	public String getModDt() {
		return modDt;
	}
	public void setModDt(String modDt) {
		this.modDt = modDt;
	}
	

}
