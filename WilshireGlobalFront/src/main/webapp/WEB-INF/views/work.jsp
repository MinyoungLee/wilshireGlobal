<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WILSHIRE GROBAL</title>
<script src="resources/js/jquery-1.7.1.min.js"  type="text/javascript"></script>
<script src="resources/js/jquery.easing.1.3.js"  type="text/javascript"></script>
<script src="resources/js/lightbox.js"  type="text/javascript"></script>
<link href="resources/css/common.css" rel="stylesheet">
<link href="resources/css/lightbox.css" rel="stylesheet">
<style>
.aside{background: url(resources/images/nav3_aside.jpg)no-repeat;background-size: contain}
</style>
</head>
<body>
   <div id="wrap">
	  <div class="fix_cont">
		  <header><h1 class="logo"><a href="/front/home"></h1></a></header>
			<nav class="nav">
				<ul>
					<li><h3>HOME</h3></li>
					<li><h3>COMPANY</h3></li>
					<li><h3>WORK</h3></li>
					<li><h3>CONTACT</h3></li>
				</ul>
			</nav>
		  	<div class="menu_box" style="top:0">
				<div class="menu">
					<ul>
						<li><a href="/front/home">WILSHIRE</a></li>
					</ul>
				</div>
				<div class="menu">
					<ul>
						<li><a href="/front/introduce">Introduction</a></li>
							<li><a href="/front/ci">Corporate Identity</a></li>
							<li><a href="/front/vision">Vision&amp;Business</a></li>
							<li><a href="/front/achievement">Achievement</a></li>
							<li><a href="/front/group">Group</a></li>
					</ul>
				</div>
				<div class="menu">
					<ul>
						<li><a href="/front/work?workType=1">Conference</a></li>
						<li><a href="/front/work?workType=2">Exhibition</a></li>
						<li><a href="/front/work?workType=3">Convention</a></li>
						<li><a href="/front/work?workType=4">Design</a></li>
					</ul>
				</div>
				<div class="menu">
					<ul>
						<li><a href="/front/contact">Contact</a></li>
					</ul>
				</div>	
			</div>
		</div><!--	fix_cont  -->
		<aside><div class="aside"></div></aside>

      <article>
      	<div>
      	</div>
		  	<div class="img_list">
				<ul>
	 		      	<c:forEach items="${selectFrontWorkList}" var="list">
						<li>
							<a href="http://localhost:8081/front/profile/${list.imgDate}/${list.imgOriginalName}/${list.imgType}" data-lightbox="image-1" data-title="
		                		<h4>${list.name}</h4>
							 	<dl>
		                  			<dt>Client</dt><dd>${list.client}</dd>
							   		<dt>Date</dt><dd>${list.start_dt}~${list.end_dt}</dd>
		                  			<dt>Location</dt><dd>${list.location}</dd>
		                		</dl>
							">
							<img src="http://localhost:8081/front/profile/${list.imgDate}/${list.imgOriginalName}/${list.imgType}" id="imgView">
							<div class="tit_box">
								<p>${list.caption}</p>
							</div>
						</a>
						</li>
					</c:forEach>
				</ul>
		  </div>
      </article>

     <footer></footer>
   </div> 
	

	<script>
	$(document).ready(function() {
		$('.nav, .menu_box').hover(function() {
			$('.menu_box').stop().animate({
				top : [190, 'easeOutBounce']
			}, 1000);
		}, function() {
			$('.menu_box').stop().animate({
				top : [0, 'easeOutBounce']
			}, 1000)
		});
	}); 
	
	lightbox.option({
      'showImageNumberLabel': false,
      'resizeDuration': 500,
      /* 'maxWidth':700, */
      'maxHeight': 700
    })

		
	
	</script>

</body>
		
	
</html>

