<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="contentsection page-start">

	<!-- menu path - 메뉴 경로 표기 -->
	<div id="menupath">
    	게시판
    	<span class="glyphicon glyphicon-menu-right" style="position:static; z-index: -1;"></span>
    	리뷰게시판
	</div>
	<hr style="margin-top: -5px;">
	<!-- 여기까지 menu path -->
                
	<h1>리뷰게시판</h1>

		<button type="button" class="btn-general" onclick="location.href='/bnna/member/review/add.action'">작성하기</button>

		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>예약일</th>
			</tr>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.seq}</td>
			<td>${dto.title}</td>
			<td>${dto.bookdate.substring(0, 10)}</td>
			</tr>
			</c:forEach>
		</table>
	
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

</section class="contentsection">