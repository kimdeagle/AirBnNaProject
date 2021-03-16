package com.test.bnna.admin.board.tripinfo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 관리자 페이지의 여행정보 게시판 관련 메소드를 담고있는 DAO입니다.
 * @author 김다은
 */
@Repository
public class TripInfoDAO implements ITripInfoDAO {
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<TripInfoDTO> list() {

		return template.selectList("tripinfo.list");
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


}
