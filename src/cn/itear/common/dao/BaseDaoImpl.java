package cn.itear.common.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoImpl implements IBaseDao {

    private final String SQL_EXEC = "sql_exec";
    
    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

	public void sqlExec(String sql) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("sql", sql);
		sqlSessionTemplate.update(SQL_EXEC, map);
	}
}
