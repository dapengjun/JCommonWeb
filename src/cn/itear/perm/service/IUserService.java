package cn.itear.perm.service;

import java.util.List;
import java.util.Map;

import cn.itear.common.service.IBaseService;
import cn.itear.perm.po.UserPo;

public interface IUserService extends IBaseService {

    // 添加用户
    public void insertUser(UserPo user);

    public void updateUser(UserPo user);

    public void deleteUser(Integer userId);

    public UserPo selectUser(Integer userId);

    @SuppressWarnings("rawtypes")
    public List<UserPo> selectUserList(Map map);
    
    @SuppressWarnings("rawtypes")
    public int selectUserCnt(Map map);

    public UserPo userLogin(UserPo user);
}
