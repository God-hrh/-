<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>智慧校园(Light Year Admin)后台管理系统模板</title>
<link rel="icon" href="favicon.ico"
	type="${pageContext.request.contextPath }/dist/image/ico">
<meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
<meta name="description"
	content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
<meta name="author" content="yinqi">
<link
	href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/dist/css/materialdesignicons.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/dist/css/style.min.css"
	rel="stylesheet">
</head>

<body data-theme="translucent" data-logobg="color_8" data-headerbg="color_8" data-sidebarbg="color_3">
	<div class="lyear-layout-web">
		<div class="lyear-layout-container">
			<!--左侧导航-->

			<jsp:include page="/page/left.jsp"></jsp:include>


			<!-- 引入上面的导航栏 -->

			<jsp:include page="/page/nav.jsp"></jsp:include>



			<!--页面主要内容-->
			<main class="lyear-layout-content">

			<div class="container-fluid">

				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
								<h4>修改角色</h4>
							</div>

							
              <form action="/store/roleUpdate" method="post">

				

				  <div class="form-group row">
				  
				   <div class="col-md-2"></div>
				    <label  for="colFormLabelLg" class="col-md-2  col-form-label-lg">角色名称</label>
				    <div class="col-md-4">
				      <input type="hidden"   value="${role.id }" name="id"  >
      <input type="text"   value="${role.roleName }" name="roleName"  class="form-control form-control-lg" id="colFormLabelLg" placeholder="角色名称">
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

						
						</div>
					</div>
				</div>

			</div>
		

		</main>
		
	</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/dist/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/dist/js/perfect-scrollbar.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/dist/js/main.min.js"></script>


</body>
</html>