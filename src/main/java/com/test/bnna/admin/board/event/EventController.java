package com.test.bnna.admin.board.event;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
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
public class EventController {
	
	@Autowired
	private IEventBoardDAO dao;
	
	@RequestMapping(value="/admin/board/eventboard/list.action", method = {RequestMethod.GET})
	public String list(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {
		
		//1. DB 위임 -> select
		//2. jsp 호출
//		System.out.println(search+"==============================");
		HashMap<String,String> map = new HashMap<String, String>();
		
		if(search == null || search.equals("")) {
			search = "";
		}
		
		map.put("search",search);
		System.out.println(search);
		List<EventBoardDTO> list = dao.list(map);
//		List<EventBoardDTO> list = dao.list();
		
		request.setAttribute("list", list);
		request.setAttribute("search", search);
		
		return "admin.board.eventboard.list";
	}

	@RequestMapping(value="/admin/board/eventboard/view.action", method = {RequestMethod.GET})
	public String view(HttpServletRequest request, HttpServletResponse response, HttpSession session, String seq) {
		
		//1. 데이터 가져오기
		//2. DB 위임 -> select
		//3. dto + JSP 호출
		
		EventBoardDTO dto = dao.get(seq);
		
		request.setAttribute("dto", dto);
		
		List<EventCmtDTO> clist = dao.clist(seq);
		
		request.setAttribute("clist", clist);

		return "admin.board.eventboard.view";
	}


	@RequestMapping(value="/admin/board/eventboard/add.action", method = {RequestMethod.GET})
	public String admin_add(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		return "admin.board.eventboard.add";
	}
	
	@RequestMapping(value="/admin/board/eventboard/addok.action", method = {RequestMethod.POST})
	public String admin_addok(HttpServletRequest request, HttpServletResponse response, HttpSession session, EventBoardDTO dto) {
		
		//데이터 가져오기
		//2. DAO 위임 -> insert
		//3. 결과 처리
		
		//관리자 번호
		dto.setSeqAdmin("1");
		
		//첨부 파일 처리
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest) request;
		
		//첨부 파일 참조 객체
		MultipartFile image = multi.getFile("imagefile");
		System.out.println(image.getName());
		// 업로드 파일이 어딨는지? -> 임시 폴더에 저장 -> 우리가 원하는 폴더로 이동
		String filename="";
		
		try {

			 String path = request.getRealPath("resources/image/board/eventboard"); 
			/*
			 * String path = request.getSession().getServletContext().getRealPath(
			 * "resources/image/board/eventboard");
			 */
			System.out.println(path);

			filename = getFileName(path, image.getOriginalFilename());
			dto.setOrgImage(image.getOriginalFilename());

			// 이동시킬 최종 경로 + 파일명
			File file = new File(path + "\\" + filename);

			// 무조건 덮어쓰기 -> 중복 방지 -> 넘버링 직접 구현
			image.transferTo(file); // renameTo()와 동일

		} catch (Exception e) {
			System.out.println(e);
		}

//		request.setAttribute("filename", filename);
		dto.setImage(filename);
		
//		System.out.println(image.getName());
		
		//2
		int result = dao.add(dto);
		
		//3.
		try {
			
			if(result == 1) {
				response.sendRedirect("/bnna/admin/board/eventboard/list.action");
			}else {
				response.sendRedirect("/bnna/admin/board/eventboard/add.action");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return "admin.board.eventboard.add";
	}
	
	private String getFileName(String path, String filename) {
		
		int n = 1; // 인덱스 숫자
		int index = filename.indexOf(".");
		String tempName = filename.substring(0, index);// "dog"
		String tempExt = filename.substring(index);// ".png"

		while (true) {

			File file = new File(path + "\\" + filename); // files\dog.png

			if (file.exists()) {
				// 있다 -> 중복 -> 파일명 수정
				filename = tempName + "_" + n + tempExt;
				n++;
			} else {
				// 없다 -> 반환
				return filename;
			}

		}
	}

	@RequestMapping(value="/admin/board/eventboard/edit.action", method = {RequestMethod.GET})
	public String admin_owner_edit(HttpServletRequest request, HttpServletResponse response, HttpSession session, String seq) {
		
		//1. 데이터 가져오기(seq)
		//2. db위임 -> select
		//3. dto + jsp 호출
		EventBoardDTO dto = dao.get(seq);
		
		request.setAttribute("dto", dto);
		
		
		
		return "admin.board.eventboard.edit";
	}
	
	@RequestMapping(value="/admin/board/eventboard/editok.action", method = {RequestMethod.POST})
	public void admin_owner_editok(HttpServletRequest request, HttpServletResponse response, HttpSession session, EventBoardDTO dto) {
		
		//데이터 가져오기
		//2. DAO 위임 -> update
		//3. 결과 처리
		
		dto.setSeqAdmin("1");
		
		//2
		int result = dao.edit(dto);
		
		//3.
		try {
			
			if(result == 1) {
				response.sendRedirect("/bnna/admin/board/eventboard/view.action?seq="+dto.getSeq());
				
			}else {
				response.sendRedirect("/bnna/admin/board/eventboard/edit.action?seq="+dto.getSeq());
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	@RequestMapping(value="/admin/board/eventboard/del.action", method = {RequestMethod.GET})
	public String admin_owner_del(HttpServletRequest request, HttpServletResponse response, HttpSession session, String seq) {
		
		//1. 데이터 가져오기(seq)
		//2. JSP 호출
		request.setAttribute("seq", seq);
		
		return "admin.board.eventboard.del";
	}
	
	@RequestMapping(value="/admin/board/eventboard/delok.action", method = {RequestMethod.GET})
	public void admin_owner_delok(HttpServletRequest request, HttpServletResponse response, HttpSession session, String seq) {
		
		//데이터 가져오기
		//2. DAO 위임 -> delete
		//3. 결과 처리
		
		//2
		int result = dao.del(seq);
		System.out.println(seq);
		//3.
		try {
			
			if(result == 1) {
				response.sendRedirect("/bnna/admin/board/eventboard/list.action");
			}else {
				response.sendRedirect("/bnna/admin/board/eventboard/view.action?seq="+ seq);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	@RequestMapping(value="/admin/board/eventboard/delcommentok.action", method = {RequestMethod.GET})
	public void admin_owner_delcommentok(HttpServletRequest request, HttpServletResponse response, HttpSession session, String seq, String bseq) {
		
		//데이터 가져오기
		//2. DAO 위임 -> delete
		//3. 결과 처리
		
		//2
		
		int result = dao.delcomment(seq);

		//3.
		try {
			
			if(result == 1) {
				response.sendRedirect("/bnna/admin/board/eventboard/view.action?seq="+bseq);
			}else {
				PrintWriter writer = response.getWriter();

				writer.print("<html><body>");
				writer.print("<script>");
				writer.print("alert('failed');");
				writer.print("</script>");
				writer.print("</body></html>");

				writer.close();

				return;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
}
