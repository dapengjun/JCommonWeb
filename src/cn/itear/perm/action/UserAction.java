package cn.itear.perm.action;

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
import cn.itear.perm.po.UserPo;
import cn.itear.perm.service.IUserService;

@Scope("prototype")
@Controller("userAction")
@Namespace("/")
@ParentPackage("struts-shops")
@Results({
	@Result(name = "success", location = "/user/success.jsp"),
    @Result(name = "failure", location = "/user/success.jsp"),
    @Result(name = "json", type = "json", params = {"root", "result"})
})
@Action(value = "user")
public class UserAction extends BaseAction {
    private static final long serialVersionUID = 1L;

    protected IUserService userService;
    
    public UserAction() {
        page = new ShowByPage();
    }

    public IUserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    private UserPo userInfo;

    public UserPo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserPo userInfo) {
        this.userInfo = userInfo;
    }

    public String execute() {
        userService.addUser(userInfo);
        return "success";
    }

    public String getUser() {
        try{
            userInfo = userService.findUserById(userInfo.getId());
            result = userInfo.toString();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return "json";
    }

    public String save() {
        try{
            userService.addUser(userInfo);
        }catch(Exception e) {
            e.printStackTrace();
        }
        result = "";
        return "json";
    }

    public String update() {
        try{
            userService.updateUser(userInfo);
        }catch(Exception e) {
            e.printStackTrace();
        }
        result = "";
        return "json";
    }

    public String remove() {
        try{
            userService.deleteUser(userInfo.getId());
        }catch(Exception e) {
            e.printStackTrace();
        }
        result = "";
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

    public String getAjaxList() {
//        JSONArray arr = null;
//        JSONObject obj = null;
//        List<UserPo> list = null;
//        int total;
//        String condition = null;
//        List<Object> param = null;
//        String userName = null;
//        try {
//            userName = page.getParam();
//            if (userName != null && userName.length() > 0) {
//                param = new ArrayList<Object>();
//                condition = "where t.userName like ?";
//                param.add("%"+userName+"%");
//            }
//            list = userService.getUserList(condition, param, (page.getPage() - 1) * page.getRows(), page.getRows());
//            total = userService.getUserCount(condition, param);
//            arr = JSONArray.fromObject(list);
//            obj = new JSONObject();
//            obj.put("total", total);
//            obj.put("rows", arr);
//            result = obj.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return "json";
    }
}
