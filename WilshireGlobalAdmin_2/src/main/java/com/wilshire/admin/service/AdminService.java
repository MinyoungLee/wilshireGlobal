package com.wilshire.admin.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wilshire.admin.vo.PortfolioVO;


public interface AdminService {
	
	// list 화면
	List<PortfolioVO> selectAdminList(PortfolioVO portfolioVO) throws Exception;
	
	// data insert
	Integer adminInsert(PortfolioVO portfolioVO) throws Exception;

	// detail 화면
	PortfolioVO detailDataList(String boardNo) throws Exception;
	
	// data insert
	Integer adminDelete(String boardNo) throws Exception;
}
