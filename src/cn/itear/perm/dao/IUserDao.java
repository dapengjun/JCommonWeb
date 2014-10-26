package cn.itear.perm.dao;

import java.util.List;

import cn.itear.perm.po.UserPo;

public interface IUserDao {

    public abstract void insertUser(UserPo user);

    public abstract void updateUser(UserPo user);

    public abstract void deleteUser(Integer userId);

    public abstract UserPo findUserByid(Integer userId);

    public abstract List<UserPo> findAll();

    public abstract UserPo userLogin(UserPo user);

}
