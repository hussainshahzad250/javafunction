package com.cantech;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TEst {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:MM:ss");
		Date parse = sdf.parse("14:00:00");
		System.out.println(parse.getHours());
		
		
	}
}
