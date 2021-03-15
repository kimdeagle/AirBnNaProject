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
	
	
	@RequestMapping(value="/admin/board/tripinfo/write.action", method= {RequestMethod.GET})
	public String write(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		
		return "admin.board.tripinfo.write";
	}
	
	@RequestMapping(value="/admin/board/tripinfo/writeok.action", method= {RequestMethod.POST})
	public void writeok(HttpServletRequest req, HttpServletResponse resp, HttpSession session, TripInfoDTO dto) {
		
		session.setAttribute("seq", 1);
		
		int result = dao.write(dto);
		
		try {
			if (result == 1) {
				resp.sendRedirect("/admin/board/tripinfo/list.action");
			} else {
				resp.sendRedirect("/admin/board/tripinfo/write.action");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@RequestMapping(value="/admin/board/tripinfo/edit.action", method= {RequestMethod.GET})
	public String edit(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		
		return "admin.board.tripinfo.edit";
	}
	
//	@RequestMapping(value="/admin/board/tripinfo/editok.action", method= {RequestMethod.POST})
//	public void editok(HttpServletRequest req, HttpServletResponse resp, HttpSession session, TripInfoDTO dto) {
//		
//		session.setAttribute("seq", 1);
//		
//		int result = dao.edit(dto);
//		
//		try {
//			if (result == 1) {
//				resp.sendRedirect("/admin/board/tripinfo/view.action?seq=" + dto.getSeq());
//			} else {
//				resp.sendRedirect("/admin/board/tripinfo/edit.action?seq=" + dto.getSeq());
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
	
}
