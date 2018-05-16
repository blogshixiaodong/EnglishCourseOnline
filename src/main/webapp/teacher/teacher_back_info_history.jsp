<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>历史反馈信息</title>
    <link rel="icon" href="images/favicon.ico" type="image/ico" />
    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
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
					                       <!-- after load -->
					                    </select>  
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
									学生列表
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

								<table id="teacherBackInfoTable" class="table table-striped">
									<thead>
										<tr>
											<th>反馈对象编号</th>
											<th>反馈对象名称</th>
											<th>反馈时间</th>
											<th>反馈内容</th>
										</tr>
									</thead>
									<tbody>
										<!-- get data and create dom by ajax -->
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
    <!-- bootstrap-daterangepicker -->
    <script src="../vendors/bootstrap-datetimepicker/build/js/bootstrap-datepicker.js"></script> 
	<!-- bootstrap-select -->
 	<script src="../vendors/bootstrap-select/bootstrap-select.min.js"></script>
 	<!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
 	<script src="../build/js/common.js"></script>
 	
    <script type="text/javascript">
    	//获取班级下拉列表的id/name列表
	    $(function() {
			$.ajax({
				url: "engclassList.action",
				type: "get",
				dataType: "json",
				success: function(responseText) {
					var json = JSON.parse(responseText);
					var select = $("#engclassList");
					for(var i = 0; i < json.length; i++) {
						var record = json[i];
						var option = $("<option></option>").html(record.engclassId + " : " + record.engclassName);
						select.append(option);
					}
					//刷新控件
					select.selectpicker('refresh');
				},
	    		error: function(XMLHttpRequest, textStatus, errorThrown) {
					alert("服务端错误，请重试!");
					reset();
				}
			});
		});		
    
    	function reset() {
			document.getElementById("engclassList").options.selectedIndex = 0;
			$("#engclassList").attr("index", 0);
			$("#engclassList").selectpicker('refresh');
			$("#teacherBackInfoTable tbody").html("");
    	}
    	
    	function createTeacherBackInfoTable(json) {
			var tbody = $("#teacherBackInfoTable tbody");
			tbody.html("");
			$("#btnGroup").html("");
			if(json.list.length == 0) {
				return;
			}
			//创建表格
			for(var i = 0; i < json.list.length; i++) {
				var teacherBackInfo = json.list[i];
				var user = teacherBackInfo.user;
				if(user == null) {
					user = new Object();
					user.userId = "全体成员";
					user.username = "全体成员";
				}
				var tr = $("<tr></tr>");
				tr.append($("<td></td>").text(user.userId));
				tr.append($("<td></td>").text(user.username));
				tr.append($("<td></td>").text(JsonDateToString(teacherBackInfo.backTime)));
				tr.append($("<td></td>").text(teacherBackInfo.backInfo));
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
    	
    	$("#btnGroup").on("click", ".btn", function() {
	  		var pageNo = $(this).attr("pageNo");
	  		var engclassId = $("#engclassList").val().split(" : ")[0];
    		var queryDate = $("#queryDate").val();
    		if(engclassId === "" || queryDate === "") {
    			return;
    		}
	  		$.ajax({
	    		url: "teacherBackInfoHistory.action",
	    		type: "post",
	    		data: {
	    			"pageContainer.currentPageNo": pageNo,
	    			"pageContainer.pageSize": 5,
	    			"engclass.engclassId" : engclassId, 
	    		},
	    		dataType: "json",
	    		success: function(responseText) {
	    			var json = JSON.parse(responseText);
	    			createTeacherBackInfoTable(json);
	    		}
	    	});
	  	});
    	
    	function sendCondition(e) {
    		$("#teacherBackInfoTable tbody").html("");
    		var engclassId = $("#engclassList").val().split(" : ")[0];
    		if(engclassId === "") {
    			return;
    		}
    		$.ajax({
    			url: "teacherBackInfoHistory.action",
    			type : "post",
    			dataType: "json",
    			data:{
    				"pageContainer.currentPageNo": 1,
	    			"pageContainer.pageSize": 5,
    				"engclass.engclassId" : engclassId
    			},
    			success: function(responseText) {
    				//JSON对象转JavaScript对象
    				var json = JSON.parse(responseText);
    				createTeacherBackInfoTable(json);
    			},
    			error: function(XMLHttpRequest, textStatus, errorThrown) {
    				alert("查询失败，请重新输入!");
    				reset();
    			}
    		});
    	}
		$("#inClassId").change("input", sendCondition);
		$("#inClassName").change("input", sendCondition);
		$("#engclassList").change(sendCondition);
		$("#reset").click(function() {
			reset();
		});

	</script>
</body>
</html>

