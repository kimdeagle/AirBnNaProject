<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/bnna/resources/css/tripinfo/admin-tripinfo.css">

        <section class="mainsection">
        
            <div id="menupath">
                게시판 <span class="glyphicon glyphicon-menu-right" style="position: static; z-index: -1;"></span> 여행정보 게시판
                <span class="glyphicon glyphicon-menu-right" style="position: static; z-index: -1;"></span> 새 글 작성
            </div>
            <hr>
            <!-- 여기까지 menu path -->
        
            <article>
        
                <h1>여행정보 게시판 <small>게시물 작성</small></h1>

                <div class="writearea">

                    <input type="text" class="form-control subject" placeholder="제목을 입력하세요.">
                    <textarea name="" id="" class="form-control content" cols="30" rows="10" placeholder="내용을 입력하세요."></textarea>
                    
                    <div id="filearea" style="width: 85%;">
                        <input multiple="multiple" type="file" name="file" class="form-control file"/>
                    </div>

                    <div style="text-align: right; margin-top: -40px;">
                        <button class="btn btn-add">파일 추가</button>
                    </div>

                    <hr>

                    <div class="btns">
                        <button class="btn" onclick="location.href='/bnna/admin/board/tripinfo/list.action'">취소</button>
                        <button class="btn">미리보기</button>
                    </div>
                    <div class="right">
                        <button class="btn btn-general" type="submit" onclick="location.href='/bnna/admin/board/tripinfo/writeok.action'">등록</button>
                    </div>

                </div>
        
            </article>
        
        </section>
	
		<script>
            // 파일업로드 추가 버튼
            $(".btn-add").on('click', function() {

                let tmp = '';
                tmp += '<input multiple="multiple" type="file" name="file" class="form-control file"/>'

                $("#filearea").append(tmp);

            });
        </script>