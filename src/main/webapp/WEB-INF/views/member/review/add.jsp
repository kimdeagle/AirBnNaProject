<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- menu path - 메뉴 경로 표기 -->
<section class="contentsection page-start">
	<div id="menupath">
	   	리뷰게시판
	   	<span class="glyphicon glyphicon-menu-right" style="position:static; z-index: -1;"></span>
	   	작성하기
	</div>
	<hr style="margin-top: -5px;">
	<!-- 여기까지 menu path -->
	<form method="POST" action="/bnna/member/review/addok.action" enctype="multipart/form-data">
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td colspan="3"><input type="text" class="form-control" id="title" name="title"></td>
			</tr>
			<tr>
				<th>주문번호</th>
				<td>
					<select class="form-control" aria-label="Default select example">
				  		<option selected>Open this select menu</option>
					  	<option value="1">One</option>
					  	<option value="2">Two</option>
					  	<option value="3">Three</option>
					</select>
				</td>
				<th>비밀글</th>
				<td><input type="checkbox" value="0"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><textarea class="form-control" id="content" name="content"></textarea></td>
			</tr>
			<tr>
				<th>리뷰사진</th>
				<td colspan="3"><input type="file" class="form-control" id="reviewpic" name="reviewpic" multiple="multiple"></td>
			</tr>
		</table>
		<input type="submit" class="btn-general" value="작성하기">
	</form>
</section>