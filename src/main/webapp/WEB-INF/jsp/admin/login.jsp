<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>LOGIN</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="../js/artDialog4.1.6/jquery.artDialog.js?skin=default"></script>
</head>
<body>
<div class="topall">
  <div class="view_size">
    <div class="logo"></div>
    <div class="link"><a href="/bs/login.html">登录</a> | <a href="/bs/register.html">注册</a></div>
  </div>
</div>
<div class="view_size content">
  <div class="login_img"></div>
  <div class="login_box">
    <div class="chkcard"><a class="active" href="#">业主登录</a> <a href="#">用户登录</a></div>
    <form id="loginform" method="post" action="/bs/flogin.html">
      <div class="div_username">
        <input name="username" type="text" placeholder="账号" />
      </div>
      <div class="msg_div" id="msg_username">用户名错误！</div>
      <div class="div_username div_password">
        <input name="password" type="password" placeholder="密码" />
      </div>
      <div class="msg_div" id="msg_password">密码错误！</div>
      <div class="div_username div_vcode">
        <input name="vcode" type="text" class="vcode" size="6" placeholder="验证码" />
      </div>
      <div class="div_mark"><img
					id="jcaptchaImage" onclick="refreshCaptcha()"
					src="${pageContext.request.contextPath}/jcaptcha.jpg"
					class="ui-checkcode-imgcode-img" align="absMiddle" alt="请输入您看到的内容"
					src="/bs/captcha" title="点击刷新图片校验码"> <a href="javascript:;"
					onclick="refreshCaptcha()" id="change-valicoad">刷新</a></div>
      <div class="overflow"></div>
      <div class="msg_div" id="msg_vcode">验证码错误！</div>
      <div class="div_submit">
        <input type="submit" value="登录" />
      </div>
    </form>
  </div>
</div>
<div class="overflow"></div>
<div class="copyright">
  <div><a href="#">关于我们</a> | <a href="#">业务介绍</a> | <a href="#">帮助中心</a></div>
  <div>&copy; Copyright 2015 beiersi.com 贝尔斯酒店管理有限公司  版权所有</div>
  <div>渝ICP证120277号</div>
</div>
<script type="text/javascript">
$(function(){
	mesbox();
	function mesbox(){
		//1:账号不存在，2:密码错误，3:验证码错误，4:被锁定
		var status = 2;
		var msg = "";
		var objName = "";
		switch (status) {
		case (1):
			msg = "帐号不存在";
			objName = "[name='username']";
			break;
		case (2):
			msg = "密码错误";
			objName = "[name='password']";
			break;
		case (3):
			msg = "验证码错误";
			break;
		default:
		}
		art.dialog({
			//title: "标题",
			content: msg,
			ok: function(){$(objName).select();},
			lock: true
		});
	}
	
	$(".msg_div").css("display","none");
	$("#loginform").submit(function(){
		var username = $("[name='username']").val();
		if($.trim(username)==""){
			$("#msg_username").css("display","block");
			$("[name='username']").select();
			return false;
		}
		$(".msg_div").css("display","none");
		$("#loginform").attr("action","main.html");
		return true;
	});
});
</script>
</body>
</html>
