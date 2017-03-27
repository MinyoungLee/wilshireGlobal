package com.wilshire.admin.Dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {
	
	protected Log log = LogFactory.getLog(AbstractDAO.class);
    
    @Autowired
    private SqlSessionTemplate sqlSessionProxy;
     
    protected void printQueryId(String queryId) {
        if(log.isDebugEnabled()){
            log.debug("\t QueryId  \t:  " + queryId);
        }
    }
     
    public Object insert(String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionProxy.insert(queryId, params);
    }
     
    public Object update(String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionProxy.update(queryId, params);
    }
     
    public Object delete(String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionProxy.delete(queryId, params);
    }
     
    public Object selectOne(String queryId){
        printQueryId(queryId);
        return sqlSessionProxy.selectOne(queryId);
    }
     
    public Object selectOne(String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionProxy.selectOne(queryId, params);
    }
     
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId){
        printQueryId(queryId);
        return sqlSessionProxy.selectList(queryId);
    }
     
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionProxy.selectList(queryId,params);
    }
    
    @SuppressWarnings("rawtypes")
    public List<Object> selectListObject (String queryId){
        printQueryId(queryId);
        return sqlSessionProxy.<Object> selectList(queryId);
    }
    
    @SuppressWarnings("rawtypes")
    public List<Object> selectListObject (String queryId, Object params){
        printQueryId(queryId);
        return sqlSessionProxy.<Object> selectList(queryId, params);
    }


}
