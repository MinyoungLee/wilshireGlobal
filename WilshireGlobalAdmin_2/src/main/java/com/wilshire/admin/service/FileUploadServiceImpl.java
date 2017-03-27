package com.wilshire.admin.service;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wilshire.admin.vo.PortfolioVO;

@Service("FileUploadService")
public class FileUploadServiceImpl implements FileUploadService {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);
	private static final String filePath = "/data/file/"; 
	
	
	public File getFile(String regDate, String imgOriginalName, String imgType) throws IOException {
		String path = filePath + regDate + File.separator +imgOriginalName;
		File file = new File(path);
		if(!file.exists())
			file = new File(path);
		return file;
	}
}
