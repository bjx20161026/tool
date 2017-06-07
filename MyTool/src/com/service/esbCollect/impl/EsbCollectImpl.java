package com.service.esbCollect.impl;

import java.io.File;

import com.service.esbCollect.EsbCollect;
import com.service.util.ftp.FileOperate;

public class EsbCollectImpl implements EsbCollect {

	@Override
	public File DownLoadFtpFile(String url) {
		// TODO Auto-generated method stub
		FileOperate fo = new FileOperate(url);
		return null;
	}
}
