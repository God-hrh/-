<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>智慧校园设备保修系统</title>

<link rel="icon" href="favicon.ico"
	type="${pageContext.request.contextPath }/dist/image/ico">

<link
	href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/dist/css/materialdesignicons.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/dist/css/style.min.css"
	rel="stylesheet">
</head>

<body data-theme="translucent" data-logobg="color_8" data-headerbg="color_8" data-sidebarbg="color_3" >
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
								<h4>设备维修</h4>
							</div>


							<div class="card mb-3" style="max-width: 100%;">
								<div class="row no-gutters">
									<div class="col-md-5">
										<img
											src="${pageContext.request.contextPath}/upload/${repair.imgUrl}"
											class="card-img" alt="...">
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


							<form action="${pageContext.request.contextPath}/maintainUpdate" method="post">

								<div class="form-group row">

									<div class="col-md-2"></div>
									<label for="repairContent" class="col-md-2  col-form-label-lg">维修描述</label>
									<div class="col-md-6">
										<input type="hidden" name="id" value="${repair.id }">

										<textarea rows="6" cols="10" name="repairContent"
											class="form-control " id="repairContent"></textarea>

									</div>
								</div>

								<div class="form-group row">

									<div class="col-md-2"></div>
									<label for="assignName" class="col-md-2  col-form-label-lg">维修人</label>
									<div class="col-md-4">
										<input type="text" name="assignName"
											class="form-control form-control-lg disabled" disabled
											id="assignName" value="${repair.assignName}">
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