package cn.itear.perm.service;

import java.util.List;
import java.util.Map;

import cn.itear.common.service.IBaseService;
import cn.itear.perm.po.GroupPo;

public interface IGroupService extends IBaseService {

    // 添加用户
    public void insert(GroupPo user);

    public void update(GroupPo user);

    public void delete(Integer userId);

    public GroupPo selectOne(Integer userId);

    @SuppressWarnings("rawtypes")
    public List<GroupPo> selectList(Map map);
    
    @SuppressWarnings("rawtypes")
    public int selectCnt(Map map);
}
