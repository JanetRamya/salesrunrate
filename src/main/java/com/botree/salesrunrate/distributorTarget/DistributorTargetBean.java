package com.botree.salesrunrate.distributorTarget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.common.AbstractBean;
import com.botree.salesrunrate.entity.DistributorTarget;


@Component("distributorTargetBean")
@Scope("session")
public class DistributorTargetBean extends AbstractBean {
	private String distCode;
	private String distName;
	private String prdCode;
	private String prdName;
	private String stock;
	private String tqty;

	@Autowired
	private IDistributorTargetService service;

	List<DistributorTarget> targetList = new ArrayList<>();
	Map<String, String> targetMap = new HashMap<>();
	List<DistributorTarget> target = new ArrayList<>();
	
	public void save() {

		service.save(distCode, distName, prdCode, prdName, stock, tqty);
		RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);

	}
	public void findDistributorTarget()
	{
		target=service.findAll();
	}

	public String getDistCode() {
		return distCode;
	}

	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}

	public String getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getTqty() {
		return tqty;
	}

	public void setTqty(String tqty) {
		this.tqty = tqty;
	}

	@Override
	public String getHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSearchPage() {
		// TODO Auto-generated method stub

	}

}
