<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>登录</title>
 <link rel="icon" href="https://im.qq.com/favicon.ico">
 <link rel="stylesheet" href="${pageContext.request.contextPath }/dist/css/index.css" />
 <script type="text/javascript" src="${pageContext.request.contextPath }/dist/js/jquery.min.js"></script>
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
			<img class="smallImg" onclick="gd()" src="${pageContext.request.contextPath }/dist/images/icon-5.png" />
			<input placeholder="请输入验证码" type="text" id="Captcha" name = "captcha" onblur="checkCaptcha()"  style="width: 232px;"/>
			
		</div>
		<div>
    		<a href="" ><img class="capImg" src="${pageContext.request.contextPath }/img.jpg"></a> 
    	</div>
		
		</div>
		<div id="tip">
			</div>
		<button type="submit" class="logBut" id = "btn">登&nbsp;&nbsp;录</button>
				
		 <%= request.getAttribute("msg")!=null?request.getAttribute("msg"):"" %>  
		
		
		 
	</div>
</div>
</form>

<script type="text/javascript">
 /* function checkCaptcha(){  
	//创建异步对象
		var xmlhttp = new XMLHttpRequest();
		 //获取发送路径、参数、是否异步
		 var imgcode = document.getElementById("Captcha").value;
		 xmlhttp.open("get","checkcaptcha?Captcha="+imgcode,true);
		 //开始发送
		 xmlhttp.send();
		 //获取到服务器响应的状态
		 xmlhttp.onreadystatechange = function(){
			
				 if(xmlhttp.readyState ===4 && xmlhttp.status === 200){ 
				  if(xmlhttp.responseText=="true"){
					 document.getElementById("tip").innerHTML = "验证码正确";
				 }else{
					 document.getElementById("tip").innerHTML = "验证码错误！";
				 } 
			 } 
		  }  
	} */
	/* function checkCaptcha(){
	$.ajax({
		type:"post",
		url:"/store/checkcaptcha",
		data:{Captcha:$("#Captcha").val()},//放参数
		success:function(rs){ //回调函数里面写自己的方法
			if(rs==="true"){
				 $("#tip").html("验证码正确");
				 $("#btn").attr("type","submit");
			}else{
				$("#tip").html("验证码错误！") ;
			}
		}
	});
	} */
	function gd() {
		$("#img").attr("src","kaptcha/kaptcha?a="+new Date().getTime());
	}
	
	/* function checkCaptcha(){
		$.get("/store/checkcaptcha",{Captcha:$('#Captcha').val()},function(rs){
			if(rs==="true"){
				 $("#tip").html("验证码正确");
				 $("#btn").attr("type","submit");
			}else{
				$("#tip").html("验证码错误！") ;
			}
		});
	} */

</script>

</body>
</html>