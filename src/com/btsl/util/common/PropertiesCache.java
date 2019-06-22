package com.btsl.util.common;
/*
@Author:MohitRaj 2017
*/
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesCache
{
   private final Properties configProp = new Properties();
    
   private PropertiesCache()
   {
      //Private constructor to restrict new instances
	 // String fileName = "/home/mbas/BackEndProcess/config/Template.properties";
	 String fileName = null;
	 FileInputStream in = null;
      try {
    	  fileName = "/home/mbas/BackEndProcess/config/LoggerFtp.properties";
    	  in = new FileInputStream(fileName);
          configProp.load(in);
      } catch (IOException e) {
          e.printStackTrace();
      }
      finally{
    	  if(in !=null){
    		  try {
				in.close();
				in = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	  }
      }
   }
 
   //Bill Pugh Solution for singleton pattern
   private static class LazyHolder
   {
      private static final PropertiesCache INSTANCE = new PropertiesCache();
   }
 
   public static PropertiesCache getInstance()
   {
      return LazyHolder.INSTANCE;
   }
   
   public String getProperty(String key){
      return configProp.getProperty(key).trim();
   }
    
   public Set<String> getAllPropertyNames(){
      return configProp.stringPropertyNames();
   }
    
   public boolean containsKey(String key){
      return configProp.containsKey(key);
   }
   
}