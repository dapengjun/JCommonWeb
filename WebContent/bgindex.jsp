<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <%@ include file="/common/header.jsp"%>
    <link rel="stylesheet" type="text/css" href="bgindex.css">
    <script type="text/javascript" language="javascript" src="bgindex.js"></script>
    <title><s:text name="bgindex.title"></s:text></title>
</head>
<body>
    <div id="contain">
	    <div id="menubar">
		    <div class="easyui-panel">
		        &nbsp;&nbsp;&nbsp;&nbsp;
		        <a href="javascript:void()" onclick="goHome()" class="easyui-linkbutton" data-options="plain:true">首页</a>
		        <a href="javascript:void()" class="easyui-menubutton" data-options="menu:'#perm'">权限管理</a>
		        <a href="javascript:void()" class="easyui-menubutton" data-options="menu:'#menu'">菜单管理</a>
		        <a href="javascript:void()" class="easyui-menubutton" data-options="menu:'#aboutus',iconCls:'icon-help'">关于我们</a>
		    </div>
	    </div>
	    <div id="perm" style="width:150px;">
	        <div onclick="userManager()">用户管理</div>
	        <div onclick="groupManager()">用户组管理</div>
	        <div class="menu-sep"></div>
	        <div>角色管理</div>
	    </div>
	    <div id="menu" style="width:100px;">
	        <div>Help</div>
	        <div>Update</div>
	        <div>About</div>
	    </div>
	    <div id="aboutus" class="menu-content" style="background:#f0f0f0;padding:10px;text-align:left">
	        <img src="bgadmin/image/cat.jpg" style="width:150px;height:150px">
	        <p style="font-size:14px;color:#444;">我们要成为IT领跑者</p>
	    </div>
	    <iframe id="content" src="<s:url value='/bgadmin/home.jsp'/>"></iframe>
    </div>
</body>
</html>