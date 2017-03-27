package com.wilshire.admin.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilshire.admin.Dao.AdminDao;
import com.wilshire.admin.common.CommonFileUtils;
import com.wilshire.admin.vo.PortfolioVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminDao admindao;
	
	/**
	 * 리스트 select 
	 * Method = adminList
	 * param = null
	 * return url = adminList.jsp
	 */
	@Override
	public List<PortfolioVO> selectAdminList(PortfolioVO portfolioVO) throws Exception{
		List<PortfolioVO> selectList = null;
		try {
			logger.debug("selectAdminList Method SERVICEIMPL");
			selectList = admindao.selectAdminList(portfolioVO);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.getStackTrace();
		}
		return selectList;
	}

    /**
     * 행사 추가하기
     * Method = adminInsert
     * param = PortfolioVO
     * return url = adminList
     */
	@Override
	public Integer adminInsert(PortfolioVO portfolioVO) throws Exception {
		int resultCode = 0;
		try {
			resultCode = admindao.adminInsert(portfolioVO);		
		} catch (Exception e) {
			logger.error("Insert admin fail");
			logger.error(e.getMessage(), e);
		}
		return resultCode;
	}
	
	/**
	 * 상세화면
	 * Method = detailDataList
	 * param = String boardNo
	 * return url = detailDataList.jsp
	 */
	@Override
	public PortfolioVO detailDataList(String boardNo) throws Exception{
		PortfolioVO detailVO= new PortfolioVO();
		try {
			logger.debug("selectAdminList Method SERVICEIMPL");
			detailVO = admindao.detailDataList(boardNo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.getStackTrace();
		}
		return detailVO;
	}
	
	
    /**
	 * 삭제하기
	 * Method = adminDelete
	 * param = String boardNo
	 * return url = adminList.jsp
	 */
	@Override
	public Integer adminDelete(String boardNo) throws Exception {
		int resultCode = 0;
		try {
			resultCode = admindao.adminDelete(boardNo);		
		} catch (Exception e) {
			logger.error("Delete admin fail");
			logger.error(e.getMessage(), e);
		}
		return resultCode;
	}

}
