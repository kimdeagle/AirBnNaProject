package com.test.bnna.member.bnbsearch;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.test.bnna.member.board.review.IReviewDAO;
import com.test.bnna.member.board.review.IReviewPicDAO;
import com.test.bnna.member.board.review.ReviewDTO;
import com.test.bnna.member.board.review.ReviewPicDTO;

@Controller
public class BnBController {
	
	@Autowired
	private IBnBDAO dao;
	
	@Autowired
	private IBnBPicDAO pdao;
	
	@Autowired
	private IReviewDAO rdao;
	
	@Autowired
	private IReviewPicDAO rpdao;
	
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
		
		// 그 숙소의 리뷰의 이미지들을 찾는다.
		List<ReviewPicDTO> rplist=rpdao.listByBnB(seq);
		
		req.setAttribute("dto", dto);
		req.setAttribute("plist", plist);
		req.setAttribute("rlist", rlist);
		req.setAttribute("rplist", rplist);
		
		return "member.nosidebar.bnbsearch.view";
	}
	
	/**
	 * ajax로 호출되는, 특정 리뷰번호로 이미지를 가져오는 메서드입니다.
	 * @param req
	 * @param resp
	 * @param session
	 * @param seq
	 */
	@RequestMapping(value="/member/bnbsearch/getreviewpic.action", method={RequestMethod.GET})
	public void getReviewPic(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq) {
		
		Gson gson=new Gson();
		
		// 리뷰 이미지들의 리스트를 넣어줄 HashMap을 만든다.
		Map<String, Object> data=new HashMap<String, Object>();
		
		// 받아온 리뷰번호로 그 리뷰의 이미지들을 찾는다.
		List<ReviewPicDTO> rplist=rpdao.list(seq);
		
		// 리뷰이미지 리스트들을 풀어서 HashMap에 넣는다.
		for (int i=0;i<rplist.size();i++) {
			data.put(i+"", rplist.get(i).getImage());
		}
		
		try {
			resp.getWriter().print(gson.toJson(data));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
