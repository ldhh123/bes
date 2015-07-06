<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录系统</title>
<link href="${pageContext.request.contextPath }/resource/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resource/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resource/css/common.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/resource/js/require.js"></script>
<script src="${pageContext.request.contextPath }/resource/js/app/config.js"></script>
<script src="${pageContext.request.contextPath }/resource/js/lib/jquery-1.11.1.min.js"></script>
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath }/resource/js/lib/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/resource/js/html5shiv.min.js"></script>
<script src="${pageContext.request.contextPath }/resource/js/respond.min.js"></script>
<![endif]-->

</head>
<body>
<div class="container-fluid" style="margin-top:140px;">
    <div class="row">
        <div class="clearfix" style="margin-bottom:5em;">
            <div class="panel panel-default container">
                <div class="panel-body">
                    <c:if test="${not empty loginError}">
                    <div class="alert alert-danger" role="alert"><strong>登陆失败：</strong>${loginError}</div>
                    </c:if>

                    <form action="/login.html" method="post" role="form" onsubmit="return formcheck();">
                        <div class="form-group input-group">
                            <div class="input-group-addon"><i class="fa fa-user"></i></div>
                            <input name="username" type="text" class="form-control input-lg" value="<feinno-security2:principal />" placeholder="请输入用户名登录" autocomplete="off" >
                        </div>
                        <div class="form-group input-group">
                            <div class="input-group-addon"><i class="fa fa-unlock-alt"></i></div>
                            <input name="password" type="password" class="form-control input-lg" placeholder="请输入登录密码" autocomplete="off" >
                        </div>
                        <div class="form-group">
                            <div class="h3">${loginMessage}</div>
                            <label class="checkbox-inline input-lg">
                                <input type="checkbox" value="true" name="rememberMe"> 记住用户名
                            </label>
                            <div class="pull-right">
                                <%-- <a href="" class="btn btn-link btn-lg">注册</a> --%>
                                <input type="submit" name="submit" value="登录" class="btn btn-primary btn-lg">
                                <input name="token" value="7180e133" type="hidden">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="footer">
    <div class="container text-center">
        <%--<a href="#">关于新媒</a>
        <a href="#">点餐帮助</a>--%>
        <p class="copyright">Powered by Feinno.com</p>
    </div>
</footer>
<script>
function formcheck() {
	if($('#remember:checked').length == 1) {
		cookie.set('remember-username', $(':text[name="username"]').val());
	} else {
		cookie.del('remember-username');
	}
	return true;
}
	require(['jquery', 'util'], function($, az){});
</script>
</body>
</html>