package com.test.bnna.member.board.review;

import java.io.File;
import java.util.ArrayList;
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
	
	@Autowired
	private IReviewPicDAO pdao;
	
	@Autowired
	private IBookForMemberDAO bdao;
	
	@RequestMapping(value="/member/board/review/list.action", method={RequestMethod.GET})
	public String list(HttpServletRequest req, HttpServletResponse resp) {
		
		// 1번회원 데이터를 보여주기로 했으므로 회원번호 1번으로 설정
		req.setAttribute("seq", 1);
		
		// 회원번호 가져와서
		String seqMember=req.getAttribute("seq").toString();
		// 그 회원의 리뷰목록 찾아오기
		List<ReviewForMemberDTO> list=dao.listForMember(seqMember);
		 
		req.setAttribute("list", list);
		
		return "member.board.review.list";
	}
	
	@RequestMapping(value="/member/board/review/add.action", method={RequestMethod.GET})
	public String add(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
		// 1번회원 데이터 보여주기로 했으므로.
		session.setAttribute("seq", 1);
		
		String seqMember=session.getAttribute("seq").toString();
		
		List<BookForMemberDTO> blist=bdao.list(seqMember);
		
		req.setAttribute("blist", blist);
		
		return "member.board.review.add";
	}
	
	@RequestMapping(value="/member/board/review/addok.action", method={RequestMethod.POST})
	public void addok(HttpServletRequest req, HttpServletResponse resp, HttpSession session, AddReviewDTO dto) {

		MultipartHttpServletRequest multi=(MultipartHttpServletRequest)req;
		List<MultipartFile> multiList = multi.getFiles("reviewpic");
		
		// 파일업로드
		if (multiList.size() == 1 && multiList.get(0).getOriginalFilename().equals("")) {
            
        } else {
        	
        	String filename="";
        	
        	try {
        	
	            for (int i = 0; i < multiList.size(); i++) {
	            	
	            	String path=req.getRealPath("/resources/image/board/review/");
	    			filename=getFileName(req, path, multiList.get(i).getOriginalFilename());
	            	
	    			File file;
	    			
	    			// 맥 OS일 때는 경로를 다르게 입력해줘야 한다.
	    			if (req.getHeader("user-agent").indexOf("Mac OS")!=0) {
	    				// 이동시킬 최종 경로 + 파일명
	    				file=new File(path + "/" + filename);
	    			} else {
	    				// 이동시킬 최종 경로 + 파일명
	    				file=new File(path + "\\" + filename);
	    			}
	    			
	    			// 이동
	    			multiList.get(i).transferTo(file); // renameTo()와 동일
	    			
	            }
            
        	}catch (Exception e) {
            	System.out.println("FileController.addok()");
    			e.printStackTrace();
            }
        }
		
		// 파일업로드가 끝나면 DTO에 파일이름을 넣어준다.
		
		ArrayList<ReviewPicDTO> plist=new ArrayList<ReviewPicDTO>();
		
		for (int i = 0; i < multiList.size(); i++) {
			ReviewPicDTO pdto=new ReviewPicDTO();
			pdto.setImage(multiList.get(i).getOriginalFilename());
			pdto.setOrgimage(multiList.get(i).getOriginalFilename());
			
			plist.add(pdto);
		}
		
		try {
			
			// DB에 데이터 넣어주기
			int result=dao.add(dto);
			
			// 방금 넣은 리뷰 글번호가져와서 리뷰사진도 DB에 넣기
			int seq=dao.getCurrentReviewSeq();
			
			for (int i = 0; i < plist.size(); i++) {
				plist.get(i).setSeqreview(seq);
			}
			
			int fileResult=pdao.addReviewPic(plist);
			
			if (fileResult>=1) {
				resp.sendRedirect("/bnna/member/board/review/list.action");
			} else {
				resp.sendRedirect("/bnna/member/board/review/add.action");
			}
			
		} catch (Exception e) {
			System.out.println("ReviewController.addok()");
			e.printStackTrace();
		}
	}
	
	private String getFileName(HttpServletRequest request, String path, String filename) {
		
		int n=1; // 인덱스
		int index=filename.indexOf(".");
		String tempName=filename.substring(0, index); // "dog"
		String tempExt=filename.substring(index); // ".png"
		
		while (true) {
			
			File file;
			
			// 맥 OS일 때는 경로를 다르게 입력해줘야 한다.
			if (request.getHeader("user-agent").indexOf("Mac OS")!=0) {
				// 이동시킬 최종 경로 + 파일명
				file=new File(path + "/" + filename);
			} else {
				// 이동시킬 최종 경로 + 파일명
				file=new File(path + "\\" + filename); // files\dog.png
			}
			
			if (file.exists()) {
				// 있다 -> 중복 -> 파일명 수정
				filename=tempName+"_"+n+tempExt;
				n++;
			} else {
				// 없다 -> 반환
				return filename;
			}
		}
	}
	
	@RequestMapping(value="/member/board/review/edit.action", method={RequestMethod.GET})
	public String edit(HttpServletRequest req, HttpServletResponse resp, String seq) {
		
		// 리뷰번호로 전체정보가져오기
		ReviewForMemberDTO dto=dao.info(seq);
		
		// 리뷰번호로 이미지가져오기
		List<ReviewPicDTO> plist=pdao.list(seq);
		
		req.setAttribute("dto", dto);
		req.setAttribute("plist", plist);
		
		return "member.board.review.edit";
	}
	
	@RequestMapping(value="/member/board/review/editok.action", method={RequestMethod.POST})
	public void editok(HttpServletRequest req, HttpServletResponse resp, EditReviewDTO dto) { // 1.

		// 1. 데이터 가져오기
		// 2. DB 위임 -> edit
		// 3. 결과 처리
		
		int result=dao.edit(dto);
		
		try {
			
			if (result==1) {
				resp.sendRedirect("/bnna/member/board/review/view.action?seq="+dto.getSeq());
			} else {
				resp.sendRedirect("/bnna/member/board/review/edit.action?seq="+dto.getSeq());
			}
			
		} catch (Exception e) {
			System.out.println("ReviewController.delok()");
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/member/board/review/view.action", method={RequestMethod.GET})
	public String view(HttpServletRequest req, HttpServletResponse resp, String seq) {
		
		// 리뷰번호로 전체정보가져오기
		ReviewForMemberDTO dto=dao.info(seq);
		
		// 리뷰번호로 이미지가져오기
		List<ReviewPicDTO> plist=pdao.list(seq);
		
		req.setAttribute("dto", dto);
		req.setAttribute("plist", plist);
		
		return "member.board.review.view";
	}
	
	@RequestMapping(value="/member/board/review/delok.action", method={RequestMethod.GET})
	public void delok(HttpServletRequest req, HttpServletResponse resp, String seq) { // 1.

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
				resp.sendRedirect("/bnna/member/board/review/list.action");
			} else {
				resp.sendRedirect("/bnna/member/board/review/view.action?seq="+seq);
			}
			
		} catch (Exception e) {
			System.out.println("ReviewController.delok()");
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/member/board/review/delfile.action", method={RequestMethod.GET})
	public String delFile(HttpServletRequest req, HttpServletResponse resp, String seq) { // 1.

		// 1. 데이터 가져오기
		// 2. DB 위임 -> delete
		// 3. 결과 처리
		
		String path=req.getRealPath("/resources/image/board/review/");
		
		// 2.
		pdao.del(path, seq);
		
		return "member.board.review.edit";
		
	}
	
}
