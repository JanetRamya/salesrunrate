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

	@PostConstruct
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
		yAxis.setMax(50);
	}

	private BarChartModel distrTarQty() {
		distributorTargetChart = distrService.findAll();
		BarChartModel distr = new BarChartModel();

		ChartSeries targetQty = new ChartSeries();
		for (DistributorTarget tar : distributorTargetChart) {
			targetQty.setLabel("TargetQuantity");
			if (tar.getTqty() != null && !"".equals(tar.getTqty())) {
				targetQty.set(tar.getDistCode(), Integer.parseInt(tar.getTqty()));
			}

		}
		ChartSeries achievedTarget = new ChartSeries();
		for (DistributorTarget achievedQty : distributorTargetChart) {
			String[] distCode=achievedQty.getDistCode().split(" - ");
			distrAchievedQty = billingService.findAll(distCode[0]);
			for (BillingDetails aQty : distrAchievedQty) {
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
	

}
