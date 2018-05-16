<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<link rel="icon" href="images/favicon.ico" type="image/ico" />
    <title>用户后台管理</title>
	<link rel="icon" href="images/favicon.ico" type="image/ico" />
    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <!-- bootstrap-select -->
	<link href="https://cdn.bootcss.com/bootstrap-select/1.12.4/css/bootstrap-select.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<!-- left nav bar -->
				<jsp:include page="left.jsp"></jsp:include>
			</div>
			<!-- top nav bar -->
			<jsp:include page="top-nav.jsp"></jsp:include>


			<!-- page content -->
			<div class="right_col" role="main">	
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>
									课程列表
								</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li><a class="collapse-link"><i
											class="fa fa-chevron-up"></i></a></li>
									<li class="dropdown"><a href="#" class="dropdown-toggle"
										data-toggle="dropdown" role="button" aria-expanded="false"><i
											class="fa fa-wrench"></i></a>
										<ul class="dropdown-menu" role="menu">
											<li><a href="#">Settings 1</a></li>
											<li><a href="#">Settings 2</a></li>
										</ul></li>
									<li><a class="close-link"><i class="fa fa-close"></i></a>
									</li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<table id="enrollList" class="table table-striped">
									<thead>
										<tr>
											<th>#</th>
											<th>课程编号</th>
											<th>课程名称</th>
											<th>课程信息</th>
											<th>课程类型</th>
											<th>价格</th>
											<th>开课时间</th>
											<th>结课时间</th>
											<th>报名人数</th>
											<th>报名截止时间</th>
											<th>报名</th>
										</tr>
									</thead>
									<tbody>
									
									<!-- ajax -->
										
									</tbody>
								</table>
								<div  class="btn-toolbar pull-right">
				                        <div class="btn-group" id="btnGroup">
				                        	<!-- page load -->
				                        </div>
			                    </div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->
			
			
			<!-- footer -->
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
	
	
	<!-- jQuery -->
    <script src="../vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../vendors/moment/min/moment.min.js"></script>
    <script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
 	<script src="../vendors/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
 	<script src="../vendors/bootstrap-datetimepicker/build/js/bootstrap-datepicker.js"></script>
 	<!-- bootstrap-select -->
 	<script src="../vendors/bootstrap-select/bootstrap-select.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    <script src="../build/js/common.js"></script>
    
    <script type="text/javascript">
    	$(getEnrollList(1));
    	
    	function getEnrollList(currentPage){
    		$.ajax({
    			url:"enrollCourseList.action",
    			type:"post",
    			data:{
    				"pageContainer.currentPageNo":currentPage
    			},
    			dataType:"json",
    			success: function(responseText){
    				var json = JSON.parse(responseText);
    				var tbody = $("#enrollList tbody");
    				tbody.html("");
    				$("#btnGroup").html("");
    				//创建表格
    				for(var i = 0; i < json.list.length; i++){
    					var courseRecord = json.list[i];
    					var courseNo = $("<td></td>").html(i);
   						var courseId =$("<td></td>").html(courseRecord.course.courseId);
   						var courseName = $("<td></td>").html(courseRecord.course.courseName);
           				var info = $("<td></td>").html(courseRecord.course.info);
           				var types = $("<td></td>").html(courseRecord.course.types);
           				var price = $("<td></td>").html(courseRecord.course.price);
       					var startTime = $("<td></td>").html(JsonDateToString(courseRecord.startTime));
           				var endTime = $("<td></td>").html(JsonDateToString(courseRecord.endTime));
           				var signCount = $("<td></td>").html(courseRecord.signCount);
           				var closeTime = $("<td></td>").html(JsonDateToString(courseRecord.closeTime));
           				var tdTemp = $("<td><td>");
           				var submit = $("<button class='register btn btn-primary btn-block' courseRecordId=" + courseRecord.courseRecordId +"></button>");
           				submit.addClass("btn btn-primary btn-block");
           				submit.html("报名");
           				
           				
           				tdTemp.append(submit);
           				
           				var tr = $("<tr></tr>");
           				tr.append(courseNo);
           				tr.append(courseId);
           				tr.append(courseName);
           				tr.append(info);
           				tr.append(types);
           				tr.append(price);
           				tr.append(startTime);
           				tr.append(endTime);
           				tr.append(signCount);
           				tr.append(closeTime);
           				tr.append(submit);
           				tbody.append(tr);
           				
    				}
    					//创建按钮组
    					var btnGroup = $("#btnGroup");
    					var currentPageNo = json.currentPageNo;
    					var pageCount = json.pageCount;
    					var recordCount = json.recordCount;
    					
    					if(currentPageNo == 1) {
            				btnGroup.append($("<button class='btn btn-default disabled' pageNo='" + (currentPageNo-1)  +"'>上一页</button>"));
            			} else {
            				btnGroup.append($("<button class='btn btn-default' pageNo='1'>上一页</button>"));
            			}
            			for(var i = 1; i <= pageCount; i++) {
            				if(currentPageNo == i){
            					btnGroup.append($("<button class='btn btn-default disabled' pageNo='" + i +"'>" + i + "</button>"));
            					continue;
            				}
            				btnGroup.append($("<button class='btn btn-default' pageNo='" + i +"'>" + i + "</button>"));
            			}
            			if(currentPageNo == pageCount) {
            				btnGroup.append($("<button class='btn btn-default disabled' pageNo='" + currentPageNo  +"'>下一页</button>"));
            			} else {
            				btnGroup.append($("<button class='btn btn-default' pageNo='" + (currentPageNo+1)  +"'>下一页</button>"));
            			}
    			},
    			error: function(data){
    				
    			}
    		});
    	}
    	
	   $("#enrollList tbody").on("click", ".register", function() {		   
		   var courseRecordId = $(this).attr("courseRecordId");
			enrollAjax(courseRecordId);
	   });
	   
	   function enrollAjax(courseRecordId){
		   $.ajax({
   			url:"enrollCourse.action",
   			type:"post",
   			data:{
   				"courseRecordId":courseRecordId
   			},
   			dataType:"json",
   			success: function(responseText){
   				alert("报名成功");
   				window.location.href="index.jsp";
   				
   			}
	   	 });
	   }
	   
	   $("#btnGroup").on('click','.btn',function(){
			var pageNo = $(this).attr('pageNo');
			getEnrollList(pageNo);
		});

	</script>
</body>
</html>

