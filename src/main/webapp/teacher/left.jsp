<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<span>欢迎教师,</span>
				<h2>管理员名称</h2>
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
						<a><i class="fa fa-home"></i>课程查看
						<span class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<li><a href="nowCourses.action">进行课程信息</a></li>
							<li><a href="historyCourses.action">历史课程记录</a></li>
							<li><a href="allCourses.action">所有课程记录</a></li>
						</ul>
					</li>
					<li>
						<a><i class="fa fa-edit"></i>班级查看
						<span class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<li><a href="searchEngclass.jsp">班级查询</a></li>
							<li><a href="allEngclasses.action">所有班级</a></li>
						</ul>
					</li>
					<li>
						<a><i class="fa fa-desktop"></i>学生查看
						<span class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<li><a href="search_user.jsp">学生查询</a></li>
						</ul>
					</li>
					<li>
						<a>
							<i class="fa fa-table"></i>考勤信息
							<span class="fa fa-chevron-down"></span>
						</a>
						<ul class="nav child_menu">
							<li><a href="tables.html">考勤记录</a></li>
							<li><a href="tables_dynamic.html">考勤登记</a></li>
						</ul>
					</li>
					<li>
						<a>
							<i class="fa fa-bar-chart-o"></i>反馈管理
							<span class="fa fa-chevron-down"></span>
						</a>
						<ul class="nav child_menu">
							<li><a href="back_info_history.jsp">反馈历史</a></li>
							<li><a href="submit_back_info.jsp">教师反馈</a></li>
							<li><a href="chartjs2.html">学生反馈</a></li>
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
