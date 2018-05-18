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
								<h2>开设班级</h2>
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
					                    <select id="courseList" class="selectpicker show-tick" title="请选择课程" data-live-search="true" data-size="5">
					                    	<!-- 页面加载后由ajax加载 -->
					                    </select>  
				                	</div> 
				                	<div class="col-md-2 col-sm-2 col-xs-12 form-group">  
					                    <select id="teacherList" class="selectpicker show-tick" title="请选择任课教师" data-live-search="true" data-size="5">
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
											<th>课程名称</th>
											<th>课程类型</th>
											<th>课程价格</th>
											<th>课程信息</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<!-- 课程选完通过ajax加载课程基本信息 -->
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
											<!-- 教师选完通过ajax加载教师基本信息 -->
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
									添加课程记录
								</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
									<li><a class="close-link"><i class="fa fa-close"></i></a></li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<table id="userList" class="table table-striped">
									<thead>
										<tr>
											<th>开课时间</th>
											<th>结课时间</th>
											<th>报名截止时间</th>
										</tr>
									</thead>
									<tbody>
										<th>
											<div class="input-group date" id="startDatepicker">
					                            <input name="starttime" id="starttime" type="text" class="form-control" readonly="readonly"/>
					                            <span class="input-group-addon">
					                               <span class="glyphicon glyphicon-calendar"></span>
					                            </span>
					                        </div>
										</th>
										<th>
											<div class="input-group date" id="endDatepicker">
					                            <input name="endtime" id="endtime" type="text" class="form-control" readonly="readonly"/>
					                            <span class="input-group-addon">
					                               <span class="glyphicon glyphicon-calendar"></span>
					                            </span>
					                        </div>
										</th>
										<th>
											<div class="input-group date" id="closeDatepicker">
					                            <input name="closetime" id="closetime" type="text" class="form-control" readonly="readonly"/>
					                            <span class="input-group-addon">
					                               <span class="glyphicon glyphicon-calendar"></span>
					                            </span>
					                        </div>
										</th>
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
								<table id="userList" class="table table-striped">
									<thead>
										<tr>
											<th>班级名称</th>
											<th>教室</th>
											<th>班级人数</th>
											<th>上课时间</th>
										</tr>
									</thead>
									<tbody>
										<th><input id="engclassName" class="form-control" name="clssname" /></th>
										<th><input id="classRoom" class="form-control" name="classroom" /></th>
										<th><input id="signCount" class="form-control" name="signCount" /></th>
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
    			url: "courseIdNameList.action",
    			type: "get",
    			dataType: "json",
    			success: function(responseText) {
    				var json = JSON.parse(responseText);
    				var select = $("#courseList");
    				for(var i = 0; i < json.length; i++) {
    					var courseId = json[i].courseId;
    					var courseName = json[i].courseName;
   	    				select.append($("<option></option>").text(courseId + " : " + courseName))
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
    			dataType: "json",
    			success: function(responseText) {
    				var json = JSON.parse(responseText);
    				var select = $("#teacherList");
    				for(var i = 0; i < json.length; i++) {
    					var teacherId = json[i].teacherId;
    					var teacherName = json[i].teacherName;
    					select.append($("<option></option>").text(teacherId + " : " + teacherName))
    				}
    				select.selectpicker('refresh');
    			},
    			error: function(XMLHttpRequest, textStatus, errorThrown) {
    				alert("请勿重复刷新!");
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
   					"course.courseId": courseId
   				},
    			success: function(responseText) {
    				var json = JSON.parse(responseText);
    				var tr = $("#courseInfo tbody tr");
    				tr.append($("<td></td>").text(json["courseId"]));
    				tr.append($("<td></td>").text(json["courseName"]));
    				tr.append($("<td></td>").text(json["types"]));
    				tr.append($("<td></td>").text(json["price"]));
    				tr.append($("<td></td>").text(json["info"]));
    			}
    		});
    	});
  		
    	//教师选择完成显示基本信息
    	$("#teacherList").change(function() {
    		$("#teacherInfo tbody tr").html("");
    		var teacherId = $("#teacherList").val().split(" : ")[0];
    		$.ajax({
    			url: "teacherInfo.action",
    			type: "post",
    			dataType: "json",
   				data: {
   					"teacher.teacherId": teacherId
   				},
    			success: function(responseText) {
    				var json = JSON.parse(responseText);
    				var tr = $("#teacherInfo tbody tr");
    				tr.append($("<td></td>").text(json["teacherId"]));
    				tr.append($("<td></td>").text(json["teacherName"]));
    				tr.append($("<td></td>").text(json["idCard"]));
    				tr.append($("<td></td>").text(json["sex"]));
    				tr.append($("<td></td>").text(json["age"]));
    				tr.append($("<td></td>").text(json["phone"]));
    				tr.append($("<td></td>").text(json["address"]));
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
    		var courseId = $("#courseList").val().split(" : ")[0];
    		var teacherId = $("#teacherList").val().split(" : ")[0];
    		var startTime = $("#starttime").val();
    		var endTime = $("#endtime").val();
    		var closeTime = $("#closetime").val();
    		var className = $("#engclassName").val();
    		var classRoom = $("#classRoom").val();
    		var signCount = $("#signCount").val();
    		var day = $("#day").prop("selectedIndex");
    		var attendTime = $("#attendTime").prop("selectedIndex"); 
    		if(courseId == "" || teacherId == "" || startTime == "" || endTime == "" || closeTime == "" || className == "" || classRoom == "" || signCount == "" || day == 0 || attendTime == 0) {
    			alert("信息不完整!");
    			return ;
    		}
    		$.ajax({
  				url: "setupEngclass.action",
  				type: "post",
  				dataType: "json",
  				data: {
  					"course.courseId": courseId,
  					"teacher.teacherId": teacherId,
  					"courseRecord.startTime": startTime,
  					"courseRecord.endTime": endTime,
  					"courseRecord.closeTime": closeTime,
  					"courseRecord.signCount": signCount,
  					"engclass.engclassName": className,
  					"engclass.classRoom": classRoom,
  					"engclass.userCount": 0,
  					"engclass.day": day,
  					"engclass.attendTime": attendTime
  				},
  				success: function(responseText) {
  					alert("创建成功");
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

