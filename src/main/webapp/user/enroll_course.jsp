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
	<s:if test="#request.enrollCourseList == null">
		<s:action name="enrollCourseList" namespace="/user"></s:action>
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
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>
									课程列表
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
											<th>课程编号</th>
											<th>课程名称</th>
											<th>课程信息</th>
											<th>课程类型</th>
											<th>价格</th>
											<th>开课时间</th>
											<th>结课时间</th>
											<th>报名人数</th>
											<th>报名截止时间</th>
											<th>报名</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#request.enrollCourseList" status="i" var="courseDetail">
											<tr>
												<th scope="row"><s:property value="#i.getIndex()" /></td>
												<td><s:property value="#courseDetail.courseId" /></td>
												<td><s:property value="#courseDetail.courseName" /></td>
												<td><s:property value="#courseDetail.info" /></td>
												<td><s:property value="#courseDetail.types" /></td>
												<td><s:property value="#courseDetail.price" /></td>
												<td><s:date name="#courseDetail.startTime" format="yyyy-MM-dd" /></td>
												<td><s:date name="#courseDetail.endTime" format="yyyy-MM-dd" /></td>
												<td><s:property value="#courseDetail.signCount" /></td>
												<td><s:date name="#courseDetail.closeTime" format="yyyy-MM-dd" /></td>
												<td><a class="btn btn-primary btn-block" type="submit" href="enrollCourse.action?courseRecordId=<s:property value="#courseDetail.courseRecordId" />">报名</a></td>
											</tr>
										</s:iterator>
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
    	
	   
		
		
	
	</script>
</body>
</html>

