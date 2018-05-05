<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>考勤登记</title>
	<link rel="icon" href="images/favicon.ico" type="image/ico" />
    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
	<link href="https://cdn.bootcss.com/bootstrap-select/1.12.4/css/bootstrap-select.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
</head>
<body class="nav-md">
	<s:if test="#request.engclassDetailList == null">
		<s:action name="engclassList" namespace="/teacher"></s:action>
	</s:if>
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
				                            <input id="queryDate" type="text" class="form-control" readonly="readonly" value='<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>'/>
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
					<!-- Start to do list -->
		            <div class="col-md-12 col-sm-12 col-xs-12">
		            	<div class="x_panel">
		                	<div class="x_title">
		                  		<h2>学生列表</h2>
	                  			<ul class="nav navbar-right panel_toolbox">
				                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				                    <li class="dropdown">
				                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
				                      <ul class="dropdown-menu" role="menu">
				                      	<li><a href="#">Settings 1</a></li>
				                        <li><a href="#">Settings 2</a> </li>
				                      </ul>
				                    </li>
				                    <li><a class="close-link"><i class="fa fa-close"></i></a></li>
	                  			</ul>
		                  		<div class="clearfix"></div>
		               		</div>
		                	<div class="x_content">
		                  		<div class="">
		                  			<table id="userList" class="table table-striped">
										<thead>
											<tr>
												<th>#</th>
												<th>学生编号</th>
												<th>学生姓名</th>
												<th>状态</th>
												<th>备注</th>
											</tr>
										</thead>
										<tbody>
											<!-- get data and create dom by ajax -->
										</tbody>
									</table>
				                   	<div class="col-md-11 col-sm-11 col-xs-12">
				                    	<button id="timeSheetSubmit" type='button' class='btn btn-success btn-sm'>提交考勤</button>
				                    </div>
		                  		</div>
		                	</div>
		              </div>
		    	</div>
            </div>
            <!-- End to do list -->
						
							
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
 	<script src="https://cdn.bootcss.com/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    
    <script src="https://cdn.bootcss.com/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script> 
    
    <script type="text/javascript">
   
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
			$("#userList tbody").html("");
    	}
    	
    	function sendCondition(e) {
    		$("#userList tbody").html("");
    		var classId = $("#engclassList").val().split(" : ")[0];
    		var queryDate = $("#queryDate").val();
    		if(classId === "" || queryDate === "") {
    			return;
    		}
    		$.ajax({
    			url: "searchUser.action",
    			type : "post",
    			dataType: "json",
    			data:{"engclass.classId" : classId},
    			success: function(responseText) {
    				//JSON对象转JavaScript对象
    				var json = JSON.parse(responseText);
    				for(var i = 0; i < json.length; i++) {
    					var tr = $("<tr></tr>");
    					var record = json[i];
    					tr.append($("<td></td>").text(i));
    					tr.append($("<td></td>").text(record["userId"]));
    					tr.append($("<td></td>").text(record["username"]));
    					tr.append($("<td>" + 
										"<input type='radio' name='status" + i  + "' class='flat' value='0'> 请假" +
										"<input type='radio' name='status" + i  + "' class='flat' value='1'> 迟到" +
										"<input type='radio' name='status" + i  + "' class='flat' value='2'> 缺席" +
									"</td>" +
									"<td>" +
										"<input type='text' class='flat' placeholder='notes'>"+
									"</td>"));
    					$("#userList tbody").append(tr);		
    				}
    			},
    			error: function(XMLHttpRequest, textStatus, errorThrown) {
    				alert("查询失败，请重新输入!");
    				reset();
    			}
    		});
    	}
    	
    	
    	$("#timeSheetSubmit").click(function() {
			/*var userIdList = new Array();
			var backInfo = $("#backInfo").val();
			if($("#check-all").is(':checked')) {
				//全体成员
				userIdList.push(-1);
			} else {
				//个别对象
				var children = $("#userList tbody").children();
				for(var i = 0; i < children.length; i++) {
					var userId = $(children[i]).children().eq(1).html();
					var checkbox = $(children[i]).find("input");
					if($(checkbox).is(":checked")) {
						userIdList.push(userId);
					}
				}
			}
			if(userIdList.length == 0 || backInfo === "") {
				alert("信息不完整,无法提交!");
				return ;
			}*/
			var classId = $("#engclassList").val().split(" : ")[0];
			
			var timeSheet = new Object();
			var recordList = $("#userList tbody");
			var length = recordList.find("tr").length;
			var timeSheetList = new Array();
			for(var i = 0; i < length; i++) {
				var record = new Object();
				var li =  recordList.children().eq(i);
				record.userId = li.children().eq(1).text();
				record.classId = $("#engclassList").val().split(" : ")[0];
				record.recordTime = new Date();
				var index = li.children().eq(3).find("input[name='status" + i + "']:checked").val();
				if(index === undefined) {
					alert("未填写完整!!!");
					return ;
				}
				var notes = li.children().eq(4).find("input").val();
				record.sheetInfo = index + ":" + notes;
				timeSheetList.push(record);
			}

			
			$.ajax({
				url: "insertTimeSheet.action",
				type: "post",
				data: {"list": JSON.stringify(timeSheetList)},
				dataType: "text",
				success : function(msg) {
					alert("提交成功!");
					window.location.href="time_sheet_histoty.jsp";
				},
				error : function(data){
		     		alert(data);
			   	}
				
			});
			
		});
		$("#engclassList").change(sendCondition);
		  $("#myDatepicker").on("changeDate", sendCondition);
		$("#reset").click(function() {
			reset();
		});

	</script>
</body>
</html>

