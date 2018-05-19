<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
</head>
<body>
	<div class="left_col scroll-view">
		<div class="navbar nav_title" style="border: 0;">
			<a href="index.html" class="site_title"><i class="fa fa-paw"></i>
				<span>后台管理</span> 
			</a>
		</div>
	
		<div class="clearfix"></div>
	
		<!-- menu profile quick info -->
		<div class="profile clearfix">
			<div class="profile_pic">
				<img src="../build/images/img.jpg" alt="..." class="img-circle profile_img">
			</div>
			<div class="profile_info">
				<span>欢迎管理员</span>
			</div>
		</div>
		<!-- /menu profile quick info -->
	
		<br />
	
		<!-- sidebar menu -->
		<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
			<div class="menu_section">
				<h3>General</h3>
				<ul class="nav side-menu">
					<li>
						<a><i class="fa fa-home"></i>课程管理
						<span class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<li><a href="all_courses.jsp">所有课程</a></li>
							<li><a href="index.jsp">进行中的课程</a></li>
							<li><a href="add_course.jsp">添加课程基本信息</a></li>
						</ul>
					</li>
					<li>
						<a><i class="fa fa-edit"></i>班级管理
						<span class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<li><a href="setup_engclass.jsp">开设班级</a></li>
							<li><a href="merge_engclass.jsp">合并班级</a></li>
							<li><a href="split_engclass.jsp">拆分班级</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!-- /menu footer buttons -->
			<div class="sidebar-footer hidden-small">
				<a data-toggle="tooltip" data-placement="top" title="Settings"> 
					<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
				</a> 
				<a data-toggle="tooltip" data-placement="top" title="FullScreen">
					<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
				</a> 
				<a data-toggle="tooltip" data-placement="top" title="Lock"> 
					<span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
				</a> 
				<a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
					<span class="glyphicon glyphicon-off" aria-hidden="true"></span>
				</a>
			</div>
			<!-- /menu footer buttons -->
		</div>
		<!-- /sidebar menu -->
	</div>

</body>
