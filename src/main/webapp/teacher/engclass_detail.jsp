<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>班级详细信息</title>
    <link rel="icon" href="images/favicon.ico" type="image/ico" />
    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
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
					<div class="col-md-12">
                		<div class="x_panel">
                  			<div class="x_title">
                    			<h2>班级详细信息</h2>
                    			<ul class="nav navbar-right panel_toolbox">
                      				<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				                    <li class="dropdown">
					                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
					                    <ul class="dropdown-menu" role="menu">
					                    	<li><a href="#">Settings 1</a></li>
					                        <li><a href="#">Settings 2</a></li>
					                    </ul>
				                    </li>
                     				<li><a class="close-link"><i class="fa fa-close"></i></a></li>
                    			</ul>
                    			<div class="clearfix"></div>
                 				
                 				<br />
                 			
	                 			<div class="row">
			                      		<p>课程信息</p>
			                     		<div class="col-md-3">
			                        		<div class="thumbnail">
				                          		<div class="image view view-first">
					                            	<img style="width: 100%; display: block;" src="<s:property value="#request.engclassDetail.imgUrl" />" alt="image" />
				                          		</div>
				                          		<div class="caption">
						                        	<p>课程预览</p>
						                        </div>
			                        		</div>
		                      			</div>
		                      			<div class="col-md-9">
		                      				<div class="col-md-12 col-sm-12 col-xs-12">
												<div class="x_panel">
													<div class="x_content">
								                    	 
									                    <div>
									                    	<div class="x_content">
									                    		<div>
									                    			<p><i>课程编号: </i><s:property value="#request.engclassDetail.courseId" /></p>
									                    			<p><i>课程名称: </i><s:property value="#request.engclassDetail.courseName" /></p>
									                    			<p><i>教师编号: </i><s:property value="#request.engclassDetail.teacherId" /></p>
									                    			<p><i>教师名称: </i><s:property value="#request.engclassDetail.teacherName" /></p>
								                 				</div>
													
															</div>
														</div>
														<div class="clearfix"></div>
	                  									<!-- left end -->
		                      						</div>
		                      					</div>
		                      				</div>
	                 						<div class="clearfix"></div>
										</div>
									</div>
								<div class="row">
		                      		<p>班级信息</p>
		                     		<div class="col-md-3">
		                        		<div class="thumbnail">
			                          		<div class="image view view-first">
				                            	<img style="width: 100%; display: block;" src="<s:property value="#request.engclassDetail.imgUrl" />" alt="image" />
			                          		</div>
			                          		<div class="caption">
					                        	<p>班级预览</p>
					                        </div>
		                        		</div>
	                      			</div>
	                      			<div class="col-md-9">
	                      				<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="x_panel">
												<div class="x_content">
							                    	
								                    <div>
								                    	<div class="x_content">
								                    		<div>
								                    			<p><i>班级编号: </i><s:property value="#request.engclassDetail.classId" /></p>
								                    			<p><i>班级名称: </i><s:property value="#request.engclassDetail.className" /></p>
								                    			<p><i>班级人数: </i><s:property value="#request.engclassDetail.userCount" /></p>
								                    			<p><i>教室地点: </i><s:property value="#request.engclassDetail.classRoom" /></p>
							                 				</div>
														</div>
													</div>
													<div class="clearfix"></div>
                  									<!-- left end -->
	                      						</div>
	                      					</div>
	                      				</div>
                 						<div class="clearfix"></div>
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

