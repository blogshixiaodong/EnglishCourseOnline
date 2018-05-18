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
				                	<div class="col-md-2 col-sm-2 col-xs-12 form-group">  
					                    <select id="engclassList2" class="selectpicker show-tick" title="请选择班级" data-live-search="true" data-size="5">
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
								<table id="engclassInfo" class="table table-striped">
									<thead>
										<tr>
											<th>#</th>
											<th>班级编号</th>
											<th>班级名称</th>
											<th>教师编号</th>
											<th>教师名称</th>
											<th>教室</th>
											<th>班级人数</th>
										</tr>
									</thead>
									<tbody>
										<!-- 课程选完通过ajax加载课程基本信息 -->
										<tr id="engclass1"></tr>
										<tr id="engclass2"></tr>
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
									填写合并班级信息
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
											<th>班级名称</th>
											<th>教室</th>
											<th>上课时间</th>
											<th>教师</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input type="text" name="className" id="className" /></td>
											<td><input type="text" name="classRoom" id="classRoom" /></td>
											<th>
											<select id="day" class="selectpicker show-tick">
												<option>======  星期  ======</option>
												<option>星期一</option>
												<option>星期二</option>
												<option>星期三</option>
												<option>星期四</option>
												<option>星期五</option>
												<option>星期六</option>
												<option>星期日</option>
											</select>
											<select id="attendTime" class="selectpicker show-tick">
												<option>======  时间  ======</option>
												<option>上午 1-2节</option>
												<option>上午 3-4节</option>
												<option>下午 5-6节</option>
												<option>下午 7-8节</option>
											</select>
										</th>
											<td id="teacherRadio">
												<!--ajax -->
											</td>
										</tr>
										
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
    			url: "courseIdNameList.action",
    			type: "post",
    			dataType: "json",
    			success: function(responseText) {
    				var json = JSON.parse(responseText);
    				for(var i = 0; i < json.length; i++) {
    					var courseId = json[i].courseId;
    					var courseName = json[i].courseName;
   	    				$("#courseList").append($("<option></option>").text(courseId + " : " + courseName))
    				}
    				$("#courseList").selectpicker('refresh');
    			}
    		});
    		//教师列表
//    		$.ajax({
//    			url: "teacherList.action",
//    			type: "post",
//    			dataType: "json",
//    			success: function(responseText) {
//    				var json = JSON.parse(responseText);
//    				for(var i = 0; i < json.length; i++) {
//    					var teacherId = json[i].teacherId;
//    					var teacherName = json[i].teacherName;
//   	    				$("#teacherList").append($("<option></option>").text(teacherId + " : " + teacherName))
//    				}
//    			}
//   			});
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
   					"course.courseId": courseId
   				},
    			success: function(responseText) {
    				var json = JSON.parse(responseText);
    				var tr = $("#courseInfo tbody tr");
    				tr.append($("<td></td>").text(json["courseId"]));
    				tr.append($("<td></td>").text(json["courseName"]));
    				tr.append($("<td></td>").text(json["info"]));
    				tr.append($("<td></td>").text(json["types"]));
    				tr.append($("<td></td>").text(json["price"]));
    			
    				//根据该门课程选择班级
    				$.ajax({
    					url: "engclassList.action",
    					type: "post",
    					dataType: "json",
    					data: {
    						"course.courseId": courseId
    					},
    					success: function(responseText) {
    	    				var json = JSON.parse(responseText);
    	    				for(var i = 0; i < json.length; i++) {
    	    					var engclassId = json[i].engclassId;
    	    					var engclassName = json[i].engclassName;
    	    					var optionDom = $("<option></option>").text(engclassId + " : " + engclassName);
    	   	    				$("#engclassList1").append($("<option></option>").text(engclassId + " : " + engclassName));
    	   	    				$("#engclassList2").append($("<option></option>").text(engclassId + " : " + engclassName));
    	    				}
    	    				$("#engclassList1").selectpicker('refresh');
    	    				$("#engclassList2").selectpicker('refresh');
    					}
    				});
    			}
    		});
    	});

    	$("#engclassList1").change(function() {
    		if($("#engclassList1").val() === $("#engclassList2").val()) {
    			alert("不能合并相同班级!");
    			document.getElementById("engclassList1").options.selectedIndex = 0;
    			return ;
    		}
    		var engclassId = $("#engclassList1").val().split(" : ")[0];
    		$.ajax({
    			url: "engclassInfo.action",
    			type: "post",
    			dataType: "json",
   				data: {
   					"engclass.engclassId": engclassId
   				},
    			success: function(responseText) {
    				var tr = $("#engclassInfo #engclass1");
    				tr.html("");
    				var json = JSON.parse(responseText);
    				tr.append($("<td></td>").text("待合并班级1"));
    				tr.append($("<td></td>").text(json.engclassId));
    				tr.append($("<td></td>").text(json.engclassName));
    				tr.append($("<td></td>").text(json.teacher.teacherId));
    				tr.append($("<td></td>").text(json.teacher.teacherName));
    				tr.append($("<td></td>").text(json.classRoom));
    				tr.append($("<td></td>").text(json.userCount));
    				setTeacher();
    			}
    		});
    	});
    	
		$("#engclassList2").change(function() {
    		if($("#engclassList1").val() === $("#engclassList2").val()) {
    			alert("不能合并相同班级!");
    			document.getElementById("engclassList2").options.selectedIndex = 0;
    			return ;
    		}
    		var engclassId = $("#engclassList2").val().split(" : ")[0];
    		$.ajax({
    			url: "engclassInfo.action",
    			type: "post",
    			dataType: "json",
   				data: {
   					"engclass.engclassId": engclassId
   				},
    			success: function(responseText) {
    				var tr = $("#engclassInfo #engclass2");
    				tr.html("");
    				var json = JSON.parse(responseText);
    				tr.append($("<td></td>").text("待合并班级2"));
    				tr.append($("<td></td>").text(json.engclassId));
    				tr.append($("<td></td>").text(json.engclassName));
    				tr.append($("<td></td>").text(json.teacher.teacherId));
    				tr.append($("<td></td>").text(json.teacher.teacherName));
    				tr.append($("<td></td>").text(json.classRoom));
    				tr.append($("<td></td>").text(json.userCount));
    				setTeacher();
    			}
    		});
    		
    	});
		
		function setTeacher() {
			if($("#engclassList1").val() != "" && $("#engclassList2").val() != "") {
				$("#teacherRadio").html("");
				var teacherId1 = $("#engclass1").find("td").eq(3).text();
				var teacherId2 = $("#engclass2").find("td").eq(3).text();
				var teacherName1 = $("#engclass1").find("td").eq(4).text();
				var teacherName2 = $("#engclass2").find("td").eq(4).text();
				var teacher1 = $("<input name='teacher' type='radio' value='" + teacherId1 + "' /> ");
				var teacher2 = $("<input name='teacher' type='radio' value='" + teacherId2 + "' /> ");
				console.log($("#engclassList1").val());
				console.log($("#engclassList2").val());
				$("#teacherRadio").append(teacher1);
				$("#teacherRadio").append(teacherName1);
				$("#teacherRadio").append(teacher2);
				$("#teacherRadio").append(teacherName2);
				
			}
		}
  		
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
    		var className = $("#className").val();
    		var classRoom = $("#classRoom").val();
    		var teacherId = $("input[name='teacher']:checked").val();
    		var courseId = $("#courseList").val().split(" : ")[0];
    		var day = $("#day").prop("selectedIndex");
    		var attendTime = $("#attendTime").prop("selectedIndex"); 
    		var oldEngclassId1 = $("#engclassList1").val().split(" : ")[0];
    		var oldEngclassId2 = $("#engclassList2").val().split(" : ")[0];
    		var userNum1 = $("#engclass1").find("td").eq(6).text();
			var userNum2 = $("#engclass2").find("td").eq(6).text();
    		
			if(className == "" || classRoom == "" || teacherId == "" || courseId == "" || day == "" || attendTime == "" || day == 0 || attendTime == 0 || oldEngclassId1 == "" || oldEngclassId2 == "" ) {                                                                  
    			alert("信息不完整!");
    			return ;
    		}
			
    		$.ajax({
  				url: "mergeEngclass.action",
  				type: "post",
  				dataType: "json",
  				data: {
  					"engclass.courseRecord.course.courseId" : courseId,
  					"engclass.teacher.teacherId": teacherId,
  					"engclass.engclassName": className,
  					"engclass.classRoom": classRoom,
  					"engclass.attendTime":attendTime,
  					"engclass.day":day,
  					"oldEngclassId1":oldEngclassId1,
  					"oldEngclassId2":oldEngclassId2,
  					"userNum1":userNum1,
  					"userNum2":userNum2
  				},
  				success: function(responseText) {
  					alert("合并成功");
  					window.location.href="all_courses.jsp";
  				},
  				error: function(XMLHttpRequest, textStatus, errorThrown) {
    				alert("查询失败，请重新输入!");
    			}
  			});
    	});
	
	</script>
</body>
</html>

