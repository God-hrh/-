<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" name="viewport">
  <title>角色信息添加</title>

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
            <div>新增用户</div>
          </h1>
          
          <div class="section-body">
            
              
              
              <div >
                
                    
                    <!-- 添加区域的一个表单 -->
                    
              <form action=" " method="post">

				  <div class="form-group row">
				  
				   <div class="col-md-2"></div>
				    <label  for="colFormLabelLg" class="col-md-2  col-form-label-lg">角色名称</label>
				    <div class="col-md-4">
				      <input type="text"  name="buildingName"  class="form-control form-control-lg" id="colFormLabelLg" placeholder="角色名称">
				    </div>
				  </div>
				  
				  
				  
				  
				  
                  
                   <div class="form-group row">
				   <div class="col-md-4"></div>
				   <div class="col-md-8">
				   <button type="submit" class="btn btn-success">确定</button>     
                  </div>
				  </div>
                   
                 
         </form>       
           
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