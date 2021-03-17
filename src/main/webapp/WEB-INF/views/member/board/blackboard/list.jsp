<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/bnna/resources/css/blackboard.css">

<section class="contentsection page-start">

	<!-- menu path - 메뉴 경로 표기 -->
	<div id="menupath">
		게시판
		<span class="glyphicon glyphicon-menu-right" style="position: static; z-index: -1;"></span>
		신고게시판
		<span class="glyphicon glyphicon-menu-right" style="position: static; z-index: -1;"></span>
		상세
	</div>
	<hr style="margin-top: -5px;">
	<!-- 여기까지 menu path -->

	<!-- 본인 작업 -->
	<div class="board-title">
		<h1 style="float: left;">신고게시판 <small>Blacklist Board</small></h1>
		
		<!-- 로그인/로그아웃 임시 -->
		<c:if test="${empty seqMember}">
			<button type="button" class="btn btn-default" style="float: right; margin-top: 20px;" onclick="location.href='/bnna/member/board/blackboard/login.action?seqMember=1';">로그인</button>
		</c:if>
		<c:if test="${not empty seqMember}">
			<button type="button" class="btn btn-default" style="float: right; margin-top: 20px;" onclick="location.href='/bnna/member/board/blackboard/logout.action';">로그아웃</button>
		</c:if>
		<div style="clear: both;"></div>
	</div>	
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>
						<a href="/bnna/member/board/blackboard/view.action?seq=${dto.seq}" style="margin-left: ${dto.depth * 30}px;">
							<c:if test="${dto.depth > 0}">
								<span class="glyphicon glyphicon-share-alt"></span>
							</c:if>
							${dto.title}
						</a>
					</td>
					<td>${dto.name}(${dto.id})</td>
					<td>${dto.regdate}</td>
					<td>${dto.readcnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${not empty seqMember}">
		<button type="button" class="btn btn-primary btn-lg" id="btnAdd" onclick="location.href='/bnna/member/board/blackboard/add.action?reply=n';">작성</button>		
	</c:if>
	
</section>
