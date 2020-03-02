<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zh">
<head>
<title>智慧校园设备保修系统</title>

<link rel="icon" href="favicon.ico" type="image/ico">

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
								<h4>维修信息</h4>
							</div>
							<div class="card-body">


								<table class="table">
									<thead>
										<tr>
											<th>编号</th>
											<th>设备名称</th>
											<th>故障描述</th>
											<th>地点</th>
											<th>报修人</th>
											<th>报修时间</th>
											<th>状态</th>
                                            <th>指派维修人</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach items="${list}" var="repair">
											<tr>
												<th>${repair.id}</th>
												<th>${repair.equipmentName}</th>
												<th>${repair.content}</th>
												<th>${repair.buildingName}</th>
												<th>${repair.userName}</th>
												<th>${repair.startTime}</th>
												<th>${repair.status==0?'新报修':repair.status==1?'维修中':'已完成'}</th>
												<th>${repair.assignName==null?'未指定':repair.assignName}</th>
												<td><a href="maintainOne?id=${repair.id}"
													class="btn btn-sm btn-info">维修</a></td>
											</tr>

										</c:forEach>

									</tbody>
								</table>
















								<nav class="text-right">
									<ul class="pagination">

										                  <li class="page-item "><a class="page-link" href="maintainIndex?pageNo=1">首页<span class="sr-only">(current)</span></a></li>

										<c:forEach begin="1" end="${page.totalPage}" var="p">
											<c:choose>
												<c:when test="${page.pageNo==p}">
													<li class="page-item active"><a class="page-link"
														href="maintainIndex?pageNo=${p}">${p} <span class="sr-only">(current)</span></a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item "><a class="page-link"
														href="maintainIndex?pageNo=${p}">${p} <span class="sr-only">(current)</span></a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										                  <li class="page-item "><a class="page-link" href="maintainIndex?pageNo=${page.totalPage}">尾页<span class="sr-only">(current)</span></a></li>

									</ul>
								</nav>

							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

		</main>
		<!--End 页面主要内容-->
	</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/dist/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/dist/js/perfect-scrollbar.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/dist/js/main.min.js"></script>
</body>
</html>