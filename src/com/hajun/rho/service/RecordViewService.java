package com.hajun.rho.service;

import java.util.Calendar;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.hajun.rho.model.LifePattern;
import com.hajun.rho.model.RecordView;
import com.hajun.rho.repository.RecordExecute;
import com.hajun.rho.util.TranceForm;

public class RecordViewService {

	// 기록보기 테이블 정렬 / 사이즈 조정
	public JTable recordView(JTable table) {
		String[] viewHeader = { "일자", "시간", "분유", "트림", "소변", "대변", "목욕", "크림", "키", "몸무게", "비고" };

		RecordViewService rd = new RecordViewService();
		String[][] viewContents = rd.getRecord();
		table = new JTable(viewContents, viewHeader);
		table.setShowGrid(true);
		int[] colWidth = { 150, 100, 60, 50, 50, 50, 50, 50, 50, 100, 300 };

		for (int i = 0; i < colWidth.length; i++) {
			table.getColumn(viewHeader[i]).setPreferredWidth(colWidth[i]);

		}

		DefaultTableCellRenderer defaultTC = new DefaultTableCellRenderer();
		defaultTC.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();

		for (int j = 0; j < tcm.getColumnCount() - 1; j++) {
			tcm.getColumn(j).setCellRenderer(defaultTC);
		}

		return table;
	}

	// 기록보기 탭 리스트 불러오기
	public String[][] getRecord() {
		RecordExecute re = new RecordExecute();
		List<LifePattern> lpList = re.selectLifePattern();

		String[][] recordData = new String[lpList.size()][11];

		for (int i = 0; i < lpList.size(); i++) {
			String date = TranceForm.dateToCustomFormat(lpList.get(i).getDate(), "yy-MM-dd HH:mm");
			String[] dateAndTime = date.split(" ");

			recordData[i][0] = String.valueOf(dateAndTime[0]);
			recordData[i][1] = String.valueOf(dateAndTime[1]);
			recordData[i][2] = String.valueOf(lpList.get(i).getMilk());
			recordData[i][3] = TranceForm.intToString(lpList.get(i).getBurp());
			recordData[i][4] = TranceForm.intToString(lpList.get(i).getPee());
			recordData[i][5] = TranceForm.intToString(lpList.get(i).getFeces());
			recordData[i][6] = TranceForm.intToString(lpList.get(i).getBath());
			recordData[i][7] = TranceForm.intToString(lpList.get(i).getCream());
			recordData[i][8] = lpList.get(i).getHeight();
			recordData[i][9] = lpList.get(i).getWeight();
			recordData[i][10] = lpList.get(i).getDesc();

		}

		return recordData;
	}

	// 데이터 분석
	public RecordView getRecord(long startDate, long endDate) {
		RecordView rv = new RecordView();

		long sDate = startDate / 86400000;
		long eDate = endDate / 86400000;
		int interval = (int) (eDate - sDate);

		RecordExecute re = new RecordExecute();
		List<LifePattern> lpList = re.periodSearchLifePattern(startDate, endDate);

		// ----- RecordView Setting
		int count = lpList.size();
		int total = 0;
		int peeCount = 0;
		int fecesCount = 0;

		for (LifePattern lifePattern : lpList) {
			total += lifePattern.getMilk();
			peeCount += lifePattern.getPee() == 1 ? 1 : 0;
			fecesCount += lifePattern.getFeces() == 1 ? 1 : 0;
		}

		int avgMilkForCount = (total / count);
		int avgMilkForDay = (total / interval);
		int term = ((60 * 60 * 24) / total);
		int avgPeeForDay = (peeCount / interval);
		int avgFecesForDay = (fecesCount / interval);
		
		
		rv.setCount(count);
		rv.setTotal(total);
		rv.setAvgMilkForCount(avgMilkForCount);
		rv.setAvgMilkForDay(avgMilkForDay);
		rv.setTerm(term);
		rv.setPeeCount(peeCount);
		rv.setFecesCount(fecesCount);
		rv.setAvgPeeForDay(avgPeeForDay);
		rv.setAvgFecesForDay(avgFecesForDay);

		// ----- //RecordView Setting

		return rv;
	}

}
