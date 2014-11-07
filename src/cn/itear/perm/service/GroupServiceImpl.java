package cn.itear.perm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itear.common.service.BaseServiceImpl;
import cn.itear.perm.dao.IGroupDao;
import cn.itear.perm.po.GroupPo;

@Transactional
@Service("groupService")
public class GroupServiceImpl extends BaseServiceImpl implements IGroupService {

    @Autowired
    private IGroupDao groupDao;

    // 添加用户
    public void insert(GroupPo group) {
        groupDao.insert(group);
    }

    // 更新用户
    public void update(GroupPo group) {
        groupDao.update(group);
    }

    public void delete(Integer userId) {
        groupDao.delete(userId);
    }

    public GroupPo selectOne(Integer userId) {
        return groupDao.selectOne(userId);
    }

    @SuppressWarnings("rawtypes")
    public List<GroupPo> selectList(Map map) {
        return groupDao.selectList(map);
    }

    @SuppressWarnings("rawtypes")
    public int selectCnt(Map map) {
        return groupDao.selectCnt(map);
    }
}
