$(document).ready(function() {
    $.extend($.fn.validatebox.defaults.rules, {
        equals: {
            validator: function(value,param){
                return value == $(param[0]).val();
            },
            message: 'Field do not match.'
        }
    });
    $('#dg').datagrid({
        title : '组列表',
        url : 'group!selectAjaxList.do',
        method : 'POST',
        nowrap : true,
        striped : true,
        singleSelect : true,
        rownumbers : true,
        pagination : true,
        showFooter : true,
        idfield : 'id',
        pageSize:10,
        pageList:[5,10,20,30,40,50],
        queryParams : {},
        columns : [ [ {
            field : 'id',
            title : '标识',
            width : 80,
            align : 'center',
            hidden : true
        }, {
            field : 'name',
            title : '组名',
            width : 150,
            align : 'left'
        }, {
            field : 'desc',
            title : '组描述',
            width : 150,
            align : 'left'
        } ] ],
        onBeforeLoad : function(param) {
        },
        onLoadSuccess : function(data) {
        },
        onLoadError : function() {

        },
        onDblClickRow : function() {
                getInfo();
        },
        loadFilter : function(data) {
            return JSON.parse(data);
        },
        toolbar : [
            {
                text : '增加',
                iconCls : 'icon-add',
                handler : function() {
                    $('#ff').form('clear');
                    $('#dd').panel('open');
                }
            },
            '-',
            {
                text : '修改',
                iconCls : 'icon-edit',
                handler : function() {
                    getInfo();
                }
            },
            '-',
            {
                text : '删除',
                iconCls : 'icon-remove',
                handler : function() {
                    del();
                }
            },
            '-',
            {
                text: "名称:<input type='text' id='keyword' />"
            },
            '-',
            {
                text : "搜索",
                iconCls : 'icon-search',
                handler : function() {
                    var keyword = $("#keyword").val();
                    reloadgrid(keyword);
                }
            }
        ],
        AllowPaging : true
    });
});

function reloadgrid(keyword) {
    var queryParams = $('#dg').datagrid('options').queryParams;
    queryParams.param = keyword;
    $('#dg').datagrid('options').queryParams = queryParams;
    $("#dg").datagrid('reload');
}
// 搜索功能
function searchData() {
    var keyword = $("#keyword").val();
    reloadgrid(keyword);
}

function cancel(){
    $('#dd').panel('close');
}

function save(){
	if ($('#id').val() == '') {
	    $('#ff').form('submit', {
	        url:"group!insert.action",
	        success: function(data){
	            data = JSON.parse(data);
	            data = JSON.parse(data);
	            if (data.result=="1"){
	                $("#dg").datagrid('reload');
	                $('#dd').panel('close');
	            }
	        }
	    });
	} else {
	    $('#ff').form('submit', {
	        url:"group!update.action",
	        success: function(data){
	            data = JSON.parse(data);
	            data = JSON.parse(data);
	            if (data.result=="1"){
	                $("#dg").datagrid('reload');
	                $('#dd').panel('close');
	            }
	        }
	    });
	}
}

function del(){
    var selected = $('#dg').datagrid('getSelected');
    if (selected) {
        var data = "{\"groupInfo.id\":\""+selected.id+"\"}";
        data = JSON.parse(data);
        $.ajax({ 
            type: "post",
            url: "group!delete.do",
            dataType: "json",
            data : data,
            success: function (data) {
                data = JSON.parse(data);
                if (data.result=="1"){
                    $("#dg").datagrid('reload');
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("删除失败");
            }
        });
    }
}

function getInfo(){
    var selected = $('#dg').datagrid('getSelected');
    if (selected) {
        var data = "{\"groupInfo.id\":\""+selected.id+"\"}";
        data = JSON.parse(data);
        $.ajax({
            type: "post",
            url: "group!selectUser.do",
            dataType: "json",
            data : data,
            success: function (data) {
                $('#ff').form('clear');
                data = JSON.parse(data);
                $('#id').val(data.id);
                $('#name').val(data.name);
                $('#desc').val(data.desc);
                $('#ff').form('validate');
                $('#dd').panel('open');
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("获取失败");
            }
        });
    }
}

function resize() {
    $('#dg').datagrid('resize', {
        width : 700,
        height : 400
    });
}

function clearSelections() {
    $('#dg').datagrid('clearSelections');
}
