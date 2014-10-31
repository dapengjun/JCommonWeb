package cn.itear.common.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoImpl implements IBaseDao {

    private final String SQL_EXEC = "sql_exec";
    
    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

	public void execSql(String sql) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("sql", sql);
		sqlSessionTemplate.update(SQL_EXEC, map);
	}
	
	public void execSqlScript(String sqlFile) throws IOException, SQLException
	{
		Connection conn = sqlSessionTemplate.getConnection();
		ScriptRunner runner = new ScriptRunner(conn);
		runner.runScript(Resources.getResourceAsReader(sqlFile));
	}
}
