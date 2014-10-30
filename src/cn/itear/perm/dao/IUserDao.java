package cn.itear.perm.dao;

import java.util.List;

import cn.itear.common.dao.IBaseDao;
import cn.itear.perm.po.UserPo;

public interface IUserDao extends IBaseDao {

    public void insertUser(UserPo user);

    public void updateUser(UserPo user);

    public void deleteUser(Integer userId);

    public UserPo findUserByid(Integer userId);

    public List<UserPo> findAll();

    public UserPo userLogin(UserPo user);

}
