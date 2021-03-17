package com.test.bnna.member.board.blackboard;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class BlackBoardController {

	@Autowired
	private IBlackBoardDAO dao;
	
	@Autowired
	private IMemberDAO mdao;
	
	@Autowired
	private IBlackBoardImgDAO idao;
	
	@Autowired
	private IBlackBoardCmtDAO cdao;
	
	
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
	public String add(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String reply, String thread, String depth) {
		
		if (reply.equals("y")) {
			req.setAttribute("thread", thread);
			req.setAttribute("depth", depth);			
		}
		req.setAttribute("reply", reply);
		
		return "member.board.blackboard.add";
	}
	
	@RequestMapping(value="/member/board/blackboard/addok.action", method={RequestMethod.POST})
	public void addok(HttpServletRequest req, HttpServletResponse resp, HttpSession session, BlackBoardDTO dto, String reply, String thread, String depth) {
		
		//데이터 가져오기 - parameter(dto)
		
		System.out.println("before");
		System.out.println(dto.toString());
		System.out.println(reply);
		System.out.println(thread);
		System.out.println(depth);
		
		//회원번호
		dto.setSeqMember((String)session.getAttribute("seqMember"));
		
		System.out.println("after");
		System.out.println(dto.toString());
		System.out.println(reply);
		System.out.println(thread);
		System.out.println(depth);
		

		int ithread = 0;
		int idepth = 0;
		
		int parentThread = 0;
		int parentDepth = 0;
		
		if (reply.equals("n")) {
			//새글쓰기
			
			ithread = dao.getThread();
			idepth = 0;
			
		} else {
			parentThread = Integer.parseInt(thread);
			parentDepth = Integer.parseInt(depth);	
			//답글쓰기
			
			//이전 새글의 thread
			int previousThread = (int)Math.floor((parentThread - 1) / 1000) * 1000;
			
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			map.put("parentThread", parentThread);
			map.put("previousThread", previousThread);
			
			dao.updateThread(map);
			
			ithread = parentThread - 1;
			idepth = parentDepth + 1;
		}
		
		dto.setThread(ithread);
		dto.setDepth(idepth);
		
		//DB 위임 -> add
		int result = dao.addok(dto);
		
		try {
			
			if (result == 1) {
				//add 성공
				
				//1. 게시판 번호 가져오기
				String addSeqBlackBoard = dao.getAddSeq();
				
				if (req.getAttribute("image") != null) {
					//이미지 추가한 경우만
					
					//2. 파일 저장 + 테이블에 추가할 글번호, 파일명, 원본파일명 저장
					MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)req;

					List<MultipartFile> flist = mreq.getFiles("image");

					List<BlackBoardImgDTO> ilist = new ArrayList<BlackBoardImgDTO>();
					
					//webapp > resources > image > board > blackboard
					String path = req.getRealPath("resources/image/board/blackboard");
					
					//TODO path test
					System.out.println(path);
					
					for (MultipartFile mf : flist) {
						BlackBoardImgDTO idto = new BlackBoardImgDTO();
						
						String orgimage = mf.getOriginalFilename(); //원본파일명
						String image = getFileName(path, orgimage); //중복 검사 후 파일명 저장
						
						String saveImage = path + "\\" + image; //저장될 경로 + 파일명
						
						mf.transferTo(new File(saveImage)); //파일 저장

						idto.setSeqBlackBoard(addSeqBlackBoard);
						idto.setImage(image);
						idto.setOrgimage(orgimage);
						
						ilist.add(idto); //글번호, 파일명, 원본파일명 저장
						
					}

					//3. 이미지 테이블에 추가하기
					int result2 = idao.add(ilist);
					
					if (result2 == ilist.size()) {
						//add 성공
						
						resp.setCharacterEncoding("UTF-8");
						
						PrintWriter writer = resp.getWriter();
						
						writer.print("<html><head><meta charset='utf-8' /></head><body>");
						writer.print("<script>");
						writer.print("alert('글쓰기 성공!!\\n목록으로 이동합니다.');");
						writer.print("location.href='/bnna/member/board/blackboard/list.action';");
						writer.print("</script>");
						writer.print("</body></html>");
						
						writer.close();
								
					} else {
						//image add 실패 -> 이미 추가된 글 삭제 후 뒤로가기
						dao.del(addSeqBlackBoard);
						
						resp.setCharacterEncoding("UTF-8");
						
						PrintWriter writer = resp.getWriter();
						
						writer.print("<html><head><meta charset='utf-8' /></head><body>");
						writer.print("<script>");
						writer.print("alert('글쓰기 실패..\\n이전 페이지로 이동합니다.');");
						writer.print("history.back();");
						writer.print("</script>");
						writer.print("</body></html>");
						
						writer.close();
						
					}
				} else {
					//이미지 추가 안한 경우
					resp.setCharacterEncoding("UTF-8");
					
					PrintWriter writer = resp.getWriter();
					
					writer.print("<html><head><meta charset='utf-8' /></head><body>");
					writer.print("<script>");
					writer.print("alert('글쓰기 성공!!\\n목록으로 이동합니다.');");
					writer.print("location.href='/bnna/member/board/blackboard/list.action';");
					writer.print("</script>");
					writer.print("</body></html>");
					
					writer.close();
				}

				
					
					

				
			} else {
				//add 실패
				
				resp.setCharacterEncoding("UTF-8");
				
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><head><meta charset='utf-8' /></head><body>");
				writer.print("<script>");
				writer.print("alert('글쓰기 실패..\\n이전 페이지로 이동합니다.');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	@RequestMapping(value="/member/board/blackboard/view.action", method={RequestMethod.GET})
	public String view(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq) {
		
		//1. 데이터 가져오기(seq)
		//2. DB 위임 -> select
		//3. 결과 처리
		
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
		
		req.setAttribute("seq", seq);
		req.setAttribute("dto", dto);
		req.setAttribute("ilist", ilist);
		req.setAttribute("clist", clist);
		
		return "member.board.blackboard.view";
	}
	
	@RequestMapping(value="/member/board/blackboard/addcmt.action", method={RequestMethod.GET})
	public void addcmt(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq, String content) {
		
		//1. 데이터 가져오기(seq, content)
		//2. DB 위임 -> insert
		//3. 결과 처리
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json"); //*****JSON
		
		BlackBoardCmtDTO dto = new BlackBoardCmtDTO();
		
		dto.setSeqMember((String)session.getAttribute("seqMember"));
		dto.setSeqBlackBoard(seq);
		dto.setContent(content);
		
		
		//댓글 추가하기
		int result = cdao.add(dto);
		
		//돌려줄 데이터 가져오기(회원이름, 회원아이디, 작성내용, 작성일)
		BlackBoardCmtDTO cdto = cdao.getAddCmt();

		try {
			
			
			if (result == 1) {
				//추가 성공				
				PrintWriter writer = resp.getWriter();
				
				writer.print("[");
				writer.print("{");
				writer.print(String.format("\"id\":\"%s\",", cdto.getId()));
				writer.print(String.format("\"name\":\"%s\",", cdto.getName()));
				writer.print(String.format("\"content\":\"%s\",", cdto.getContent()));
				writer.print(String.format("\"regdate\":\"%s\"", cdto.getRegdate()));
				writer.print("}");
				writer.print("]");
				
				writer.close();
				
			} else {
				//추가 실패
				PrintWriter writer = resp.getWriter();
				
				writer.print("<html><head><meta charset='utf-8' /></head><body>");
				writer.print("<script>");
				writer.print("alert('글쓰기 실패..\\n이전 페이지로 이동합니다.');");
				writer.print("history.back();");
				writer.print("</script>");
				writer.print("</body></html>");
				
				writer.close();
			}			
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}	
	
	
	@RequestMapping(value="/member/board/blackboard/list.action", method={RequestMethod.GET})
	public String list(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		//DB 위임 -> select
		List<BlackBoardDTO> list = dao.list();
		
		//날짜 자르기
		for (BlackBoardDTO dto : list) {
			dto.setRegdate(dto.getRegdate().substring(0, 10));
		}
		
		//결과 처리
		req.setAttribute("list", list);
		
		return "member.board.blackboard.list";
	}	
	
	@RequestMapping(value="/member/board/blackboard/login.action", method= {RequestMethod.GET})
	public void login(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seqMember) {
		
		//1. 데이터 가져오기(seqMember) - 매개변수
		//2. 인증 티켓 발급
		//3. 페이지 이동
		
		//2.
		session.setAttribute("seqMember", seqMember);
		
		//3.
		try {
			resp.sendRedirect("/bnna/member/board/blackboard/list.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	
	@RequestMapping(value="/member/board/blackboard/logout.action", method= {RequestMethod.GET})
	public void logout(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		//1. 인증 티켓 폐기
		//2. 페이지 이동
		
		//1.
		session.invalidate();
		
		//2.
		try {
			resp.sendRedirect("/bnna/member/board/blackboard/list.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}		
	
	

	private String getFileName(String path, String filename) {
		
		//return System.currentTimeMillis() + "_" + filename;
		//return System.nanoTime() + "_" + filename;
		
		//dog.png -> dog_1.png -> dog_2.png
		
		//path = "files"
		//filename = "dog.png"
		
		int n = 1; //인덱스
		int index = filename.lastIndexOf(".");
		String tempName = filename.substring(0, index); //"dog"
		String tempExt = filename.substring(index); //".png"
		
		while (true) {
			File file = new File(path + "\\" + filename); //files\dog.png
			if (file.exists()) {
				//있다 -> 중복 -> 파일명 수정
				filename = tempName + "_" + n + tempExt;
				n++;
			} else {
				//없다 -> 반환
				return filename;
			}
		}
		
	} //getFileName()	
	
}
