package com.test.bnna.member.board.blackboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlackBoardImgDAO implements IBlackBoardImgDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public int add(List<BlackBoardImgDTO> ilist) {
		
		int result = 0;
		
		for (BlackBoardImgDTO idto : ilist) {
			result += template.insert("blackboardimg.add", idto);
		}
		
		return result;
	}
	
}
