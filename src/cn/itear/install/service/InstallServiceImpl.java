package cn.itear.install.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import cn.itear.common.service.BaseServiceImpl;
import cn.itear.install.dao.IInstallDao;
import cn.itear.perm.dao.IUserDao;
import cn.itear.perm.po.UserPo;

@Transactional
@Service("installService")
public class InstallServiceImpl extends BaseServiceImpl implements IInstallService {

    @Autowired
    private IInstallDao installDao;

    public void dbInit() throws Exception
    {
//    	try {
    	    installDao.execSqlScript("database.sql");
//		} catch (IOException | SQLException e) {
//			e.printStackTrace();
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			throw e;
//		}
    }
}
