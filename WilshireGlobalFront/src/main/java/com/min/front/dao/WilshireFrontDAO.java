package com.min.front.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.min.front.common.AbstractDAO;
import com.min.front.common.PortfolioVO;

@Repository("WilshireFrontDAO")
public class WilshireFrontDAO extends AbstractDAO {
	
	/**
	 * ¸®½ºÆ® select 
	 * Method = adminList
	 * param = null
	 * return url = adminList.jsp
	 */
    public List<PortfolioVO> selectFrontWorkList(String workType) throws Exception{
        return (List<PortfolioVO>)selectList("front.selectFrontWorkList", workType);
    }
}
