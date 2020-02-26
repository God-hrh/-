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
      
      <div class="container-fluid">
        
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-header"><h4>用户管理</h4></div>
                <div class="col-lg-12">  
                      <a href="${pageContext.request.contextPath}/page/user/add.jsp"  class="btn btn-success" >新增用户</a>
                  </div>
              <div class="card-body">
                 <table class="table ">
                  <thead>
                        <tr>
                          <th>用户编号</th>
                          <th>用户名称</th>
                          <th>用户状态</th>
                          <th>操作</th>
                        </tr>
                   </thead>
                    <tbody>
                         <c:forEach items="${list}" var="user">
                        <tr  class="active">
                           <th scope="row">${user.userCode }</th>
                          <td>${user.userName}</td>
                          <td>${user.locked ==0 ?'正常':'账号被锁定' }</td>
                          <td><a href="userOne?id=${user.id}" class="btn btn-sm btn-info">编辑</a>
                          
                   <a  href="UserDel?id=${user.id}" class="btn btn-sm btn-danger">
                          	删除</a></td>
                         
                       </tr>
                        </c:forEach>
                        
                            </tbody>
                      </table>            

<!--  分页-->
     
                    <nav>
                  <ul class="pagination mb-0">
                  <li class="page-item "><a class="page-link" href="userIndex?pageNo=1">首页<span class="sr-only">(current)</span></a></li>
                        <li class="page-item ">
                        <c:if test="${page.pageNo>1}">
                          <a class="page-link" href="userIndex?pageNo=${page.pageNo-1}" tabindex="-1"><i class="mdi mdi-chevron-left"></i></a>
                        </c:if>
                        </li>
                        <c:forEach begin="1" end="${page.totalPage}" var="p">
                          <c:choose >
                             <c:when test="${page.pageNo==p}">
                             <li class="page-item active"><a class="page-link" href="userIndex?pageNo=${p}">${p} <span class="sr-only">(current)</span></a></li>
                             </c:when>
                             <c:otherwise>
                             <li class="page-item "><a class="page-link" href="userIndex?pageNo=${p}">${p} <span class="sr-only">(current)</span></a></li>
                             </c:otherwise>
                          </c:choose>
                        </c:forEach>
                       <li class="page-item">
                       <c:if test="${page.pageNo+1<=page.totalPage}">
                          <a class="page-link" href="userIndex?pageNo=${page.pageNo+1}"><i class="mdi mdi-chevron-right"></i></a>
                        </c:if>
                        </li>
                        <li class="page-item "><a class="page-link" href="userIndex?pageNo=${page.totalPage}">尾页<span class="sr-only">(current)</span></a></li>
                      </ul>
                </nav>
             
                </div>
               
              </div>
            </div>
          </div>
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