package cn.itear.perm.dao;

import java.util.List;
import java.util.Map;

import cn.itear.common.dao.IBaseDao;
import cn.itear.perm.po.GroupPo;

public interface IGroupDao extends IBaseDao {

    public void insert(GroupPo user);

    public void update(GroupPo user);

    public void delete(Integer userId);

    public GroupPo selectOne(Integer userId);

    @SuppressWarnings("rawtypes")
    public List<GroupPo> selectList(Map map);
    
    @SuppressWarnings("rawtypes")
    public int selectCnt(Map map);

}
