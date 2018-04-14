package com.hajun.rho;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.ImageProducer;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import javax.swing.JEditorPane;
import java.awt.Canvas;
import java.awt.Panel;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("기록", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("일자");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("D2Coding", Font.PLAIN, 12));
		label.setBounds(12, 10, 38, 15);
		panel_1.add(label);
		
		JLabel lblNewLabel = new JLabel("시간");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel.setBounds(62, 10, 57, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("모유");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(137, 10, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("분유");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(206, 10, 57, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("소변");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(275, 10, 57, 15);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("대변");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(344, 10, 57, 15);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("목욕");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(413, 10, 57, 15);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("크림");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(486, 10, 57, 15);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("비고");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(555, 10, 57, 15);
		panel_1.add(lblNewLabel_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 35, 48, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(72, 35, 47, 21);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(137, 35, 57, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(292, 33, 21, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(431, 33, 21, 23);
		panel_1.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setBounds(501, 33, 21, 23);
		panel_1.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		chckbxNewCheckBox_3.setBounds(363, 33, 21, 23);
		panel_1.add(chckbxNewCheckBox_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(206, 35, 57, 21);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(565, 33, 336, 21);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("사진", null, panel_2, null);
		panel_2.setLayout(null);
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(24, 10, 200, 200);
		JLabel imgLabel = new JLabel(new ImageIcon("D:\\다운로드\\test.jpg"));
		panel_3.add(imgLabel);
		panel_2.add(panel_3);
	}
}
