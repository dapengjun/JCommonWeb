package cn.itear.perm.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class InterceptorImpl extends AbstractInterceptor {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
//        Map session = ActionContext.getContext().getSession();
//        //获取session作用域内是否有值
//        UserPo user = (UserPo) session.get("user");
//        if(user!=null){//合法访问
            return invocation.invoke();
//        }else{//user为空说明未经过登陆,保存错误提示信息,跳到登陆页面
//            return Action.LOGIN;
//        }
    }

}
