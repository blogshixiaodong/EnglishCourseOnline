<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>所有课程</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Bootstrap -->
	<link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- Font Awesome -->
	<link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
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
			
			<jsp:include page="top_nav.jsp"></jsp:include>
			
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>所有课程</h2>
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
									<li><a class="close-link"><i class="fa fa-close"></i></a></li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">

								<table id="courseTable" class="table">
									<thead>
										<tr>
											<th>课程编号</th>
											<th>课程名称</th>
											<th>课程信息</th>
											<th>课程类型</th>
											<th>开课时间</th>
											<th>结课时间</th>
										</tr>
									</thead>
									<tbody>
										<!-- after load -->
									</tbody>
								</table>
								<div class="row">
			                    	<div class="btn-toolbar pull-right">
				                        <div id="btnGroup" class="btn-group">
				                        	<!-- create after page load -->
				                        </div>
			                     	</div>
			                    </div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->

			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
	
	<!-- jQuery -->
	<script src="../vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="../build/js/custom.min.js"></script>
	<script src="../build/js/common.js"></script>
	<script type="text/javascript">
		$(function() {
			$.ajax({
	    		url: "allCourseList.action",
	    		type: "post",
	    		data: {
	    			"pageContainer.currentPageNo": 1,
	    			"pageContainer.pageSize": 3
	    		},
	    		dataType: "json",
	    		success: function(responseText) {
	    			var json = JSON.parse(responseText);
	    			createCourseTable(json);
	    		}
	    	});
			
		});
		
	  	$("#btnGroup").on("click", ".btn", function() {
	  		var pageNo = $(this).attr("pageNo");
	  		$.ajax({
	    		url: "allCourseList.action",
	    		type: "post",
	    		data: {
	    			"pageContainer.currentPageNo": pageNo,
	    			"pageContainer.pageSize": 3
	    		},
	    		dataType: "json",
	    		success: function(responseText) {
	    			var json = JSON.parse(responseText);
	    			createCourseTable(json);
	    		}
	    	});
	  	});
	
		function createCourseTable(json) {
			var tbody = $("#courseTable tbody");
			tbody.html("");
			//创建表格
			for(var i = 0; i < json.list.length; i++) {
				var course = json.list[i];
				//一门课程存在多个课程记录
				var courseRecordSet = course.courseRecordSet;
				for(var j = 0; j < courseRecordSet.length; j++) {
					var courseRecord = courseRecordSet[j];
					var courseId = $("<td></td>").html(course.courseId);
					var courseName = $("<td></td>").html(course.courseName);
					var info = $("<td></td>").html(course.info);
					var types = $("<td></td>").html(course.types);
					var startTime = $("<td></td>").html(JsonDateToString(courseRecord.startTime));
					var endTime = $("<td></td>").html(JsonDateToString(courseRecord.endTime));
					var tr = $("<tr></tr>");
					tr.append(courseId);
					tr.append(courseName);
					tr.append(info);
					tr.append(types);
					tr.append(startTime);
					tr.append(endTime);
					tbody.append(tr);
				}
			}
			
			//创建按钮组
			var btnGroup = $("#btnGroup");
			btnGroup.html("");
			var currentPageNo = json.currentPageNo;
			var pageCount = json.pageCount;
			
			var recordCount = json.recordCount;
			if(currentPageNo == 1) {
				btnGroup.append($("<button class='btn btn-default disabled' pageNo='1'>上一页</button>"));
			} else {
				btnGroup.append($("<button class='btn btn-default' pageNo='" + (currentPageNo - 1) + "'>上一页</button>"));
			}
			for(var i = 1; i <= pageCount; i++) {
				if(i == currentPageNo) {
					btnGroup.append($("<button class='btn btn-default disabled' pageNo='" + i  +"'>" + i + "</button>"));
					continue;
				}
				btnGroup.append($("<button class='btn btn-default' pageNo='" + i  +"'>" + i + "</button>"));
			}
			if(currentPageNo == pageCount) {
				btnGroup.append($("<button class='btn btn-default disabled' pageNo='" + currentPageNo  +"'>下一页</button>"));
			} else {
				btnGroup.append($("<button class='btn btn-default' pageNo='" + (currentPageNo + 1 ) + "'>下一页</button>"));
			}
		}
    	
    </script>
</body>

</html>