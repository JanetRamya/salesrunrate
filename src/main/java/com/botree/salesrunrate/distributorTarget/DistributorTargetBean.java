package com.botree.salesrunrate.distributorTarget;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.common.AbstractBean;
import com.botree.salesrunrate.distributorDetails.IDistributorDetailsService;
import com.botree.salesrunrate.entity.DistributorDetails;
import com.botree.salesrunrate.entity.DistributorTarget;
import com.botree.salesrunrate.entity.Inventory;
import com.botree.salesrunrate.inventory.InventoryRepo;

@Component("distributorTargetBean")
@Scope("session")
public class DistributorTargetBean extends AbstractBean {
	private String distCode;
	private String distName;
	private Date sdate=new Date();
	private Date edate;
	private String prdCode;
	private String prdName;
	private String qty;
	private String tqty;

	@Autowired
	private IDistributorTargetService service;

	@Autowired
	private IDistributorDetailsService distributorService;

	@Autowired
	InventoryRepo repo;

	@Autowired
	DistributorTargetRepo distributorTargetRepo;

	List<DistributorDetails> distList = new ArrayList<>();
	DistributorDetails distNameList = new DistributorDetails();
	Map<String, String> distMap = new HashMap<>();
	List<Inventory> target = new ArrayList<>();

	List<DistributorTarget> distributorTarget = new ArrayList<>();

	public void save() {
		service.save(distCode, distName, sdate, edate, prdCode, prdName, qty, tqty);
		distributorTargetRepo.save(distributorTarget);
		RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);

	}
	public void changeToDate()
	{
		Date mindate = sdate;
	}

	public void findDistributorTarget() {
		distributorTarget = service.findAll();
	}

	@PostConstruct
	public List<DistributorDetails> findDistributor()

	{
		// target = service.findAll();
		target = repo.findAll();
		for (Inventory obj : target) {
			DistributorTarget target = new DistributorTarget();
			target.setPrdCode(obj.getPrdCode());
			target.setPrdName(obj.getPrdName());
			target.setQty(obj.getQty());
			distributorTarget.add(target);
		}
		distMap = new HashMap<>();
		distList = distributorService.findAll();

		for (DistributorDetails dist : distList) {
			distMap.put(dist.getDistCode() + " - " + dist.getDistName(), dist.getDistCode());
		}
		return distList;
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

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
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

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getTqty() {
		return tqty;
	}

	public void setTqty(String tqty) {
		this.tqty = tqty;
	}

	public IDistributorDetailsService getDistributorService() {
		return distributorService;
	}

	public void setDistributorService(IDistributorDetailsService distributorService) {
		this.distributorService = distributorService;
	}

	public List<DistributorDetails> getDistList() {
		return distList;
	}

	public void setDistList(List<DistributorDetails> distList) {
		this.distList = distList;
	}

	public DistributorDetails getDistNameList() {
		return distNameList;
	}

	public void setDistNameList(DistributorDetails distNameList) {
		this.distNameList = distNameList;
	}

	public Map<String, String> getDistMap() {
		return distMap;
	}

	public void setDistMap(Map<String, String> distMap) {
		this.distMap = distMap;
	}

	public List<Inventory> getTarget() {
		return target;
	}

	public void setTarget(List<Inventory> target) {
		this.target = target;
	}

	public List<DistributorTarget> getDistributorTarget() {
		return distributorTarget;
	}

	public void setDistributorTarget(List<DistributorTarget> distributorTarget) {
		this.distributorTarget = distributorTarget;
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
