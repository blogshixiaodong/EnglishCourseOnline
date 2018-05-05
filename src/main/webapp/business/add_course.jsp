<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>教师后台管理</title>
	<link rel="icon" href="images/favicon.ico" type="image/ico" />
    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    
    <!-- file input -->
    <link href="../build/css/fileinput.css" rel="stylesheet" />
    
    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet" />
</head>
<body class="nav-md">
	 <s:if test="#request.pageContainer == null">
		<s:action name="nowCourses" namespace="/teacher">
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
          		<div class="">
            	<div class="page-title">
	              	<div class="title_left">
	                	<h3>课程管理</h3>
	              	</div>
	        	</div>
            	<div class="clearfix"></div>

            	<div class="row">
              		<div class="col-md-12 col-sm-12 col-xs-12">
                		<div class="x_panel">
                  			<div class="x_title">
                    			<h2>课程添加</h2>
                   				<ul class="nav navbar-right panel_toolbox">
                     					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                     					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
				                        <ul class="dropdown-menu" role="menu">
					                        <li><a href="#">Settings 1</a></li>
					                        <li><a href="#">Settings 2</a></li>
				                        </ul>
                     					</li>
                     					<li><a class="close-link"><i class="fa fa-close"></i></a></li>
                   				</ul>
                   				<div class="clearfix"></div>
                  			</div>
                  			<div class="x_content">
                    			<form class="form-horizontal form-label-left" novalidate >
				                    <div class="item form-group">
				                    	<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">课程名称 <span class="required">*</span></label>
				                        <div class="col-md-6 col-sm-6 col-xs-12">
				                        	<input id="name" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="name" required="required" type="text" />
				                        </div>
				                    </div>
	                      			<div class="item form-group">
	                        			<label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">课程类别 <span class="required">*</span></label>
				                        <div class="col-md-6 col-sm-6 col-xs-12">
				                        	<input type="email" id="email" name="email" required="required" class="form-control col-md-7 col-xs-12" />
				                        </div>
	                      			</div>
	                      			<div class="item form-group">
	                        			<label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">课程价格 <span class="required">*</span></label>
				                        <div class="col-md-6 col-sm-6 col-xs-12">
				                        	<input type="email" id="email" name="email" required="required" class="form-control col-md-7 col-xs-12" />
				                        </div>
	                      			</div>
	                     			<div class="item form-group">
	                        			<label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">详细信息<span class="required">*</span></label>
				                        <div class="col-md-6 col-sm-6 col-xs-12">
				                        	<input type="email" id="email2" name="confirm_email" data-validate-linked="email" required="required" class="form-control col-md-7 col-xs-12" />
				                        </div>
	                      			</div>
									<!--  img upload
		                      			<div class="item form-group"> 
							                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">图片预览<span class="required">*</span></label>
											<div class="col-xs-7"> 
												<input id="testlogo" type="file" name="icoFile" class="file-loading" /> 
												<input type="text" name="htestlogo" id="htestlogo" onchange="addFile(this)" > 
											</div> 
						            	</div> 
		                      		-->
	                      			<div class="ln_solid"></div>
				                    <div class="form-group">
				                    	<div class="col-md-6 col-md-offset-3">
				                        	<button type="submit" class="btn btn-primary">Cancel</button>
				                            <button id="send" type="submit" class="btn btn-success">Submit</button>
				                        </div>
				                    </div>
					            	
                    			</form>
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
    <!-- fileinput -->
    <script src="../build/js/fileinput.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    
    
    <script type="text/javascript"> 
   
	</script>
</body>
</html>

