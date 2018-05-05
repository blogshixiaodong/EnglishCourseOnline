<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>所有课程</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<!-- Bootstrap -->
	<link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- Font Awesome -->
	<link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<!-- Custom Theme Style -->
	<link href="../build/css/custom.min.css" rel="stylesheet">
</head>
<body class="nav-md">
	<s:if test="#request.pageContainer == null">
		<s:action name="allCourses" namespace="/teacher">
			<s:param name="pageContainer.currentPageNo">1</s:param>
		</s:action>
	</s:if>
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<!-- left nav bar -->
				<jsp:include page="left.jsp"></jsp:include>
			</div>
			
			<jsp:include page="top_nav.jsp"></jsp:include>
			
			<!-- page content -->
			<div class="right_col" role="main">
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
								<table id="courseList" class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>课程编号</th>
											<th>课程名称</th>
											<th>课程类型</th>
											<th>开课时间</th>
											<th>结课时间</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#request.courseDetailList" status="i" var="courseDetail">
											<tr>
												<th scope="row"><s:property value="#i.getIndex()" /></td>
												<td><s:property value="#courseDetail.courseId" /></td>
												<td><s:property value="#courseDetail.courseName" /></td>
												<td><s:property value="#courseDetail.types" /></td>
												<td><s:date name="#courseDetail.startTime" format="yyyy-MM-dd" /></td>
												<td><s:date name="#courseDetail.endTime" format="yyyy-MM-dd" /></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
								<div class="row">
			                    	<div  class="btn-toolbar pull-right">
				                        <div class="btn-group">
				                        	<s:if test="#request.pageContainer.currentPageNo == 1">
				                        		<a class="btn btn-default disabled" type="button" href="allCourses.action?pageContainer.currentPageNo=<s:property value="#request.pageContainer.currentPageNo - 1" />">上一页</a>
				                        	</s:if>
				                        	<s:else>
				                        		<a class="btn btn-default" type="button" href="allCourses.action?pageContainer.currentPageNo=<s:property value="#request.pageContainer.currentPageNo - 1" />">上一页</a>
				                        	</s:else>
				                        	<s:bean name="org.apache.struts2.util.Counter" var="counter">
									            <s:param name="first" value="1" />
									            <s:param name="last" value="#request.pageContainer.pageCount" />
									            <s:iterator>
									            	<s:if test="#request.pageContainer.currentPageNo == #request.counter.current - 1">
									            		<a class="btn btn-default disabled" type="button"><s:property /></a>
									            	</s:if>
									            	<s:else>
									            		<a class="btn btn-default" type="button" href="allCourses.action?pageContainer.currentPageNo=<s:property />"><s:property /></a>
									            	</s:else>
									           	</s:iterator>
									        </s:bean>
									        <s:if test="#request.pageContainer.currentPageNo == #request.pageContainer.pageCount">
				                          		<a class="btn btn-default disabled" type="button" href="allCourses.action?pageContainer.currentPageNo=<s:property value="#request.pageContainer.currentPageNo + 1" />">下一页</a>
				                        	</s:if>
				                        	<s:else>
				                          		<a class="btn btn-default" type="button" href="allCourses.action?pageContainer.currentPageNo=<s:property value="#request.pageContainer.currentPageNo + 1" />">下一页</a>
				                        	</s:else>
				                        </div>
			                     	</div>
			                    </div>
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
	<!-- Custom Theme Scripts -->
	<script src="../build/js/custom.js"></script>
	<script type="text/javascript">
		
	
	</script>
	
</body>

</html>