<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>设备报修</title>
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
       <!-- 使用引入语句 ，将导航也页面引入进来 -->
      <jsp:include page="/page/nav.jsp"></jsp:include>
       <!-- 使用引入语句 ，引入左边的导航 -->
      <jsp:include page="/page/left.jsp"></jsp:include>
    
    
    <!--页面主要内容-->
    <main class="lyear-layout-content">
      <div class="card-header"><h4>设备报修</h4></div>
              <div class="card-body">
              
              	<!-- 添加区域的一个表单 -->
              	
                  <form action="/store/submit" >
                  
                  <div class="row col-sm-offset-2">
                  <div class="form-group col-sm-5 col-sm-offset-2">
                    <label for="example-nf-email">设备名称</label>
                    
                   <select  name="equipment_name_id"  class="form-control" id="FormControlSelect">
				        <option >请选择设备名称</option>
				        <c:forEach items="${list1}" var="equip">
				         <option  value="${equip.equipment_id}">${equip.equipment_name}+1</option>
				        
				        </c:forEach>
				    </select>       
    	 </div>
       </div>
                  
                  <div class="row col-sm-offset-2">
                  <div class="form-group col-sm-5 col-sm-offset-2">
                    <label for="example-nf-password">设备位置</label>
               <select  name="equipment_building_id"  class="form-control" id="FormControlSelect">
	    
				        <option >请选择设备位置</option>
				        
				        <c:forEach items="${list}" var="build">
				        
				         <option  value="${build.id}">${build.buildingName}</option>
				        
				        </c:forEach>
				    </select>	
    		</div>
                  </div>
                  
                   <div class="row col-sm-offset-2">
                  <div class="form-group col-sm-5 col-sm-offset-2">
                    <label for="example-nf-password">问题描述</label>
                    <input type="textarea" cols="25" rows="5" name="equipment_content"  class="form-control form-control-lg" id="colFormLabelLg" >
       	 </div>
                  </div>
                           
                  	<div class="row col-sm-offset-2">
                  <div class="form-group col-sm-5 col-sm-offset-2">
                    <label for="example-nf-password form-control">故障图片</label>
                  <input type="file" name="equipment_img" id="colFormLabelLg">
       	 </div>
                  </div>
                  
                  
                    <div class="row col-sm-offset-2">
                  <div class="form-group col-sm-5 col-sm-offset-2">
                    <label for="example-nf-password">报修人名</label>
                      <input type="text" name="equipment_user"  value="${user.userName }" class="form-control form-control-lg" id="colFormLabelLg" disabled="disabled">
          </div> 
             	 </div>
             	 
              <div class="row col-sm-offset-5 row">
                  <div class="form-group">
                 <button type="submit" class="btn btn-success" onclick="fun()">提交</button>     
        </div>
                  </div>
                   <script >
				  function fun() {
					alert('提交成功');
				}
				  </script>      
                  </form>
            </div>
            
    </main>
    <!--End 页面主要内容-->
  </div>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
</body>
</html>