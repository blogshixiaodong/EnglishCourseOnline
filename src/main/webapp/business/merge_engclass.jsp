<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>合并班级</title>
	<link rel="icon" href="images/favicon.ico" type="image/ico" />
    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
	<link href="../vendors/bootstrap-select/bootstrap-select.min.css" rel="stylesheet">
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
					<div class="col-md-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>课程选择   <small>仅能合并相同课程的班级</small></h2>
								<ul class="nav navbar-right panel_toolbox">
									<li>
										<a class="collapse-link">
											<i class="fa fa-chevron-up"></i>
										</a>
									</li>
									<li class="dropdown">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
											<i class="fa fa-wrench"></i>
										</a>
										<ul class="dropdown-menu" role="menu">
											<li><a href="#">Settings 1</a></li>
											<li><a href="#">Settings 2</a></li>
										</ul>
									</li>
									<li>
										<a class="close-link"><i class="fa fa-close"></i></a>
									</li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<br />
								<form class="form-horizontal form-label-left input_mask" onsubmit="return false;" >
									<div class="col-md-2 col-sm-2 col-xs-12 form-group">  
					                    <select id="courseList" class="selectpicker show-tick" title="请选择课程" data-live-search="true" data-size="5">
					                    	<!-- 页面加载后由ajax加载 -->
					                    </select>  
				                	</div> 
									<div class="col-md-2 col-sm-2 col-xs-12 form-group has-feedback form-group">
										<button class="btn btn-primary" id="reset">重新选择</button>
		                     		</div>
								</form>
							</div>
						</div>
					</div>	
				</div>
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>
									课程基本信息
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
								<table id="courseInfo" class="table table-striped">
									<thead>
										<tr>
											<th>课程编号</th>
											<th>课程名称</th>
											<th>课程信息</th>
											<th>课程类型</th>
											<th>课程价格</th>
										</tr>
									</thead>
									<tbody>
										<!-- 课程选完通过ajax加载课程基本信息 -->
										<tr></tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>合并班级选择</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li>
										<a class="collapse-link">
											<i class="fa fa-chevron-up"></i>
										</a>
									</li>
									<li class="dropdown">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
											<i class="fa fa-wrench"></i>
										</a>
										<ul class="dropdown-menu" role="menu">
											<li><a href="#">Settings 1</a></li>
											<li><a href="#">Settings 2</a></li>
										</ul>
									</li>
									<li>
										<a class="close-link"><i class="fa fa-close"></i></a>
									</li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<br />
								<form class="form-horizontal form-label-left input_mask" onsubmit="return false;" >
									<div class="col-md-2 col-sm-2 col-xs-12 form-group">  
					                    <select id="engclassList1" class="selectpicker show-tick" title="请选择班级" data-live-search="true" data-size="5">
					                    	<!-- 页面加载后由ajax加载 -->
					                    </select>  
				                	</div>
									<div class="col-md-2 col-sm-2 col-xs-12 form-group has-feedback form-group">
										<button class="btn btn-primary" id="reset">重新选择</button>
		                     		</div>
								</form>
							</div>
						</div>
					</div>	
				</div>
				
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>
									班级基本信息
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
								<table id="courseInfo" class="table table-striped">
									<thead>
										<tr>
											<th>#</th>
											<th>班级编号</th>
											<th>班级名称</th>
											<th>教师编号</th>
											<th>班级人数</th>
											<th>教室</th>
										</tr>
									</thead>
									<tbody>
										<!-- 课程选完通过ajax加载课程基本信息 -->
										<tr></tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>
									教师基本信息
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
								<table id="teacherInfo" class="table table-striped">
									<thead>
										<tr>
											<th>教师编号</th>
											<th>教师名称</th>
											<th>身份证</th>
											<th>性别</th>
											<th>年龄</th>
											<th>联系方式</th>
											<th>居住地址</th>
										</tr>
									</thead>
									<tbody>
										<!-- 教师选完通过ajax加载教师基本信息 -->
										<tr></tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
                	<div class="col-md-6 col-md-offset-5">
                        <button id="sendFrom" type="submit" class="btn btn-success">提交</button>
                    </div>
                </div>
                <br />
				<br />
				<br />
				<br />
				<br />
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
    <!-- jquery-json -->
    <script src="../build/js/jquery.json.min.js"></script> 
    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    
    <script type="text/javascript">
    	$(function() {
    		//课程列表
    		$.ajax({
    			url: "courseList.action",
    			type: "post",
    			dataType: "json",
    			success: function(responseText) {
    				var json = JSON.parse(responseText);
    				for(var i = 0; i < json.length; i++) {
    					var courseId = json[i].courseId;
    					var courseName = json[i].courseName;
   	    				$("#courseList").append($("<option></option>").text(courseId + " : " + courseName))
    				}
    			}
    		});
    		//教师列表
    		$.ajax({
    			url: "teacherList.action",
    			type: "post",
    			dataType: "json",
    			success: function(responseText) {
    				var json = JSON.parse(responseText);
    				for(var i = 0; i < json.length; i++) {
    					var teacherId = json[i].teacherId;
    					var teacherName = json[i].teacherName;
   	    				$("#teacherList").append($("<option></option>").text(teacherId + " : " + teacherName))
    				}
    			}
    		});
    	});
    	
  		//课程选择完成显示基本信息
    	$("#courseList").change(function() {
    		$("#courseInfo tbody tr").html("");
    		var courseId = $("#courseList").val().split(" : ")[0];
    		$.ajax({
    			url: "courseInfo.action",
    			type: "post",
    			dataType: "json",
   				data: {
   					"courseId": courseId
   				},
    			success: function(responseText) {
    				var json = JSON.parse(responseText);
    				var tr = $("#courseInfo tbody tr");
    				tr.append($("<td></td>").text(json["courseId"]));
    				tr.append($("<td></td>").text(json["courseName"]));
    				tr.append($("<td></td>").text(json["info"]));
    				tr.append($("<td></td>").text(json["types"]));
    				tr.append($("<td></td>").text(json["price"]));
    			}
    		});
    		
    		//根据该门课程选择班级
			$.ajax({
				url: "engclassList.action",
				type: "post",
				dataType: "json",
				data: {
					"courseId": courseId
				},
				success: function(responseText) {
					
    				var json = JSON.parse(responseText);
    				for(var i = 0; i < json.length; i++) {
    					var engclassId = json[i].classId;
    					var engclassName = json[i].className;
    					var optionDom = $("<option></option>").text(engclassId + " : " + engclassName);
   	    				$("#engclassList1").append(optionDom);
    				}
				}
			});
    		
    		
    	});
    	
    	$("#engclassList1").change(function() {
    		
    		
    	});
    	
		$("#engclassList1").change(function() {
    		
    	});
  		
    	$('#startDatepicker').datepicker({
	    	 format: 'yyyy-mm-dd'
	    });
    	$('#endDatepicker').datepicker({
	    	 format: 'yyyy-mm-dd'
	    });
    	$('#closeDatepicker').datepicker({
	    	 format: 'yyyy-mm-dd'
	    });
    	
    	$("#reset").click(function() {
    		document.getElementById("courseList").options.selectedIndex = 0;
    		document.getElementById("teacherList").options.selectedIndex = 0;
			$("#courseList").attr("index", 0);
			$("#courseList").selectpicker('refresh');
			$("#teacherList").attr("index", 0);
			$("#teacherList").selectpicker('refresh');
			$("#myDatepicker").datepicker("clearDates");
			$("#userList tbody").html("");
		});
    	
    	$("#sendFrom").click(function() {
    		var courseId = $("#courseList").val().split(" : ")[0];
    		var teacherId = $("#teacherList").val().split(" : ")[0];
    		var startTime = $("#starttime").val();
    		var endTime = $("#endtime").val();
    		var closeTime = $("#closetime").val();
    		var className = $("#className").val();
    		var classRoom = $("#classRoom").val();
    		var userCount = $("#userCount").val();
    		$.ajax({
  				url: "setupEngclass.action",
  				type: "post",
  				dataType: "json",
  				data: {
  					"courseId": courseId,
  					"teacherId": teacherId,
  					"startTime": startTime,
  					"endTime": endTime,
  					"closeTime": closeTime,
  					"clasName": className,
  					"classRoom": classRoom,
  					"userCount": userCount
  				},
  				success: function(responseText) {
  					console.log(responseText);
  				},
  				error: function(XMLHttpRequest, textStatus, errorThrown) {
    				alert("查询失败，请重新输入!");
    			}
  				
  			});
    	});
	
	</script>
</body>
</html>

