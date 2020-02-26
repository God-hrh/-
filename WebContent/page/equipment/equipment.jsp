<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>设备管理</title>
<link rel="icon" href="favicon.ico" type="image/ico">
<meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
<meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
<meta name="author" content="yinqi">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/animate.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/materialdesignicons.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/style.min.css">

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
        
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-header"><h4>设备管理</h4></div>
              <div class="card-body">
              
                <a href="${pageContext.request.contextPath}/page/equipment/addequipment.jsp" class="btn btn-success">新增设备</a>
                <table class="table">
                  <thead>
                    <tr>
                      <th>序号</th>
                      <th>设备编号</th>
                      <th>设备名称</th>
                      <th>设备类型</th>
                      <th>启用时间</th>
                      <th>责任人</th>
                      <th>备注</th>
                      <th>编辑</th>
                      <th>删除</th>
                    </tr>
                  </thead>
                  <tbody>
                 
                  <c:forEach items="${list}" var="equipment">
                  
                    <tr class="active">
                      <th scope="row">${equipment.id } </th>
                      <td>${equipment.equipment_id }</td>
                      <td>${equipment.equipment_name }</td>
                      <td>${equipment.equipment_type }</td>
                      <td>${equipment.createtime }</td>
                      <td>${equipment.responsible_person }</td>
                      <td>${equipment.remark}</td>
                      <th><a href="ToUpdateEquipmentServlet?id=${equipment.id }" class="btn btn-cyan">编辑</a></th>
                      <th><a href="DelEquipmentServlet?id=${equipment.id }" class="btn btn-danger">删除</a></th>
                    </tr>
                    
                    </c:forEach>
                   
                  </tbody>
                </table>
                
                

                <nav>
                  <ul class="pagination mb-0">
                  <li class="page-item "><a class="page-link" href="EquipmentServlet?pageNo=1">首页<span class="sr-only">(current)</span></a></li>
                        <li class="page-item ">
                        <c:if test="${page.pageNo>1}">
                          <a class="page-link" href="EquipmentServlet?pageNo=${page.pageNo-1}" tabindex="-1"><i class="mdi mdi-chevron-left"></i></a>
                        </c:if>
                        </li>
                        <c:forEach begin="1" end="${page.totalPage}" var="p">
                          <c:choose >
                             <c:when test="${page.pageNo==p}">
                             <li class="page-item active"><a class="page-link" href="EquipmentServlet?pageNo=${p}">${p} <span class="sr-only">(current)</span></a></li>
                             </c:when>
                             <c:otherwise>
                             <li class="page-item "><a class="page-link" href="EquipmentServlet?pageNo=${p}">${p} <span class="sr-only">(current)</span></a></li>
                             </c:otherwise>
                          </c:choose>
                        </c:forEach>
                       <li class="page-item">
                       <c:if test="${page.pageNo+1<=page.totalPage}">
                          <a class="page-link" href="EquipmentServlet?pageNo=${page.pageNo+1}"><i class="mdi mdi-chevron-right"></i></a>
                        </c:if>
                        </li>
                        <li class="page-item "><a class="page-link" href="EquipmentServlet?pageNo=${page.totalPage}">尾页<span class="sr-only">(current)</span></a></li>
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


  <script src="${pageContext.request.contextPath}/dist/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/dist/js/perfect-scrollbar.min.js"></script>
  <script src="${pageContext.request.contextPath}/dist/js/main.min.js"></script>
</body>
</html>