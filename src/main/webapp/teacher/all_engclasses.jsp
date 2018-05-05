<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>所有班级</title>
	<link rel="icon" href="images/favicon.ico" type="image/ico" />
	<title>商家后台管理</title>
	<!-- Bootstrap -->
	<link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- Font Awesome -->
	<link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<!-- Custom Theme Style -->
	<link href="../build/css/custom.min.css" rel="stylesheet">
</head>
<body class="nav-md">
	<s:if test="#request.pageContainer == null">
		 <s:action name="allEngclasses" namespace="/teacher">
			<s:param name="pageContainer.currentPageNo">1</s:param>
		</s:action>	 
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
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>所有班级</h2>
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

								<table class="table">
									<thead>
										<tr>
											<th>#</th>
											<th>班级编号</th>
											<th>班级名称</th>
											<th>教室</th>
											<th>班级人数</th>
											<th>课程编号</th>
											<th>课程名称</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#request.engclassDetailList" status="i" var="engclassDetail">
											<tr>
												<th scope="row"><s:property value="#i.getIndex()" /></td>
												<td><s:property value="#engclassDetail.classId" /></td>
												<td><s:property value="#engclassDetail.className" /></td>
												<td><s:property value="#engclassDetail.classRoom" /></td>
												<td><s:property value="#engclassDetail.userCount" /></td>
												<td><s:property value="#engclassDetail.teacherId" /></td>
												<td><s:property value="#engclassDetail.teacherName" /></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
								<div class="row">
			                    	<div  class="btn-toolbar pull-right">
				                        <div class="btn-group">
				                        	<s:if test="#request.pageContainer.currentPageNo == 1">
				                        		<a class="btn btn-default disabled" type="button" href="allEngclasses.action?pageContainer.currentPageNo=<s:property value="#request.pageContainer.currentPageNo - 1" />">上一页</a>
				                        	</s:if>
				                        	<s:else>
				                        		<a class="btn btn-default" type="button" href="allEngclasses.action?pageContainer.currentPageNo=<s:property value="#request.pageContainer.currentPageNo - 1" />">上一页</a>
				                        	</s:else>
				                        	<s:bean name="org.apache.struts2.util.Counter" var="counter">
									            <s:param name="first" value="1" />
									            <s:param name="last" value="#request.pageContainer.pageCount" />
									            <s:iterator>
									            	<s:if test="#request.pageContainer.currentPageNo == #counter.current - 1">
									            		<a class="btn btn-default active" type="button"><s:property /></a>
									            	</s:if>
									            	<s:else>
									            		<a class="btn btn-default" type="button" href="allEngclasses.action?pageContainer.currentPageNo=<s:property />"><s:property /></a>
									            	</s:else>
									           	</s:iterator>
									        </s:bean>
									        <s:if test="#request.pageContainer.currentPageNo == #request.pageContainer.pageCount">
				                          		<a class="btn btn-default disabled" type="button" href="allEngclasses.action?pageContainer.currentPageNo=<s:property value="#request.pageContainer.currentPageNo + 1" />">下一页</a>
				                        	</s:if>
				                        	<s:else>
				                          		<a class="btn btn-default" type="button" href="allEngclasses.action?pageContainer.currentPageNo=<s:property value="#request.pageContainer.currentPageNo + 1" />">下一页</a>
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

			<!-- footer -->
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
	<!-- jQuery -->
    <script src="../vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
</body>
</html>

