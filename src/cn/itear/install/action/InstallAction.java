package cn.itear.install.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itear.common.action.BaseAction;
import cn.itear.install.service.IInstallService;

@Scope("prototype")
@Controller("installAction")
@Namespace("/")
@ParentPackage("struts-shops")
@Results({
	@Result(name = "success", location = "/user/success.jsp"),
    @Result(name = "failure", location = "/user/success.jsp"),
    @Result(name = "json", type = "json", params = {"root", "result"})
})
@Action(value = "install")
public class InstallAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    
    @Autowired
    protected IInstallService installService;
    
    public InstallAction() {
    }

    public String execute() {
        String rootPath = ServletActionContext.getServletContext().getRealPath("/");
        
        return "success";
    }
}
