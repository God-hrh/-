<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>新添区域</title>
<link rel="icon" href="favicon.ico" type="image/ico">
<meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
<meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
<meta name="author" content="yinqi">
<link href="${pageContext.request.contextPath}/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/dist/css/materialdesignicons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/dist/css/style.min.css" rel="stylesheet">
</head>
  
<body data-theme="translucent" data-logobg="color_8" data-headerbg="color_8" data-sidebarbg="color_3" >
<div class="lyear-layout-web">
  <div class="lyear-layout-container">
 
    
    <!--左侧导航-->
    <jsp:include page="/page/left.jsp"></jsp:include>
    <!--End 左侧导航-->
    
    <!--头部信息-->
   <jsp:include page="/page/nav.jsp"></jsp:include>
    <!--End 头部信息-->
    <!--页面主要内容-->
    
    
 <main class="lyear-layout-content">
      
      <div class="container-fluid">
        
       
            <div class="card">
              <div class="card-header"><h4>新添区域</h4></div>
              <div class="card-body">
                
                <form action="/store/buildingAdd" method="post" >
                  <div class="form-group">
                    <label for="example-nf-email">区域名称</label>
                    <input class="form-control" type="text" id="colFormLabelLg" name="buildingName" placeholder="区域名称">
                  </div>
            
                  <div class="form-group">
                    <button class="btn btn-primary" type="submit">确定</button>
                  </div>
                </form>
                
              </div>
            </div>
</div>

</main>

<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/main.min.js"></script>

</body>
</html>