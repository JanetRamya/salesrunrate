package com.botree.salesrunrate.chart;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.botree.salesrunrate.billingDetails.IBillingDetailsService;
import com.botree.salesrunrate.distributorTarget.IDistributorTargetService;
import com.botree.salesrunrate.entity.BillingDetails;
import com.botree.salesrunrate.entity.DistributorTarget;

@Component("targetDistributorBean")
@Scope("session")
public class TargetDistributorBean {

	@Autowired
	private IDistributorTargetService distrService;

	@Autowired
	private IBillingDetailsService billingService;

	List<DistributorTarget> distributorTargetChart = new ArrayList<>();
	List<BillingDetails> distrAchievedQty = new ArrayList<>();

	private BarChartModel barModel;
	private BarChartModel distrTar;
	private boolean showChart;
	private Date sdate = new Date();
	private Date edate = new Date();
	private Date toMaxDate;
	private Date toMinDate;
	private Date fromMaxDate=new Date();
	private Integer maxHeight;
	
	@PostConstruct
	public void onPageDisplay()
	{
		if(distrTar!=null)
		{
		distrTar.clear();
		}
	}
	public void createBarModels() {
		showChart=true;
		createDistributorTarget();
	}

	private void createDistributorTarget() {

		distrTar = distrTarQty();
		distrTar.setTitle("Bar Chart");
		distrTar.setLegendPosition("ne");

		Axis xAxis = distrTar.getAxis(AxisType.X);
		xAxis.setLabel("Product");

		Axis yAxis = distrTar.getAxis(AxisType.Y);
		yAxis.setLabel("Quantity");
		yAxis.setMin(0);
		yAxis.setMax(maxHeight);
	}

	private BarChartModel distrTarQty() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdate);
		cal.add(Calendar.DATE, -1);
		Date fromDate = cal.getTime();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(edate);
		calendar.add(Calendar.DATE, +1);
		Date toDate = calendar.getTime();
		distributorTargetChart = distrService.findByTqty(fromDate, toDate);
		BarChartModel distr = new BarChartModel();

		ChartSeries targetQty = new ChartSeries();
		for (DistributorTarget tar : distributorTargetChart) {
			targetQty.setLabel("TargetQuantity");
			if(maxHeight == null) {
				maxHeight = Integer.parseInt(tar.getTqty());
			} else if(maxHeight < Integer.parseInt(tar.getTqty())){
				maxHeight = Integer.parseInt(tar.getTqty());
			}
			if (tar.getTqty() != null && !"".equals(tar.getTqty())) {
				String[] dist=tar.getDistCode().split(" - ");
				targetQty.set(dist[0], Integer.parseInt(tar.getTqty()));
			}

		}
		ChartSeries achievedTarget = new ChartSeries();
		achievedTarget.setLabel("Achieved Quantity");
		for (DistributorTarget achievedQty : distributorTargetChart) {
			String[] distCode = achievedQty.getDistCode().split(" - ");
			distrAchievedQty = billingService.findAll(distCode[0]);
			if (distrAchievedQty.isEmpty()) {
				achievedTarget.set(distCode, 0);
			} else {
				for (BillingDetails aQty : distrAchievedQty) {
					if(maxHeight == null) {
						maxHeight = Integer.parseInt(aQty.getOrderQuantity());
					} else if(maxHeight < Integer.parseInt(aQty.getOrderQuantity())){
						maxHeight = Integer.parseInt(aQty.getOrderQuantity());
					}
					achievedTarget.set(aQty.getDistrCode(), Integer.parseInt(aQty.getOrderQuantity()));
				}
			}
			
		}
		maxHeight = maxHeight + 2;
		distr.addSeries(targetQty);
		distr.addSeries(achievedTarget);
		return distr;
	}
	
	public void changeToDate() {
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdate);
			cal.add(Calendar.MONTH, 6);
			toMaxDate = cal.getTime();
		setToMinDate(sdate);
	}
	public BarChartModel getBarModel() {
		return barModel;
	}

	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}

	public BarChartModel getDistrTar() {
		return distrTar;
	}

	public void setDistrTar(BarChartModel distrTar) {
		this.distrTar = distrTar;
	}

	public boolean isShowChart() {
		return showChart;
	}

	public void setShowChart(boolean showChart) {
		this.showChart = showChart;
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

	public Date getToMaxDate() {
		return toMaxDate;
	}

	public void setToMaxDate(Date toMaxDate) {
		this.toMaxDate = toMaxDate;
	}

	public Date getToMinDate() {
		return toMinDate;
	}

	public void setToMinDate(Date toMinDate) {
		this.toMinDate = toMinDate;
	}

	public Date getFromMaxDate() {
		return fromMaxDate;
	}

	public void setFromMaxDate(Date fromMaxDate) {
		this.fromMaxDate = fromMaxDate;
	}
	public Integer getMaxHeight() {
		return maxHeight;
	}
	public void setMaxHeight(Integer maxHeight) {
		this.maxHeight = maxHeight;
	}
	
	

}
