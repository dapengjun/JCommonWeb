package cn.itear.install.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itear.common.service.BaseServiceImpl;
import cn.itear.install.dao.IInstallDao;

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
