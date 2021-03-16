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
	<h1 class="board-title">신고게시판 <small>Blacklist Board</small></h1>

		
		<!-- 글 상세 정보 -->
		<table class="table table-bordered" id="tblView">
			<tr>
				<th>제목</th>
				<td>
					${dto.title}
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					${dto.name} (${dto.id})
				</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>
					${dto.regdate}
				</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>
					${dto.readcnt}
				</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td>
					<c:if test="${empty ilist}">
						이미지가 없습니다.
					</c:if>
					<c:forEach items="${ilist}" var="image">
						<a href="/bnna/resources/image/board/blackboard/${image.image}" class="imgname" title="다운로드" download>${image.orgimage}</a>					
					</c:forEach>
					
				</td>
			</tr>
			<tr>
				<th>
					신고대상회원				
				</th>
				<td>
					${dto.issueMemberName} (${dto.issueMemberId})
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<c:forEach items="${ilist}" var="image">
						<img src="/bnna/resources/image/board/blackboard/${image.image}" class="insertimg">					
					</c:forEach>
					<div class="content">${dto.content}</div>
				</td>
			</tr>
		</table>
	
		<div class="btns">
			<button type="button" class="btn btn-success" onclick="location.href='/bnna/member/board/blackboard/edit.action?seq=${seq}';">수정</button>
			<button type="button" class="btn btn-danger" onclick="location.href='/bnna/member/board/blackboard/del.action?seq=${seq}';">삭제</button>
			<button type="button" class="btn btn-default" onclick="location.href='/bnna/member/board/blackboard/list.action';">목록</button>
		</div>
		
		<!-- 댓글 -->
		<h3 class="comment-title">댓글 <small>Comment</small></h3>
		<table class="table table-bordered" id="tblComment">
			<thead>
				<tr>
					<th>작성자</th>
					<th>내용</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty clist}">
					<tr><td colspan="3" style="text-align: center;">댓글이 없습니다.</td></tr>
				</c:if>
				<c:forEach items="${clist}" var="cmt">
					<tr>
						<td>${cmt.name} (${cmt.id})</td>
						<td>${cmt.content}</td>
						<td>${cmt.regdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

</section>



