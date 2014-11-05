package cn.itear.common.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

public class BaseAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {
	protected Map<String, Object> session;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
	protected Log log = LogFactory.getLog(this.getClass());
	protected static Gson gson = new Gson();

	private static final long serialVersionUID = 1L;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    @Override
    public void setSession(Map<String, Object> stringObjectMap) {
        this.session = stringObjectMap;
    }
}
