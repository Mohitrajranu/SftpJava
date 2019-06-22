package com.btsl.logger;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.btsl.util.common.*;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
    public class LoggerSftpRename {
	public final static Logger loger= Logger.getLogger(LoggerSftpRename.class);
	static Properties props;
	

	public boolean sftpFileRename (String userId, String ipAddr, String passwd) throws IOException{
		loger.info("sftpFileRename() : Enter, userName="+userId+", ip="+ipAddr);
		
		props = new Properties();
		boolean flag = true;
		String root = null;
		String downloadDirectory = null;
		String downloadPath = null;
		String errorDirectory= null;
		String errorPath = null;
		
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		Details dt = null;
		
		try{
			dt = new Details();
			props.load(dt.getFTPfile());
			
			if(!Details.isNullString(props.getProperty("homeDir"))){
				root = props.getProperty("homeDir").trim();
			}
			if(!Details.isNullString(props.getProperty("downloadDirectory"))){
				downloadDirectory = props.getProperty("downloadDirectory").trim();
				downloadPath = root+"/"+downloadDirectory;
			}
			if(!Details.isNullString(props.getProperty("errorDirectory"))){
				errorDirectory = props.getProperty("errorDirectory").trim();
				errorPath = root+"/"+errorDirectory;
			}

			File downloadFileList = new File (downloadPath);
			File[] files = downloadFileList.listFiles();
			int  SFTPPORT = 22;
			JSch jsch = new JSch();
			String appSourceDir = null;
			if(!Details.isNullString(props.getProperty("appSourceDir"))){
				appSourceDir = props.getProperty("appSourceDir").trim();
			}
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			
			for (File file : files)  {	
				if (file.length() > 0) {
					try{
						if(file.getName().contains("SDRSE00") && file.getName().endsWith(".cdr")){
							if (!file.isFile()){
								continue;
							}
							try {
								session = jsch.getSession(userId, ipAddr, SFTPPORT);
								session.setPassword(passwd);
								session.setConfig(config);
								session.connect();
								
								channel = session.openChannel("sftp");
								channel.connect();
								
								channelSftp = (ChannelSftp) channel;
								channelSftp.cd(appSourceDir);
								channelSftp.rename(file.getName(), file.getName()+".done");
							} 
							catch (Exception ex) {
								ex.printStackTrace();
								loger.debug("sftpFileRename() : Exception is"+ex.getMessage());
								flag = false;
							}
							finally{
								try {
									if (channel != null) {
										channel.disconnect();
										channel = null;
									}
									if (channelSftp !=null){
										channelSftp.exit();
										channelSftp = null;
									}
									if (session !=null){
										session.disconnect();
										session =null;
									}
								} 
								catch (Exception e) {
									loger.debug("sftpFileRename() : Exception Sftp Session Creation, Error="+e.getMessage());
									flag = false;
								}
							}
						}
						else {
							File newFile1 = new File(errorPath);
							FileUtils.moveToDirectory(file, newFile1, true);
							loger.debug("sftpFileRename() : Invalid File Naming Convention "+file.getName());
						}
					}
					catch(Exception e){
						loger.error("sftpFileRename() : Exception in File renaming, Error ="+e.getMessage());
						flag = false;
					} 
					finally{
						loger.debug("sftpFileRename() : file Iteration Exit");
					} 

				}
				else{
					File newF = new File(errorPath);
					FileUtils.moveToDirectory(file, newF, true);
					loger.debug("sftpFileRename() : Zero size file found, fileName="+file.getName()); 
				} 
			}
		}
		catch(Exception e){
			loger.error("sftpFileRename() : Exception is"+e.getMessage());
			e.printStackTrace();
			flag = false;
		}
		finally{
			loger.debug("sftpFileRename() : finally Exit.");
		} 
		return flag;
	}
}