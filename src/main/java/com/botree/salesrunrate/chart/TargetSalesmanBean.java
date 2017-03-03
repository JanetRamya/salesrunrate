package com.botree.salesrunrate.chart;

import java.util.ArrayList;
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
import com.botree.salesrunrate.entity.BillingDetails;
import com.botree.salesrunrate.entity.SalesmanTarget;
import com.botree.salesrunrate.salesmanTarget.ISalesmanTargetService;

@Component("targetSalesmanBean")
@Scope("session")
public class TargetSalesmanBean {

	@Autowired
	private ISalesmanTargetService saleService;

	@Autowired
	private IBillingDetailsService billingService;

	List<SalesmanTarget> salesmanTargetChart = new ArrayList<>();
	List<BillingDetails> salesAchievedQty = new ArrayList<>();

	private BarChartModel barModel;
	private BarChartModel salesmanTar;
	private boolean showChart;

	@PostConstruct
	public void createBarModels() {
		showChart=true;
		createDistributorTarget();
	}

	private void createDistributorTarget() {

		salesmanTar = distrTarQty();
		salesmanTar.setTitle("Bar Chart");
		salesmanTar.setLegendPosition("ne");

		Axis xAxis = salesmanTar.getAxis(AxisType.X);
		xAxis.setLabel("Product");

		Axis yAxis = salesmanTar.getAxis(AxisType.Y);
		yAxis.setLabel("Quantity");
		yAxis.setMin(0);
		yAxis.setMax(50);
	}

	private BarChartModel distrTarQty() {
		salesmanTargetChart = saleService.findAll();
		BarChartModel distr = new BarChartModel();

		ChartSeries targetQty = new ChartSeries();
		for (SalesmanTarget tar : salesmanTargetChart) {
			targetQty.setLabel("TargetQuantity");
			if (tar.getTqty() != null && !"".equals(tar.getTqty())) {
				targetQty.set(tar.getSmCode(), Integer.parseInt(tar.getTqty()));
			}

		}
		ChartSeries achievedTarget = new ChartSeries();
		for (SalesmanTarget achievedQty : salesmanTargetChart) {
			String[] smCode=achievedQty.getSmCode().split(" - ");
			salesAchievedQty = billingService.findAll(smCode[0]);
			for (BillingDetails aQty : salesAchievedQty) {
				achievedTarget.setLabel("Achieved Quantity");
				achievedTarget.set(aQty.getDistrCode(), Integer.parseInt(aQty.getOrderQuantity()));
			}

		}

		distr.addSeries(targetQty);
		distr.addSeries(achievedTarget);
		return distr;
	}


	public BarChartModel getBarModel() {
		return barModel;
	}

	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
	public BarChartModel getSalesmanTar() {
		return salesmanTar;
	}

	public void setSalesmanTar(BarChartModel salesmanTar) {
		this.salesmanTar = salesmanTar;
	}

	public boolean isShowChart() {
		return showChart;
	}

	public void setShowChart(boolean showChart) {
		this.showChart = showChart;
	}
	

}
