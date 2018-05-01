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
	<s:if test="#request.engclassDetailList == null">
		<s:action name="searchEngclasses" namespace="/user"></s:action>
	</s:if>
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
					<div class="col-md-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>选择班级</h2>
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

									<div class="col-md-3 col-sm-3 col-xs-12 form-group">  
					                    <select id="engclassList" class="selectpicker show-tick" title="请选择班级" data-live-search="true" data-size="5">
					                        <s:iterator value="#request.engclassDetailList" status="i" var="engclass">
					                        	<option><s:property value="#engclass.classId " /> : <s:property value="#engclass.className" /></option>
					                        </s:iterator>
					                    </select>  
				                	</div> 
				                	<div class="col-md-3 col-sm-3 col-xs-12 form-group">
				                    	<div class="input-group date" id="myDatepicker">
				                            <input id="queryDate" type="text" class="form-control" readonly="readonly"/>
				                            <span class="input-group-addon">
				                               <span class="glyphicon glyphicon-calendar"></span>
				                            </span>
				                        </div>
					                </div>
									
									<div class="col-md-2 col-sm-2 col-xs-12 form-group has-feedback form-group">
										<button class="btn btn-primary" id="reset">重置查询</button>
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
									信息列表
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

								<table id="timeSheet" class="table table-striped">
									<thead>
										<tr>
											<th>#</th>
											<th>用户编号</th>
											<th>用户姓名</th>
											<th>班级编号</th>
											<th>班级名称</th>
											<th>教师编号</th>
											<th>教师名称</th>
											<th>教室</th>
											<th>考勤时间</th>
											<th>考勤状态</th>
										</tr>
									</thead>
									<tbody>
										<!-- get data and create dom by ajax -->
									</tbody>
								</table>
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
    
    <script type="text/javascript">
    	
	    $('#myDatepicker').datepicker({
	    	 format: 'yyyy-mm-dd'
	    });
	    
	  
	    
	    function AppendZero(number) {
    		if(number < 10) {
    			return "0" + number;
    		}
    		return number;
    	}
	    
	    function JsonDateToString(dateObject) {
    		var year = 1900 + dateObject.year;
    		var month = 1 + dateObject.month;
    		var day = dateObject.date;
    		var hours = dateObject.hours;
    		
    		var minutes = dateObject.minutes;
    		
    		var seconds = dateObject.seconds;
    		
    		return year + "-" + AppendZero(month) + "-" + AppendZero(day) + " " + AppendZero(hours) + ":" + AppendZero(minutes) + ":" + AppendZero(seconds);
    	}
	    
    	function reset() {
			document.getElementById("engclassList").options.selectedIndex = 0;
			$("#engclassList").attr("index", 0);
			$("#engclassList").selectpicker('refresh');
			$("#myDatepicker").datepicker("clearDates");
			$("#userList tbody").html("");
    	}
    	
    	function sendCondition(e) {
    		$("#timeSheet tbody").html("");
    		var classId = $("#engclassList").val().split(" : ")[0];
    		var queryDate = $("#queryDate").val();
    		if(classId === ""){
    			return;
    		}
    		$.ajax({
    			url: "showtimeSheets.action",
    			type : "post",
    			dataType: "json",
    			data:{"engclass.classId" : classId, "queryDate" : queryDate},
    			success: function(responseText) {
    				//JSON对象转JavaScript对象
    				var json = JSON.parse(responseText);
    				for(var i = 0; i < json.length; i++) {
    					var tr = $("<tr></tr>");
    					var record = json[i];
    					tr.append($("<td></td>").text(i));
    					tr.append($("<td></td>").text(record["userId"]));
    					tr.append($("<td></td>").text(record["username"]));
    					tr.append($("<td></td>").text(record["classId"]));
    					tr.append($("<td></td>").text(record["className"]));
    					tr.append($("<td></td>").text(record["teacherId"]));
    					tr.append($("<td></td>").text(record["teacherName"]));
    					tr.append($("<td></td>").text(record["classRoom"]));
    					tr.append($("<td></td>").text(JsonDateToString(record["recordTime"])));
    					tr.append($("<td></td>").text(record["sheetInfo"]));
    					$("#timeSheet tbody").append(tr);		
    				}
    			},
    			error: function(XMLHttpRequest, textStatus, errorThrown) {
    				alert("查询失败，请重新输入!");
    				reset();
    			}
    		});
    	}
		$("#engclassList").change(sendCondition);
		  $("#myDatepicker").on("changeDate", sendCondition);
		$("#reset").click(function() {
			reset();
		});
		
		
	
	</script>
</body>
</html>

