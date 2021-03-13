<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="mainsection">

	<!-- menu path - 메뉴 경로 표기 -->
	<div id="menupath">
		게시판 <span class="glyphicon glyphicon-menu-right"
			style="position: static; z-index: -1;"></span> 여행정보 게시판
	</div>
	<hr>
	<!-- 여기까지 menu path -->

	<article>

		<h1>여행정보 게시판</h1>

		<table class="table tbl-lg">
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<tr>
				<td>1</td>
				<td>제목입니다.</td>
				<td>10</td>
				<td>2021-02-02</td>
			</tr>
		</table>

		<button class="btn-general">안녕</button>
		<button class="btn">안녕</button>

		<div class=pagearea>
			<div class="pagination">
				<a href="#">&laquo;</a> 
				<a href="#">1</a> 
				<a href="#" class="active">2</a>
				<a href="#">3</a> 
				<a href="#">4</a> 
				<a href="#">5</a> 
				<a href="#">6</a>
				<a href="#">&raquo;</a>
			</div>
		</div>


	</article>

</section>