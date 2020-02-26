<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" name="viewport">
  <title>角色信息</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/modules/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/modules/ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/modules/fontawesome/web-fonts-with-css/css/fontawesome-all.min.css">

  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/demo.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/style.css">
</head>

<body data-theme="translucent" data-logobg="color_8" data-headerbg="color_8" data-sidebarbg="color_3" >
  <div id="app">
    <div class="main-wrapper">
      <div class="navbar-bg"></div>
     
      <!-- 使用引入语句 ，将导航也页面引入进来 -->
      <jsp:include page="/page/nav.jsp"></jsp:include>
       <!-- 使用引入语句 ，引入左边的导航 -->
      <jsp:include page="/page/left.jsp"></jsp:include>
    
      <div class="main-content">
        <section class="section">
          <h1 class="section-header">
            <div>角色管理</div>
          </h1>
          <div class="section-body">
              <div >
                <div class="card">
                  <div class="card-header">
                      
                      <a href="${pageContext.request.contextPath}/page/role/add.jsp"  class="btn btn-success">新增角色</a>
                  </div>
                  <div class="card-body p-0">
                    <div class="table-responsive">
                      <table class="table table-striped">
                        <tr>
                         
                          <th>角色名称</th>
                          <th>角色状态</th>
                          <th>操作</th>
                        </tr>
                         <c:forEach items="${list}" var="role">
                        <tr>
                         <td>${role.roleName}</td>
                          <td>${role.available ==1 ?'正常':'禁用' }</td>
                          <td><a href="roleOne?id=${role.id}" class="btn btn-sm btn-info">编辑</a><a  href="" class="btn btn-sm btn-danger">删除</a></td>
                       </tr>
                        
                        </c:forEach>
                      </table>
                    </div>
                  </div>
                  <div class="card-footer text-right">
                    <nav class="d-inline-block">
                      <ul class="pagination mb-0">
                        <li class="page-item ">
                          <a class="page-link" href="userIndex?pageNo=${page.pageNo-1}" tabindex="-1"><i class="ion ion-chevron-left"></i></a>
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
                          <a class="page-link" href="userIndex?pageNo=${page.pageNo+1}"><i class="ion ion-chevron-right"></i></a>
                        </li>
                      </ul>
                    </nav>
                  </div>
                </div>
              </div>
           </div>
        </section>
      </div>
      <footer class="main-footer">
        <div class="footer-left">
          Copyright &copy; 2020 <div class="bullet"></div> by fujun 
        </div>
        <div class="footer-right"></div>
      </footer>
    </div>
    
    

    
    
    
    
    
  </div>











  <script src="${pageContext.request.contextPath}/dist/modules/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/dist/modules/popper.js"></script>
  <script src="${pageContext.request.contextPath}/dist/modules/tooltip.js"></script>
  <script src="${pageContext.request.contextPath}/dist/modules/bootstrap/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/dist/modules/nicescroll/jquery.nicescroll.min.js"></script>
  <script src="${pageContext.request.contextPath}/dist/modules/scroll-up-bar/dist/scroll-up-bar.min.js"></script>
  <script src="${pageContext.request.contextPath}/dist/js/sa-functions.js"></script>
  <script src="${pageContext.request.contextPath}/dist/js/scripts.js"></script>
  <script src="${pageContext.request.contextPath}/dist/js/custom.js"></script>
  <script src="${pageContext.request.contextPath}/dist/js/demo.js"></script>
</body>
</html>