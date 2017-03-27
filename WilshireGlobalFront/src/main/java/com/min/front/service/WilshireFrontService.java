package com.min.front.service;

import java.util.List;

import com.min.front.common.PortfolioVO;


public interface WilshireFrontService {
	
	// list È­¸é
		List<PortfolioVO> selectFrontWorkList(String workType) throws Exception;

}
