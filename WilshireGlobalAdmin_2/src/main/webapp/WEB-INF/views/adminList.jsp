<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>WILSHIRE GLOBAL KOREA ADMIN</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- The styles -->
<link id="bs-css" href="resources/css/bootstrap-cerulean.min.css" rel="stylesheet">

<link href="resources/css/charisma-app.css" rel="stylesheet">
<link href='resources/css/jquery.noty.css' rel='stylesheet'>
<link href='resources/css/noty_theme_default.css' rel='stylesheet'>
<link href='resources/css/elfinder.min.css' rel='stylesheet'>
<link href='resources/css/elfinder.theme.css' rel='stylesheet'>
<link href='resources/css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='resources/css/uploadify.css' rel='stylesheet'>
<link href='resources/css/animate.min.css' rel='stylesheet'>

<!-- jQuery -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- 추가 function -->
<script>
	function insertPortfolio(){
		window.location.href = '/admin/insertForm'; 
	}
	
	// 해당 포트폴리오 삭제
	function deleteData(number){
		var boardNo = number;
		var confirmDelete = confirm("Are you sure you want to do this??");
		if(confirmDelete){
			$.ajax({
			    url : "/admin/adminDelete"
			   ,dataType : "json"
			   ,data: {boardNo : boardNo}
			   ,type:"GET"
			}).done(function(data) {
				if(data="success"){
					alert("해당 건이 삭제되었습니다.");
					location.reload();
				}else{
					alert("삭제 중 오류가 발생하였습니다.");
				}
			})
		}else{
			alert("Ok, you should confirm before delete!");
		}
	}
	
	function detailData(number){
		var boardNo = number;
 		window.location.href = '/admin/detailDataList?boardNo='+boardNo; 
	}
</script>


<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->
<link rel="shortcut icon" href="resources/img/browser_logo.jpg">

</head>

<body>
	<!-- topbar starts -->
	<div class="navbar navbar-default" role="navigation">

		<div class="navbar-inner">
			<button type="button" class="navbar-toggle pull-left animated flip">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/admin/adminList"> 
				<img alt="Wilshire Logo" src="resources/img/wilshire_log.png" class="hidden-xs"/>
            </a>
		</div>
	</div>
	<!-- topbar ends -->
	<div class="ch-container">
		<div class="row">
			<div id="content" class="col-lg-12 col-sm-12">
				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-content">
								<div class="alert alert-info">
									<button class="btn btn-info btn-xs" onclick="javascript:insertPortfolio();">INSERT</button>
								</div>
								<table
									class="table table-striped table-bordered bootstrap-datatable datatable responsive">
									<thead>
										<tr>
											<th class="center">ID Number</th>
											<th class="center">Username</th>
											<th class="center">Date registered</th>
											<th class="center">Role</th>
											<th class="center">Status</th>
											<th class="center">Actions</th>
										</tr>
									</thead>
									<tbody id="tbodyId">
									<c:forEach items="${selectAdminList}" var="list">
										<tr>
											<td class="center">${list.boardNo}</td>
											<td class="center">${list.name}</td>
											<td class="center">${list.created_datetime}</td>
											<td class="center">${list.client}</td>
											<td class="center">
											<span class="label-success label label-default">${list.scale}</span></td>
											<td class="center">
												<a class="btn btn-info" onclick="javascript:detailData(${list.boardNo});"> 
													View
												</a> 
												<a class="btn btn-danger" onclick="javascript:deleteData(${list.boardNo});"> 
													Delete
												</a>
											</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!--/span-->

				</div>
				<!--/row-->



				<!-- content ends -->
			</div>
			<!--/#content.col-md-0-->
		</div>
		<!--/fluid-row-->


		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">

			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<h3>Settings</h3>
					</div>
					<div class="modal-body">
						<p>Here settings can be configured...</p>
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
						<a href="#" class="btn btn-primary" data-dismiss="modal">Save
							changes</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
