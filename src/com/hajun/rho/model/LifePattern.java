package com.hajun.rho.model;

public class LifePattern {
	long date = 0; // 일시
	int milk = 0; // 분유
	int burp = 0; // 트림
	int pee = 0; // 소변
	int feces = 0; // 대변
	int bath = 0; // 목욕
	int cream = 0; // 크림
	String height = ""; // 키
	String weight = ""; // 몸무게
	String desc = ""; // 비고

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	public int getBurp() {
		return burp;
	}

	public void setBurp(int burp) {
		this.burp = burp;
	}

	public int getPee() {
		return pee;
	}

	public void setPee(int pee) {
		this.pee = pee;
	}

	public int getFeces() {
		return feces;
	}

	public void setFeces(int feces) {
		this.feces = feces;
	}

	public int getBath() {
		return bath;
	}

	public void setBath(int bath) {
		this.bath = bath;
	}

	public int getCream() {
		return cream;
	}

	public void setCream(int cream) {
		this.cream = cream;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "LifePattern [date=" + date + ", milk=" + milk + ", burp=" + burp + ", pee=" + pee + ", feces=" + feces
				+ ", bath=" + bath + ", cream=" + cream + ", height=" + height + ", weight=" + weight + ", desc=" + desc
				+ "]";
	}

}
