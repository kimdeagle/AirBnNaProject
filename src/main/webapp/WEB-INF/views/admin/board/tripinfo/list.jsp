<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="mainsection">

    <div id="menupath">
        게시판 <span class="glyphicon glyphicon-menu-right" style="position: static; z-index: -1;"></span> 여행정보 게시판
        <span class="glyphicon glyphicon-menu-right" style="position: static; z-index: -1;"></span> 목록보기
    </div>
    <hr>
    <!-- 여기까지 menu path -->

    <article>

        <h1>여행정보 게시판</h1>

        <div class="searcharea">
            여기가 검색창
        </div>

        <div class="btns">
            <button class="btn btn-thumbnail">썸네일보기</button>
            <button class="btn btn-write">새글쓰기</button>
        </div>

        <div class="admin-listarea">
            <table class="tbl-tripinfo table table-bordered">
                <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td><a href="#">제목입니다.</a></td>
                    <td>10</td>
                    <td>2021-02-02</td>
                </tr>
                <tr>
                    <td>1</td>
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
                <tr>
                    <td>1</td>
                    <td><a href="#">제목입니다.</a></td>
                    <td>10</td>
                    <td>2021-02-02</td>
                </tr>
            </table>

            <div class=pagearea>
                <div class="pagination">
                    <a href="#">&laquo;</a>
                    <a href="#">1</a>
                    <a href="#" class="active">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">6</a>
                    <a href="#">&raquo;</a>
                </div>
            </div>
        </div>

    </article>

</section>