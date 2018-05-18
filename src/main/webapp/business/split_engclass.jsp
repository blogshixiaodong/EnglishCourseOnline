<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>开设班级</title>
	<link rel="icon" href="images/favicon.ico" type="image/ico" />
    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!-- bootstrap-daterangepicker -->
    <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet" />
	<link href="../vendors/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" />
    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet" />
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
								<h2>拆分班级</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
									<li><a class="close-link"><i class="fa fa-close"></i></a></li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<br />
								<form class="form-horizontal form-label-left input_mask" onsubmit="return false;" >
									<div class="col-md-2 col-sm-2 col-xs-12 form-group">  
					                    <select id="engclassList" class="selectpicker show-tick" title="请选择班级" data-live-search="true" data-size="5">
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
									课程信息
								</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
									<li><a class="close-link"><i class="fa fa-close"></i></a></li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<table id="courseInfo" class="table table-striped">
									<thead>
										<tr>
											<th>课程编号</th>
											<th>课程记录编号</th>
											<th>课程名称</th>
											<th>课程类型</th>
											<th>课程价格</th>
											<th>课程信息</th>
											<th>开课时间</th>
											<th>结课时间</th>
											<th>报名截止</th>
											<th>报名人数</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<!-- 班级选完通过ajax加载课程基本信息 -->
										</tr>
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
									<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
									<li><a class="close-link"><i class="fa fa-close"></i></a></li>
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
										<tr>
											<!-- 班级选完通过ajax加载教师基本信息 -->
										</tr>
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
									班级基本信息
								</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
									<li><a class="close-link"><i class="fa fa-close"></i></a></li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<table id="engclassInfo" class="table table-striped">
									<thead>
										<tr>
											<th>班级编号</th>
											<th>班级名称</th>
											<th>学生人数</th>
											<th>教室</th>
											<th>上课时间</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<!-- 班级选完通过ajax加载教师基本信息 -->
										</tr>
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
									添加班级信息
								</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
									<li><a class="close-link"><i class="fa fa-close"></i></a></li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<table id="new_engclass1" class="table table-striped">
									<thead>
										<tr>
											<th>班级名称</th>
											<th>教室</th>
											<th>班级人数</th>
											<th>任课教师</th>
											<th>上课时间</th>
										</tr>
									</thead>
									<tbody>
										<th><input id="engclassName1" class="form-control" name="clssname" /></th>
										<th><input id="classRoom1" class="form-control" name="classroom" /></th>
										<th><input id="userCount1" class="form-control" name="signCount" /></th>
										<th>
											<form class="form-horizontal input_mask" onsubmit="return false;" >
							                	<div class="col-md-2 col-sm-2 col-xs-12 form-group">  
								                    <select id="teacherList1" class="teacherList selectpicker show-tick" title="请选择任课教师" data-live-search="true" data-size="5">
								                    	<!-- 页面加载后由ajax加载 -->
								                    </select>  
							                	</div> 
											</form>
										</th>
										<th>
											<select id="day1" class="selectpicker show-tick">
												<option>======  星期  ======</option>
												<option>星期一</option>
												<option>星期二</option>
												<option>星期三</option>
												<option>星期四</option>
												<option>星期五</option>
												<option>星期六</option>
												<option>星期日</option>
											</select>
											<select id="attendTime1" class="selectpicker show-tick">
												<option>======  时间  ======</option>
												<option>上午 1-2节</option>
												<option>上午 3-4节</option>
												<option>下午 5-6节</option>
												<option>下午 7-8节</option>
											</select>
										</th>
									</tbody>
								</table>
								
								<table id="new_engclass2" class="table table-striped">
									<thead>
										<tr>
											<th>班级名称</th>
											<th>教室</th>
											<th>班级人数</th>
											<th>任课教师</th>
											<th>上课时间</th>
										</tr>
									</thead>
									<tbody>
										<th><input id="engclassName2" class="form-control" name="clssname" /></th>
										<th><input id="classRoom2" class="form-control" name="classroom" /></th>
										<th><input id="userCount2" class="form-control" name="signCount" /></th>
										<th>
											<form class="form-horizontal input_mask" onsubmit="return false;" >
							                	<div class="col-md-2 col-sm-2 col-xs-12 form-group">  
								                    <select id="teacherList2" class="teacherList selectpicker show-tick" title="请选择任课教师" data-live-search="true" data-size="5">
								                    	<!-- 页面加载后由ajax加载 -->
								                    </select>  
							                	</div> 
											</form>
										</th>
										<th>
											<select id="day2" class="selectpicker show-tick">
												<option>======  星期  ======</option>
												<option>星期一</option>
												<option>星期二</option>
												<option>星期三</option>
												<option>星期四</option>
												<option>星期五</option>
												<option>星期六</option>
												<option>星期日</option>
											</select>
											<select id="attendTime2" class="selectpicker show-tick">
												<option>======  时间  ======</option>
												<option>上午 1-2节</option>
												<option>上午 3-4节</option>
												<option>下午 5-6节</option>
												<option>下午 7-8节</option>
											</select>
										</th>
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
    <script src="../build/js/common.js"></script>
    <script type="text/javascript">
    	$(function() {
    		//课程列表
    		$.ajax({
    			url: "engclassIdNameList.action",
    			type: "get",
    			async: false,
    			dataType: "json",
    			success: function(responseText) {
    				var json = JSON.parse(responseText);
    				var select = $("#engclassList");
    				for(var i = 0; i < json.length; i++) {
    					var engclassId = json[i].engclassId;
    					var engclassName = json[i].engclassName;
   	    				select.append($("<option></option>").text(engclassId + " : " + engclassName))
    				}
    				select.selectpicker('refresh');
    			},
    			error: function(XMLHttpRequest, textStatus, errorThrown) {
    				alert("请勿重复刷新!");
    			}
    		});
    		
    		//教师列表
    		$.ajax({
    			url: "teacherIdNameList.action",
    			type: "get",
    			async: false,
    			dataType: "json",
    			success: function(responseText) {
    				var json = JSON.parse(responseText);
    				var select = $("#teacherList1");
    				for(var i = 0; i < json.length; i++) {
    					var teacherId = json[i].teacherId;
    					var teacherName = json[i].teacherName;
    					select.append($("<option></option>").text(teacherId + " : " + teacherName))
    				}
    				select.selectpicker('refresh');
    				
    				select = $("#teacherList2");
    				for(var i = 0; i < json.length; i++) {
    					var teacherId = json[i].teacherId;
    					var teacherName = json[i].teacherName;
    					select.append($("<option></option>").text(teacherId + " : " + teacherName))
    				}
    				select.selectpicker('refresh');
    			},
    			error: function(XMLHttpRequest, textStatus, errorThrown) {
    				alert("服务端异常，请稍后重试!");
    			}
    		});
    	});
    	
  		//班级选择完成显示基本信息
    	$("#engclassList").change(function() {
    		$("#courseInfo tbody tr").html("");
    		$("#teacherInfo tbody tr").html("");
    		$("#engclassInfo tbody tr").html("");
    		var engclassId = $("#engclassList").val().split(" : ")[0];
    		$.ajax({
    			url: "engclassInfo.action",
    			type: "post",
    			dataType: "json",
   				data: {
   					"engclass.engclassId": engclassId
   				},
    			success: function(responseText) {
    				var engclass = JSON.parse(responseText);
    				var course_tr = $("#courseInfo tbody tr");
    				var teacher_tr = $("#teacherInfo tbody tr");
    				var engclass_tr = $("#engclassInfo tbody tr");
    				
    				var courseRecord = engclass.courseRecord;
    				var course = courseRecord.course;
    				var teacher = engclass.teacher;

    				course_tr.append($("<td></td>").text(course.courseId));
    				course_tr.append($("<td id='courseRecordId'></td>").text(courseRecord.courseRecordId));
    				course_tr.append($("<td></td>").text(course.courseName));
    				course_tr.append($("<td></td>").text(course.types));
    				course_tr.append($("<td></td>").text(course.price));
    				course_tr.append($("<td></td>").text(course.info));
    				course_tr.append($("<td></td>").text(JsonDateToString(courseRecord.startTime)));
    				course_tr.append($("<td></td>").text(JsonDateToString(courseRecord.endTime)));
    				course_tr.append($("<td></td>").text(JsonDateToString(courseRecord.closeTime)));
    				course_tr.append($("<td></td>").text(courseRecord.signCount));
    				
    				teacher_tr.append($("<td></td>").text(teacher.teacherId));
    				teacher_tr.append($("<td></td>").text(teacher.teacherName));
    				teacher_tr.append($("<td></td>").text(teacher.idCard));
    				teacher_tr.append($("<td></td>").text(teacher.sex));
    				teacher_tr.append($("<td></td>").text(teacher.age));
    				teacher_tr.append($("<td></td>").text(teacher.phone));
    				teacher_tr.append($("<td></td>").text(teacher.address));
    				
    				engclass_tr.append($("<td></td>").text(engclass.engclassId));
    				engclass_tr.append($("<td></td>").text(engclass.engclassName));
    				engclass_tr.append($("<td></td>").text(engclass.userCount));
    				engclass_tr.append($("<td></td>").text(engclass.classRoom));
    				engclass_tr.append($("<td></td>").text(schooltime(engclass.day, engclass.attendTime)));
    			}
    		});
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
			
			$("#courseInfo tbody tr").html("");
			$("#teacherInfo tbody tr").html("");
		});
    	
    	$("#sendFrom").click(function() {
    		var targetEngclassId = $("#engclassList").val().split(" : ")[0];
    		var targetCourseRecordId = $("#courseRecordId").html();
    		
    		var engclassName1 = $("#engclassName1").val();
    		var engclassName2 = $("#engclassName2").val();
    		
    		var classRoom1 = $("#classRoom1").val();
    		var classRoom2 = $("#classRoom2").val();
    		
    		var userCount1 = $("#userCount1").val();
    		var userCount2 = $("#userCount2").val();
    		
    		var teacherId1 = $("#teacherList1").val().split(" : ")[0];
    		var teacherId2 = $("#teacherList2").val().split(" : ")[0];
    		
    		var day1 = $("#day1").prop("selectedIndex");
    		var day2 = $("#day2").prop("selectedIndex");
    		
    		var attendTime1 = $("#attendTime1").prop("selectedIndex");
    		var attendTime2 = $("#attendTime2").prop("selectedIndex");
    		
    		var engclass1 = new Object();
    		var engclass2 = new Object();
    		
    		engclass1.engclassName = engclassName1;
    		engclass1.classRoom = classRoom1;
    		engclass1.userCount = userCount1;
    		engclass1.day = day1;
    		engclass1.attendTime = attendTime1;
    		engclass1.teacher = new Object();
    		engclass1.teacher.teacherId = teacherId1;
    		engclass1.courseRecord = new Object();
    		engclass1.courseRecord.courseRecordId = targetCourseRecordId;
    		
    		engclass2.engclassName = engclassName2;
    		engclass2.classRoom = classRoom2;
    		engclass2.userCount = userCount2;
    		engclass2.day = day2;
    		engclass2.attendTime = attendTime2;
    		engclass2.teacher = new Object();
    		engclass2.teacher.teacherId = teacherId2;
    		engclass2.courseRecord = new Object();
    		engclass2.courseRecord.courseRecordId = targetCourseRecordId;
    		
    		var engclassList = new Array();
    		engclassList.push(engclass1);
    		engclassList.push(engclass2);
    		
    		$.ajax({
  				url: "splitEngclass.action",
  				type: "post",
  				dataType: "json",
  				data: {
  					"engclass.engclassId": targetEngclassId,
  					"engclassList": JSON.stringify(engclassList)
  				},
  				success: function(responseText) {
  					alert("创建成功");
  					//window.location.href="all_courses.jsp";
  				},
  				error: function(XMLHttpRequest, textStatus, errorThrown) {
    				alert("查询失败，请重新输入!");
    			}
  			});
    	});
	
	</script>
</body>
</html>

