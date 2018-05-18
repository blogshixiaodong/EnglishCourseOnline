<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>课表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<!-- left nav bar -->
				<jsp:include page="left.jsp"></jsp:include>
			</div>
			<jsp:include page="top_nav.jsp"></jsp:include>
			
		
			<!-- page content -->
			<div class="right_col" role="main">
				<form class="form-horizontal form-label-left input_mask" onsubmit="return false;" >
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

								<table class="table" id="timeTable">
									<thead>
										<tr>
											<th>#</th>
											<th>星期一</th>
											<th>星期二</th>
											<th>星期三</th>
											<th>星期四</th>
											<th>星期五</th>
											<th>星期六</th>
											<th>星期日</th>
											
										</tr>
									</thead>
									<tbody>
										<!-- ajax  -->
										<tr id = "first">
											<td id="week1">一二节</td>
											<td id="week1"></td>
											<td id="week2"></td>
											<td id="week3"></td>
											<td id="week4"></td>
											<td id="week5"></td>
											<td id="week6"></td>
											<td id="week7"></td>
										</tr>
										<tr id = "second">
											<td id="week1">三四节</td>
											<td id="week1"></td>
											<td id="week2"></td>
											<td id="week3"></td>
											<td id="week4"></td>
											<td id="week5"></td>
											<td id="week6"></td>
											<td id="week7"></td>
										</tr>
										<tr id = "third">
											<td id="week1">五六节</td>
											<td id="week2"></td>
											<td id="week3"></td>
											<td id="week4"></td>
											<td id="week5"></td>
											<td id="week6"></td>
											<td id="week7"></td>
										</tr>
										<tr id = "forth">
											<td id="week1">七八节</td>
											<td id="week2"></td>
											<td id="week3"></td>
											<td id="week4"></td>
											<td id="week5"></td>
											<td id="week6"></td>
											<td id="week7"></td>
										</tr>
										
									</tbody>
								</table>
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
	<!-- bootstrap-daterangepicker -->
    <script src="../vendors/moment/min/moment.min.js"></script>
    <script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
 	<script src="../vendors/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
 	<script src="../vendors/bootstrap-datetimepicker/build/js/bootstrap-datepicker.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="../build/js/custom.min.js"></script>
	<script src="../build/js/common.js"></script>
	
	<script type="text/javascript">
	$(sendCondition());
	
	function DateToString(dateObject) {
		var year = dateObject.getYear() + 1900;
		var month = dateObject.getMonth() + 1;
		var monthStr = "";
		if(month < 10){
			monthStr = "0"+month;
		}else{
			monthStr = month;
		}
		var day = dateObject.getDate();

		return year+ "-" + monthStr + "-" + day;
	}
	
	 function getPartName(attendTime){
		 var partName = "";
		 switch(attendTime){
		 	case 1:
		 		partName = "first";
		 		break;
		 	case 2:
		 		partName = "second";
		 		break;
		 	case 3:
		 		partName = "third";
		 		break;
		 	case 4:
		 		partName = "forth";
		 		break;
		 }
		 return partName;
	 }	
	
	function sendCondition(){
		var queryDate = $("#queryDate").val();
		if(queryDate === ""){
			var date = new Date();
			queryDate = DateToString(date);
		}
		$.ajax({
			url:"timeTable.action",
			type:"post",
			data:{
				"queryDate" : queryDate
			},
			dataType:"json",
			success: function(responseText){
				var json = JSON.parse(responseText);
				for(var i = 0; i < json.length; i++){
					var engclass = json[i];
					var partName = getPartName(engclass.attendTime);
					var weekName = "week"+engclass.day;
					var info = engclass.courseRecord.course.courseName +" " + engclass.teacher.teacherName+" "+engclass.classRoom;
					$("#timeTable tbody #"+partName+" #"+weekName).html(info);
				}
			},
			error: function(data){
				
			}
		});
	}
	
	$('#myDatepicker').datepicker({
   	 format: 'yyyy-mm-dd'
   });
	
	$("#myDatepicker").on("changeDate",function(){
		 sendCondition();
	});
	
	$("#reset").click(function() {
		$("#myDatepicker").datepicker("clearDates");
		sendCondition();
	});
	
	</script>
	
</body>

</html>