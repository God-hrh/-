 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>智慧校园设备保修系统</title>
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
  <div class="lyear-layout-container">
  
  <!-- 使用引入语句 ，将导航也页面引入进来 -->
      <jsp:include page="/page/nav.jsp"></jsp:include>
       <!-- 使用引入语句 ，引入左边的导航 -->
      <jsp:include page="/page/left.jsp"></jsp:include>
    
    <!--页面主要内容-->
    <main class="lyear-layout-content">
      
      <div class="main-content">
        <section class="section">
          <h1 class="section-header">
                    维修调度
          </h1>
          
          <div class="section-body">
         
  <div class="card mb-3" style="max-width:100%;">
  <div class="row no-gutters">
    <div class="col-md-5">
      <img src="${pageContext.request.contextPath}/upload/${repair.imgUrl}" class="card-img" >
    </div>
    <div class="col-md-7">
      <div class="card-body">
          <h5 class="card-title">设备名称:${repair.buildingName}</h5>
          <h5 class="card-title">设备位置:${repair.equipmentName}</h5>
          <h5 class="card-title">报修时间:${repair.startTime}</h5>
          <h5 class="card-title">报修人员:${repair.userName}</h5>
          <h5 class="card-title">问题描述:${repair.content}</h5>
      </div>
    </div>
  </div>
</div>


      <!-- 表单 用户提交指定维修人 -->
 <form action="/store/dispatchUpdate" method="post"  >

				  <div class="form-group row">
				  
				   <div class="col-md-2"></div>
				    <label  for="buildingId" class="col-md-2  col-form-label-lg">指派人员</label>
				    <div class="col-md-4">
				    <input type="hidden" name="id" value="${repair.id}"/>
				      <select   name="assignId"  class="form-control form-control-lg" id="buildingId">
				          <c:forEach items="${ulist}" var="user">
				            <option value="${user.id}">${user.userName}</option>
				          </c:forEach>
				      </select>
				    </div>
				  </div>				  

                   <div class="form-group row">
				   <div class="col-md-4"></div>
				   <div class="col-md-8">
				   <button type="submit" class="btn btn-success">确定</button>     
                  </div>
				  </div>
                   
                 
         </form>       

          
           <div >
        </section>
      </div>
        
     
      
    </main>
    <!--End 页面主要内容-->
    
     </div>
  </div>
  
  
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
</body>
</html>