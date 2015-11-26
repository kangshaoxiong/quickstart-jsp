package com.my.quickstart.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件操作
 * 
 * @author bsr
 * @version 6.0
 * @created 2014-5-5 上午11:47:05
 */
public class FileUtil {

	private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

	public static FileType uploadFile(File imgFile) {
		if (null == imgFile) {
			return null;
		}

		FileType fileType = new FileType();

		fileType.file = imgFile;

		if (fileType.file == null) {
			return null;
		}

		String type = fileType.fileType;

		if (type == null) {
			return null;
		}

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(imgFile);
			// Blob blob = new Blob();
			// blob.set(fis, "image/png");
			// fileType.filePath = "/images?uuid=" + blob.getUUID();

		} catch (FileNotFoundException e) {
			logger.error("上传图片 复制文件 出现异常!", e);
			return null;
		}

		return fileType;
	}
}
