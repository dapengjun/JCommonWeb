package cn.itear.perm.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import cn.itear.common.service.BaseServiceImpl;
import cn.itear.perm.dao.IUserDao;
import cn.itear.perm.po.UserPo;

@Transactional
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    public void dbInit()
    {
    	try {
    		//    	userDao.execSql("create table test1(name varchar(20))");
			userDao.execSqlScript("database.sql");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
    }
    
    // 添加用户
    public void addUser(UserPo user) {
        userDao.insertUser(user);
    }

    // 更新用户
    public void updateUser(UserPo user) {
        userDao.updateUser(user);
    }

    public void deleteUser(Integer userId) {
        userDao.deleteUser(userId);
    }

    public UserPo findUserById(Integer userId) {
        return userDao.findUserByid(userId);
    }

    public List<UserPo> findAllUser() {
        return userDao.findAll();
    }

    public UserPo login(UserPo user) {
        return userDao.userLogin(user);
    }
}
