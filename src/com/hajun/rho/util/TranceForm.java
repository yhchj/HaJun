package com.hajun.rho.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TranceForm {

	// boolean을 int로 표현
	// true : 1, false : 0
	public static int booleanToInt(boolean flag) {
		return flag == true ? 1 : 0;
	}

	// int로 표현된 boolean(0, 1) String으로 표현
	public static String intToString(int flag) {
		return flag == 1 ? "√" : "";
	}

	// 날짜 표현 형식 변경(date → customFormat)
	public static String dateToCustomFormat(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	// 날짜 표현 형식 변경(long → customFormat)
	public static String dateToCustomFormat(long date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d = new Date(date);
		return sdf.format(d);
	}
}
