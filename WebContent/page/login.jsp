<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>登录</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/dist/css/index.css" />
</head>

<body>

<form action="${pageContext.request.contextPath }/loginservlet" method="post">
<div class="content">
	<div class="login">
		<div class="title">设备报修系统&nbsp;·&nbsp;登录</div>
		<div class="line">
			<img class="smallImg" src="${pageContext.request.contextPath }/dist/images/icon-4.png" />
			<input placeholder="请输入账号" type="text" name="usercode" />
		</div>
		<div class="line">
			<img class="smallImg" src="${pageContext.request.contextPath }/dist/images/icon-5.png" />
			<input placeholder="请输入密码" type="password" name = "userpsw"/>
		</div>
		<div class="captchadiv">
		<div class="line captcha">
			<img class="smallImg" src="${pageContext.request.contextPath }/dist/images/icon-5.png" />
			<input placeholder="请输入验证码" type="password"  name = "captcha"/>
		</div>
		<div>
    		<img class="capImg" alt="" src="${pageContext.request.contextPath }/img.jpg">
    	</div>
		
		</div>
	
		<button type="submit" class="logBut">登&nbsp;&nbsp;录</button>
				
		<%= request.getAttribute("msg")!=null?request.getAttribute("msg"):"" %>
		
		
		 
	</div>
</div>
</form>

</body>
</html>