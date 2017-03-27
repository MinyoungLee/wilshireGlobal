package com.min.front.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.front.common.PortfolioVO;
import com.min.front.dao.WilshireFrontDAO;

@Service("WilshireFrontService")
public class WilshireFrontServiceImpl implements WilshireFrontService{
	
	private static final Logger logger = LoggerFactory.getLogger(WilshireFrontServiceImpl.class);
	
	@Autowired
	private WilshireFrontDAO wilshireFrontDao;

	@Override
	public List<PortfolioVO> selectFrontWorkList(String workType) throws Exception {
		List<PortfolioVO> selectList = null;
		try {
			logger.debug("selectAdminList Method SERVICEIMPL");
			selectList = wilshireFrontDao.selectFrontWorkList(workType);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.getStackTrace();
		}
		return selectList;
	}

}
