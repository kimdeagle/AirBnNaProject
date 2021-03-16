<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <link rel="stylesheet" href="/bnna/resources/css/tripplan/tpstart.css">
   
        <section class="mainsection">
            
            <div class="tp-start">
                <div class="title">여행지</div>
                <div class="intro">원하시는 여행지를 목록에서 선택해주세요.</div>

                <div id="category">
                    <span id="all" onclick="javascript:doShowAll()">전체</span>
                    <span id="type1" onclick="javascript:doShow1()">수도권</span>
                    <span id="type2" onclick="javascript:doShow2()">특별·광역시</span>
                    <span id="type3" onclick="javascript:doShow3()">지방</span>
                </div>

                <hr>

                <div id="citylist">

                    <div class="city type1 type2">
                        <div class="crop">
                        <img src="/bnna/resources/image/tripplan/city/서울.jpg">
                        </div>
                        <div class="info">
                            <div class="eng">SEOUL</div>
                            <div class="kor">서울특별시</div>
                            <div class="desc">남산타워,경복궁,명동,남대문</div>
                        </div>
                    </div>

                    <div class="city type1 type2">
                        <div class="crop">
                        <img src="/bnna/resources/image/tripplan/city/인천.jpg">
                        </div>
                        <div class="info">
                            <div class="eng">INCHEON</div>
                            <div class="kor">인천광역시</div>
                            <div class="desc">차이나타운,인천공항,센트럴파크</div>
                        </div>
                    </div>

                    <div class="city type2 type3">
                        <div class="crop">
                        <img src="/bnna/resources/image/tripplan/city/대전.jpg">
                        </div>
                        <div class="info">
                            <div class="eng">DAEJEON</div>
                            <div class="kor">대전광역시</div>
                            <div class="desc">성심당,계룡산,대전오월드</div>
                        </div>
                    </div>

                    <div class="city type2 type3">
                        <div class="crop">
                        <img src="/bnna/resources/image/tripplan/city/대구.jpg">
                        </div>
                        <div class="info">
                            <div class="eng">DAEGU</div>
                            <div class="kor">대구광역시</div>
                            <div class="desc">반곡지,합천영상테마파크,이월드</div>
                        </div>
                    </div>

                    <div class="city type2 type3">
                        <div class="crop">
                        <img src="/bnna/resources/image/tripplan/city/광주.jpg">
                        </div>
                        <div class="info">
                            <div class="eng">GWANGJU</div>
                            <div class="kor">광주광역시</div>
                            <div class="desc">화담숲,시화문화마을,사직공원</div>
                        </div>
                    </div>

                    <div class="city type2 type3">
                        <div class="crop">
                        <img src="/bnna/resources/image/tripplan/city/부산.jpg">
                        </div>
                        <div class="info">
                            <div class="eng">BUSAN</div>
                            <div class="kor">부산광역시</div>
                            <div class="desc">해운대,광안리,센텀시티</div>
                        </div>
                    </div>

                    <div class="city type2 type3">
                        <div class="crop">
                        <img src="/bnna/resources/image/tripplan/city/울산.jpg">
                        </div>
                        <div class="info">
                            <div class="eng">ULSAN</div>
                            <div class="kor">울산광역시</div>
                            <div class="desc">대왕암공원,간절곶,태화강국가정원</div>
                        </div>
                    </div>

                    <div class="city type1">
                        <div class="crop">
                        <img src="/bnna/resources/image/tripplan/city/경기도.jpg">
                        </div>
                        <div class="info">
                            <div class="eng">GYEONGGI</div>
                            <div class="kor">경기도</div>
                            <div class="desc">헤이리,두물머리,수원화성,한국민속촌</div>
                        </div>
                    </div>

                    <div class="city type3">
                        <div class="crop">
                        <img src="/bnna/resources/image/tripplan/city/강원도.jpg">
                        </div>
                        <div class="info">
                            <div class="eng">GANGWON</div>
                            <div class="kor">강원도</div>
                            <div class="desc">대관령양때목장,남이섬,오죽헌</div>
                        </div>
                    </div>

                    <div class="city type3">
                        <div class="crop">
                        <img src="/bnna/resources/image/tripplan/city/충청도.jpg">
                        </div>
                        <div class="info">
                            <div class="eng">CHUNGCHEONG</div>
                            <div class="kor">충청도</div>
                            <div class="desc">꽂지해수욕장,아산온천,해미읍성</div>
                        </div>
                    </div>

                    <div class="city type3">
                        <div class="crop">
                        <img src="/bnna/resources/image/tripplan/city/전라도.jpg">
                        </div>
                        <div class="info">
                            <div class="eng">JEOLLA</div>
                            <div class="kor">전라도</div>
                            <div class="desc">광한루원,전주한옥마을,여수엑스포</div>
                        </div>
                    </div>

                    <div class="city type3">
                        <div class="crop">
                        <img src="/bnna/resources/image/tripplan/city/경상도.jpg">
                        </div>
                        <div class="info">
                            <div class="eng">GYEONGSANG</div>
                            <div class="kor">경상도</div>
                            <div class="desc">첨성대,동궁과월지,하회마을,석굴암</div>
                        </div>
                    </div>

                    <div class="city type2 type3">
                        <div class="crop">
                        <img src="/bnna/resources/image/tripplan/city/제주도.jpg">
                        </div>
                        <div class="info">
                            <div class="eng">JEJU ISLAND</div>
                            <div class="kor">제주도</div>
                            <div class="desc">한라산,애월,섭지코지,서귀포</div>
                        </div>
                    </div>


                </div>

            </div>

            <script>

                //전체 보여주기
                function doShowAll() { 
                    $('.city').show();
                } 

                //수도권 보여주기
                function doShow1() { 
                    $('.type2').hide();
                    $('.type3').hide();
                    $('.type1').show();
                } 

                //특별.광역시 보여주기
                function doShow2() { 
                    $('.type1').hide();
                    $('.type3').hide();
                    $('.type2').show();
                } 

                //지방 보여주기
                function doShow3() { 
                    $('.type1').hide();
                    $('.type2').hide();
                    $('.type3').show();
                } 

            </script>


                   
            

        </section>    