package com.botree.salesrunrate.salesmanTarget;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.salesrunrate.entity.Inventory;
import com.botree.salesrunrate.entity.SalesmanDetails;
import com.botree.salesrunrate.entity.SalesmanTarget;
import com.botree.salesrunrate.inventory.IInventoryService;
import com.botree.salesrunrate.inventory.InventoryRepo;
import com.botree.salesrunrate.salesmanDetails.ISalesmanDetailsService;

@Component("salesmanTargetBean")
@Scope("session")
public class SalesmanTargetBean {
	private String smCode;
	private String smName;
	private Date sdate = new Date();
	private Date edate = new Date();
	private String prdCode;
	private String prdName;
	private String qty;
	private String tqty;
	private Date toMinDate;
	
	@Autowired
	private ISalesmanTargetService service;
	
	@Autowired
	private ISalesmanDetailsService saleService;
	
	@Autowired
	InventoryRepo repo;
	
	@Autowired
	SalesmanTargetRepo saleTargetRepo;
	
	@Autowired
	private IInventoryService inventoryService;
	
	List<SalesmanDetails> salesList = new ArrayList<>();
	SalesmanDetails salesNameList = new SalesmanDetails();
	Map<String, String> salesMap = new HashMap<>();

	List<Inventory> target = new ArrayList<>();
	List<SalesmanTarget> salesmanTarget = new ArrayList<>();
	SalesmanTarget salesmanTargetList = new SalesmanTarget();
	Inventory inventory = new Inventory();

	public void save() {
		salesmanTargetList.setSmCode(smCode);
		salesmanTargetList.setSdate(sdate);
		salesmanTargetList.setEdate(edate);
		if (validation()) {
			for (SalesmanTarget target : salesmanTarget) {
				if (target.getTqty() != "") {
					salesmanTargetList.setPrdCode(target.getPrdCode());
					salesmanTargetList.setPrdName(target.getPrdName());
					salesmanTargetList.setQty(target.getQty());
					salesmanTargetList.setTqty(target.getTqty());
					saleTargetRepo.save(salesmanTargetList);
					Integer totalQty = Integer.parseInt(target.getQty()) - Integer.parseInt(target.getTqty());
					inventory.setQty(totalQty.toString());
					inventoryService.save(target.getPrdCode(), target.getPrdName(), totalQty.toString());
					RequestContext.getCurrentInstance().addCallbackParam("showDialog", true);
				}
			}
		}

	}

	public void findsalesmanTarget() {
		salesmanTarget=service.findAll();
	}

	@PostConstruct
	public List<SalesmanDetails> findDistributor()

	{
		target = repo.findAll();
		for (Inventory obj : target) {
			SalesmanTarget target = new SalesmanTarget();
			target.setPrdCode(obj.getPrdCode());
			target.setPrdName(obj.getPrdName());
			target.setQty(obj.getQty());
			salesmanTarget.add(target);
		}
		salesMap = new HashMap<>();
		salesList = saleService.findAll();

		for (SalesmanDetails dist : salesList) {
			salesMap.put(dist.getSmCode() + " - " + dist.getSmName(), dist.getSmCode());
		}
		return salesList;
	}

	public boolean validation() {
		for (SalesmanTarget targ : salesmanTarget) {
			if (targ.getTqty() != "") {
				Integer index = salesmanTarget.indexOf(targ);
				if (Integer.parseInt(targ.getTqty()) > Integer.parseInt(targ.getQty())) {
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage("content:distrTarget:" + index + ":tqty", new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "Target limit exceeded", "Target limit exceeded"));
					return false;
				}
			}
		}
		return true;
	}

	public void changeToDate() {
		setToMinDate(sdate);
	}
	
	public String getSmCode() {
		return smCode;
	}
	public void setSmCode(String smCode) {
		this.smCode = smCode;
	}
	public String getSmName() {
		return smName;
	}
	public void setSmName(String smName) {
		this.smName = smName;
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
	public Date getToMinDate() {
		return toMinDate;
	}
	public SalesmanTargetRepo getSaleTargetRepo() {
		return saleTargetRepo;
	}

	public InventoryRepo getRepo() {
		return repo;
	}

	public void setRepo(InventoryRepo repo) {
		this.repo = repo;
	}

	public void setSaleTargetRepo(SalesmanTargetRepo saleTargetRepo) {
		this.saleTargetRepo = saleTargetRepo;
	}

	public List<SalesmanDetails> getSalesList() {
		return salesList;
	}

	public void setSalesList(List<SalesmanDetails> salesList) {
		this.salesList = salesList;
	}

	public SalesmanDetails getSalesNameList() {
		return salesNameList;
	}

	public void setSalesNameList(SalesmanDetails salesNameList) {
		this.salesNameList = salesNameList;
	}

	public Map<String, String> getSalesMap() {
		return salesMap;
	}

	public void setSalesMap(Map<String, String> salesMap) {
		this.salesMap = salesMap;
	}

	public List<Inventory> getTarget() {
		return target;
	}

	public void setTarget(List<Inventory> target) {
		this.target = target;
	}

	public List<SalesmanTarget> getSalesmanTarget() {
		return salesmanTarget;
	}

	public void setSalesmanTarget(List<SalesmanTarget> salesmanTarget) {
		this.salesmanTarget = salesmanTarget;
	}

	public SalesmanTarget getSalesmanTargetList() {
		return salesmanTargetList;
	}

	public void setSalesmanTargetList(SalesmanTarget salesmanTargetList) {
		this.salesmanTargetList = salesmanTargetList;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setToMinDate(Date toMinDate) {
		this.toMinDate = toMinDate;
	}
	
	
	
	
}