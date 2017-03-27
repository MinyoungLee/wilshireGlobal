<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>WILSHIRE GLOBAL ADMIN</title>
    <!-- The styles -->
    <link href="resources/css/bootstrap-cerulean.min.css" rel="stylesheet">
    <link href="resources/css/charisma-app.css" rel="stylesheet">
    <link href='resources/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='resources/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='resources/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='resources/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='resources/css/uploadify.css' rel='stylesheet'>
    <link href='resources/css/animate.min.css' rel='stylesheet'>
    <!-- jQuery -->
    <script src="resources/bower_components/jquery/jquery.min.js"></script>
	<!-- datepicker 사용을 위한 css.js --> 
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
</head>
<script>
	
	$( document ).ready(function() {
		var workType="${detailVO.workType}";
		if(workType=="1"){
			$("#conference").attr("checked",true);
		}else if(workType="2"){
			$("#exhibition").attr("checked",true);			
		}else if(workType="3"){
			$("#convention").attr("checked",true);
		}else{
			$("#design").attr("checked",true);
		}
		$(".form-control").attr("disabled",true);
		$(".radioButton").attr("disabled",true);
	});
	
	function backAdminList(){
		window.location.href = '/admin/adminList'; 
	}
	
	// datepicker 달력 날짜 선택
	$(function() {
		$("#start_dt").datepicker({
			minDate: 0,
			onSelect: function(selected) {
			 	$("#end_dt").datepicker("option","minDate", selected)
			 }
		});
		
	});
	$(function() {
		$("#end_dt").datepicker({
			minDate: 0, 
			onSelect: function(selected) {
				$("#start_dt").datepicker("option","maxDate", selected)
			}
		});
	});
</script>
<!-- The fav icon -->
<link rel="shortcut icon" href="resources/img/browser_logo.jpg">
<body>
    <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-inner">
			<a class="navbar-brand" href="/admin/adminList"> 
				<img alt="Wilshire Logo" src="resources/img/wilshire_log.png" class="hidden-xs"/>
            </a>
        </div>
    </div>
<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-edit"></i>  행사 내용 입력</h2>
            </div>
            <div class="box-content">
                <form  id="wilshireForm"  name="wilshireForm" enctype="multipart/form-data" method="post">
	                    <div class="form-group">
	                        <label for="name">행사이름</label>
	                        <input type="text" class="form-control" id="name" name="name" value="${detailVO.name}">
	                    </div>
	                    <div class="form-group">
	                        <label for="client">주최</label>
	                        <input type="text" class="form-control" id="client" name="client" value="${detailVO.client}">
	                    </div>
	                    <div class="form-group">
	                        <label for="location">장소</label>
	                        <input type="text" class="form-control" id="location" name="location" value="${detailVO.location}">
	                    </div>
	                    <div class="form-group">
	                        <label for="sclae">규모</label>
	                        <input type="text" class="form-control" id="scale" name="scale" value="${detailVO.scale}">
	                    </div>
	                    <div class="form-group">
	                        <label for="formation">구성</label>
	                    </div>
	                    <div class="form-group">
	                        <textarea rows="20" class="form-control" title="구성내용" id="formation" name="formation" >
	                        ${detailVO.formation}
	                        </textarea>
	                    </div>
	                    <div class="form-group">
	                        <label for="caption">캡션</label>
	                        <input type="text" class="form-control" id="caption" name="caption" value="${detailVO.caption}">
	                    </div>
	                    <div class="form-group">
	                        <label for="caption">날짜</label>
	                        <input type="text" class="form-control" id="start_dt" name="start_dt" value="${detailVO.start_dt}">
	                        <input type="text" class="form-control" id="end_dt" name="end_dt" value="${detailVO.end_dt}">
	                    </div>
	                    <div class="form-group">
	                         <label class="radio-inline">
		                    	<input type="radio" name="workType" id="conference" value="1" class="radioButton"> conference
			                </label>
			                 <label class="radio-inline">
			                    <input type="radio" name="workType" id="exhibition" value="2" class="radioButton"> exhibition
			                 </label>
			                 <label class="radio-inline">
			                    <input type="radio" name="workType" id="convention" value="3" class="radioButton"> convention
			                 </label>
			                 <label class="radio-inline">
			                    <input type="radio" name="workType" id="design" value="4" class="radioButton"> design
			                 </label>
		                </div>
	                    <div class="form-group">
	                        <label for="exampleInputFile">File input</label>
	                        <input type="file" id="uploadFile" name="uploadFile" value="${detailVO.imgOriginalName}" class="form-control">
	                        <p class="help-block">*행사 당 이미지는 하나만 선택 가능합니다*</p>
	                    </div>
						<img src="http://localhost:8082/admin/profile/${detailVO.imgDate}/${detailVO.imgOriginalName}/${detailVO.imgType}" id="imgView">	                    	
	                    <button type="button" class="btn btn-default" onclick="javascript:backAdminList();">목록으로 가기</button>
                </form>

            </div>
        </div>
    </div>
    <!--/span-->

</div><!--/row-->

<script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="resources/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='resources/bower_components/moment/min/moment.min.js'></script>
<script src='resources/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='resources/js/jquery.dataTables.min.js'></script>
<!-- select or dropdown enhancer -->
<script src="resources/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="resources/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- library for making tables responsive -->
<script src="resources/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- star rating plugin -->
<script src="resources/js/jquery.raty.min.js"></script>
<!-- autogrowing textarea plugin -->
<script src="resources/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="resources/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="resources/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="resources/js/charisma.js"></script>
</body>
</html>

