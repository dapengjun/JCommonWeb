<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="netnote.css">
    <style>
        .datagrid-row { cursor : pointer;}
    </style>
    <script type="text/javascript" language="javascript" src="js/jquery-2.0.0.js"></script>
    <script type="text/javascript" language="javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" language="javascript" src="netnote.js"></script>
    <title><s:text name="user.title"></s:text></title>
</head>
<body>
    <div id="dg">
    </div>
    <div id="dd" class="easyui-dialog" title="便签信息" style="width:550px;height:500px;"
        data-options="iconCls:'icon-save',resizable:true,modal:true, closed : true,
         buttons:[{ text:'保存', handler:save},
            {text:'取消', handler:cancel}]">
        <form id="ff" method="post">
           <input type=hidden id="id" name="noteInfo.id"/>
           <table>
            <tr>
                <td><textarea class="easyui-validatebox" style="width:500px;height:400px;" id="content" name="noteInfo.content" data-options="required:true" /></td>
            </tr>
            </table>
        </form>
    </div>
</body>
</html>