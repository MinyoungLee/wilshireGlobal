package com.wilshire.admin.Dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.wilshire.admin.vo.PortfolioVO;

@Repository("AdminDao")
public class AdminDao extends AbstractDAO {
	
	/**
	 * 리스트 select 
	 * Method = adminList
	 * param = null
	 * return url = adminList.jsp
	 */
    public List<PortfolioVO> selectAdminList(PortfolioVO portfolioVO) throws Exception{
        return (List<PortfolioVO>)selectList("admin.selectAdminList");
    }
	
    /**
     * 행사 추가하기
     * Method = adminInsert
     * param = PortfolioVO
     * return url = adminList
     */
	public Integer adminInsert(PortfolioVO portfolioVO) throws Exception{
		return (Integer)insert("admin.insertData", portfolioVO);
	}
	
	/**
	 * 상세화면
	 * Method = detailDataList
	 * param = String boardNo
	 * return url = detailDataList.jsp
	 */
    public PortfolioVO detailDataList(String boardNo) throws Exception{
        return (PortfolioVO)selectOne("admin.detailDataList", boardNo);
    }
    
    /**
	 * 삭제하기
	 * Method = adminDelete
	 * param = String boardNo
	 * return url = adminList.jsp
	 */
    public Integer adminDelete(String boardNo) throws Exception{
        return (Integer)delete("admin.adminDelete", boardNo);
    }

}
