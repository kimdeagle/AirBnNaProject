<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/bnna/resources/css/tripplan/tpmake.css">
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=55ab69bc871b766267ae1612c1e51daf&libraries=services"></script>

<section class="mainsection">

	<div id="dayarea">
		<!-- 일정 간단 정보 -->
		<div id="dayInfo">
			<p>일정작성</p>
			<p>
				서울 <span class="day">4</span>일
			</p>
			<div class="day-period">
				<span>03.14</span> <span> - </span> <span>03.17</span>
			</div>
		</div>

		<div id="dayContent">
			<!-- 총 며칠간의 여행? -->
			<div id="dayList">

				<div class="dayitem selectAble selected">
					<div class="day-num">
						DAY <span class="num">1</span>
					</div>
					<span class="day-date">03.14</span> <span class="day-day">(일)</span>
				</div>

				<div class="dayitem selectAble">
					<div class="day-num">
						DAY <span class="num">2</span>
					</div>
					<span class="day-date">03.15</span> <span class="day-day">(월)</span>
				</div>
			</div>

			<div class="day-add">DAY 추가</div>
		</div>


	</div>

	<!-- 일정 추가 영역 -->
	<div id="planarea">
		<div id="planHead">
			<span>DAY <span>1</span></span>
			<div>2021.03.14 (일)</div>
		</div>

		<div id="planBody">
			<div id="planDetail">
				<!--                         
                     <div class="scheduleItem">
                         <div class="imgbox">
                             <div class="item_number">1</div>
                             <img src="/image/tripplan/1.jpg" alt="">
                         </div>

                         <div class="contentbox">
                             <p>장소이름1</p>
                             <p>장소종류1</p>
                         </div>

                         <button class="btn btn_del">
                             <span class="glyphicon glyphicon-remove"></span>
                         </button>
                         
                         <div class="btn_box" style="display: none;">
                             <input type="button" class="btn btn-default" data-toggle="modal" data-target="#detailCommonInfo" value="정보보기">
                             <input type="button" class="btn btn-default addScheduleItem" value="일정추가">
                         </div>
                     </div> 
                     -->
			</div>
		</div>
	</div>


	<!-- 지도파트 -->
	<div id="maparea">
		<div id="map"></div>
	</div>

	<!-- 검색창 파트 -->
	<div id="searcharea">
		<div id="searchBody">
			<!--  searchBody -->
			<div id="searchTheme">
				<div class="titleTheme">테마 선택</div>
				<div class="theme_area">
					<button class="nature btn">자연</button>
					<button class="tour btn">관광</button>
					<button class="activity btn">레포츠</button>
					<button class="shopping btn">쇼핑</button>
					<button class="food btn">음식</button>
				</div>
			</div>

			<div id="searchKeyword" class="searchRow">
				<input type="text" placeholder="검색어를 입력하세요."
					class="form-control inline-block" id="searchText" name="keyword">
				<button id="searchBtn" class="inline-block btn" onclick="getData();">
					<span class="glyphicon glyphicon-search"></span>
				</button>
			</div>

		</div>

		<div class="resultInfo">
			<div class="inline-block">
				선택 테마 : <span>자연</span>
			</div>
			<div class="inline-block">
				검색결과 (<span>1</span>건)
			</div>
			<div style="clear: both;"></div>
		</div>

		<div id="searchResult" class="searchRow">
			<!-- resultItem -->
			<div class="resultItem">
				<div class="img_box">
					<img src="/image/tripplan/1.jpg" alt="">
					<div class="item_number" style="display: none;"></div>
				</div>
				<div class="content_box">
					<p class="content_name">장소이름</p>
					<p class="content_type">자연</p>
				</div>
				<button class="btn_del btn" style="display: none;">
					<span class="glyphicon glyphicon-remove deleteScheduleItem"></span>
				</button>
				<div class="btn_box">
					<input type="button" class="btn btn-default" data-toggle="modal"
						data-target="#detailCommonInfo" value="정보보기"> <input
						type="button" class="btn btn-default addScheduleItem" value="일정추가">
				</div>
			</div>

		</div>
		<!-- paging -->
		<div id="paging">
			<nav aria-label="Page navigation">
				<ul id="pagination" class="pagination">페이징구간
				</ul>
			</nav>
		</div>
	</div>




	<!-- 장소 정보보기 Modal -->
	<div class="modal fade" id="detailCommonInfo" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="commonInfoTitle">Modal title</h4>
				</div>
				<div class="modal-body" id="commonInfoBody"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>

	<script src="/bnna/resources/js/tripplan/tpmake.js"></script>

</section>

