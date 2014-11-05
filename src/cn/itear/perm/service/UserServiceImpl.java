package cn.itear.perm.service;

import java.util.List;
import java.util.Map;

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

    // 添加用户
    public void insertUser(UserPo user) {
        userDao.insertUser(user);
    }

    // 更新用户
    public void updateUser(UserPo user) {
        userDao.updateUser(user);
    }

    public void deleteUser(Integer userId) {
        userDao.deleteUser(userId);
    }

    public UserPo selectUser(Integer userId) {
        return userDao.selectUser(userId);
    }

    @SuppressWarnings("rawtypes")
    public List<UserPo> selectUserList(Map map) {
        return userDao.selectUserList(map);
    }

    @SuppressWarnings("rawtypes")
    public int selectUserCnt(Map map) {
        return userDao.selectUserCnt(map);
    }

    public UserPo userLogin(UserPo user) {
        return userDao.userLogin(user);
    }
}
