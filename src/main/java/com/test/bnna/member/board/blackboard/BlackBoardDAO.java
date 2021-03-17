package com.test.bnna.member.board.blackboard;

import java.util.HashMap;
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
	
	@Override
	public int getThread() {

		return template.selectOne("blackboard.getThread");
	}
	
	@Override
	public void updateThread(HashMap<String, Integer> map) {
		
		template.update("blackboard.updateThread", map);
		
	}
	
	@Override
	public int addok(BlackBoardDTO dto) {

		return template.insert("blackboard.addok", dto);
	}
	
	@Override
	public String getAddSeq() {

		return template.selectOne("blackboard.getAddSeq");
	}
	
	@Override
	public void del(String addSeqBlackBoard) {
		
		template.delete("blackboard.del", addSeqBlackBoard);
		
	}
	
	@Override
	public List<BlackBoardDTO> list() {

		return template.selectList("blackboard.list");
	}
	
}
