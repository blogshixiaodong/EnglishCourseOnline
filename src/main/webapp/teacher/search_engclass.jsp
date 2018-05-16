<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>班级查询</title>
    <link rel="icon" href="images/favicon.ico" type="image/ico" />
    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
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
								<h2>班级查询条件</h2>
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

									<div class="col-md-5 col-sm-5 col-xs-12 form-group has-feedback">
										<input type="text" class="form-control has-feedback-left" id="engclassId" placeholder="班级编号" /> 
										<span class="fa fa-hand-o-right form-control-feedback left" aria-hidden="true"></span>
									</div>

									<div class="col-md-5 col-sm-5 col-xs-12 form-group has-feedback">
										<input type="text" class="form-control has-feedback-left" id="engclassName" placeholder="班级名称" /> 
										<span class="fa fa-book form-control-feedback left" aria-hidden="true"></span>
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
									班级简略信息
								</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
									<li><a class="close-link"><i class="fa fa-close"></i></a></li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<table id="engclassList" class="table table-striped">
									<thead>
										<tr>
											<th>班级编号</th>
											<th>班级名称</th>
											<th>班级人数</th>
											<th>教室</th>
											<th>上课时间</th>
											<th>操作</th>
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
    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    <script src="../build/js/common.js"></script>
    <script type="text/javascript">

    	function reset() {
			$("#engclassId").val("");
			$("#engclassName").val("");
			$("#engclassList tbody").html("");
    	}
    
    	function sendCondition(e) {
    		var engclassId = $("#engclassId").val();
    		var engclassName = $("#engclassName").val();
    		if(engclassId === "" && engclassName === "") {
    			return;
    		}
    		$.ajax({
    			url: "searchEngclass.action",
    			type : "post",
    			dataType: "json",
    			data:{
    				"engclass.engclassId" : engclassId, 
    				"engclass.engclassName" : engclassName
    			},
    			success: function(responseText) {
    				//JSON对象转JavaScript对象
    				var json = JSON.parse(responseText);
    				
    				for(var i = 0; i < json.length; i++) {
    					var tr = $("<tr></tr>");
    					var record = json[i];
    					tr.append($("<td></td>").text(record.engclassId));
    					tr.append($("<td></td>").text(record.engclassName));
    					tr.append($("<td></td>").text(record.userCount));
    					tr.append($("<td></td>").text(record.classRoom));
    					tr.append($("<td></td>").text(schooltime(record.day, record.attendTime)));
    					tr.append($("<button type='submit' class='btn btn-success btn-sm' engclassId='" + record.engclassId + "'>详细信息</button>"))
    					$($("#engclassList tbody")).append(tr);
    				}
    			},
    			error: function(XMLHttpRequest, textStatus, errorThrown) {
    				alert("查询失败，请重新输入!");
    				reset();
    			}
    		});
    	}
		$("#engclassId").change("input", sendCondition);
		$("#engclassName").change("input", sendCondition);
		$("#reset").click(function() {
			reset();
		});
		$("#engclassList").on('click', "button[type='submit']", function() {
			var engclassId = $(this).attr("engclassId");
			window.location.href = "engclassDetail.action?engclass.engclassId=" +  engclassId;
		});
	
	</script>
</body>
</html>

