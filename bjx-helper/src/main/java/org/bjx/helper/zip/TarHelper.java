package org.bjx.helper.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.bjx.helper.file.FileHelper;

/**
 * @author b j x
 * @Description Compress folder
 */

public class TarHelper {
	
	public static void tar(String targetFile,String sourceFolder) throws Exception {
		Logger logger = Logger.getLogger(TarHelper.class);
		targetFile = targetFile+".tar.gz";
		logger.info(String.format("Compress [%s] to [%s] started!", sourceFolder,targetFile));
		long start = System.currentTimeMillis();
		OutputStream outputStreama = new FileOutputStream(targetFile);
		outputStreama = new GZIPOutputStream(outputStreama);
		TarArchiveOutputStream tarArchiveOutputStream = new TarArchiveOutputStream(outputStreama);
		tarArchiveOutputStream.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
		int i = 0;
		for (String filePath : FileHelper.listFiles(sourceFolder)) {
			i++;
			logger.debug(filePath);
			File file = new File(filePath);
			tarArchiveOutputStream.putArchiveEntry(new TarArchiveEntry(file));
			FileInputStream fileInputStream = new FileInputStream(file);
			IOUtils.copy(fileInputStream, tarArchiveOutputStream);
			tarArchiveOutputStream.closeArchiveEntry();
			fileInputStream.close();
		}
		tarArchiveOutputStream.finish();
		tarArchiveOutputStream.flush();
		tarArchiveOutputStream.close();
		long end = System.currentTimeMillis();
		logger.info("-----------------------");
		logger.info("Total time : " + (end - start) + "ms");
		logger.info("File num : " + i);
		logger.info("-----------------------");
	}
}
