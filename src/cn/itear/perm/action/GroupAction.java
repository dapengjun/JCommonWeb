package cn.itear.perm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itear.common.action.BaseAction;
import cn.itear.common.util.ShowByPage;
import cn.itear.perm.po.GroupPo;
import cn.itear.perm.service.IGroupService;

@Scope("prototype")
@Controller("groupAction")
@Namespace("/perm")
@ParentPackage("struts-shops")
@Results({
	@Result(name = "success", location = "/perm/success.jsp"),
    @Result(name = "failure", location = "/perm/success.jsp"),
    @Result(name = "json", type = "json", params = {"root", "result"})
})
@Action(value = "group")
public class GroupAction extends BaseAction {
    private static final long serialVersionUID = 1L;

    @Autowired
    private IGroupService groupService;
    
    public GroupAction() {
        page = new ShowByPage();
    }

    private GroupPo groupInfo;

    public GroupPo getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(GroupPo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public String execute() {
        return "success";
    }

    public String selectUser() {
        try{
            groupInfo = groupService.selectOne(groupInfo.getId());
            result = gson.toJson(groupInfo);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return "json";
    }

    public String insert() {
        try{
            groupService.insert(groupInfo);
            result = "1";
        }catch(Exception e) {
            e.printStackTrace();
            result = "0";
        }
        result = "{\"result\":\""+result+"\"}";
        return "json";
    }

    public String update() {
        try{
            groupService.update(groupInfo);
            result = "1";
        }catch(Exception e) {
            e.printStackTrace();
            result = "0";
        }
        result = "{\"result\":\""+result+"\"}";
        return "json";
    }

    public String delete() {
        try{
            groupService.delete(groupInfo.getId());
            result = "1";
        }catch(Exception e) {
            e.printStackTrace();
            result = "0";
        }
        result = "{\"result\":\""+result+"\"}";
        return "json";
    }

    private String result;

    public String getResult() {
        return result;
    }
    
    private ShowByPage page;
    
    public void setRows(int rows) {
        page.setRows(rows);
    }
    
    public void setPage(int page) {
        this.page.setPage(page);
    }
    
    public void setParam(String param) {
        page.setParam(param);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public String selectAjaxList() {
        Map map = null;
        List<GroupPo> list = null;
        int total;
        int currPage;
        Map param = null;
        String name = null;
        try {
            param = new HashMap();
            name = page.getParam();
            if (name != null && name.length() > 0) {
                param.put("name", "%"+name+"%");
            }
            currPage = (page.getPage() - 1) * page.getRows();
            currPage = currPage < 0 ? 0 : currPage;
            param.put("currRow", currPage);
            param.put("rowNum", page.getRows());
            list = groupService.selectList(param);
            total = groupService.selectCnt(param);
            map = new HashMap();
            map.put("rows", list);
            map.put("total", total);
            result = gson.toJson(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "json";
    }
}
