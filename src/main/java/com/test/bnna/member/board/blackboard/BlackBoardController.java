package com.test.bnna.member.board.blackboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlackBoardController {

	@Autowired
	private IBlackBoardDAO dao;
	
	@Autowired
	private IMemberDAO mdao;
	
	
	@RequestMapping(value="/member/board/blackboard/searchmember.action", method={RequestMethod.GET})
	public void searchmember(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String condition, String keyword) {
		
		resp.setCharacterEncoding("UTF-8"); //돌아갈 때 한글 안깨짐
		resp.setContentType("application/json"); //*****JSON
		
		//검색 결과 받아오기
		List<MemberDTO> mlist = mdao.list(condition, keyword);
		
		System.out.println(mlist.size());
		
//		[
//		{
//		"name": "홍길동",
//		"age": 20
//		}
//		,
//		{
//		"name": "홍길동",
//		"age": 20
//		}
//		]		
		
		try {
			PrintWriter writer = resp.getWriter();
			
			writer.print("[");
			
			for (int i=0; i<mlist.size(); i++) {
				writer.print("{");
				writer.print(String.format("\"seq\":\"%s\",", mlist.get(i).getSeq()));
				writer.print(String.format("\"name\":\"%s\",", mlist.get(i).getName()));
				writer.print(String.format("\"id\":\"%s\"", mlist.get(i).getId()));
				writer.print("}");
				
				//마지막 , 빼기
				if (i < mlist.size() - 1) {
					writer.print(",");
				}
			}
			
			writer.print("]");
			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@RequestMapping(value="/member/board/blackboard/add.action", method={RequestMethod.GET})
	public String add(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		return "member.board.blackboard.add";
	}
	
	@RequestMapping(value="/member/board/blackboard/addok.action", method={RequestMethod.POST})
	public String addok(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		return "member.board.blackboard.list";
	}
	
	@RequestMapping(value="/member/board/blackboard/view.action", method={RequestMethod.GET})
	public String view(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq) {
		
		//1. 데이터 가져오기(seq)
		//2. DB 위임 -> select
		//3. 결과 처리
		
		//글번호 (임시)
		seq = "2";
		
		//글 정보 가져오기
		BlackBoardDTO dto = dao.get(seq);
		
		//날짜 자르기
		dto.setRegdate(dto.getRegdate().substring(0, 10));
		
		//<br>처리
		dto.setContent(dto.getContent().replace("\r\n", "<br>"));
		dto.setContent(dto.getContent().replace("\n", "<br>"));
		
		//이미지 가져오기
		List<BlackBoardImgDTO> ilist = dao.getImages(seq);
		
		//댓글 가져오기
		List<BlackBoardCmtDTO> clist = dao.getComments(seq);
		
		//댓글 작성일 자르기
		for (BlackBoardCmtDTO cdto : clist) {
			cdto.setRegdate(cdto.getRegdate().substring(0, 10));
		}
		
		req.setAttribute("seq", seq);
		req.setAttribute("dto", dto);
		req.setAttribute("ilist", ilist);
		req.setAttribute("clist", clist);
		
		return "member.board.blackboard.view";
	}
	
}
