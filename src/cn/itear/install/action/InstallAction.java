package cn.itear.install.action;

import java.io.File;

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
@Namespace("/install")
@ParentPackage("struts-shops")
@Results({
	@Result(name = "success", location = "/install/success.jsp"),
    @Result(name = "failure", location = "/install/failure.jsp"),
    @Result(name = "json", type = "json", params = {"root", "result"})
})
@Action(value = "install")
public class InstallAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    
    private String result;
    
    public String getResult() {
        return result;
    }

    @Autowired
    private IInstallService installService;
    
    public InstallAction() {
    }

    public String execute() {
        String rootPath = ServletActionContext.getServletContext().getRealPath("/");
        File file = new File(rootPath+"/.install");
        String ret = "success";

        try {
            if (!file.exists()) {
                installService.dbInit();
                file.createNewFile();
                result = "安装成功";
            } else {
                result = "已经安装";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "安装失败";
            ret = "failure";
        }
        return ret;
    }
}
