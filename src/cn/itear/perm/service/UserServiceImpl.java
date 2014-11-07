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
    public void insert(UserPo user) {
        userDao.insert(user);
    }

    // 更新用户
    public void update(UserPo user) {
        userDao.update(user);
    }

    public void delete(Integer userId) {
        userDao.delete(userId);
    }

    public UserPo selectOne(Integer userId) {
        return userDao.selectOne(userId);
    }

    @SuppressWarnings("rawtypes")
    public List<UserPo> selectList(Map map) {
        return userDao.selectList(map);
    }

    @SuppressWarnings("rawtypes")
    public int selectCnt(Map map) {
        return userDao.selectCnt(map);
    }

    public UserPo userLogin(UserPo user) {
        return userDao.userLogin(user);
    }
}
