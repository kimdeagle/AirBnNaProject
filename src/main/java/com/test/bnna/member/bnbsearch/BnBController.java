package com.test.bnna.member.bnbsearch;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.bnna.member.board.review.IReviewDAO;
import com.test.bnna.member.board.review.ReviewDTO;

@Controller
public class BnBController {
	
	@Autowired
	private IBnBDAO dao;
	
	@Autowired
	private IBnBPicDAO pdao;
	
	@Autowired
	private IReviewDAO rdao;
	
	/**
	 * 하나의 숙소의 상세정보를 가져오는 메서드입니다.
	 * @param req
	 * @param resp
	 * @param session
	 * @param seq 숙소번호입니다.
	 * @return "member/bnbsearch/view"를 호출합니다.
	 */
	@RequestMapping(value="/member/bnbsearch/view.action", method={RequestMethod.GET})
	public String view(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq) {
		
		// 받아온 숙소번호로 정보를 찾는다.
		BnBDTO dto=dao.getInfo(seq);
		
		// 받아온 숙소번호로 숙소이미지를 찾는다.
		List<BnBPicDTO> plist=pdao.pic(Integer.parseInt(seq));
		
		// 받아온 숙소번호로 그 숙소의 리뷰를 찾는다.
		List<ReviewDTO> rlist=rdao.list(seq);
		
		req.setAttribute("dto", dto);
		req.setAttribute("plist", plist);
		req.setAttribute("rlist", rlist);
		
		return "member.nosidebar.bnbsearch.view";
	}

}
