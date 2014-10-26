package cn.itear.perm.service;

import java.util.List;

import cn.itear.perm.po.UserPo;

public interface IUserService {

    // 添加用户
    public abstract void addUser(UserPo user);

    public abstract void updateUser(UserPo user);

    public abstract void deleteUser(Integer userId);

    public abstract UserPo findUserById(Integer userId);

    public abstract List<UserPo> findAllUser();

    public abstract UserPo login(UserPo user);

}
