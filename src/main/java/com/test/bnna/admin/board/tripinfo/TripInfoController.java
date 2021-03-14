package com.test.bnna.admin.board.tripinfo;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 관리자 페이지의 여행정보 게시판 관련 컨트롤러입니다.
 * @author 김다은
 */
@Controller
public class TripInfoController {
	
	@Autowired
	private ITripInfoDAO dao;
	
	/**
	 * 
	 * @param req
	 * @param resp
	 * @return 
	 */
	@RequestMapping(value="/admin/board/tripinfo/list.action", method={RequestMethod.GET})
	public String list(HttpServletRequest req, HttpServletResponse resp) {
		
		List<TripInfoDTO> list = dao.list();
		
		req.setAttribute("list", list);
		
		return "admin.board.tripinfo.list";
	}
	
	
	@RequestMapping(value="/admin/board/tripinfo/view.action", method={RequestMethod.GET})
	public String view(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq) {
		
		TripInfoDTO dto = dao.view(seq);
		
		List<TripInfoCmtDTO> cmtlist = dao.cmtlist(seq);
		
		req.setAttribute("dto", dto);
		req.setAttribute("cmtlist", cmtlist);
		
		return "admin.board.tripinfo.view";
	}
	
}
