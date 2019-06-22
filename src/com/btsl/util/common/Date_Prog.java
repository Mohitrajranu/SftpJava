package com.btsl.util.common;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Date_Prog {
	public String getDate()
	{
		Calendar cal = Calendar.getInstance(); 
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss: a");
		String today=dateFormat.format(cal.getTime());
		return today;
	}
	public String getDateonly()
	{
		Calendar cal = Calendar.getInstance(); 
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		cal.add(Calendar.DATE, -1);
	    String today=dateFormat.format(cal.getTime());
		return today;
	}
	
	public String getDateforSeq()
	{
		Calendar cal = Calendar.getInstance(); 
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
	    String today=dateFormat.format(cal.getTime());
		return today;
	}
	
	public String getDateforReport()
	{
		Calendar cal = Calendar.getInstance(); 
		DateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
	    String today=dateFormat.format(cal.getTime());
		return today;
	}
	
	public String getDateforSFTP()
	{
		Calendar cal = Calendar.getInstance(); 
		DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
	    String today=dateFormat.format(cal.getTime());
		return today;
	}
	
	public String getDateforFile()
	{
		Calendar cal = Calendar.getInstance(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    String today=dateFormat.format(cal.getTime());
		return today;
	}
	
	public String getSequence(){
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
	    String today=dateFormat.format(cal.getTime());
	    return today;
	}
	public String getDateMysql(){
		Calendar cal = Calendar.getInstance(); 
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss: a");
		String today=dateFormat.format(cal.getTime());
		return today;
	}
	
	public String originalgetDateMysql(){
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String today=dateFormat.format(cal.getTime());
	    return today;
	}
	public String getfirstDateofMonthforReport(){
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DATE, 1);
		String firstDateOfPreviousMonth = dateFormat.format(cal.getTime());
		
		return firstDateOfPreviousMonth;
	}
	public String getlastDateofMonthforReport(){
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DATE, 1);
		

		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE)); // changed calendar to cal

		String lastDateOfPreviousMonth = dateFormat.format(cal.getTime());
		
		return lastDateOfPreviousMonth;
	}
	 public  String firstDayOfLastWeek()
	    {
		 Calendar c = Calendar.getInstance();
		 DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
	        c = (Calendar) c.clone();
	        // last week
	        c.add(Calendar.WEEK_OF_YEAR, -1);
	        // first day
	        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
	        String firstDayOfLastWeek= dateFormat.format(c.getTime());
	        return firstDayOfLastWeek;
	    }

	    public  String lastDayOfLastWeek()
	    {
	    	Calendar c = Calendar.getInstance();
	    	DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
	        c = (Calendar) c.clone();
	        // first day of this week
	        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
	        // last day of previous week
	        c.add(Calendar.DAY_OF_MONTH, -1);
	        String lastDayOfLastWeek= dateFormat.format(c.getTime());
	        return lastDayOfLastWeek;
	    }

	  /*  public  int getBinaryDate(String bindate){
			int binaryDate =0;

			try {
				dc=new Database_con();
				conn=dc.getConnection1();
				
				String getBinDate="SELECT TO_CHAR(to_date('"+bindate+"', 'ddMMyyyy') ,'J') - TO_CHAR(TO_DATE('31-12-1899','DD-MM-YYYY'),'J') as BinaryDate from dual";
				stmt4 = conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
				 res13 = stmt4.executeQuery(getBinDate); 
				res13.next();

				String BinaryDate = res13.getString("BinaryDate");
				binaryDate = Integer.valueOf(BinaryDate);


				stmt4.close();
				res13.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return binaryDate;
			
	    }
*//*public static void main(String[] args) {
	Date_Prog dp=new Date_Prog();
	Date date = new Date();
	String binftdate="";
	String binltdate="";
	String Prevbinftdate="";
	String Prevbinltdate="";
	DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
	Calendar c = Calendar.getInstance();
	c.setTime(date);
	
     
	String firstdate=dp.getfirstDateofMonthforReport();
	System.out.println("first date of month"+firstdate);
	int binaryfirstdate =dp.getBinaryDate(firstdate);
	binftdate = String.valueOf(binaryfirstdate);
		
		if (binftdate == null || binftdate.length() < 9 ||binftdate == " ") {
						
			Prevbinftdate = ("00000000" + binftdate).substring(binftdate.length());

		} else {
			Prevbinftdate = binftdate.substring(binftdate.length() - 9);
		}
	System.out.println("first date of month"+Prevbinftdate);
	String lastdate=dp.getlastDateofMonthforReport();
	System.out.println("first date of month"+lastdate);
	int binarylastdate =dp.getBinaryDate(lastdate);
	binltdate = String.valueOf(binarylastdate);
	
	if (binltdate == null || binltdate.length() < 9 ||binltdate == " ") {
					
		Prevbinltdate = ("00000000" + binltdate).substring(binltdate.length());

	} else {
		Prevbinltdate = binltdate.substring(binltdate.length() - 9);
	}
	System.out.println("first date of month"+Prevbinltdate);
	
}*/
	
	   


}
