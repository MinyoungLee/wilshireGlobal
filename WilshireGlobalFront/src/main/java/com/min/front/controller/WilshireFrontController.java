package com.min.front.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.min.front.common.PortfolioVO;
import com.min.front.service.FileUploadService;
import com.min.front.service.WilshireFrontService;



@Controller
public class WilshireFrontController {
	
	private static final Logger logger = LoggerFactory.getLogger(WilshireFrontController.class);
	
	@Autowired
	private WilshireFrontService wilshireFrontService;
	@Autowired
	private FileUploadService fileUploadService;
	
	/**
	 * wilshireGlobal 홈
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/achievement", method = RequestMethod.GET)
	public String achievement(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "achievement";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "contact";
	}
	
	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public String group(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "group";
	}

	@RequestMapping(value = "/introduce", method = RequestMethod.GET)
	public String introduce(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "introduce";
	}

	@RequestMapping(value = "/vision", method = RequestMethod.GET)
	public String vision(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "vision";
	}


	@RequestMapping(value = "/ci", method = RequestMethod.GET)
	public String ciView(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "ci";
	}
	@RequestMapping(value = "/work", method = RequestMethod.GET)
	public ModelAndView workView(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="workType") String workType) {
		ModelAndView mv = new ModelAndView();
        List<PortfolioVO> selectFrontWorkList = null;
		try {
			selectFrontWorkList = wilshireFrontService.selectFrontWorkList(workType);
		} catch (Exception e) {
			e.printStackTrace();
		}
        mv.addObject("selectFrontWorkList", selectFrontWorkList);
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


}
