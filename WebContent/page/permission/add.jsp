<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" name="viewport">
  <title>角色信息添加</title>

  <link href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/dist/css/materialdesignicons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/dist/css/style.min.css" rel="stylesheet">
  
  

  
</head>

<body data-theme="translucent" data-logobg="color_8" data-headerbg="color_8" data-sidebarbg="color_3" >
  <div id="app">
    <div class="main-wrapper">
      <div class="navbar-bg"></div>
     
  
     
     
           <!-- 使用引入语句 ，将导航也页面引入进来 -->
      <jsp:include page="/page/nav.jsp"></jsp:include>
       <!-- 使用引入语句 ，引入左边的导航 -->
      <jsp:include page="/page/left.jsp"></jsp:include>
    

     
    
    <main class="lyear-layout-content">
      <div class="card-header"><h4>权限管理</h4></div>
              <div class="card-body">
                
              <form action="/store/PerAddServlet " method="post">

				  <div class="form-group row">
				   <div class="col-md-2"></div>
				    <label  for="colFormLabelLg" class="col-md-2  col-form-label-lg">权限名称</label>
				    <div class="col-md-4">
				      <input type="text"  name="permission_name"  class="form-control form-control-lg" id="colFormLabelLg" placeholder="权限名称">
				    </div>
				   </div>
				   
				   <div class="form-group row">
				     <div class="col-md-2"></div>
				    <label  for="colFormLabelLg" class="col-md-2  col-form-label-lg">权限类型</label>
				    <div class="col-md-4">
				      <input type="text"  name="permission_type"  class="form-control form-control-lg" id="colFormLabelLg" placeholder="权限类型">
				    </div>
				    </div>
				    
				   <div class="form-group row">
				     <div class="col-md-2"></div>
				    <label  for="colFormLabelLg" class="col-md-2  col-form-label-lg">菜单地址</label>
				    <div class="col-md-4">
				      <input type="text"  name="permission_url"  class="form-control form-control-lg" id="colFormLabelLg" placeholder="菜单地址">
				    </div>
				    </div>
				    
				    
				    <div class="form-group row">
				     <div class="col-md-2"></div>
				    <label  for="colFormLabelLg" class="col-md-2  col-form-label-lg">菜单排序</label>
				    <div class="col-md-4">
				      <input type="text"  name="permission_sort"  class="form-control form-control-lg" id="colFormLabelLg" placeholder="菜单排序">
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
    </main>
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
      
  
        </section>
      </div>
      
    </div>
  </div>










<script type="text/javascript" src="${pageContext.request.contextPath }/dist/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/dist/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/dist/js/main.min.js"></script>

  
  
</body>
</html>