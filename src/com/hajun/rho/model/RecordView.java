package com.hajun.rho.model;

public class RecordView {
	private int count = 0;				// 등록 횟수
	private int total = 0;				// 총 분유량
	private int avgMilkForDay = 0;		// 1일 평균 분유량
	private int avgMilkForCount = 0;	// 1회 평균 분유량
	private int term = 0;				// 분유 섭취 텀
	private int peeCount = 0;			// 소변 횟수
	private int fecesCount = 0;		// 대변 횟수
	private int avgPeeForDay = 0;		// 1일 평균 소변 횟수
	private int avgFecesForDay = 0;	// 1일 평균 대변 횟수

	public int getAvgMilkForDay() {
		return avgMilkForDay;
	}

	public void setAvgMilkForDay(int avgMilkForDay) {
		this.avgMilkForDay = avgMilkForDay;
	}

	public int getAvgMilkForCount() {
		return avgMilkForCount;
	}

	public void setAvgMilkForCount(int avgMilkForCount) {
		this.avgMilkForCount = avgMilkForCount;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public int getPeeCount() {
		return peeCount;
	}

	public void setPeeCount(int peeCount) {
		this.peeCount = peeCount;
	}

	public int getFecesCount() {
		return fecesCount;
	}

	public void setFecesCount(int fecesCount) {
		this.fecesCount = fecesCount;
	}

	public int getAvgPeeForDay() {
		return avgPeeForDay;
	}

	public void setAvgPeeForDay(int avgPeeForDay) {
		this.avgPeeForDay = avgPeeForDay;
	}

	public int getAvgFecesForDay() {
		return avgFecesForDay;
	}

	public void setAvgFecesForDay(int avgFecesForDay) {
		this.avgFecesForDay = avgFecesForDay;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "RecordView [count=" + count + ", total=" + total + ", avgMilkForDay=" + avgMilkForDay
				+ ", avgMilkForCount=" + avgMilkForCount + ", term=" + term + ", peeCount=" + peeCount + ", fecesCount="
				+ fecesCount + ", avgPeeForDay=" + avgPeeForDay + ", avgFecesForDay=" + avgFecesForDay + "]";
	}

}
