package com.test.bnna.admin.board.tripinfo;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 관리자 페이지의 여행정보 게시판 관련 메소드를 담고있는 DAO입니다.
 * @author 김다은
 */
@Repository
public class TripInfoDAO implements ITripInfoDAO {
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public int getTotalCount() {

		return template.selectOne("tripinfo.gettotalcount");
	}
	
	@Override
	public List<TripInfoDTO> list(HashMap<String, String> map) {

		return template.selectList("tripinfo.list", map);
	}
	
	@Override
	public TripInfoDTO view(String seq) {
		
		return template.selectOne("tripinfo.view", seq);
	}
	
	//view에서 댓글 목록 불러오기
	@Override
	public List<TripInfoCmtDTO> cmtlist(String seq) {

		return template.selectList("tripinfo.cmtlist", seq);
	}
	
	@Override
	public int write(TripInfoDTO dto) {
		
		return template.insert("tripinfo.add", dto);
	}
	
	@Override
	public String getTripInfoSeq() {
		
		return template.selectOne("tripinfo.getTripInfoSeq");
	}

	
	@Override
	public TripInfoDTO get(String seq) {
		
		return template.selectOne("tripinfo.get", seq);
	}
	
	
	@Override
	public int edit(TripInfoDTO dto) {
		
		return template.update("tripinfo.edit", dto);
	}
	
	@Override
	public int del(String path, String seq) {
		
		int result = delFiles(path, seq);
		
		template.delete("tripinfo.delimg", seq);
		
		return template.delete("tripinfo.del", seq);
		
	}

	/**
	 * 게시글을 삭제하면 해당 게시글의 사진들도 함께 삭제가 되어야한다.
	 * @param path
	 * @param seq
	 * @return 삭제한 게시물의 수, 실패시 0
	 */
	private int delFiles(String path, String seq) {
		
		int delcnt = 0;
		
		// 파일명들을 가져온다.
		List<TripInfoImgDTO> list = template.selectList("tripinfo.ilist", seq);
		
		// 삭제한다.
		for(TripInfoImgDTO dto:list) {
			
			File file = new File(path + dto.getImage());
			file.delete();
			delcnt++;
		}
		
		return delcnt;
	}


}
