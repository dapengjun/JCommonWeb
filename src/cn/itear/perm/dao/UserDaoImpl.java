package cn.itear.perm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itear.common.dao.BaseDaoImpl;
import cn.itear.perm.po.UserPo;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {
    private final String INSERT_USER = "insertUser";
    private final String UPDATE_USER = "updateUser";
    private final String DELETE_USER = "deleteUser";
    private final String SELECT_USER = "selectUser";
    private final String SELECT_USER_LIST = "selectUserList";
    private final String SELECT_USER_CNT = "selectUserCnt";
    private final String USER_LOGIN = "userLogin";

    public void insert(UserPo user) {
        sqlSessionTemplate.insert(INSERT_USER, user);
    }

    public void update(UserPo user) {
        sqlSessionTemplate.update(UPDATE_USER, user);
    }

    public void delete(Integer userId) {
        sqlSessionTemplate.delete(DELETE_USER, userId);
    }

    public UserPo selectOne(Integer userId) {
        return sqlSessionTemplate.selectOne(SELECT_USER, userId);
    }

    @SuppressWarnings("rawtypes")
    public List<UserPo> selectList(Map map) {
        return sqlSessionTemplate.selectList(SELECT_USER_LIST, map);
    }

    @SuppressWarnings("rawtypes")
    public int selectCnt(Map map) {
        return sqlSessionTemplate.selectOne(SELECT_USER_CNT, map);
    }
    
    public UserPo userLogin(UserPo user) {
        return sqlSessionTemplate.selectOne(USER_LOGIN, user);
    }
}
