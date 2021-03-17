<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/bnna/resources/css/tripinfo/admin-tripinfo.css">

<section class="mainsection">

    <div id="menupath">
        게시판 <span class="glyphicon glyphicon-menu-right" style="position: static; z-index: -1;"></span> 여행정보 게시판
        <span class="glyphicon glyphicon-menu-right" style="position: static; z-index: -1;"></span> 전체보기
    </div>
    <hr style="margin-top: -5px">
    <!-- 여기까지 menu path -->

    <article>

        <h1>여행정보 게시판</h1>

        <div class="boardhead">
            <div class="searchform searcharea">
                <input type="text" class="form-control boardsearch">
                <button id="searchBtn" class="btn"><span class="glyphicon glyphicon-search"></span></button>
            </div>

            <div class="btns">
                <button class="btn btn-thumbnail">썸네일보기</button>
                <button class="btn btn-write" onclick="location.href='/bnna/admin/board/tripinfo/write.action?reply=n'">새글쓰기</button>
            </div>
        </div>

        <div class="admin-listarea">
            <table class="tbl-tripinfo table table-bordered">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
                <tr>
                    <td>0</td>
                    <td>
                        <span class="glyphicon glyphicon-share-alt"></span>
                        <a href="#">제목입니다.</a>
                        <span class="badge">댓글수</span>
                        <span class="label label-danger">new</span>
                        <span class="glyphicon glyphicon-floppy-disk"></span>
                    </td>
                    <td>10</td>
                    <td>2021-02-02</td>
                </tr>
                
                <c:forEach items="${list}" var="dto">
                <tr>
                    <td>${dto.seq}</td>
                    <td>
              	 	<a href="/bnna/admin/board/tripinfo/view.action?seq=${dto.seq}&search=${search}&page=${nowPage}" 
          	style="margin-left: ${dto.depth * 30}px;">
          			
          			<c:if test="${dto.depth > 0}">
          			<span class="glyphicon glyphicon-share-alt"></span>
          			</c:if>
          			
                    ${dto.subject}
                    
                    <!-- 댓글 수 -->
                   	<c:if test="${dto.cmtcnt > 0}">
                   	<span class="badge">${dto.cmtcnt}</span>
                   	</c:if>
                   	
                    </a>
                    </td>
                    <td>${dto.readcnt}</td>
                    <td>${dto.regdate.substring(0, 10)}</td>
                </tr>
                </c:forEach>
                
            </table>

            <div class=pagearea>
                <div class="pagination">
					${pagebar}
				</div>
            </div>
        </div>

    </article>

</section>