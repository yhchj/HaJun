package com.hajun.rho.service;

import java.awt.Font;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import com.hajun.rho.model.LifePattern;
import com.hajun.rho.repository.RecordExecute;
import com.hajun.rho.util.TranceForm;

public class ChartService extends ApplicationFrame {

	// 차트 스타일 설정
	public ChartService(String applicationTitle, String chartTitle, long startDate, long endDate) {
		super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, "날짜", "분유량", createDataset(startDate, endDate),
				PlotOrientation.VERTICAL, true, true, false);

		lineChart.getTitle().setFont(new Font("돋움", Font.BOLD, 15)); // 제목
		lineChart.getLegend().setItemFont(new Font("돋움", Font.PLAIN, 10)); // 범례

		CategoryPlot plot = lineChart.getCategoryPlot();
		Font font = plot.getDomainAxis().getLabelFont();
		plot.getDomainAxis().setLabelFont(new Font("돋움", font.getStyle(), font.getSize())); // X축 라벨
		plot.getDomainAxis().setTickLabelFont(new Font("돋움", font.getStyle(), 10)); // X축 도메인

		font = plot.getRangeAxis().getLabelFont();
		plot.getRangeAxis().setLabelFont(new Font("돋움", font.getStyle(), font.getSize())); // Y축 라벨
		plot.getRangeAxis().setTickLabelFont(new Font("돋움", font.getStyle(), 10)); // Y축 범위
		plot.getRangeAxis().setAutoRangeMinimumSize(500);
		
		
		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));

		setContentPane(chartPanel);
	}

	// 차트 데이터 세팅
	private DefaultCategoryDataset createDataset(long startDate, long endDate) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		RecordExecute re = new RecordExecute();
		List<LifePattern> lpList = re.periodSearchLifePattern(startDate, endDate);

		long sDate = startDate / 86400000;
		long eDate = endDate / 86400000;

		int interval = (int) (eDate - sDate);

		int[] sumMilk = new int[interval];

		for (int j = 0; j < interval; j++) {

			long date1 = startDate + (j * 86400000);
			long date2 = startDate + ((j + 1) * 86400000);
			if (j == 0) {
				date1 = startDate;
			} else if (j == (interval - 1)) {
				date2 = endDate;
			}

			for (int i = 0; i < lpList.size(); i++) {
				long date = lpList.get(i).getDate();
				if (date >= date1 && date <= date2) {
					sumMilk[j] += lpList.get(i).getMilk();
				} else {
					continue;
				}
			}
		}

		for (int i = 0; i < sumMilk.length; i++) {
			System.out.println("[DEBUG] sumMilk[i] : "+sumMilk[i]);
			dataset.addValue(sumMilk[i], "milk",
					TranceForm.dateToCustomFormat((startDate + (86400000 * i)), "MM.dd"));
		}

		return dataset;
	}

}
