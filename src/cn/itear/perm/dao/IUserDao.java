package cn.itear.perm.dao;

import java.util.List;
import java.util.Map;

import cn.itear.common.dao.IBaseDao;
import cn.itear.perm.po.UserPo;

public interface IUserDao extends IBaseDao {

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
