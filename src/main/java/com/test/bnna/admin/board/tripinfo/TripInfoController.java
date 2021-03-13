package com.test.bnna.admin.board.tripinfo;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TripInfoController {
	
	
	@RequestMapping(value="/admin/board/tripinfo/list.action", method={RequestMethod.GET})
	public String list(HttpServletRequest req, HttpServletResponse resp) {
		
		//List<TripInfoDTO> list=dao.list();
		
		//req.setAttribute("list", list);
		
		return "admin.board.tripinfo.list";
	}
	
}
