package com.test.bnna.admin.board.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.bnna.admin.board.review.IReviewForAdminDAO;
import com.test.bnna.admin.board.review.ReviewForAdminDTO;
import com.test.bnna.member.board.review.ReviewPicDTO;

@Controller
public class ReviewControllerForAdmin {
	
	@Autowired
	IReviewForAdminDAO dao;
	
	@Autowired
	IReviewPicForAdminDAO pdao;
	
	@RequestMapping(value="/admin/board/review/list.action", method={RequestMethod.GET})
	public String list(HttpServletRequest req, HttpServletResponse resp) {
		
		// 리뷰를 전부 가져온다.
		List<ReviewForAdminDTO> list=dao.list();
		
		req.setAttribute("list", list);
		
		return "admin.board.review.list";
	}
	
	@RequestMapping(value="/admin/board/review/view.action", method={RequestMethod.GET})
	public String view(HttpServletRequest req, HttpServletResponse resp, String seq) {
		
		// 선택한 글번호를 가져와서 그 번호로 리뷰글정보를 찾는다.
		ReviewForAdminDTO dto=dao.info(seq);
		// 그 글번호로 리뷰이미지도 찾는다.
		List<ReviewPicForAdminDTO> plist=pdao.list(seq);
		
		req.setAttribute("dto", dto);
		req.setAttribute("plist", plist);
		
		return "admin.board.review.view";
	}
	
	@RequestMapping(value="/admin/board/review/delok.action", method={RequestMethod.GET})
	public void delok(HttpServletRequest req, HttpServletResponse resp, String seq) {
		
		// 1. 데이터 가져오기
		// 2. DB 위임 -> delete
		// 3. 결과 처리
		
		// 2.
		
		String path=req.getRealPath("/resources/image/board/review/");
		
		// dao 내부에서 원본이미지파일삭제, DB의 이미지파일정보 삭제, DB의 리뷰글 삭제가 모두 일어난다.
		int result=dao.del(path, seq);
		
		// 3.
		
		try {
			
			if (result==1) {
				resp.sendRedirect("/bnna/admin/board/review/list.action");
			} else {
				resp.sendRedirect("/bnna/admin/board/review/view.action?seq="+seq);
			}
			
		} catch (Exception e) {
			System.out.println("ReviewControllerForAdmin.delok()");
			e.printStackTrace();
		}
	}

}
