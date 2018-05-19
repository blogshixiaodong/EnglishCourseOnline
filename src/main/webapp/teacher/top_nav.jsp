<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top_nav</title>
</head>
<body>
	<!-- top navigation -->
	<div class="top_nav">
		<div class="nav_menu">
			<nav>
				<div class="nav toggle">
					<a id="menu_toggle"><i class="fa fa-bars" target="left"></i></a>
				</div>
	
				<ul class="nav navbar-nav navbar-right">
					<li class="">
						<a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
							<s:property value="#session.teacher.teacherName"/>
							<span class=" fa fa-angle-down"></span>
						</a>
						<ul class="dropdown-menu dropdown-usermenu pull-right">
							<!--  
								<li><a href="javascript:;">Profile</a></li>
								<li><a href="javascript:;"><span class="badge bg-red pull-right">50%</span> <span>Settings</span></a></li>
								<li><a href="javascript:;">Help</a></li>
							-->
							<li><a href="teacherLogout.action"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
						</ul>
					</li>
					<li>
						<a href="../index.html" class="user-profile dropdown-toggle">回到首页</a>
					</li>
					<!-- envelope list -->
					<!-- 
						<li role="presentation" class="dropdown">
							<a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
								<i class="fa fa-envelope-o"></i> 
								<span class="badge bg-green">6</span>
							</a>
							<ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
								<li>
									<a>
										<span class="image"><img src="../build/images/img.jpg" alt="Profile Image" /></span>
										<span><span>John Smith</span> <span class="time">3 mins ago</span></span> 
										<span class="message"> Film festivals used to be do-or-die moments for movie makers. They were where... </span>
									</a>
								</li>
								
							</ul>
						</li>
					 -->
				</ul>
			</nav>
		</div>
	</div>
	<!-- /top navigation -->
</body>
</html>