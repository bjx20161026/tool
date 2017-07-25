package com.service.esbCollect;

import java.io.File;

public interface EsbCollect {
	public File DownLoadFtpFile(String url);
	public String WordTextToExcel(String path);
}
