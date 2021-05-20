# 온라인 숙소 예약 사이트 에어비엔나✈️

<img src="https://user-images.githubusercontent.com/20657250/113282729-49b98c00-9322-11eb-99b3-972722853421.png" width="700">

### 에어비엔나는 MVC 기반 Spring Framework를 사용한 온라인 숙소 예약 사이트 입니다.


### ▶ 특징 Feature
+ 지도 API를 사용하여 예약한 숙소 주변 맛집, 관광지 정보 확인
+ 숙소, 관광지, 식당을 연결하여 여행 일정 추가
+ 자유, 신고, 여행정보 게시판 등 다양한 게시판 활용


### ▶ 프로젝트 일정 Project Schedule
<img src="https://user-images.githubusercontent.com/20657250/113282742-51793080-9322-11eb-873c-c08a7362dc7e.png" width="700">


### ▶ 개발 환경 Develop Environment
|구분|개발 환경|
|:--:|--------|
|**OS**|Windows 10 x64|
|**Language**|Java(JDK 1.8)|
|**IDE**|Spring Tool Suite(3.9.11)|
|**DB**|Oracle|
|**Server**|Apache Tomcat 8.5|


### ▶ 개발 팀원 Project Member
+ __김주혁__ , 김다은 , 이현우 , 오수경 , 최진영 , 조아라


### ▶ 데이터 구조 Data Structure
<img src="https://user-images.githubusercontent.com/20657250/113282753-563de480-9322-11eb-8a14-b4aba13e6c4a.png" width="700">


### ▶ 담당 업무 구현 Development
+ __(사용자) 신고게시판__
+ __(관리자) 회원 관리, 호스트 관리, 블랙리스트 관리, 신고게시판 관리__   
(아래 구현 화면은 사용자 신고게시판 구현 화면입니다. 관리자 구현 화면은 추후 업데이트 예정입니다.)


#### ✔️신고게시판 목록
<img src="https://user-images.githubusercontent.com/20657250/113276187-8bdecf80-931a-11eb-907e-0bf1e57b9c4c.png" width="700">   
사용자가 작성한 게시글을 DB에서 가져와 목록으로 출력합니다.

검색조건을 선택하고 검색어를 입력 받아 부합하는 게시글을 DB에서 가져와 출력하고, 페이징 기능을 제공합니다.


#### ✔️게시글 검색
<img src="https://user-images.githubusercontent.com/20657250/113280231-f8f46400-931e-11eb-877f-6572b8ae5b95.png" width="700">   
<img src="https://user-images.githubusercontent.com/20657250/113280232-f98cfa80-931e-11eb-8d48-6931a7509903.png" width="700">   
제목, 이름, 아이디로 검색할 수 있고 검색조건과 검색어를 통해 DB에서 조건에 부합하는 데이터를 가져와 출력합니다.


#### ✔️게시글 작성
<img src="https://user-images.githubusercontent.com/20657250/113280168-f134bf80-931e-11eb-8a51-06454832f8d4.png" width="700">   
신고대상회원 검색을 통해 선택할 수 있습니다.

이미지 다중 업로드를 제공합니다.


#### ✔️신고대상회원 검색
<img src="https://user-images.githubusercontent.com/20657250/113280171-f1cd5600-931e-11eb-9f35-7fb2c5bb24ce.png" width="700">
<img src="https://user-images.githubusercontent.com/20657250/113280172-f1cd5600-931e-11eb-9153-f537d2dfe4f4.png" width="700">   
이름, 아이디로 검색이 가능하며 ajax를 통해 검색조건, 검색어를 전달하여 DB에서 조건에 부합하는 데이터를 가져와 json 형식의 데이터를 전달하고 화면에 출력합니다.


#### ✔️이미지 다중 업로드
<img src="https://user-images.githubusercontent.com/20657250/113280175-f265ec80-931e-11eb-8bf2-929f54057c39.png" width="700">   
이미지 다중 업로드를 제공하며 jQuery를 사용하여 이미지 이외의 파일 첨부 시 예외처리 하였습니다.

업로드한 이미지들을 저장하기 위해 MultipartFile을 사용했습니다.


#### ✔️게시글 상세
<img src="https://user-images.githubusercontent.com/20657250/113280180-f2fe8300-931e-11eb-82ee-3abd95bd0af5.png" width="700">   
게시글 정보를 DB에서 가져와 화면에 출력합니다.

이미지 다운로드 기능을 제공하며, 로그인한 본인의 게시글만 수정, 삭제가 가능하도록 AOP를 사용해 해당 페이지가 호출되기 전에 예외처리 하였습니다.


#### ✔️댓글 작성
<img src="https://user-images.githubusercontent.com/20657250/113280188-f42fb000-931e-11eb-9d8f-8e78b9d70477.png" width="700">   
<img src="https://user-images.githubusercontent.com/20657250/113280191-f42fb000-931e-11eb-9198-d2ce73d65f3c.png" width="700">   
해당 게시글에 달린 댓글 정보를 DB에서 가져와 출력합니다.

댓글 작성 시 ajax를 통해 전달한 데이터를 DB에 반영하고 json 형식의 데이터를 클라이언트로 전달하여 page reload 없이 화면에 출력합니다.


#### ✔️답글 작성
<img src="https://user-images.githubusercontent.com/20657250/113280208-f5f97380-931e-11eb-8a23-01ab5ebdd488.png" width="700">   
<img src="https://user-images.githubusercontent.com/20657250/113280211-f6920a00-931e-11eb-892c-f5bb02e1b42c.png" width="700">   
답글 작성 시 신고대상회원을 선택하지 않도록 JSTL을 사용해서 예외처리 하였습니다.

답글을 작성한 경우 부모글 밑에 위치하도록 select문에 조건절을 추가하여 조정하였습니다.


#### ✔️글 삭제
<img src="https://user-images.githubusercontent.com/20657250/113280212-f6920a00-931e-11eb-9859-06ca48bb30b4.png" width="700">   
글 삭제 시 실수로 삭제하는 일을 방지하기 위해 삭제여부를 최종 확인할 수 있도록 구현했습니다.


#### ✔️글 삭제 예외 처리
<img src="https://user-images.githubusercontent.com/20657250/113280215-f72aa080-931e-11eb-9d19-fbd01b73068a.png">   
<img src="https://user-images.githubusercontent.com/20657250/113280216-f7c33700-931e-11eb-9cc0-c6da0a191f9e.png">   
답글이 있거나 댓글이 달려있는 게시글은 삭제할 수 없도록 DB 작업을 통해 예외처리 하였습니다.


#### ✔️URL 직접 입력하여 접근 시 예외 처리(로그인 하지 않은 경우)
<img src="https://user-images.githubusercontent.com/20657250/113280235-f98cfa80-931e-11eb-821d-66ee3f543261.png">   
로그인 하지 않은 사용자가 URL을 직접 입력하여 접근하는 경우 AOP를 사용해 페이지 호출 전에 예외처리 하였습니다.


#### ✔️URL 직접 입력하여 접근 시 예외 처리(본인이 아닌 경우)
<img src="https://user-images.githubusercontent.com/20657250/113280236-fa259100-931e-11eb-86c0-4e3e64a0d697.png">   
본인이 작성하지 않은 글을 수정, 삭제하는 URL을 직접 입력하여 접근하는 경우 AOP를 사용해 페이지 호출 전에 예외처리 하였습니다.


### ▶ 후기 Comment
> __쌍용교육센터에서의 마지막 프로젝트__   
Servlet/JSP 프로젝트가 끝나자마자 Spring 프로젝트를 시작해서 처음엔 조금 벅찬 느낌이었습니
다. 그래도 전 프로젝트와 동일한 팀원으로 프로젝트를 진행해서 작업 시간은 많이 단축되었습니
다. 프로젝트를 진행하면서 동시에 이력서와 포트폴리오 작업을 병행하다 보니 생각했던 모든 업
무를 구현하지 못해서 아쉽지만, 특정 업무에 집중하여 구현했습니다. 그 결과 퀄리티는 전 프로젝
트보다 좋아졌다고 생각합니다.   
스프링 프레임워크를 사용해 작업하는데 아직 많이 부족하다고 느꼈습니다. 의존 주입(DI)과 관점
지향 프로그래밍(AOP)에 대한 이해와 사용 방법이 조금 어려웠고, 앞으로 공부도 많이 하고 연습
도 많이 해야겠다고 생각했습니다.   
벌써 쌍용교육센터에서의 마지막 프로젝트를 마무리한다는 것이 실감 나지 않습니다. 약 6개월이
라는 시간이 금방 지나간 느낌입니다. 그동안 했던 프로젝트를 더 신경 써서 했더라면 더 완벽하
게 했을 텐데... 하는 아쉬움도 있지만, 같이 프로젝트를 진행한 팀원들 덕분에 잘 마무리할 수 있
었고 정말 고마웠고, 고생했다고 말하고 싶습니다.
