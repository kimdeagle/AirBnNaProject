package com.test.bnna.member.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ReviewController {
	
	@Autowired
	private IReviewDAO dao;
	
	@RequestMapping(value="/member/review/list.action", method={RequestMethod.GET})
	public String list(HttpServletRequest req, HttpServletResponse resp) {
		
		List<ReviewDTO> list=dao.list();
		
		req.setAttribute("list", list);
		
		return "member.sidebar.review.list";
	}
	
}
