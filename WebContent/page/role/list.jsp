<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>智慧校园设备保修系统</title>
<link rel="icon" href="favicon.ico" type="image/ico">
<meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
<meta name="description"
	content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
<meta name="author" content="yinqi">
<link href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/dist/css/materialdesignicons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/dist/css/style.min.css" rel="stylesheet">
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
								<h4>角色管理</h4>
							</div>
							<div class="card-body">

								<a
									href="${pageContext.request.contextPath}/page/role/add.jsp"
									class="btn btn-success btn-w-md">新增角色</a>
								<table class="table">
									<thead>
										<tr>
											<th>角色名称</th>
                                            <th>角色状态</th>
											<th>编辑</th>
											<th>禁用</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach items="${list}" var="role">
						                        <tr>
						                        <td>${role.roleName}</td>
						                        <td>${role.available ==1 ?'正常':'禁用' }</td>
												<th><a href="roleOne?id=${role.id}" class="btn btn-sm btn-info">编辑</a></th>
												<th><a href="#delModal" class="btn btn-sm btn-danger" data-id="${role.id}" data-toggle="modal" >禁用</a></th>
											</tr>

										</c:forEach>

									</tbody>
								</table>



   <!-- 删除的模态框 -->
               <!--删除的 Modal -->
	<div class="modal fade" id="delModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle"></h5>
					<button type="button" class="close" data-dismiss="modal"
						onclick="closeModal()" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<div class="alert alert-danger" role="alert">
						确定要禁用该角色吗？</div>
				</div>
				<div class="modal-footer">
					<a href="" class="btn btn-danger" id="delbtn">确定一定以及肯定</a>
					<button type="button" onclick="closeModal()"
						class="btn btn-success">我再想想</button>

				</div>
			</div>
		</div>
	</div>
					<nav class=" text-right">
									<ul class="pagination">

										                        <li class="page-item "><a class="page-link" href="roleIndex?pageNo=1">首页</a></li>

										<c:forEach begin="1" end="${page.totalPage}" var="p">
											<c:choose>
												<c:when test="${page.pageNo==p}">
													<li class="page-item active"><a class="page-link"
														href="roleIndex?pageNo=${p}">${p} <span
															class="sr-only">(current)</span></a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item "><a class="page-link"
														href="roleIndex?pageNo=${p}">${p} <span
															class="sr-only">(current)</span></a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										                        <li class="page-item "><a class="page-link" href="roleIndex?pageNo=${page.totalPage}">尾页</a></li>


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

	<script type="text/javascript" src="${pageContext.request.contextPath }/dist/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/dist/js/perfect-scrollbar.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/dist/js/main.min.js"></script>

<script type="text/javascript">
 $('#delModal').on('show.bs.modal', function (e) {
	  //通过事件的relatedTarget属性 获取到被点击的按钮 
	  var  bta =$(e.relatedTarget);
	  //获取到我们设置在该元素中的属性  
	  var id=bta.data("id");
	  //将id更新到 模态框中的 a标签中 
	  $("#delbtn").attr("href","roleDel?id="+id);
	})
	function  closeModal(){
	 $('#delModal').modal('hide')
  }
	</script>

</body>
</html>