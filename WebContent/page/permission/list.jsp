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
<body data-theme="translucent" data-logobg="color_8" data-headerbg="color_8" data-sidebarbg="color_3" :>
<div class="lyear-layout-web">
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
              <div class="card-header"><h4>权限管理</h4></div>
              <div class="card-body">
              
                <a href="${pageContext.request.contextPath}/page/permission/add.jsp"  class="btn btn-success">新增权限</a>
                      <table class="table table-striped">
                        <tr>
                         <th>权限id</th>
                          <th>权限名称</th>
                          <th>权限类型</th>
                          <th>权限地址</th>
                          <th>权限图标</th>
                          <th>权限排序</th>
                          <th>操作</th>
                        </tr>
                         <c:forEach items="${list}" var="permission">
                        <tr>
                         <td>${permission.id}</td>
                          <td>${permission.name }</td>
                            <td>${permission.type}</td>
                          <td>${permission.url}</td>
                           <td>${permission.percode}</td>
                          <td>${permission.sortstring}</td>
<td><a href="${pageContext.request.contextPath}/ToUpdateServlet?id=${permission.id}" class="btn btn-sm btn-info">编辑</a>
<a  href="#delModal" class="btn btn-sm btn-danger" data-id="${permission.id}" data-toggle="modal" >删除</a></td>                       </tr>
                        </c:forEach>
                      </table>
                
                
                
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
						你真的确定以及肯定删除该条记录吗？</div>
				</div>
				<div class="modal-footer">
					<a href="" class="btn btn-danger" id="delbtn">残忍删除</a>
					<button type="button" onclick="closeModal()"
						class="btn btn-success">我再考虑一下</button>

				</div>
			</div>
		</div>
	</div>

                <div class="card-footer text-right">
                    <nav class="d-inline-block">
                      <ul class="pagination mb-0">
                        <li class="page-item ">
                          <a class="page-link" href="perIndex?pageNo=${page.pageNo-1}" tabindex="-1"><i class="ion ion-chevron-left">首页</i></a>
                        </li>
                        <c:forEach begin="1" end="${page.totalPage}" var="p">
                          <c:choose >
                             <c:when test="${page.pageNo==p}">
                             <li class="page-item active"><a class="page-link" href="perIndex?pageNo=${p}">${p} <span class="sr-only">(current)</span></a></li>
                             </c:when>
                             <c:otherwise>
                             <li class="page-item "><a class="page-link" href="perIndex?pageNo=${p}">${p} <span class="sr-only">(current)</span></a></li>
                             </c:otherwise>
                          </c:choose>
                        </c:forEach>
                       <li class="page-item">
                          <a class="page-link" href="perIndex?pageNo=${page.pageNo+1}"><i class="ion ion-chevron-right">尾页</i></a>
                        </li>
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
	  $("#delbtn").attr("href","PerDelServlet?id="+id);
	})
	function  closeModal(){
	 
	 
	 $('#delModal').modal('hide')
  }
	</script>


</body>
</html>