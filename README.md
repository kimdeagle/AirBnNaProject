# ✈️ AirBnNa [Spring Framework Project]

<br>

## 🗒️ 프로젝트 개요

- 온라인 숙박 중개 사이트 에어비앤비를 벤치마킹하여, 웹 페이지 이용자가 숙소를 호스팅 또는 이용 할 수 있는 국내 숙소 예약 사이트를 구현한다.
- 숙소 예약 이외에도 블랙회원 신고, 리뷰, 이벤트 및 여행정보를 보여주는 게시판이 있으며, Map API를 활용해 숙소 주변의 관광정보를 확인하고 이를 가지고 여행 일정을 작성, 다른 이용자들과 공유할 수 있다.

<br>

## 🚩 프로젝트 기간 및 팀원

- 2021년 3월 4일 - 2021년 3월 21일 (총 18일)
- <b>김다은</b>, 김주혁, 오수경, 이현우, 조아라, 최진영 (6명)
 
<br>

## ⚙️ AirBnNa 기술 스택
<p align="center">
  <img src="https://img.shields.io/badge/API-국문_관광_정보-skyblue?style=flat">&nbsp 
  <img src="https://img.shields.io/badge/API-KakaoMap-yellow?style=flat">&nbsp 
  <img src="https://img.shields.io/badge/Library-Bootstrap-563D7C?style=flat&logo=bootstrap">&nbsp 
  <img src="https://img.shields.io/badge/Language-Java_8-007396?style=flat&logo=java&logoColor=white">&nbsp 
  <img src="https://img.shields.io/badge/Language-JavaScript-F7DF1E?style=flat&logo=javascript&logoColor=white">&nbsp 
  <img src="https://img.shields.io/badge/Language-JSP-orange?style=flat">&nbsp 
  <img src="https://img.shields.io/badge/Language-JSTL-green?style=flat">&nbsp 
  <img src="https://img.shields.io/badge/Language-jquery-0769AD?style=flat&logo=jquery&logoColor=white">&nbsp 
  <img src="https://img.shields.io/badge/Database-Oracle-F80000?style=flat&logo=oracle&logoColor=white">&nbsp 
  <img src="https://img.shields.io/badge/Server-ApacheTomcat_8.5v-D22128?style=flat&logo=apahce&logoColor=white">&nbsp 
  <img src="https://img.shields.io/badge/Framework-SpringFramework_5.0.7-6DB33F?style=flat&logo=spring&logoColor=white">&nbsp 
</p>

<br>

## 📷 AirBnNa ERD 
![AirBnNa ERD](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/8d75b70f-d3f9-49f9-955d-5be7899ac77b/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210322%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210322T062624Z&X-Amz-Expires=86400&X-Amz-Signature=f22133350a2960a6d61d68fb4818e5d9a3d21cc82a3e7740c209c8985a90c618&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22)

<br>

## ✈️ AirBnNa 기능 소개
<center><img src="https://user-images.githubusercontent.com/74163296/112174994-33cd0c80-8c3a-11eb-9cc1-3cbf07ccdf68.png" width="75%"></center>
<br>

## 🔥 김다은 담당 업무
|    단계    |  담당업무                                              |
| :--------: | :----------------------------------------------------------- |
|  기획단계  | - 요구사항 분석, ERD 작성</br>- Script 작성</br>- 화면 설계</br>- 더미데이터 생성</br>- 깃허브 프로젝트 세팅 |
|  구현단계  | - (사용자) 고객마이페이지(고객), 관심숙소, 여행일정, 여행정보 게시판</br>- (관리자)여행정보 게시판 관리 |
| 마무리단계 | - 테스트 및 에러 수정</br>- 본인 구현파트 화면캡처</br>- 발표용 PPT 작성</br>- 프로젝트 최종요약본 세팅</br>- 프로젝트 최종요약본 작성 |
<br>

## 💻 담당 업무 구현 화면
### [관리자] 여행정보 게시판 관리 ###
<img src="https://user-images.githubusercontent.com/74163296/112239918-b978a880-8c8a-11eb-9f67-258e80321361.png" width="48%"> <img src="https://user-images.githubusercontent.com/74163296/112178046-d1294000-8c3c-11eb-8a41-18a7954cb67c.png" width="48%"> 

**📷게시판 상세조회 & 목록조회** 
- 글에 업로드 된 이미지 파일을 슬라이드 형식으로 확인할 수 있으며, 글에 달린 댓글 또는 관련글을 확인할 수 있다.
- 글을 공유하고 싶을 땐, 스크랩 버튼을 눌러 클립보드에 현재 url을 복사할 수 있다.
- 검색을 통해 게시글을 조회 할 수 있으며, 관련글(답글)도 확인이 가능하다.

<img src="https://user-images.githubusercontent.com/74163296/112240444-ac0fee00-8c8b-11eb-9980-bf1c93153df9.png" width="32%"> <img src="https://user-images.githubusercontent.com/74163296/112240448-af0ade80-8c8b-11eb-94c6-ff1f3e8deece.png" width="32%"> <img src="https://user-images.githubusercontent.com/74163296/112240451-afa37500-8c8b-11eb-9299-3ae8a574777f.png" width="32%"> 

**📷게시글 쓰기 & 수정 & 삭제** 
- 새 글을 추가/수정/삭제할 수 있으며, 파일추가 버튼을 통한 다중파일 업로드가 가능하다.

### [사용자] 마이페이지 ###
<img src="https://user-images.githubusercontent.com/74163296/112242563-72d97d00-8c8f-11eb-9edc-770c2a9b6633.png" width="48"> <img src="https://user-images.githubusercontent.com/74163296/112240732-33f5f800-8c8c-11eb-8880-7a56fe172c25.png" width="48%"> 

**📷마일리지 & 찜한 숙소**
- 마일리지 내역을 전체, 사용, 적립별로 확인할 수 있다.
- 간단한 회원 정보를 확인할 수 있고, 문의 내역 수를 확인할 수 있다.
- 찜 한 숙소들을 확인할 수 있으며, 하트 버튼을 누르면 찜 해제가 된다.


### [사용자] 마이페이지 ###

<br>

## 🔗 AirBnNa 깃허브 주소

👉🏻 [AirBnNa github](https://github.com/abcdana/AirBnNaProject)


