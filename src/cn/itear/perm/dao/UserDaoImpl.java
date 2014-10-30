package cn.itear.perm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itear.common.dao.BaseDaoImpl;
import cn.itear.perm.po.UserPo;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {
    private final String INSERT_USER = "insertUser";
    private final String UPDATE_USER = "updateUser";
    private final String DELETE_USER = "deleteUser";
    private final String FIND_USER_BYID = "findUserById";
    private final String SELECT_ALL_USER = "selectAllUser";
    private final String USER_LOGIN = "userLogin";

    public void insertUser(UserPo user) {
        sqlSessionTemplate.insert(INSERT_USER, user);
    }

    public void updateUser(UserPo user) {
        sqlSessionTemplate.update(UPDATE_USER, user);
    }

    public void deleteUser(Integer userId) {
        sqlSessionTemplate.delete(DELETE_USER, userId);
    }

    public UserPo findUserByid(Integer userId) {
        return sqlSessionTemplate.selectOne(FIND_USER_BYID, userId);
    }

    public List<UserPo> findAll() {
        return sqlSessionTemplate.selectList(SELECT_ALL_USER);
    }

    public UserPo userLogin(UserPo user) {
        return sqlSessionTemplate.selectOne(USER_LOGIN, user);
    }
}
