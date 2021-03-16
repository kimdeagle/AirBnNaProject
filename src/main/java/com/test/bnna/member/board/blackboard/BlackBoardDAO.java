package com.test.bnna.member.board.blackboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlackBoardDAO implements IBlackBoardDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public BlackBoardDTO get(String seq) {
		
		return template.selectOne("blackboard.get", seq);
	}
	
	@Override
	public List<BlackBoardImgDTO> getImages(String seq) {
		
		return template.selectList("blackboard.getImages", seq);
	}
	
	@Override
	public List<BlackBoardCmtDTO> getComments(String seq) {
		
		return template.selectList("blackboard.getComments", seq);
	}
	
}
