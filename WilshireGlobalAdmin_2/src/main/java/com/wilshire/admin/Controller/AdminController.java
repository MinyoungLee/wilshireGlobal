package com.wilshire.admin.Controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wilshire.admin.common.CommonFileUtils;
import com.wilshire.admin.service.AdminService;
import com.wilshire.admin.service.FileUploadService;
import com.wilshire.admin.vo.PortfolioVO;



/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminservice;
	@Autowired
	private FileUploadService fileUploadService ;
	@Autowired
	private CommonFileUtils fileutils;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	private static final String imgViewURL = "http://localhost:8082/admin/profile"; 
	
	
	int resultCode = 0;
	String resultMessage ="";
	
	/**
	 * 리스트 select 
	 * Method = adminList
	 * param = null
	 * return url = adminList.jsp
	 */
    @RequestMapping(value="/adminList")
    public ModelAndView adminList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mv = new ModelAndView("adminList");
        PortfolioVO portfolioVO = new PortfolioVO();
        List<PortfolioVO> selectAdminList = adminservice.selectAdminList(portfolioVO);
        mv.addObject("selectAdminList", selectAdminList);
        return mv;
    }
    

	/**
	 * 행사 추가하기 폼화면
	 * Method = adminInsertForm
	 * param = null
	 * return url = insertForm
	 */
    @RequestMapping(value="/insertForm")
    public ModelAndView adminInsertForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mv = new ModelAndView("insertForm");
        return mv;
    }
    
    
    
    /**
     * 행사 추가하기
     * Method = adminInsert
     * param = PortfolioVO
     * return url = adminList
     */
    @RequestMapping(value="/adminInsert" ,method=RequestMethod.POST)
    public String adminInsert(HttpServletRequest request, HttpServletResponse response, PortfolioVO portfolioVO) throws Exception{
    	String returnUrl="";
    	logger.debug("Method adminInsert call");
    	System.out.println("???"+portfolioVO.getWorkType());
    	try {
    		portfolioVO = fileutils.parseInsertFileInfo(portfolioVO, request);
    		resultCode = adminservice.adminInsert(portfolioVO);
    		if(resultCode==0){
    			resultMessage="Data Insert fail";
    			returnUrl="/error";
    		}else{
    			resultMessage="Data Insert success";
    			returnUrl="/adminList";
    		}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(resultMessage);
		}
    	
    	return "redirect:"+returnUrl;
    }
    
	/**
	 * 상세화면
	 * Method = detailDataList
	 * param = String boardNo
	 * return url = detailDataList.jsp
	 */
    @RequestMapping(value="/detailDataList")
    public ModelAndView detailDataList(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="boardNo") String boardNo) throws Exception{
    	logger.debug("Method detailDataList call");
    	ModelAndView mv = new ModelAndView("detailDataList");
    	try {
    		PortfolioVO detailVO = adminservice.detailDataList(boardNo);
    		detailVO.setImgViewURL(imgViewURL);
    		mv.addObject("detailVO", detailVO);
    	} catch (Exception e) {
			e.printStackTrace();
		}
        return mv;
    }
    
    /**
	 * 이미지 보여주기 로직
	 * Method = viewImage
	 * param = String imgDate
	 * param = String imgOriginalName
	 * param = String imageType
	 * return url = detailDataList.jsp
	 */
    @RequestMapping(value="/profile/{imgDate}/{imgOriginalName}/{imgType}" , method=RequestMethod.GET)
	public void viewImage(HttpServletRequest request, HttpServletResponse response, @PathVariable("imgDate") String imgDate ,@PathVariable("imgOriginalName") String imgOriginalName, @PathVariable("imgType") String imgType) throws IOException{
    	try{
			//String regDate, String imgName, String imageType
			File file = fileUploadService.getFile(imgDate, imgOriginalName, imgType);
			response.setContentType("image/png");
			FileUtils.copyFile(file, response.getOutputStream());
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    /**
	 * 삭제하기
	 * Method = adminDelete
	 * param = String boardNo
	 * return url = adminList.jsp
	 */
    @RequestMapping(value="/adminDelete")
    @ResponseBody
    public Map<String, Object> adminDelete(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="boardNo") String boardNo) throws Exception{
    	logger.debug("Method delete call");
    	int resultCode;
		Map<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultCode = adminservice.adminDelete(boardNo);
    		if(resultCode==0){
    			resultMessage="error";
    			resultMap.put("data", resultMessage);
    		}else{
    			resultMessage="success";
    			resultMap.put("data", resultMessage);
    		}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(resultMessage);
		}
    	
    	return resultMap;
    }
    
    
	/**
	 * error 화면
	 * Method = errorPage
	 * return url = error.jsp
	 */
    @RequestMapping(value="/error")
    public ModelAndView errorPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mv = new ModelAndView("error");
        return mv;
    }
}
