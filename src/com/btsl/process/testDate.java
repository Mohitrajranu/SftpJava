package com.btsl.process;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class testDate {

	public static void main(String[] args) {
		 Date now = new Date();
		SimpleDateFormat timeFormatter = new SimpleDateFormat("MMddyyhhmm",Locale.US);
		String Currentdatetime = timeFormatter.format(now);
		System.out.println("Currentdatetime :"+Currentdatetime);
	}
}
