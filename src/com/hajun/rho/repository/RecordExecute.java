package com.hajun.rho.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hajun.rho.database.Database;
import com.hajun.rho.model.LifePattern;

public class RecordExecute {

	final static String LIFE_PATTERN_INSERT_SQL = "INSERT INTO life_pattern(date, milk, burp, pee, feces, bath, cream, height, weight, desc) VALUES(?,?,?,?,?,?,?,?,?,?)";
	final static String LIFE_PATTERN_SELECT_SQL = "SELECT * FROM life_pattern";
	final static String LIFE_PATTERN_PERIOD_SEARCH = "SELECT * FROM life_pattern WHERE date >= ? AND date <= ?";

	// lifePattern 입력
	public int insertLifePattern(LifePattern lifePattern) {
		int result = 0;
		try (PreparedStatement ps = Database.con.prepareStatement(LIFE_PATTERN_INSERT_SQL)) {
			ps.setLong(1, lifePattern.getDate());
			ps.setInt(2, lifePattern.getMilk());
			ps.setInt(3, lifePattern.getBurp());
			ps.setInt(4, lifePattern.getPee());
			ps.setInt(5, lifePattern.getFeces());
			ps.setInt(6, lifePattern.getBath());
			ps.setInt(7, lifePattern.getCream());
			ps.setString(8, lifePattern.getHeight());
			ps.setString(9, lifePattern.getWeight());
			ps.setString(10, lifePattern.getDesc());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("RecordExecute executeLifePattern SQLException --> " + e.getMessage());
		}

		return result;
	}

	// lifePattern 기본 조회
	public List<LifePattern> selectLifePattern() {
		List<LifePattern> lpList = new ArrayList<LifePattern>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = Database.con.prepareStatement(LIFE_PATTERN_SELECT_SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				LifePattern lp = new LifePattern();
				lp.setDate(rs.getLong("date"));
				lp.setMilk(rs.getInt("milk"));
				lp.setBurp(rs.getInt("burp"));
				lp.setPee(rs.getInt("pee"));
				lp.setFeces(rs.getInt("feces"));
				lp.setBath(rs.getInt("bath"));
				lp.setCream(rs.getInt("cream"));
				lp.setHeight(rs.getString("height"));
				lp.setWeight(rs.getString("weight"));
				lp.setDesc(rs.getString("desc"));
				lpList.add(lp);

			}

		} catch (SQLException e) {
			System.out.println("RecordExecute selectLifePattern SQLException --> " + e.getMessage());
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("RecordExecute selectLifePattern finally SQLException --> " + e.getMessage());
			}
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println("RecordExecute selectLifePattern finally SQLException --> " + e.getMessage());
			}
		}

		return lpList;
	}

	// lifePattern 기본 조회
	public List<LifePattern> periodSearchLifePattern(long startDate, long endDate) {
		List<LifePattern> lpList = new ArrayList<LifePattern>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = Database.con.prepareStatement(LIFE_PATTERN_PERIOD_SEARCH);
			ps.setLong(1, startDate);
			ps.setLong(2, endDate);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				LifePattern lp = new LifePattern();
				lp.setDate(rs.getLong("date"));
				lp.setMilk(rs.getInt("milk"));
				lp.setBurp(rs.getInt("burp"));
				lp.setPee(rs.getInt("pee"));
				lp.setFeces(rs.getInt("feces"));
				lp.setBath(rs.getInt("bath"));
				lp.setCream(rs.getInt("cream"));
				lp.setHeight(rs.getString("height"));
				lp.setWeight(rs.getString("weight"));
				lp.setDesc(rs.getString("desc"));
				lpList.add(lp);

			}

		} catch (SQLException e) {
			System.out.println("RecordExecute periodSearchLifePattern SQLException --> " + e.getMessage());
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("RecordExecute periodSearchLifePattern finally SQLException --> " + e.getMessage());
			}
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println("RecordExecute periodSearchLifePattern finally SQLException --> " + e.getMessage());
			}
		}

		return lpList;
	}

}
