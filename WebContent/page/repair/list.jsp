 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>智慧校园设备保修系统</title>


<link href="${pageContext.request.contextPath}/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/dist/css/materialdesignicons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/dist/css/style.min.css" rel="stylesheet">
</head>
  
<body data-theme="translucent" data-logobg="color_8" data-headerbg="color_8" data-sidebarbg="color_3" >
<div class="lyear-layout-web">
  <div class="lyear-layout-container">
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
              <div class="card-header"><h4>维修单管理</h4></div>
              
              
              
              
              
              
              
            <!--   新增模糊查询 -->
              
              <form action="repairs" method="post"  id="f1" class="form-inline" style="margin-left: 25px;">
 
   <input type="hidden" name="pageNo" id="pageNo" />
     <div class="col-auto form-group">
      <label for="equipmentName">设备名称</label>
      <div class="input-group mb-2 ">
       
        <input type="text" name="equipmentName" class="form-control" id="equipmentName" value="${params.equipmentName}" >
      </div>
    </div> 
    <div class="col-auto  form-group">
      <label for="userName">报修人</label>
      <div class="input-group mb-2 ">
        
        <input type="text" class="form-control" value="${params.userName}" name="userName" id="userName" >
      </div>
    </div>
    <div class="col-auto form-group">
     <label for="status">维修状态</label>
      <div class="input-group mb-2">
          <select class="form-control" id="status" name="status">
        <option value="all">全部状态</option>
        <option value="0" ${params.status ==0?'selected':'' }>新报修</option>
        <option value="1" ${params.status ==1?'selected':'' }>维修中</option>
        <option value="2" ${params.status ==2?'selected':'' }>已完成</option>
      </select>
      </div>
    </div>
    <div class="col-auto  form-group">
      <button type="submit" class="btn btn-primary mb-2">查询</button>
      <button type="button" onclick="submitAll()" class="btn btn-primary mb-2">查询所有</button>
   
    </div>

</form>




              <div class="card-body">
                      <table class="table  table-hover">
                        <tr style="color:PaleGodenrod">
                          
                          <th>设备名称</th>
                          <th>故障描述</th>
                          <th>地点</th>
                          <th>报修人</th>
                          <th>报修时间</th>
                          <th>状态</th>
                          <th>维修人</th>
                          <th>操作</th>
                        </tr>
                         <c:forEach items="${list}" var="repair">
                         <!--style="color:${repair.status==0?'white':repair.status==1?'black':'rgb(204,238,208)'}"s  -->
                        <tr  style="color:AliceBlue" >
                       
                          <th>${repair.equipmentName}</th>
                          <th>${repair.content}</th>
                          <th>${repair.buildingName}</th>
                          <th>${repair.userName}</th>
                          <th>${repair.startTime}</th>
                          <th>${repair.status==0?'新报修':repair.status==1?'维修中':'已完成'}</th>
                          <th>${repair.assignName==null?'未指定':repair.assignName}</th>
                          <td><a href="repairOne?id=${repair.id }" class="btn btn-sm btn-info">查看</a></td>
                       </tr>
                        
                        </c:forEach>
                      </table>

<!--  分页-->
     
                    <nav class=" text-right">
                  <ul class="pagination mb-0 ">
                  <li class="page-item "><a class="page-link" href="javascript:submitPage(1)">首页<span class="sr-only">(current)</span></a></li>
                        <li class="page-item ">
                        <%-- <c:if test="${page.pageNo>1}">
                          <a class="page-link" href="repairs?pageNo=${page.pageNo-1}" tabindex="-1"><i class="mdi mdi-chevron-left"></i></a>
                        </c:if> --%>
                        </li>
                        <c:forEach begin="1" end="${page.totalPage}" var="p">
                          <c:choose >
                             <c:when test="${page.pageNo==p}">
                             <li class="page-item active"><a class="page-link" href="javascript:submitPage(${p})">${p} </a></li>
                             </c:when>
                             <c:otherwise>
                             <li class="page-item "><a class="page-link"  href="javascript:submitPage(${p})">${p} <span class="sr-only">(current)</span></a></li>
                             </c:otherwise>
                          </c:choose>
                        </c:forEach>
                       <li class="page-item">
                       <%-- <c:if test="${page.pageNo+1<=page.totalPage}">
                          <a class="page-link" href="repairs?pageNo=${page.pageNo+1}"><i class="mdi mdi-chevron-right"></i></a>
                        </c:if> --%>
                        </li>
                        <li class="page-item "><a class="page-link"  href="javascript:submitPage(${page.totalPage})">尾页</a></li>
                      </ul>
                </nav>
                </div>
              </div>
            </div>
          </div>
        </div>
        
     
      
    </main>
    <!--End 页面主要内容-->
    
     </div>
  </div>
  
  
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/main.min.js"></script>
 <script type="text/javascript">
  
    //模糊查询分页提交的方法 
    function  submitPage(page){
    	$("#pageNo").val(page);
    	$("#f1").submit();
    }
    
    
    function  submitAll(){
    	
    	$("#equipmentName").val("");
    	$("#userName").val("");
    	$("#status").val("all");
    	$("#pageNo").val("1");
    	$("#f1").submit();
    }
  </script>
</body>
</html>