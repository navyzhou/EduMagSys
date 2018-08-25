<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<script type="text/javascript" src="../js/cropbox.js"></script>
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
        	<c:if test="${not empty currentLoginUser.photo}">
        		<img src = "../../../${currentLoginUser.photo}"  id="adminPhoto" onclick="changeAdminPhoto()"/>
        	</c:if>
        	<c:if test="${empty currentLoginUser.photo}">
        		<img src="../images/user.png"  id="adminPhoto" onclick="changeAdminPhoto()"/>
        	</c:if>
        </div>
        <div class="wu-header-right">
        	<p><strong class="easyui-tooltip">${currentLoginUser.aname }</strong>，欢迎您！</p>
            <p><a href="#">帮助中心</a>|<a href="javascript:admingSignOut()">安全退出</a></p>
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
                    <li iconCls="icon-tick"><a href="javascript:void(0)" data-icon="icon-cog" data-link="page/updatepwd.html" iframe="0">修改密码</a></li>
                    <li iconCls="icon-cog"><a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">修改信息</a></li>
                    <li iconCls="icon-door-out"><a href="javascript:admingSignOut()" data-icon="icon-door-out" iframe="0">安全退出</a></li>
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
<video id="video" autoplay width="400px" height="468px"></video>
<div id="index_showphotoDiv">
	<img src="../images/close.jpg" onclick=" $('#index_showphotoDiv').css('display','none') "/>
	<div class="container">
		<div class="imageBox" id="imageBox">
			<div class="thumbBox"></div>
			<div class="spinner" style="display: none">Loading...</div>
		</div>
		<div class="action">
			<div class="new-contentarea tc">
				<a href="javascript:void(0)" class="upload-img"> <label for="upload-file">本地上传</label> </a> <input type="file" class="" name="upload-file" id="upload-file" />
			</div>
			<input type="button" class="Btnsty_peyton" value="保存" onclick="uploadAdminHead()">
			<input type="button" id="btnCrop" class="Btnsty_peyton" value="裁切">
			<input type="button" id="btnZoomIn" class="Btnsty_peyton" value="+">
			<input type="button" id="btnZoomOut" class="Btnsty_peyton" value="-">
			<input id="snap" type="button" class="Btnsty_peyton" value="拍照"/>
			<input type="button" id="openVideo" class="Btnsty_peyton" value="打开摄像头" style="width:120px">
		</div>
		<div class="cropped"></div>
	</div>
</div>   
    
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

function changeAdminPhoto() { // 修改用户图像
	$("#index_showphotoDiv").css("display","block");
}


var options ={thumbBox : '.thumbBox',spinner : '.spinner',imgSrc : '../images/head.jpg'};
var cropper = $('.imageBox').cropbox(options);
$('#upload-file').on('change', function() {
	var reader = new FileReader();
	reader.onload = function(e) {
		options.imgSrc = e.target.result;
		cropper = $('.imageBox').cropbox(options);
	}
	reader.readAsDataURL(this.files[0]);
	this.files = [];
});

$('#btnCrop').on('click',function() {
	var img = cropper.getDataURL();
	$('.cropped').html('');
	$('.cropped').append('<img id="headinfo1" src="'+img+'" align="absmiddle" style="width:64px;margin-top:4px;border-radius:64px;box-shadow:0px 0px 12px #7E7E7E;" ><p>64px*64px</p>');
	$('.cropped').append('<img id="headinfo2" src="'+img+'" align="absmiddle" style="width:128px;margin-top:4px;border-radius:128px;box-shadow:0px 0px 12px #7E7E7E;"><p>128px*128px</p>');
	$('.cropped').append('<img id="headinfo3" src="'+img+'" align="absmiddle" style="width:180px;margin-top:4px;border-radius:180px;box-shadow:0px 0px 12px #7E7E7E;"><p>180px*180px</p>');
});

$('#btnZoomIn').on('click', function() {
	cropper.zoomIn();
});

$('#btnZoomOut').on('click', function() {
	cropper.zoomOut();
});



var openVideo=document.getElementById("openVideo");//获得一个打开视屏按钮的对象；
//getContext方法创建一个在画布上绘图的环境，它里面的参数指定了你要绘制的图形的类型；
var video=document.getElementById("video");

var canvas = document.createElement("canvas");
var context = canvas.getContext("2d");


openVideo.addEventListener("click",function(){
	$("#video").css("display","block");
	
	// 新版本方法
	if (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
        navigator.mediaDevices.getUserMedia({
            video: true,
            audio: false
        }).then(function(stream) {
            mediaStreamTrack = typeof stream.stop === 'function' ? stream : stream.getTracks()[1];

            video.src = (window.URL || window.webkitURL).createObjectURL(stream);
            video.play();
        })
    }
});

video.addEventListener("canplay", function () {  
    canvas.width = videoWidth =$("#imageBox").width();  
    canvas.height = videoHeight = $("#imageBox").height();  
    context.fillStyle = '#ffffff';  
   	context.fillRect(0, 0, videoWidth, videoWidth);  
    //context.fillRect(0, 0, videoWidth, videoHeight);  
    video.removeEventListener("canplay", arguments.callee);  
 });  

// 点击拍照
document.getElementById("snap").addEventListener("click", function() {
	//context.drawImage(video, 0, 0, 400, 400);
	context.drawImage(video, 0, 0,$("#imageBox").height(), $("#imageBox").width());
	//context.drawImage(video, 0, 0,$("#imageBox").width(), $("#imageBox").height());
	var dataUrl = canvas.toDataURL("image/png");
	$("#imageBox").css("background-image","url("+dataUrl+")");
	options.imgSrc=dataUrl;
	cropper = $('#imageBox').cropbox(options);
	mediaStreamTrack && mediaStreamTrack.stop(); // 关闭摄像头
	$("#video").css("display","none");
});

function uploadAdminHead(){
	var pic = $("#headinfo2").attr("src");
	pic = pic.replace(/^data:image\/(png|jpg);base64,/, "");
	$.post("../back/updateAdminHead", {imageData:pic}, function(data){
		data = $.trim(data);
		if (data == "0") {
			$.messager.alert('温馨提示','请先登录...','error');
			location.href="../login.html";
		} else if (data == "1") {
			$.messager.alert('失败提示','头像上传失败，请稍后重试...','error');
		} else if (data == "2") {
			$.messager.alert('错误提示','头像修改，请稍后重试...','error');
		} else {
			$.messager.show({title:'成功提示',msg:'图像修改成功...',timeout:3000,showType:'slide'});
			$("#adminPhoto").attr("src","../../../"+data);
			$("#index_showphotoDiv").css("display","none");
		}
			
	},"text");
}

function admingSignOut() {
	$.get("../back/admingSignOut", {}, function(data) {
		location.href="../login.html";
	});
}
</script>
</body>
</html>
