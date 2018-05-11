package com.hajun.rho.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.hajun.rho.model.LifePattern;
import com.hajun.rho.util.TranceForm;

// 기록보기 다이얼로그 창
// 시간 선택시 그 시간대에 해당하는 다른 일자의 기록을 팝업으로 보여줌
public class RecordViewDialog extends JDialog {

	// Constructor
	public RecordViewDialog(JFrame frame, String title, List<LifePattern> lpList) {
		super(frame, title);

		JButton close = new JButton("닫기");
		String[] header = { "일자", "시간", "분유" };
		
		String[][] data = new String[lpList.size()][3];

		for (int i = 0; i < lpList.size(); i++) {
			long dwDate = lpList.get(i).getDate();
			String szDate = TranceForm.dateToCustomFormat(dwDate, "yy-MM-dd");
			String szTime = TranceForm.dateToCustomFormat(dwDate, "HH:mm");

			data[i][0] = szDate;
			data[i][1] = szTime;
			data[i][2] = String.valueOf(lpList.get(i).getMilk());
		}

		JTable table = new JTable(data, header);
		table.setShowGrid(true);
		
		DefaultTableCellRenderer defaultTC = new DefaultTableCellRenderer();
		defaultTC.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();

		for (int j = 0; j < tcm.getColumnCount(); j++) {
			tcm.getColumn(j).setCellRenderer(defaultTC);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(20, 10, 200, 290);
		scrollPane.setViewportView(table);
		
		getContentPane().add(scrollPane);
		
		close.setBounds(70, 320, 100, 25);
		getContentPane().add(close);
		setLayout(null);
		setSize(250, 400);
		setLocation(500, -50);
		setLocationRelativeTo(frame);
		setVisible(true);

		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
	}
}
