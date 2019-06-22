package com.btsl.logger;

public class aBC {
	
	public static void main(String[] args) {
		
		String f1= "105_0000_SDRSE00_16052018190000_DIG.cdr";
		String f2= "105_0000_ENT_SDRSE00_16052018190000_DIG.cdr";
		String fnameArr [] = f2.split("\\_");				
		System.out.println(fnameArr[4]);
	    /*for(int i=0;i<10;i++)
	    {
	        if (i==4)
	        {
	            break;
	        }
	        System.out.print(i+"\t");

	    }
	    System.out.println();
	    for(int i=0;i<10;i++)
	    {

	        if (i==4)
	        {
	            continue;
	        }
	        System.out.print(i+"\t");
	    }*/
	}

}
