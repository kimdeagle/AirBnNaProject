<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/bnna/resources/css/admin-tripinfo.css">

<section class="mainsection">

	<div id="menupath">
		게시판 <span class="glyphicon glyphicon-menu-right"
			style="position: static; z-index: -1;"></span> 여행정보 게시판 <span
			class="glyphicon glyphicon-menu-right"
			style="position: static; z-index: -1;"></span> 상세보기
	</div>
	<hr>
	<!-- 여기까지 menu path -->

	<article>

		<h1>여행정보 게시판</h1>


		<div class="viewarea">

			<div class="subject">[여행정보제목] 제목입니다.</div>
			<div class="btnarea">
				<button class="btn btn-list">목록으로</button>
				<button class="btn link">스크랩</button>
			</div>

			<div class="imgarea">
				<div class="background">
					<span class="glyphicon glyphicon-chevron-left"></span> <img
						src="/image/tripplan/1.jpg" alt=""> <span
						class="glyphicon glyphicon-chevron-right"></span>
				</div>
			</div>

			<div class="content">글 내용입니다. 어쩌구 저쩌구입니다. 글 내용입니다. 어쩌구 저쩌구입니다.
				글 내용입니다. 어쩌구 저쩌구입니다. 글 내용입니다. 어쩌구 저쩌구입니다. 글 내용입니다. 어쩌구 저쩌구입니다. 글
				내용입니다. 어쩌구 저쩌구입니다. 글 내용입니다. 어쩌구 저쩌구입니다. 글 내용입니다. 어쩌구 저쩌구입니다.</div>


			<div class="related">
				관련 글 보기
				<button class="btn btn-related">답글쓰기</button>

				<table class="table tbl-related">
					<tr>
						<td><a href="#">관련글 제목입니다. 어쩌구 저쩌구</a></td>
						<td>2021-03-13</td>
					</tr>
				</table>

			</div>

			<div class="cmtarea">
				댓글
				<table class="table tbl-cmt">
					<tr>
						<td rowspan="2" class="pic">
							<div class="crop">
								<img src="/image/annface.jpg" alt="">
							</div>
						</td>
						<td class="id small">anna123</td>
						<td></td>
						<td class="regdate small">2021-02-02 11:11:11</td>
					</tr>
					<tr>
						<td colspan="2" class="ccontent noborder">댓글내용입니다롱</td>
						<td class="btn-del noborder"><span>[삭제]</span></td>
					</tr>
				</table>

				<div class="cmt-write">
					<textarea class="form-control" id="ccontent" name="ccontent"
						required placeholder="댓글을 남겨보세요." cols="30" rows="5"></textarea>
					<div id="comment_cnt">(0 / 100)</div>
				</div>

				<button type="submit" class="btn btn-cmt">등록</button>
				<div style="clear:both;"></div>

                    </div>

                    

                </div>

	</article>

</section>