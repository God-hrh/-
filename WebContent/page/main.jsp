<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>设备报修管理系统</title>
<link rel="icon" href="favicon.ico" type="image/ico">
<meta name="keywords" content="设备报修">
<meta name="description" content="设备报修">
<meta name="author" content="yinqi">
<link href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/dist/css/materialdesignicons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/dist/css/style.min.css" rel="stylesheet">
</head>
<body>
<div class="lyear-layout-web">
  <div class="lyear-layout-container">

     <!-- 使用引入语句 ，将导航也页面引入进来 -->
      <jsp:include page="/page/nav.jsp"></jsp:include>
       <!-- 使用引入语句 ，引入左边的导航 -->
      <jsp:include page="/page/left.jsp"></jsp:include>
    <!--页面主要内容-->
    <main class="lyear-layout-content">
      <div class="container-fluid">
       <div class="main-content">
        <section class="section">
          <h1 class="section-header">
            <div>区域管理</div>
          </h1>
          <div class="section-body">
              <div >
                <div class="card">
                  <div class="card-header">
                      <a href="${pageContext.request.contextPath}/page/building/buildingadd.jsp"  class="btn btn-success">新增区域</a>
                  </div>
                  <div class="card-body p-0">
                    <div class="table-responsive">
                      <table class="table table-striped">
                        <tr>
                          <th>id</th>
                          <th>区域名称</th>
                          <th>操作</th>
                        </tr>
                         <c:forEach items="${list}" var="building">
                        <tr>
                          <td>${building.id }</td>
                          <td>${building.buildingName}</td>
                          <td><a href="buildingOne?id=${building.id}" class="btn btn-sm btn-info">编辑</a><a  href="buildingDel?id=${building.id}" class="btn btn-sm btn-danger">删除</a></td>
                       </tr>
                        </c:forEach>
                      </table>
                    </div>
                  </div>
                  <div class="card-footer text-right">
                    <nav class="d-inline-block">
                      <ul class="pagination mb-0">
                        <li class="page-item ">
                          <a class="page-link" href="buildingIndex?pageNo=${page.pageNo-1}" tabindex="-1"><i class="ion ion-chevron-left"></i></a>
                        </li>
                        <c:forEach begin="1" end="${page.totalPage}" var="p">
                          <c:choose >
                             <c:when test="${page.pageNo==p}">
                             <li class="page-item active"><a class="page-link" href="buildingIndex?pageNo=${p}">${p} <span class="sr-only">(current)</span></a></li>
                             </c:when>
                             <c:otherwise>
                             <li class="page-item "><a class="page-link" href="buildingIndex?pageNo=${p}">${p} <span class="sr-only">(current)</span></a></li>
                             </c:otherwise>
                          </c:choose>
                        </c:forEach>
                       <li class="page-item">
                          <a class="page-link" href="buildingIndex?pageNo=${page.pageNo+1}"><i class="ion ion-chevron-right"></i></a>
                        </li>
                      </ul>
                    </nav>
                  </div>
                </div>
              </div>
           </div>
        </section>
      </div>
      </div>
      
    </main>
    <!--End 页面主要内容-->
  </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath }/page/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/page/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/page/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/page/js/main.min.js"></script>

<!--图表插件-->
<script type="text/javascript" src="${pageContext.request.contextPath }/page/js/Chart.js"></script>
</body>
</html>