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
    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet" />
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

					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>进行中的课程</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li>
										<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
									</li>
									<li>
										<a class="close-link"><i class="fa fa-close"></i></a>
									</li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<table id="courseTable" class="table">
									<thead>
										<tr>
											<th>课程编号</th>
											<th>课程名称</th>
											<th>课程信息</th>
											<th>课程类型</th>
											<th>开课时间</th>
											<th>结课时间</th>
										</tr>
									</thead>
									<tbody>
										<!-- create after page load -->
									</tbody>
								</table>
								<div class="row">
			                    	<div class="btn-toolbar pull-right">
				                        <div id="btnGroup" class="btn-group">
				                        	<!-- create after page load -->
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
    <script src="../build/js/common.js"></script>

    <script type="text/javascript">
	  	$(function() {
    		$.ajax({
        		url: "nowCourses.action",
        		type: "post",
        		data: {
        			"pageContainer.currentPageNo": 1,
        			"pageContainer.pageSize": 3
        		},
        		dataType: "json",
        		success: function(responseText) {
        			var json = JSON.parse(responseText);
        			var tbody = $("#courseTable tbody");
					
        			//创建表格
        			for(var i = 0; i < json.list.length; i++) {
        				var course = json.list[i];
        				//一门课程存在多个课程记录
        				var courseRecordSet = course.courseRecordSet;
        				for(var j = 0; j < courseRecordSet.length; j++) {
        					var courseRecord = courseRecordSet[j];
            				var courseId = $("<td></td>").html(course.courseId);
            				var courseName = $("<td></td>").html(course.courseName);
            				var info = $("<td></td>").html(course.info);
            				var types = $("<td></td>").html(course.types);
        					var startTime = $("<td></td>").html(JsonDateToString(courseRecord.startTime));
            				var endTime = $("<td></td>").html(JsonDateToString(courseRecord.endTime));
            				var tr = $("<tr></tr>");
            				tr.append(courseId);
            				tr.append(courseName);
            				tr.append(info);
            				tr.append(types);
            				tr.append(startTime);
            				tr.append(endTime);
            				tbody.append(tr);
        				}
        			}
        			
        			//创建按钮组
        			var btnGroup = $("#btnGroup");
        			var currentPageNo = json.currentPageNo;
        			var pageCount = json.pageCount;
        			
        			var recordCount = json.recordCount;
        			if(currentPageNo == 1) {
        				btnGroup.append($("<button class='btn btn-default disabled' pageNo='1'>上一页</button>"));
        			} else {
        				btnGroup.append($("<button class='btn btn-default' pageNo='1'>上一页</button>"));
        			}
        			for(var i = 1; i <= pageCount; i++) {
        				btnGroup.append($("<button class='btn btn-default disabled' pageNo='" + i  +"'>" + i + "</button>"));
        			}
        			if(currentPageNo == pageCount) {
        				btnGroup.append($("<button class='btn btn-default disabled' pageNo='" + currentPageNo  +"'>下一页</button>"));
        			} else {
        				btnGroup.append($("<button class='btn btn-default' pageNo='" + currentPageNo  +"'>下一页</button>"));
        			}
        		}
        	});
    		
    	});
    	
    /*	function initTable() {  
            //先销毁表格  
            $('#courseTable').bootstrapTable('destroy');  
            //初始化表格,动态从服务器加载数据  
            $("#courseTable").bootstrapTable({  
                method: "get",  //使用get请求到服务器获取数据  
                url: "nowCourses.action", //获取数据的Servlet地址  
                striped: true,  //表格显示条纹  
                pagination: true, //启动分页  
                pageSize: 5,  //每页显示的记录数  
                pageNumber:1, //当前第几页  
                pageList: [5, 10, 15, 20, 25],  //记录数可选列表  
                search: false,  //是否启用查询  
                showColumns: true,  //显示下拉框勾选要显示的列  
                showRefresh: true,  //显示刷新按钮  `
                sidePagination: "server", //表示服务端请求  
                //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
                //设置为limit可以获取limit, offset, search, sort, order  
                queryParamsType : "undefined",   
                queryParams: function queryParams(params) {   //设置查询参数  
                  var param = {    
                      "pageContainer.currentPageNo": params.pageNumber,
                      "pageContainer.pageSize": params.pageSize
                  };    
                  return param;                   
                },  
                onLoadSuccess: function(){  //加载成功时执行  
                  alert("success");
                },  
                onLoadError: function(){  //加载失败时执行  
                  alert("fail");
                }  
              });  
          }  
      
          $(document).ready(function () {          
              //调用函数，初始化表格  
              initTable();  
      
              //当点击查询按钮的时候执行  
              $("#search").bind("click", initTable);  
          });  */

    </script>
</body>
</html>

