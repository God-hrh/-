<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>区域展示</title>
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
     <!--左侧导航-->
    <jsp:include page="/page/left.jsp"></jsp:include>
    <!--End 左侧导航-->
    
    <!--头部信息-->
   <jsp:include page="/page/nav.jsp"></jsp:include>
    <!--End 头部信息-->
    
    <!--页面主要内容-->
    <main class="lyear-layout-content">
      
      <div class="container-fluid">
         <div class="card-header">
               <div class="row">
               <div class="col-lg-4">       
       <a href="${pageContext.request.contextPath}/page/building/buildingadd.jsp" 
        class="btn btn-success   btn-w-md">新增区域</a></div>
                  </div>
                  </div>
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-header"></div>
              <div class="card-body">
                
                <h5>区域展示</h5>
                
                 <table class="table">
									<thead>
										<tr>
											<th>id</th>
											<th>区域名称</th>
											<th>编辑</th>
											<th>删除</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach items="${list}" var="building">

											<tr class="active">

												<td>${building.id }</td>
												<td>${building.buildingName }</td>

												<th><a href="buildingOne?id=${building.id}"
													class="btn btn-cyan">编辑</a></th>
												<th><a  href="#delModal" data-toggle="modal" role="button"   data-id="${building.id}" class="btn btn-sm btn-danger">删除</a></th>
											</tr>

										</c:forEach>

									</tbody>
								</table>
    </div>
    </div>
    </div>
    </div>
    </div>
    
    
    
    
    
   
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


    
   <div class="section-body">
            
            
             
           <!-- 页面 -->
                   
                  <div class="card-footer text-right">
                    <nav class="d-inline-block">
                      <ul class="pagination mb-0">
                        <li class="page-item ">
                          <a class="page-link" href="buildingIndex?pageNo=${page.pageNo-1}" tabindex="-1"><i class="ion ion-chevron-left">首页</i></a>
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
                          <a class="page-link" href="buildingIndex?pageNo=${page.pageNo+1}"><i class="ion ion-chevron-right">尾页</i></a>
                        </li>
                      </ul>
                    </nav>
                  </div>
                </div>
            
    
  
    
    
    
<!-- 新增的模态框 -->
<div class="modal fade" id="addModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
        
   <form action="buildingAdd" method="post" id="addForm"> 
  <div class="form-group row">
    <label for="staticEmail" class="col-sm-2 col-form-label">区域名称</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control-plaintext" id="staticEmail"  name="buildingName">
    </div>
  </div>
  
</form>
        
        
        
        
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="saveBuilding()">新增</button>
      </div>
    </div>
  </div>
</div>
    
    
    
    </main>

    <!--End 页面主要内容-->
  


<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/main.min.js"></script>

<!--图表插件-->
<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/Chart.js"></script>
<script type="text/javascript">
 $('#delModal').on('show.bs.modal', function (e) {
	  //通过事件的relatedTarget属性 获取到被点击的按钮 
	  var  bta =$(e.relatedTarget);
	  //获取到我们设置在该元素中的属性  
	  var id=bta.data("id");
	  //将id更新到 模态框中的 a标签中 
	  $("#delbtn").attr("href","buildingDel?id="+id);
	})
	function  closeModal(){
	 
	 
	 $('#delModal').modal('hide')
  }
	</script>
<script type="text/javascript">

</script>
</body>
</html>