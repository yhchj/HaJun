package com.hajun.rho.listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;

import com.hajun.rho.database.Database;

// 창 이벤트
public class Window extends WindowAdapter {

	// 창이 열린 후
	@Override
	public void windowOpened(WindowEvent e) {

	}

	// 창을 닫을 때
	@Override
	public void windowClosing(WindowEvent e) {
		try {
			Database.con.close();
		} catch (SQLException e1) {
			System.out.println("Window windowClosing SQLException --> " + e1.getMessage());
		}
		
		JFrame frame = (JFrame) e.getSource();
		frame.dispose();
	}

}
