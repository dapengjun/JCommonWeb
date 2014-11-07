package cn.itear.perm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itear.common.dao.BaseDaoImpl;
import cn.itear.perm.po.GroupPo;

@Repository("groupDao")
public class GroupDaoImpl extends BaseDaoImpl implements IGroupDao {
    private final String INSERT_GROUP = "insertGroup";
    private final String UPDATE_GROUP = "updateGroup";
    private final String DELETE_GROUP = "deleteGroup";
    private final String SELECT_GROUP = "selectGroup";
    private final String SELECT_GROUP_LIST = "selectGroupList";
    private final String SELECT_GROUP_CNT = "selectGroupCnt";

    public void insert(GroupPo group) {
        sqlSessionTemplate.insert(INSERT_GROUP, group);
    }

    public void update(GroupPo group) {
        sqlSessionTemplate.update(UPDATE_GROUP, group);
    }

    public void delete(Integer userId) {
        sqlSessionTemplate.delete(DELETE_GROUP, userId);
    }

    public GroupPo selectOne(Integer userId) {
        return sqlSessionTemplate.selectOne(SELECT_GROUP, userId);
    }

    @SuppressWarnings("rawtypes")
    public List<GroupPo> selectList(Map map) {
        return sqlSessionTemplate.selectList(SELECT_GROUP_LIST, map);
    }

    @SuppressWarnings("rawtypes")
    public int selectCnt(Map map) {
        return sqlSessionTemplate.selectOne(SELECT_GROUP_CNT, map);
    }
}
