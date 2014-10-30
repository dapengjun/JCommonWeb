package cn.itear.perm.service;

import java.util.List;

import cn.itear.common.service.IBaseService;
import cn.itear.perm.po.UserPo;

public interface IUserService extends IBaseService {

    // 添加用户
    public void addUser(UserPo user);

    public void updateUser(UserPo user);

    public void deleteUser(Integer userId);

    public UserPo findUserById(Integer userId);

    public List<UserPo> findAllUser();

    public UserPo login(UserPo user);

}
