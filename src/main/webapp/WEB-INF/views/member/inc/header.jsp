<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- header -->
        <header>

            <!-- 상단메뉴 -->
            <div id="headerlink">
                <a href="#" class="headerlink-item">마이페이지</a>
                <a href="#" class="headerlink-item">로그아웃</a>
                <a href="#" class="headerlink-item">회원가입</a>
                <a href="#" class="headerlink-item">호스트되기</a>
                <a href="#" class="headerlink-item">예약확인</a>
                <a href="#" class="headerlink-item">게시판</a>
                <a href="#" class="headerlink-item last">고객센터</a>
            </div>


            <!-- 로고 및 캐릭터 -->
            <img src="/bnna/resources/image/logo.png" id="logo">

            <div class="header-search">
                <input type="text" id="location" placeholder="위치 선택">
                <input type="date" id="checkin" >
                <input type="date" id="checkout">
                <input type="text" id="guest" placeholder="게스트 추가" class="last">

                <button class="btn-search">
                    <span class="glyphicon glyphicon-search"></span>
                </button>
            </div>


        </header>