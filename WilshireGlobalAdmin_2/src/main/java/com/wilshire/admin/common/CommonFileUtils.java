package com.wilshire.admin.common;
 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wilshire.admin.vo.PortfolioVO;
 
@Component("fileUtils")
public class CommonFileUtils {
    private static final String filePath = "/data/file/";
	
    public PortfolioVO parseInsertFileInfo(PortfolioVO portfolioVO, HttpServletRequest request) throws Exception{
       
    	MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
         
        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String storedFileName = null;
        
        Date today = new Date();
        String s = today.toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String formatDay = dateFormat.format(today);
        String [] regdateArray = formatDay.split("\\-");				//		2017 03 21
		
        String regdate = regdateArray[0]+regdateArray[1]+regdateArray[2];
        
        portfolioVO.setCreated_datetime(today);
        portfolioVO.setImgDate(regdate);
        String filePaths=filePath;
        filePaths+=regdate+"/";
         
        File file = new File(filePaths);
        if(file.exists() == false){
            file.mkdirs();
        }
         
        while(iterator.hasNext()){
        	multipartFile = multipartHttpServletRequest.getFile(iterator.next());
        	if(multipartFile.isEmpty() == false){
        		originalFileName = multipartFile.getOriginalFilename();
        		originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        		storedFileName = CommonUtils.getRandomString() + originalFileExtension;
        		
        		file = new File(filePaths + originalFileName);
        		multipartFile.transferTo(file);
        		
        		
        		/*
        		 * #{imgOriginalName}		=> 이미지 실제 이름
        		 * #{imgName}				=> 랜덤 이름	
        		 * #{imgSize}				=> 이미지 사이즈
        		 * #{imgPath}				=> 이미지 경로
        		 */
        		String [] arrayImgName = originalFileName.split("\\.");
        		
        		portfolioVO.setImgOriginalName(originalFileName);
        		portfolioVO.setImgName(storedFileName);
        		portfolioVO.setImgSize(multipartFile.getSize());
        		portfolioVO.setImgType(arrayImgName[1]);
        		portfolioVO.setImgPath(filePaths+originalFileName);
        		
        }
        }
        return portfolioVO;
    }
    
}


