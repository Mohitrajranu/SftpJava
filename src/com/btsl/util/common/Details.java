package com.btsl.util.common;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Details {
	InputStream in;

	String ftpprop="/ftp.properties";//Take our properties file.Details.class.getResourceAsStream(ftpprop);
	Properties props;
	
		
	public InputStream getFTPfile() throws IOException {
		in = Details.class.getResourceAsStream(ftpprop);
		return in;
	}
	 public static String convertUtilDateToString(java.util.Date date, String pattern)
	    {
	            try
	            {
	                java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(pattern);
	                formatter.setLenient(false);
	                return formatter.format(date);
	            }
	            catch(Exception ex)
	            {
	                        return null;
	            }

	    }
	
	public static boolean isNullString (String p_text) {
		if(p_text != null && p_text.trim().length() > 0 && !"null".equalsIgnoreCase(p_text.trim())){
			return false;
		}
		else{
			return true;
		}
	}//end of isNullString

}

