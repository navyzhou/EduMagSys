<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>源辰信息-教务管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="copyright" content="All Rights Reserved, Copyright (C) 2018, ycinfo" />
<link rel="shortcut icon" type="image/x-icon" href="../easyui/images/yc.png"/>
<link rel="stylesheet" type="text/css" href="../easyui/css/easyui.css" />
<link rel="stylesheet" type="text/css" href="../easyui/css/wu.css" />
<link rel="stylesheet" type="text/css" href="../easyui/css/icon.css" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<script type="text/javascript" src="../easyui/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="../easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript" src="../js/showpic.js"></script>
<script type="text/javascript" src="../js/websocket.js"></script>
<script type="text/javascript">
$(function(){
	$.get("../back/getLoginAdminId",{},function(data){
		data = parseInt($.trim(data));
		if (data == -1) {
			$.messager.alert('温馨提示','请先登录...','info');
			location.href="../login.html";
		}
		openWebSocket(data);		
	},"text");
})
</script>
</head>
<body class="easyui-layout">
	<!-- begin of header -->
	<div class="wu-header" data-options="region:'north',border:false,split:true">
    	<div class="wu-header-left">
        	<h1>衡阳市源辰信息科技有限公司-教务管理系统</h1>
        </div>
        <div class="wu-header-center">
        	<img src="../images/user.png"  id="adminPhoto"/>
        </div>
        <div class="wu-header-right">
        	<p><strong class="easyui-tooltip">${currentLoginUser.aname }</strong>，欢迎您！</p>
            <p><a href="#">帮助中心</a>|<a href="">安全退出</a></p>
        </div>
    </div>
    <!-- end of header -->
    <!-- begin of sidebar -->
	<div class="wu-sidebar" data-options="region:'west',split:true,border:true,title:'导航菜单'"> 
    	<div class="easyui-accordion" data-options="border:false,fit:true"> 
            <div title="考勤信息" data-options="iconCls:'icon-wrench'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
                    <li iconCls="icon-tick"><a href="javascript:void(0)" data-icon="icon-tick" data-link="page/attendance.html" iframe="0">开始考勤</a></li>
                    <li iconCls="icon-edit"><a href="javascript:void(0)" data-icon="icon-edit" data-link="page/updateatt.html" iframe="0">考勤修改</a></li>
                    <li iconCls="icon-chart-curve"><a href="javascript:void(0)" data-icon="icon-chart-curve" data-link="page/statistics.html" iframe="0">考勤统计</a></li>
                </ul>
            </div>
            
            <div title="学生信息" data-options="iconCls:'icon-user'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
                    <li iconCls="icon-bookmark"><a href="javascript:void(0)" data-icon="icon-bookmark" data-link="page/train.html" iframe="0">课程方向</a></li>
                    <li iconCls="icon-group"><a href="javascript:void(0)" data-icon="icon-group" data-link="page/classinfo.html" iframe="0">班级信息</a></li>
                    <li iconCls="icon-user"><a href="javascript:void(0)" data-icon="icon-user" data-link="page/stu.html" iframe="0">学生信息</a></li>
                </ul>
            </div>
            
            <div title="用户管理" data-options="iconCls:'icon-user-group'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
                    <li iconCls="icon-joystick"><a href="javascript:void(0)" data-icon="icon-joystick" data-link="page/role.html" iframe="0">角色信息</a></li>
                    <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="page/admin.html" iframe="0">管理员信息</a></li>
                </ul>
            </div>
            
            <div title="个人信息" data-options="iconCls:'icon-wrench'" style="padding:5px;">  	
    			<ul class="easyui-tree wu-side-tree">
                    <li iconCls="icon-tick"><a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">修改密码</a></li>
                    <li iconCls="icon-cog"><a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">修改信息</a></li>
                    <li iconCls="icon-cog"><a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">安全退出</a></li>
                </ul>
            </div>
        </div>
    </div>	
    <!-- end of sidebar -->    
    <!-- begin of main -->
    <div class="wu-main" data-options="region:'center'">
        <div id="wu-tabs" class="easyui-tabs" data-options="border:false,fit:true">  
            <div title="首页" data-options="href:'page/welcome.html',closable:false,iconCls:'icon-tip',cls:'pd3'"></div>
        </div>
    </div>
    <!-- end of main --> 
    <!-- begin of footer -->
	<div class="wu-footer" data-options="region:'south',border:true,split:true">
    	<a href="http://www.hyycinfo.com">衡阳市源辰信息科技有限公司 &copy; 版权所有</a>
    </div>
    <!-- end of footer -->  
    
<script type="text/javascript">
$(function(){
	$('.wu-side-tree a').bind("click",function(){
		var title = $(this).text();
		var url = $(this).attr('data-link');
		var iconCls = $(this).attr('data-icon');
		var iframe = $(this).attr('iframe')==1?true:false;
		addTab(title,url,iconCls,iframe);
	});	
});

/**
* Name 选项卡初始化
*/
$('#wu-tabs').tabs({
	tools:[{
		iconCls:'icon-reload',
		border:false,
		handler:function(){
			$('#wu-datagrid').datagrid('reload');
		}
	}]
});
	
/**
* Name 添加菜单选项
* Param title 名称
* Param href 链接
* Param iconCls 图标样式
* Param iframe 链接跳转方式（true为iframe，false为href）
*/
function addTab(title, href, iconCls, iframe){
	var tabPanel = $('#wu-tabs');
	if(!tabPanel.tabs('exists',title)){
		var content = '<iframe scrolling="auto" frameborder="0"  src="'+ href +'" style="width:100%;height:100%;"></iframe>';
		if(iframe){
			tabPanel.tabs('add',{
				title:title,
				content:content,
				iconCls:iconCls,
				fit:true,
				cls:'pd3',
				closable:true
			});
		}
		else{
			tabPanel.tabs('add',{
				title:title,
				href:href,
				iconCls:iconCls,
				fit:true,
				cls:'pd3',
				closable:true
			});
		}
	}
	else
	{
		tabPanel.tabs('select',title);
	}
}

/**
* Name 移除菜单选项
*/
function removeTab(){
	var tabPanel = $('#wu-tabs');
	var tab = tabPanel.tabs('getSelected');
	if (tab){
		var index = tabPanel.tabs('getTabIndex', tab);
		tabPanel.tabs('close', index);
	}
}
</script>
</body>
</html>
