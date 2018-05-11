package com.hajun.rho.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import com.hajun.rho.database.Database;
import com.hajun.rho.dialog.RecordViewDialog;
import com.hajun.rho.listener.Window;
import com.hajun.rho.model.LifePattern;
import com.hajun.rho.model.RecordView;
import com.hajun.rho.service.ChartService;
import com.hajun.rho.service.RecordSaveService;
import com.hajun.rho.service.RecordViewService;
import com.hajun.rho.util.TranceForm;
import com.toedter.calendar.JDateChooser;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;

	private JScrollPane scrollPane;

	public static void main(String[] args) throws ParseException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database.getConnection();
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 생성자
	public Main() {
		final JFrame mainFrame = this;

		setTitle("하준이 생활 분석 프로그램");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new Window());
		setBounds(100, 100, 944, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("img/favicon.png");
		setIconImage(img);

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane);

		// Tab - 소개
		panel_1 = new JPanel();
		tabbedPane.addTab("소개", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_14 = new JLabel("Ver. 1.0.0");
		lblNewLabel_14.setBounds(844, 10, 57, 15);
		panel_1.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("Dev. RhoYoungHoon :: E-mail. yhchj61@gmail.com");
		lblNewLabel_15.setBounds(308, 347, 300, 15);
		panel_1.add(lblNewLabel_15);

		JPanel panel_6 = new JPanel();

		Calendar today = Calendar.getInstance();
		Calendar birthDay = Calendar.getInstance();

		birthDay.set(2018, 2, 25);

		long longToday = today.getTimeInMillis() / 86400000;
		long longBirthDay = birthDay.getTimeInMillis() / 86400000;
		int count = (int) (longToday - longBirthDay);
		panel_6.setLayout(null);

		JLabel dDay = new JLabel("+ " + (count + 1) + " Days");
		dDay.setForeground(Color.BLUE);
		dDay.setHorizontalAlignment(SwingConstants.CENTER);
		dDay.setBounds(12, 117, 376, 68);
		dDay.setFont(new java.awt.Font("맑은 고딕", java.awt.Font.PLAIN, 60));

		panel_6.add(dDay);
		panel_6.setBounds(256, 36, 400, 300);
		panel_1.add(panel_6);

		// Tab - 기록보기
		panel_2 = new JPanel();
		tabbedPane.addTab("기록보기", null, panel_2, null);
		tabbedPane.setEnabledAt(1, true);

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new java.awt.Dimension(800, 350));
		scrollPane.setViewportBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_2.add(scrollPane);

		// Tab - 데이터 분석
		panel_4 = new JPanel();
		tabbedPane.addTab("데이터 분석", null, panel_4, null);
		panel_4.setLayout(null);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(35, 14, 120, 20);
		panel_4.add(dateChooser);

		JLabel lblNewLabel_17 = new JLabel("부터");
		lblNewLabel_17.setBounds(163, 14, 35, 15);
		panel_4.add(lblNewLabel_17);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(190, 14, 120, 20);
		panel_4.add(dateChooser_1);

		JLabel lblNewLabel_16 = new JLabel("까지");
		lblNewLabel_16.setBounds(322, 14, 35, 15);
		panel_4.add(lblNewLabel_16);

		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				dateChooser_1.setDate(dateChooser.getDate());
			}
		});

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setForeground(Color.BLACK);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_7.setBounds(36, 46, 845, 316);
		panel_4.add(panel_7);
		panel_7.setLayout(null);

		JLabel lblNewLabel_18 = new JLabel("등록횟수");
		lblNewLabel_18.setBounds(12, 10, 120, 15);
		panel_7.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("총 분유량");
		lblNewLabel_19.setBounds(12, 40, 120, 15);
		panel_7.add(lblNewLabel_19);

		JLabel lblNewLabel_20 = new JLabel("1일 평균 분유량");
		lblNewLabel_20.setBounds(12, 70, 120, 15);
		panel_7.add(lblNewLabel_20);

		JLabel lblNewLabel_21 = new JLabel("1회 평균 분유량");
		lblNewLabel_21.setBounds(12, 100, 120, 15);
		panel_7.add(lblNewLabel_21);

		JLabel lblNewLabel_22 = new JLabel("분유 텀");
		lblNewLabel_22.setBounds(12, 130, 120, 15);
		panel_7.add(lblNewLabel_22);

		JLabel lblNewLabel_23 = new JLabel("소변 횟수");
		lblNewLabel_23.setBounds(12, 160, 120, 15);
		panel_7.add(lblNewLabel_23);

		JLabel lblNewLabel_24 = new JLabel("대변 횟수");
		lblNewLabel_24.setBounds(12, 190, 120, 15);
		panel_7.add(lblNewLabel_24);

		JLabel lblNewLabel_25 = new JLabel("1일 평균 소변 횟수");
		lblNewLabel_25.setBounds(12, 220, 120, 15);
		panel_7.add(lblNewLabel_25);

		JLabel lblNewLabel_26 = new JLabel("1일 평균 대변 횟수");
		lblNewLabel_26.setBounds(12, 250, 120, 15);
		panel_7.add(lblNewLabel_26);

		JLabel lblNewLabel_18_view = new JLabel("-");
		lblNewLabel_18_view.setForeground(Color.RED);
		lblNewLabel_18_view.setBounds(140, 10, 70, 15);
		panel_7.add(lblNewLabel_18_view);

		JLabel lblNewLabel_19_view = new JLabel("-");
		lblNewLabel_19_view.setForeground(Color.RED);
		lblNewLabel_19_view.setBounds(140, 40, 70, 15);
		panel_7.add(lblNewLabel_19_view);

		JLabel lblNewLabel_20_view = new JLabel("-");
		lblNewLabel_20_view.setForeground(Color.RED);
		lblNewLabel_20_view.setBounds(140, 70, 70, 15);
		panel_7.add(lblNewLabel_20_view);

		JLabel lblNewLabel_21_view = new JLabel("-");
		lblNewLabel_21_view.setForeground(Color.RED);
		lblNewLabel_21_view.setBounds(140, 100, 70, 15);
		panel_7.add(lblNewLabel_21_view);

		JLabel lblNewLabel_22_view = new JLabel("-");
		lblNewLabel_22_view.setForeground(Color.RED);
		lblNewLabel_22_view.setBounds(140, 130, 70, 15);
		panel_7.add(lblNewLabel_22_view);

		JLabel lblNewLabel_23_view = new JLabel("-");
		lblNewLabel_23_view.setForeground(Color.RED);
		lblNewLabel_23_view.setBounds(140, 160, 70, 15);
		panel_7.add(lblNewLabel_23_view);

		JLabel lblNewLabel_24_view = new JLabel("-");
		lblNewLabel_24_view.setForeground(Color.RED);
		lblNewLabel_24_view.setBounds(140, 190, 70, 15);
		panel_7.add(lblNewLabel_24_view);

		JLabel lblNewLabel_25_view = new JLabel("-");
		lblNewLabel_25_view.setForeground(Color.RED);
		lblNewLabel_25_view.setBounds(140, 220, 70, 15);
		panel_7.add(lblNewLabel_25_view);

		JLabel lblNewLabel_26_view = new JLabel("-");
		lblNewLabel_26_view.setForeground(Color.RED);
		lblNewLabel_26_view.setBounds(140, 250, 70, 15);
		panel_7.add(lblNewLabel_26_view);

		JButton btnNewButton_1 = new JButton("실행");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date1 = TranceForm.dateToCustomFormat(dateChooser.getDate(), "yy-MM-dd 00:00");
				String date2 = TranceForm.dateToCustomFormat(dateChooser_1.getDate(), "yy-MM-dd 23:59");

				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");

				long startDate = 0;
				long endDate = 0;

				try {
					startDate = sdf.parse(date1).getTime();
					endDate = sdf.parse(date2).getTime();
				} catch (ParseException e1) {
					System.out.println("[DEBUG] Main create actionPerformed ParseException --> " + e1.getMessage());
				}

				RecordViewService rd = new RecordViewService();
				RecordView rv = rd.getRecord(startDate, endDate);

				lblNewLabel_18_view.setText(rv.getCount() + "회");
				lblNewLabel_19_view.setText(rv.getTotal() + "ml");
				lblNewLabel_20_view.setText(rv.getAvgMilkForDay() + "ml");
				lblNewLabel_21_view.setText(rv.getAvgMilkForCount() + "ml");
				lblNewLabel_22_view.setText(rv.getTerm() + "분");
				lblNewLabel_23_view.setText(rv.getPeeCount() + "회");
				lblNewLabel_24_view.setText(rv.getFecesCount() + "회");
				lblNewLabel_25_view.setText(rv.getAvgPeeForDay() + "회");
				lblNewLabel_26_view.setText(rv.getAvgFecesForDay() + "회");

			}
		});
		btnNewButton_1.setBounds(371, 13, 97, 23);
		panel_4.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("차트");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String date1 = TranceForm.dateToCustomFormat(dateChooser.getDate(), "yy-MM-dd 00:00");
				String date2 = TranceForm.dateToCustomFormat(dateChooser_1.getDate(), "yy-MM-dd 23:59");

				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");

				long startDate = 0;
				long endDate = 0;

				try {
					startDate = sdf.parse(date1).getTime();
					endDate = sdf.parse(date2).getTime();
				} catch (ParseException e1) {
					System.out.println("[DEBUG] Main create actionPerformed ParseException --> " + e1.getMessage());
				}

				ChartService chart = new ChartService("Chart", "일별 분유량 추세선", startDate, endDate);
				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(480, 14, 97, 23);
		panel_4.add(btnNewButton_2);

		// Tab - 기록하기
		panel_5 = new JPanel();
		tabbedPane.addTab("기록하기", null, panel_5, null);
		panel_5.setLayout(null);

		// "일자", "시간", "트림", "분유", "소변", "대변", "목욕", "크림", "키", "몸무게", "비고"
		JLabel lblNewLabel = new JLabel("일자");
		lblNewLabel.setBounds(49, 10, 57, 15);
		panel_5.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("시간");
		lblNewLabel_1.setBounds(49, 35, 57, 15);
		panel_5.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("트림");
		lblNewLabel_2.setBounds(49, 85, 57, 15);
		panel_5.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("분유");
		lblNewLabel_3.setBounds(49, 60, 57, 15);
		panel_5.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("소변");
		lblNewLabel_4.setBounds(49, 110, 57, 15);
		panel_5.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("대변");
		lblNewLabel_5.setBounds(49, 135, 57, 15);
		panel_5.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("목욕");
		lblNewLabel_6.setBounds(49, 160, 57, 15);
		panel_5.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("크림");
		lblNewLabel_7.setBounds(49, 185, 57, 15);
		panel_5.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("키");
		lblNewLabel_8.setBounds(49, 210, 57, 15);
		panel_5.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("몸무게");
		lblNewLabel_9.setBounds(49, 235, 57, 15);
		panel_5.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("비고");
		lblNewLabel_10.setBounds(49, 260, 57, 15);
		panel_5.add(lblNewLabel_10);

		textField_1 = new JTextField();
		textField_1.setBounds(136, 7, 116, 21);
		panel_5.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("※ 필수");
		lblNewLabel_11.setBounds(264, 10, 57, 15);
		panel_5.add(lblNewLabel_11);

		textField_2 = new JTextField();
		textField_2.setBounds(136, 32, 116, 21);
		panel_5.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("※ 필수");
		lblNewLabel_12.setBounds(264, 35, 57, 15);
		panel_5.add(lblNewLabel_12);

		textField_4 = new JTextField();
		textField_4.setBounds(136, 57, 116, 21);
		panel_5.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("※ 필수");
		lblNewLabel_13.setBounds(264, 60, 57, 15);
		panel_5.add(lblNewLabel_13);

		textField_9 = new JTextField();
		textField_9.setBounds(136, 207, 116, 21);
		panel_5.add(textField_9);
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(136, 232, 116, 21);
		panel_5.add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(136, 257, 116, 21);
		panel_5.add(textField_11);
		textField_11.setColumns(10);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(136, 81, 115, 23);
		panel_5.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(136, 106, 115, 23);
		panel_5.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setBounds(136, 131, 115, 23);
		panel_5.add(chckbxNewCheckBox_2);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		chckbxNewCheckBox_3.setBounds(136, 156, 115, 23);
		panel_5.add(chckbxNewCheckBox_3);

		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("");
		chckbxNewCheckBox_4.setBounds(136, 181, 115, 23);
		panel_5.add(chckbxNewCheckBox_4);

		JButton btnNewButton = new JButton("저장");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 필수 입력사항 검사
				String checkDate = textField_1.getText().trim();
				String checkTime = textField_2.getText().trim();
				String checkMilk = textField_4.getText().trim();

				if (checkDate.equals("") || checkDate == null) {
					JOptionPane.showMessageDialog(null, "일자 항목을 입력하세요");
					return;
				}

				if (checkTime.equals("") || checkTime == null) {
					JOptionPane.showMessageDialog(null, "시간 항목을 입력하세요");
					return;
				}

				if (checkMilk.equals("") || checkMilk == null) {
					JOptionPane.showMessageDialog(null, "분유 항목을 입력하세요");
					return;
				}

				// 데이터 저장
				SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd HHmm");

				long date = 0;
				try {
					date = sdf.parse(textField_1.getText().trim() + " " + textField_2.getText().trim()).getTime();
				} catch (ParseException e1) {
					System.out.println("Main actionPerformed ParseException --> " + e1.getMessage());
				}

				int milk = Integer.parseInt(textField_4.getText().trim());
				int burp = TranceForm.booleanToInt(chckbxNewCheckBox.isSelected());
				int pee = TranceForm.booleanToInt(chckbxNewCheckBox_1.isSelected());
				int feces = TranceForm.booleanToInt(chckbxNewCheckBox_2.isSelected());
				int bath = TranceForm.booleanToInt(chckbxNewCheckBox_3.isSelected());
				int cream = TranceForm.booleanToInt(chckbxNewCheckBox_4.isSelected());
				String height = textField_9.getText().trim();
				String weight = textField_10.getText().trim();
				String desc = textField_11.getText().trim();

				LifePattern lifePattern = new LifePattern();
				lifePattern.setDate(date);
				lifePattern.setMilk(milk);
				lifePattern.setBurp(burp);
				lifePattern.setPee(pee);
				lifePattern.setFeces(feces);
				lifePattern.setBath(bath);
				lifePattern.setCream(cream);
				lifePattern.setHeight(height);
				lifePattern.setWeight(weight);
				lifePattern.setDesc(desc);

				System.out.println(lifePattern);

				RecordSaveService recordSave = new RecordSaveService();
				int result = recordSave.saveLifePattern(lifePattern);

				if (result == 1) {
					// 값 초기화(일자 제외)
					textField_2.setText("");
					textField_4.setText("");
					chckbxNewCheckBox.setSelected(false);
					chckbxNewCheckBox_1.setSelected(false);
					chckbxNewCheckBox_2.setSelected(false);
					chckbxNewCheckBox_3.setSelected(false);
					chckbxNewCheckBox_4.setSelected(false);
					textField_9.setText("");
					textField_10.setText("");
					textField_11.setText("");
					textField_2.requestFocusInWindow();
				} else {
					JOptionPane.showMessageDialog(null, "저장 실패\n입력값을 확인해 주세요");
				}

			}
		});
		btnNewButton.setBounds(156, 288, 97, 23);
		panel_5.add(btnNewButton);

		// ----- /기록하기 탭

		tabController(tabbedPane, mainFrame);

	}

	// Tab 선택시 분기(Tab별 초기화 실행)
	private void tabController(JTabbedPane tabbedPane, JFrame mainFrame) {
		RecordViewService recordLoad = new RecordViewService();

		// Tab Change 이벤트
		tabbedPane.addChangeListener(new ChangeListener() {
			int selectedIndex = 0;

			@Override
			public void stateChanged(ChangeEvent e) {
				selectedIndex = tabbedPane.getSelectedIndex();

				switch (selectedIndex) {
				case 0:
					// 소개

					break;
				case 1:
					// 기록보기
					table = recordLoad.recordView(table);
					scrollPane.setViewportView(table);

					table.addMouseListener(new MouseListener() {

						// 선택한 시간대를 기준으로 다른 일자에서 같은 시간대 찾기
						@Override
						public void mouseClicked(MouseEvent e) {
							List<LifePattern> lpList = new ArrayList<LifePattern>();

							int row = table.getSelectedRow();
							int col = table.getSelectedColumn();

							if (col == 1) {
								String time = (String) table.getValueAt(row, col);

								try {

									SimpleDateFormat sdf = new SimpleDateFormat("HH");
									SimpleDateFormat sdf1 = new SimpleDateFormat("yy-MM-dd HH:mm");

									int hour = sdf.parse(time).getHours();

									String matchTime = null;
									int matchHour = 0;
									String matchDate = null;
									int matchMilk = 0;
									long date = 0;

									for (int i = 0; i < table.getRowCount(); i++) {
										matchTime = (String) table.getValueAt(i, col);
										matchHour = sdf.parse(matchTime).getHours();

										if (hour == matchHour) {
											LifePattern lp = new LifePattern();
											matchDate = (String) table.getValueAt(i, col - 1);
											matchTime = (String) table.getValueAt(i, col);

											date = sdf1.parse(matchDate + " " + matchTime).getTime();
											matchMilk = Integer.parseInt((String) table.getValueAt(i, col + 1));

											lp.setDate(date);
											lp.setMilk(matchMilk);

											lpList.add(lp);
										}
									}

								} catch (ParseException e1) {
									System.out.println("[DEBUG] " + e1.getMessage());
								}

								if (lpList.isEmpty()) {
									JOptionPane.showMessageDialog(null, "일치하는 항목이 없습니다.");
								} else {
									new RecordViewDialog(mainFrame, "시간대 매칭", lpList);
								}

							}

						}

						@Override
						public void mousePressed(MouseEvent e) {

						}

						@Override
						public void mouseReleased(MouseEvent e) {

						}

						@Override
						public void mouseEntered(MouseEvent e) {

						}

						@Override
						public void mouseExited(MouseEvent e) {

						}
					});
					break;
				case 2:
					// 차트

					break;
				case 3:
					// 데이터 분석

					break;
				case 4:
					// 기록하기

					break;

				}

			}
		});
	}
}
