<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>添加反馈信息</title>
    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
	<link href="../vendors/bootstrap-select/bootstrap-select.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
</head>
<body class="nav-md">
	<s:if test="#request.engclassDetailList == null">
		<s:action name="engclassList" namespace="/teacher"></s:action>
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
					<div class="col-md-12 col-xs-12">
						<div class="x_panel">
							<div class="x_title">
								<h2>选择班级</h2>
								<ul class="nav navbar-right panel_toolbox">
									<li>
										<a class="collapse-link">
											<i class="fa fa-chevron-up"></i>
										</a>
									</li>
									<li class="dropdown">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
											<i class="fa fa-wrench"></i>
										</a>
										<ul class="dropdown-menu" role="menu">
											<li><a href="#">Settings 1</a></li>
											<li><a href="#">Settings 2</a></li>
										</ul>
									</li>
									<li>
										<a class="close-link"><i class="fa fa-close"></i></a>
									</li>
								</ul>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<br />
								<form class="form-horizontal form-label-left input_mask" onsubmit="return false;" >

									<div class="col-md-3 col-sm-3 col-xs-12 form-group">  
					                    <select id="engclassList" class="selectpicker show-tick" title="请选择班级" data-live-search="true" data-size="5">
					                        <s:iterator value="#request.engclassDetailList" status="i" var="engclass">
					                        	<option><s:property value="#engclass.classId " /> : <s:property value="#engclass.className" /></option>
					                        </s:iterator>
					                    </select>  
				                	</div> 
									<div class="col-md-2 col-sm-2 col-xs-12 form-group has-feedback form-group">
										<button class="btn btn-primary" id="reset">重置查询</button>
		                     		</div>
								</form>
							</div>
						</div>
					</div>	
				</div>
					
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class=" x_panel">
							<div class="x_title">
			                  <h2>班级成员列表</h2>
			                  <ul class="nav navbar-right panel_toolbox">
			                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
			                    </li>
			                    <li class="dropdown">
			                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
			                      <ul class="dropdown-menu" role="menu">
			                        <li><a href="#">Settings 1</a>
			                        </li>
			                        <li><a href="#">Settings 2</a>
			                        </li>
			                      </ul>
			                    </li>
			                    <li><a class="close-link"><i class="fa fa-close"></i></a>
			                    </li>
			                  </ul>
			                  <div class="clearfix"></div>
			                </div>
			               
			                <!-- content begin-->
			                <div class="x_content">
				                <div class="row">
				                	<div class="col-md-5 col-sm-5 col-xs-12">
										<div class="table-responsive">
											<table id="userList" class="table table-striped jambo_table bulk_action">
				                        		<thead>
				                          			<tr class="headings">
							                            <th>
							                              <input type="checkbox" id="check-all" class="flat">
							                            </th>
							                            <th class="column-title">用户编号</th>
							                            <th class="column-title">用户名称</th>
							                            <th class="bulk-actions" colspan="7">
							                              <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
							                            </th>
						                          	</tr>
						                        </thead>
				
				                        		<tbody>
							                       	<!-- get data by ajax -->
				                        		 </tbody>
				                       		</table>
				                       		
				                       	</div>
				                	</div>
			                	
				                	<div class="col-md-7 col-sm-7 col-xs-12">
				                		<div>
											<div class="form-group">
							                    <label class="control-label col-md-1 col-sm-1 col-xs-12">反馈内容</label>
							                    <div class="col-md-11 col-sm-11 col-xs-12">
							                    	<textarea id="backInfo" rows="15" class="resizable_textarea form-control" placeholder="信息反馈..."></textarea>
							                    	<br />
							                    	<button id="backInfoSubmit" type='button' class='btn btn-success btn-sm'>提交反馈</button>
				                       				<button id="backInfoReset" type='button' class='btn btn-success btn-sm'>重置</button>
							                    </div>
						                  	</div>
										</div>
				                	</div>
				                </div>
			                </div>
			                <!-- content over!  -->
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
    <!-- iCheck -->
    <script src="../vendors/iCheck/icheck.min.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../vendors/moment/min/moment.min.js"></script>
    <script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- bootstrap-select -->
    <script src="../vendors/bootstrap-select/bootstrap-select.min.js"></script> 
    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
   
    <script type="text/javascript">
    
    	function reset() {
    		document.getElementById("engclassList").options.selectedIndex = 0;
			$("#engclassList").selectpicker('refresh');
			$("#userList tbody").html("");
    	}
    	
    	function sendCondition(e) {
    		$("#userList tbody").html("");
    		var engclassId = $("#engclassList").val().split(" : ")[0];
    		if(engclassId === "") {
    			return;
    		}
    		$.ajax({
    			url: "../user/queryUserByClassid.action",
    			type : "post",
    			dataType: "json",
    			data:{"engclassId" : engclassId},
    			success: function(responseText) {
    				//JSON对象转JavaScript对象
    				var json = JSON.parse(responseText);
    				for(var i = 0; i < json.length; i++) {
    					var tr;
    					if(i % 2 == 0) {
    						tr = $("<tr class='odd pointer'></td>");
    					} else {
    						tr = $("<tr class='even pointer'></td>");
    					}
    					var record = json[i];
    					tr.append($("<td class='a-center '><input type='checkbox' class='flat' name='table_records'></td>"));
    					tr.append($("<td></td>").text(record["userId"]));
    					tr.append($("<td></td>").text(record["username"]));
    					$("#userList tbody").append(tr);		
    				}
    			},
    			error: function(XMLHttpRequest, textStatus, errorThrown) {
    				alert("查询失败，请重新输入!");
    				reset();
    			}
    		});
    	}
		$("#engclassList").change(sendCondition);
		
		$("#backInfoSubmit").click(function() {
			var userIdList = new Array();
			var backInfo = $("#backInfo").val();
			if($("#check-all").is(':checked')) {
				//全体成员
				userIdList.push(-1);
			} else {
				//个别对象
				var children = $("#userList tbody").children();
				for(var i = 0; i < children.length; i++) {
					var userId = $(children[i]).children().eq(1).html();
					var checkbox = $(children[i]).find("input");
					if($(checkbox).is(":checked")) {
						userIdList.push(userId);
					}
				}
			}
			if(userIdList.length == 0 || backInfo === "") {
				alert("信息不完整,无法提交!");
				return ;
			}
			var classId = $("#engclassList").val().split(" : ")[0];
			$.ajax({
				url: "insertBackInfo.action",
				type: "post",
				data: {
					"engclassId" : classId,
					"userIdList" : userIdList,
					"backInfo": backInfo
				},
				dataType: "text",
				success : function(msg) {
					alert("提交成功!");
					window.location.href="back_info_history.jsp";
				},
				error : function(data){
		     		alert(data);
			   	}
				
			});
			
		});
		
		$("#backInfoReset").click(function() {
			$("#backInfo").val("");
		});
		

		$("#reset").click(function() {
			reset();
		});
	</script>
</body>
</html>

