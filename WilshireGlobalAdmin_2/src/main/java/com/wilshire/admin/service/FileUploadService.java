package com.wilshire.admin.service;

import java.io.File;
import java.io.IOException;

public interface FileUploadService {
	
	public File getFile(String regDate, String imgOriginalName, String imgType) throws IOException;

}
