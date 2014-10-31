package cn.itear.common.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface IBaseDao {
	public void execSql(String sql);
	public void execSqlScript(String sqlFile) throws IOException, SQLException;
}
