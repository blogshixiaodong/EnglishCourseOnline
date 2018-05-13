<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>所有班级</title>
	<link rel="icon" href="images/favicon.ico" type="image/ico" />
	<title>商家后台管理</title>
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
			<!-- top nav bar -->
			<jsp:include page="top_nav.jsp"></jsp:include>

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>所有班级</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
									<li><a class="close-link"><i class="fa fa-close"></i></a></li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<table id="engclassTable" class="table">
									<thead>
										<tr>
											<th>班级编号</th>
											<th>班级名称</th>
											<th>教室</th>
											<th>班级人数</th>
											<td>上课时间</td>
											<th>课程编号</th>
											<th>课程名称</th>
										</tr>
									</thead>
									<tbody>
										<!-- create after page load -->
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

			<!-- footer -->
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
	    		url: "allEngclasses.action",
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
	    		url: "allEngclasses.action",
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
			var tbody = $("#engclassTable tbody");
			tbody.html("");
			//创建表格
			for(var i = 0; i < json.list.length; i++) {
				var engclass = json.list[i];

				var engclassId = $("<td></td>").html(engclass.engclassId);
				var engclassName = $("<td></td>").html(engclass.engclassName);
				var classRoom = $("<td></td>").html(engclass.classRoom);
				var userCount = $("<td></td>").html(engclass.userCount);
				var attendTime = $("<td></td>").html(schooltime(engclass.day, engclass.attendTime));
				var courseId = $("<td></td>").html(engclass.courseRecord.course.courseId);
				var courseName = $("<td></td>").html(engclass.courseRecord.course.courseName);
				var tr = $("<tr></tr>");
				tr.append(engclassId);
				tr.append(engclassName);
				tr.append(classRoom);
				tr.append(userCount);
				tr.append(attendTime);
				tr.append(courseId);
				tr.append(courseName);
				tbody.append(tr);
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

