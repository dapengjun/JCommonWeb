package cn.itear.perm.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itear.common.action.BaseAction;
import cn.itear.perm.po.UserPo;
import cn.itear.perm.service.IUserService;

import com.opensymphony.xwork2.ActionContext;

@Scope("prototype")
@Controller("login")
@Namespace("/perm")
@ParentPackage("struts-shops")
@Results({
    @Result(name = "success", type="redirect", location = "/index.jsp"),
    @Result(name = "failure", location = "/login.jsp"),
    @Result(name = "json", type = "json", params = {"root", "result"})
})
@Action(value = "login")
@InterceptorRefs({
    @InterceptorRef("defaultStack")
})
public class LoginAction extends BaseAction {

    private static final long serialVersionUID = 1L;
    @Autowired
    protected IUserService userService;
    
    private UserPo userPo;
    public UserPo getUserPo() {
        return userPo;
    }
    public void setUserPo(UserPo userPo) {
        this.userPo = userPo;
    }
    
    public String execute() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        try {
        	userService.test();
            if (userPo != null) {
                session.put("user", userPo);
            }else{
                return "login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
    public String reg() {
        userService.insert(userPo);
        return "success";
    }
}
