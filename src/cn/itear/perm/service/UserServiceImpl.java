package cn.itear.perm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itear.common.service.BaseServiceImpl;
import cn.itear.perm.dao.IUserDao;
import cn.itear.perm.po.UserPo;

@Transactional
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    public void test()
    {
    	userDao.sqlExec("create table test1(name varchar(20))");
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
