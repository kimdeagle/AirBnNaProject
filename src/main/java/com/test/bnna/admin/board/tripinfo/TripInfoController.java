package com.test.bnna.admin.board.tripinfo;

import java.io.File;
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


/**
 * 관리자 페이지의 여행정보 게시판 관련 컨트롤러입니다.
 * @author 김다은
 */
@Controller
public class TripInfoController {
	
	@Autowired
	private ITripInfoDAO dao;
	
	@Autowired
	private ITripInfoImgDAO idao;
	
	/**
	 * 
	 * @param req
	 * @param resp
	 * @return 
	 */
	@RequestMapping(value="/admin/board/tripinfo/list.action", method={RequestMethod.GET})
	public String list(HttpServletRequest req, HttpServletResponse resp) {
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		//페이징
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수 
		int pageSize = 10;		//한 페이지당 출력 개수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//rnum 시작번호
		int end = 0;			//rnum 끝번호
		int n = 0;				//페이지바 관련 변수
		int loop = 0;			//페이지바 관련 변수
		int blockSize = 10;		//페이지바 관련 변수
		
		String page = req.getParameter("page");
		
		if (page == null || page == "") {
			//기본 -> page = 1
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		//HashMap에 정보를 넘겨
		map.put("begin", begin + "");
		map.put("end", end + "");		
		
		
		List<TripInfoDTO> list = dao.list(map);
		
		totalCount = dao.getTotalCount(); //총 게시물 수
		
		totalPage = (int)Math.ceil((double)totalCount / pageSize); //총 페이지 수
		
		
		String pagebar = "";
		
		loop = 1;
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		
		
		//이전 10페이지로
		if(n == 1) {
			pagebar += String.format("<a class='disabled' href=\"#!\" aria-label=\"Previous\">"
						+ "                &laquo;"
						+ "            </a>");
		} else {
			pagebar += String.format("<a href=\"/bnna/admin/board/tripinfo/list.action?page=%d\" aria-label=\"Previous\">"
						+ "                &laquo;"
						+ "            </a>", n - 1);			
		}
		
		
		
		while (!(loop > blockSize || n > totalPage)) {

			if (nowPage == n) {
				pagebar += "<a class='active' ";
			} else {
				pagebar += "<a ";
			}
			pagebar += String.format("href=\"/bnna/admin/board/tripinfo/list.action?page=%d\">%d</a>", n, n);

			loop++;
			n++;

		}
		
		
		//다음 10페이지로 이동
		if (n > totalPage) {
			pagebar += String.format("<a class='disabled' href=\"#!\" aria-label=\"Next\">"
						+ "                &raquo;"
						+ "            </a>");
			//a href = "#" 본인 페이지 항상 위, "#!" 위로 올라가는 현상 사라짐
		} else {
			pagebar += String.format("<a href=\"/bnna/admin/board/tripinfo/list.action?page=%d\" aria-label=\"Next\">"
					+ "                &raquo;"
					+ "            </a>", n);
		}
		
		
		
		req.setAttribute("list", list);
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("nowPage", nowPage);
		
		return "admin.board.tripinfo.list";
	}
	
	
	@RequestMapping(value="/admin/board/tripinfo/view.action", method={RequestMethod.GET})
	public String view(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq) {
		
		TripInfoDTO dto = dao.view(seq);
		
		// 게시글 번호로 댓글정보 가져오기
		List<TripInfoCmtDTO> cmtlist = dao.cmtlist(seq);
		
		// 게시글 번호로 image 가져오기
		List<TripInfoImgDTO> ilist = idao.list(seq);
		
		req.setAttribute("dto", dto);
		req.setAttribute("cmtlist", cmtlist);
		req.setAttribute("ilist", ilist);
		
		return "admin.board.tripinfo.view";
	}
	
	
	@RequestMapping(value="/admin/board/tripinfo/write.action", method= {RequestMethod.GET})
	public String write(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		

		return "admin.board.tripinfo.write";
	}
	
	@RequestMapping(value="/admin/board/tripinfo/writeok.action", method= {RequestMethod.POST})
	public void writeok(HttpServletRequest req, HttpServletResponse resp, HttpSession session, TripInfoDTO dto) {

		MultipartHttpServletRequest multi=(MultipartHttpServletRequest)req;
		List<MultipartFile> multiList = multi.getFiles("image");
		
		// 파일업로드
		if (multiList.size() == 1 && multiList.get(0).getOriginalFilename().equals("")) {
		
		} else {
			
			String filename="";
			
			try {
				
				for (int i = 0; i < multiList.size(); i++) {
					
					String path=req.getRealPath("/resources/image/board/tripinfo/");
					
					filename = getFileName(path, multiList.get(i).getOriginalFilename());
					
					//이동시킬 최종 경로 + 파일명
					File file = new File(path + "\\" + filename);
					
					//무조건 덮어쓰기 -> 중복 방지 -> 넘버링 직접 구현..
					multiList.get(i).transferTo(file); //renameTo()와 동일
					
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		
		
		// DTO에 저장
		ArrayList<TripInfoImgDTO> ilist = new ArrayList<TripInfoImgDTO>();
		
		for (int i = 0; i < multiList.size(); i++) {
			TripInfoImgDTO idto = new TripInfoImgDTO();
			idto.setImage(multiList.get(i).getOriginalFilename());
			idto.setOrgimage(multiList.get(i).getOriginalFilename());
			
			System.out.println("idto : " + multiList.get(i).getOriginalFilename());
			
			ilist.add(idto);
		}
		
		
		try {
			
			int result = dao.write(dto);	//게시글 DB에 데이터 넣기
			
			
			String seq = dao.getTripInfoSeq();	//여행정보 글번호 가져오기
			
			for (int i = 0; i < ilist.size(); i++) {
				ilist.get(i).setSeqTripInfo(seq);
			}
			
			int fileResult = idao.addTripInfoImg(ilist);	//여행정보 사진 DB에 데이터 넣기
			
			
			if (fileResult == 1) {
				resp.sendRedirect("/bnna/admin/board/tripinfo/list.action");
			} else {
				resp.sendRedirect("/bnna/admin/board/tripinfo/write.action");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private String getFileName(String path, String filename) {
		
		int n = 1; //인덱스 숫자
		int index = filename.indexOf(".");
		String tempName = filename.substring(0, index); //"dog"
		String tempExt = filename.substring(index); //".png"
		
		while (true) {
			
			File file = new File(path + "\\" + filename); //files\dog.png
			
			if (file.exists()) {
				//있다 -> 중복 -> 파일명 수정
				filename = tempName + "(" + n + ")" + tempExt;
				n++;
				
			} else {
				//없다 -> 반환
				return filename;
			}
			
		}
	}


	@RequestMapping(value="/admin/board/tripinfo/edit.action", method= {RequestMethod.GET})
	public String edit(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String seq) {
		
		//해당 seq의 여행정보 게시글 가져오기
		TripInfoDTO dto = dao.get(seq);
		
		// 리뷰번호로 이미지가져오기
		List<TripInfoImgDTO> ilist = idao.list(seq);
		
		req.setAttribute("dto", dto);
		req.setAttribute("ilist", ilist);
		
		return "admin.board.tripinfo.edit";
	}
	
	@RequestMapping(value="/admin/board/tripinfo/editok.action", method= {RequestMethod.POST})
	public void editok(HttpServletRequest req, HttpServletResponse resp, HttpSession session, TripInfoDTO dto) {
		
		
		int result = dao.edit(dto);
		
		try {
			if (result == 1) {
				resp.sendRedirect("/bnna/admin/board/tripinfo/view.action?seq=" + dto.getSeq());
			} else {
				resp.sendRedirect("/bnna/admin/board/tripinfo/edit.action?seq=" + dto.getSeq());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	@RequestMapping(value="/admin/board/tripinfo/delok.action", method={RequestMethod.GET})
	public void delok(HttpServletRequest req, HttpServletResponse resp, String seq) { 
		
		String path = req.getRealPath("/resources/image/board/tripinfo/");
		
		int result = dao.del(path, seq);
		
		
		// 3.
		
		try {
			
			if (result == 1) {
				resp.sendRedirect("/bnna/admin/board/tripinfo/list.action");
			} else {
				resp.sendRedirect("/bnna/admin/board/tripinfo/view.action?seq="+seq);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
