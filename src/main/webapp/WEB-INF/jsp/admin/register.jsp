<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>账号管理-添加</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.8.1.min.js"></script>
</head>
<body>
<div class="topall">
  <div class="view_size">
    <div class="logo"></div>
<!--     <div class="link"><a href="login.html">登录</a> | <a href="register.html">注册</a></div> -->
  </div>
</div>
<div class="opt_cont">
  <div class="form_box">
    <div class="register_box">
      <form id="userform" method="post" action="/bs/registeradd.html">
      <div>${errmsg }</div>
        <div class="input_box">
          <label><strong>*</strong>账号：</label>
          <input name="username" type="text" />
          <div class="alt_box" id="msg_username">账号不能为空！</div>
        </div>
        <div class="input_box">
          <label><strong>*</strong>密码：</label>
          <input name="password" type="password" />
          <div class="alt_box" id="msg_password">密码不能为空！</div>
        </div>
        <div class="input_box">
          <label><strong>*</strong>确认密码：</label>
          <input name="password2" type="password" />
          <div class="alt_box" id="msg_password2">请确认密码！</div>
        </div>
          <div class="input_box">
          <label><strong>*</strong>类型：</label>
          <input name="type" type="radio" value="3" checked="checked" />业主
          <input name="type" type="radio" value="4" />个人
        </div>
        <div class="input_box">
          <label>说明：</label>
          <textarea name="note" cols="40"></textarea>
          <div class="alt_box" id="msg_note"></div>
        </div>
        <div class="button_box">
          <input type="submit" value="提交" />
        </div>
      </form>
    </div>
  </div>
</div>
<script type="text/javascript">
$(function(){
	$(".alt_box").css("display","none");

	$("#userform").submit(function(){
		$(".alt_box").css("display","none");
		var username = $("[name='username']").val();
		if($.trim(username)==""){
			$("#msg_username").css("display","block");
			$("[name='username']").select();
			return false;
		}

		var myReg = /[\u4e00-\u9fa5]/;
		var length = 20;
		if(myReg.test(username)){
			length = 10;
		}
		if($.trim(username).length<4 || $.trim(username).length > length){
			$("#msg_username").text("账号名长度必须为4到20个字符之间！");
			$("#msg_username").css("display","block");
			$("[name='username']").select();
			return false;
		}
		
		var password = $("[name='password']").val();
		if($.trim(password)==""){
			$("#msg_password").css("display","block");
			$("[name='password']").select();
			return false;
		}
		
		var password2 = $("[name='password2']").val();
		if($.trim(password2)==""){
			$("#msg_password2").css("display","block");
			$("[name='password2']").select();
			return false;
		}
		
		if(password != password2){
			$("#msg_password").text("两次密码输入不一致！");
			$("#msg_password").css("display","block");
			$("[name='password']").select();
			return false;
		}
		
		var note = $("[name='note']").val();
		length = 30;
		if(myReg.test(note)){
			length = 15;
		}
		if($.trim(note).length > length){
			$("#msg_note").text("说明内容超出"+length+"个字符！");
			$("#msg_note").css("display","block");
			$("[name='note']").select();
			return false;
		}
		
		//$("input[type='submit']").attr("disabled","disabled");
		
		//$("#userform").attr("action","register.html");
		return true;
	});
	
});
</script>
</body>
</html>
