package org.bjx.helper.ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;

public class FileOperate {
	
	Logger logger = Logger.getLogger(FileOperate.class);

	private String url;

	private FtpFileObject fileObject;
	private FTPClient ftpClient;

	private String localUrl = "../data/";

	public FileOperate(String url) {
		this.url = url;
		fileObject = new FtpFileObject(url);
	}

	public String getDownloadFile() throws Exception {
		String filePath = null;
		File file = new File(localUrl);
		if (!file.exists() && !file.isDirectory())
			file.mkdirs();
		filePath = localUrl + url.substring(url.lastIndexOf("/") + 1);
		login();
		cd();
		get(url.substring(url.lastIndexOf("/") + 1), new FileOutputStream(filePath));
		return filePath;
	}

	public void login() throws Exception {
			FtpFileObject ffo=(FtpFileObject) fileObject;
			ftpClient=new FTPClient();
			ftpClient.connect(ffo.getHost());
			if(ftpClient.login(ffo.getUsername(), ffo.getPassword())==false) {
				throw new ConnectException(String.format("Ftp login failed for Host[%s] UserName[%s] PassWord[%s]", ffo.getHost(),ffo.getUsername(),ffo.getPassword()));
			}
			ftpClient.enterLocalPassiveMode();
		    logger.info(String.format("[%s] login [%s] success","ftp",fileObject.getUrl()));
	}

	public void cd() throws Exception {
		if (fileObject.getDir() != null && !fileObject.getDir().equals("") && !fileObject.getDir().equals("/"))
			cd(fileObject.getDir());
	}

	public void cd(String dir) throws Exception {
		ftpClient.changeWorkingDirectory(dir);
	}

	public String[] ls() throws Exception {
		String[] names = ftpClient.listNames();
		return names;
	}

	public FTPFile[] lsFTPFiles() throws Exception{
		return ftpClient.listFiles();
	}
	
	public void get(OutputStream os) throws Exception {
		get(fileObject.getName(), os);
	}

	public void get(String filename, OutputStream os) throws Exception {
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
		ftpClient.setControlEncoding("utf-8");
		ftpClient.retrieveFile(filename, os);
	}

	public InputStream get(String filename) throws Exception {
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
		ftpClient.setControlEncoding("utf-8");
		return ftpClient.retrieveFileStream(filename);
	}

	public void put(InputStream is) throws Exception {
		put(fileObject.getName(), is);
	}

	public void put(String filename, InputStream is) throws Exception {

		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
		ftpClient.setControlEncoding("utf-8");
		String name = filename + ".temp";
		ftpClient.storeFile(name, is);
		ftpClient.rename(name, filename);
	}

	public void MakeRemoteDir() throws Exception {
		String dir = fileObject.getDir();
		String directory = dir.substring(0, dir.lastIndexOf("/"));
		String path = dir.substring(dir.lastIndexOf("/") + 1, dir.length());
		login();
		ftpClient.changeWorkingDirectory(directory);
		ftpClient.makeDirectory(path);
	}

	public void disConnect() {
		try {
			ftpClient.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public FtpFileObject getFileObject() {
		return fileObject;
	}

	public void setFileObject(FtpFileObject fileObject) {
		this.fileObject = fileObject;
	}

	public FTPClient getFtpClient() {
		return ftpClient;
	}

	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}

}
