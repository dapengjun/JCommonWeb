<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="/common/header.jsp"%>
    <link rel="stylesheet" type="text/css" href="group.css">
    <script type="text/javascript" language="javascript" src="group.js"></script>
    <title><s:text name="group.title"></s:text></title>
</head>
<body>
    <div id="dg">
    </div>
    <div id="dd" class="easyui-dialog" title="组信息"
        style="width:550px;height:500px;" 
        data-options="iconCls:'icon-save',resizable:true,modal:true, closed : true,
         buttons:[{ text:'保存', handler:save},
            {text:'取消', handler:cancel}]">
        <form id="ff" method="post">
           <input type=hidden id="id" name="groupInfo.id"/>
           <table>
            <tr>
                <td>名称</td>
                <td>
                    <input class="easyui-validatebox"
                      id="name" name="groupInfo.name"
                       data-options="required:true" />
               </td>
            </tr>
            <tr>
                <td>组描述</td>
                <td>
                    <input class="easyui-validatebox"
                      id="desc" name="groupInfo.desc"
                       data-options="required:true" />
               </td>
            </tr>
            </table>
        </form>
    </div>
</body>
</html>