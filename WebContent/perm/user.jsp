<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="/common/header.jsp"%>
    <link rel="stylesheet" type="text/css" href="user.css">
    <script type="text/javascript" language="javascript" src="user.js"></script>
    <title><s:text name="user.title"></s:text></title>
</head>
<body>
    <div id="dg">
    </div>
    <div id="dd" class="easyui-dialog" title="用户信息"
        style="width:550px;height:500px;" 
        data-options="iconCls:'icon-save',resizable:true,modal:true, closed : true,
         buttons:[{ text:'保存', handler:save},
            {text:'取消', handler:cancel}]">
        <form id="ff" method="post">
           <input type=hidden id="id" name="userInfo.id"/>
           <table>
            <tr>
                <td>名称</td>
                <td>
                    <input class="easyui-validatebox"
                      id="name" name="userInfo.name"
                       data-options="required:true" />
               </td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input class="easyui-validatebox"
                      id="password" name="userInfo.password"
                       data-options="required:true" />
               </td>
            </tr>
            </table>
        </form>
    </div>
</body>
</html>