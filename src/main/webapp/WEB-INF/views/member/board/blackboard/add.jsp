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
		추가
	</div>
	<hr style="margin-top: -5px;">
	<!-- 여기까지 menu path -->

	<!-- 본인 작업 -->
	<h1 class="board-title">신고게시판 <small>Blacklist Board</small></h1>

	<form method="POST" action="/bnna/member/board/blackboard/addok.action" enctype="multipart/form-data">
	
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td>
					<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요." maxlength=100>
				</td>
			</tr>
			<tr>
				<th>
					신고대상회원
					<button type="button" class="btn btn-default" id="btnSearch"><span class="glyphicon glyphicon-search"></span></button>				
				</th>
				<td>
					<span>홍길동(hong12)</span>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요." maxlength=1000></textarea>
				</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td>
					<button type="button" class="btn btn-success" onclick="$('#image').click();">파일 선택</button>
					<input type="file" id="image" name="image" multiple="multiple">
					<div id="imagename"></div>
				</td>
			</tr>
		</table>
	
		<div class="btns">
			<button type="submit" class="btn btn-primary">작성</button>
			<button type="button" class="btn btn-warning" onclick="location.href='/bnna/member/board/blackboard/list.action';">취소</button>
		</div>
		
	</form>

	<!-- searchModal -->
	<div class="modal fade" id="searchModal" tabindex="-1" role="dialog"
		aria-labelledby="searchModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">신고대상회원 검색</h4>
				</div>
				<div class="modal-body">
				
					<div class="form-inline" style="text-align: right;">
						<select class="form-control">
							<option>이름</option>
							<option>아이디</option>
						</select>
						<input type="text" class="form-control" id="keyword" name="keyword">
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
					</div>
					
					<table class="table table-hover">
						<thead>
							<tr>
								<th>선택</th>
								<th>아이디</th>
								<th>이름</th>								
							</tr>						
						</thead>
						<tbody>
							<tr>
								<td><input type="radio" id="select1" name="select" value="회원번호"></td>
								<td><label for="select1">hong12</label></td>
								<td><label for="select1">홍길동</label></td>
							</tr>
							<tr>
								<td><input type="radio" id="select2" name="select" value="회원번호"></td>
								<td><label for="select2">amugae</label></td>
								<td><label for="select2">아무개</label></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">선택</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>

</section>

<script src="/bnna/resources/js/blackboard.js"></script>
